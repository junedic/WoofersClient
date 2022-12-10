package controller;

import controller.events.ReiseHandhaber;
import controller.sql.QueryController;
import model.db.DB;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import view.Hauptfenster;
import view.View;
import view.gemeinsam.Meldungsfenster;
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;
import view.bearbeiten.BearbeiteKunde;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;

/**
 * zentraler State der GUI
 */
public class GuiController {

    public record GUI(EingabeTerminId eingabeTerminId, EingabeKundeId eingabeKundeId,
                      BearbeiteKunde bearbeiteKunde) {}

    private Display anzeige;
    private Monitor primaer;
    private View aktuell;
    private Hauptfenster hauptfenster;
    private Shell shell;
    private GUI gui;
    private ReiseHandhaber reiseHandhaber;

    public GuiController() {
        hauptfenster = new Hauptfenster();
        aktuell = hauptfenster;
        shell = hauptfenster.getShell();
        gui = new GUI(new EingabeTerminId(shell), new EingabeKundeId(shell), new BearbeiteKunde(shell));
        initView();
    }

    private void initView() {
        anzeige = Display.getDefault();
        /** get the size of the screen */
        primaer = anzeige.getPrimaryMonitor();
        Rectangle bounds = primaer.getBounds();
        /** get the size of the window */
        Rectangle rect = shell.getBounds();
        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        /** set the new location */
        shell.setLocation(x, y);
    }

    public void oeffnen() {
        shell.layout();
        while (!shell.isDisposed()) {
            if (!anzeige.readAndDispatch()) {
                anzeige.sleep();
            }
        }
    }

    private class IpHandhaber implements Runnable {

        String ip;
        GuiController controller;

        IpHandhaber(String ip, GuiController controller) {
            this.ip = ip;
            this.controller = controller;
        }

        @Override
        public void run() {
            try(DB db = new DB(ip)) {}catch(Exception e) {
                Meldungsfenster m = new Meldungsfenster("Fehler", "Die IP-Adresse ist ungueltig");
                return;
            }
            Meldungsfenster m = new Meldungsfenster("Erfolg", "IP Adresse gesetzt");
            reiseHandhaber = new ReiseHandhaber(controller, new QueryController(ip));
            hauptfenster.getEntferneTermin().addMouseListener(reiseHandhaber.getDeleteAppointment().entferneTermin());
            gui.eingabeTerminId().getConfirm().addMouseListener(reiseHandhaber.getDeleteAppointment().bestaetige());
            gui.eingabeTerminId().getBack().addMouseListener(reiseHandhaber.getDeleteAppointment().zurueck());

            hauptfenster.getBearbeiteKunde().addMouseListener(reiseHandhaber.getEditCustomer().eingabeKundenId());
            gui.eingabeKundeId().getConfirm().addMouseListener(reiseHandhaber.getEditCustomer().bestaetige());
            gui.bearbeiteKunde().getSave().addMouseListener(reiseHandhaber.getEditCustomer().bearbeiteKunde());
        }
    }

    public void initialisiere() {
        final String[] ip = new String[1];
        final GuiController controller = this;
        shell.open();
        hauptfenster.getSetzeIP().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                super.mouseDown(mouseEvent);
                ip[0] = hauptfenster.getIp().getText();
                Meldungsfenster m1 = new Meldungsfenster("Verbinde", "Bitte Warten", true);
                anzeige.asyncExec(new IpHandhaber(ip[0], controller));
            }
        });
        oeffnen();
    }

    public View getAktuell() {
        return aktuell;
    }

    public void setAktuell(View aktuell) {
        this.aktuell = aktuell;
    }

    public GUI getGui() {
        return gui;
    }

    //alle fenster in gleicher shell -> disposed elemente muessen neu initialisiert werden
    public void zuruecksetzen() {
        aktuell.entsorge();
        aktuell = hauptfenster;
        hauptfenster.weiseElementeZu();
        hauptfenster.init();
        shell = hauptfenster.getShell();
        initialisiere();
    }
}
