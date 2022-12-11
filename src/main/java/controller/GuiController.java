package controller;

import controller.events.ReiseHandhaber;
import controller.sql.QueryController;
import model.db.DB;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import view.Hauptfenster;
import view.View;
import view.erstellen.Buchungsdetails;
import view.erstellen.Terminerstellung;
import view.gemeinsam.Meldungsfenster;
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;
import view.bearbeiten.BearbeiteKunde;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * zentraler State der GUI
 */
public class GuiController {

    public record GUI(EingabeTerminId eingabeTerminId, EingabeKundeId eingabeKundeId_BearbeiteKunde, EingabeKundeId eingabeKundeId_TerminErstellen,
                      BearbeiteKunde bearbeiteKunde, Terminerstellung terminErstellung, Buchungsdetails buchungsDetails) {}

    private Display anzeige;
    private Monitor primaer;
    private View aktuell;
    private Hauptfenster hauptfenster;
    private Shell shell;
    private GUI gui;
    private ReiseHandhaber reiseHandhaber;
    private AtomicBoolean ipGesetzt;
    private String globaleIp;

    public GuiController() {
        hauptfenster = new Hauptfenster();
        aktuell = hauptfenster;
        shell = hauptfenster.getShell();
        gui = new GUI(new EingabeTerminId(shell), new EingabeKundeId(shell), new EingabeKundeId(shell), new BearbeiteKunde(shell), new Terminerstellung(shell), new Buchungsdetails(shell));
        ipGesetzt = new AtomicBoolean(false);
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

    public static class FehlerHandhaber implements Runnable {

        String ueberschrift;
        String beschreibung;

        public FehlerHandhaber(String ueberschrift, String beschreibung) {
            this.ueberschrift = ueberschrift;
            this.beschreibung = beschreibung;
        }

        @Override
        public void run() {
            Meldungsfenster m = new Meldungsfenster(ueberschrift, beschreibung);
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
            if(!ipGesetzt.get() || globaleIp != ip) {
                try (DB db = new DB(ip)) {
                } catch (Exception e) {
                    anzeige.asyncExec(new FehlerHandhaber("Fehler", "IP Adresse ung\u00FCltig"));
                    ipGesetzt.set(false);
                    globaleIp = null;
                    return;
                }
                ipGesetzt.set(true);
                globaleIp = ip;
                anzeige.asyncExec(new FehlerHandhaber("Erfolg", "IP Adresse gesetzt"));
            }
            reiseHandhaber = new ReiseHandhaber(controller, new QueryController(ip), anzeige);
            hauptfenster.getIp().setText(globaleIp);
            hauptfenster.getEntferneTermin().addMouseListener(reiseHandhaber.getEntferneTermin().entferneTermin());
            gui.eingabeTerminId().getConfirm().addMouseListener(reiseHandhaber.getEntferneTermin().bestaetige());
            gui.eingabeTerminId().getBack().addMouseListener(reiseHandhaber.getEntferneTermin().zurueck());

            hauptfenster.getBearbeiteKunde().addMouseListener(reiseHandhaber.getBearbeiteKunde().eingabeKundenId());
            gui.eingabeKundeId_BearbeiteKunde().getConfirm().addMouseListener(reiseHandhaber.getBearbeiteKunde().bestaetige());
            gui.bearbeiteKunde().getSave().addMouseListener(reiseHandhaber.getBearbeiteKunde().bearbeiteKunde());

            hauptfenster.getErstelleTermin().addMouseListener(reiseHandhaber.getErstelleTermin().eingabeKundenId());
            gui.eingabeKundeId_TerminErstellen().getConfirm().addMouseListener(reiseHandhaber.getErstelleTermin().erstelleTermin());
            gui.terminErstellung().getBestellUebersicht().addMouseListener(reiseHandhaber.getErstelleTermin().zeigeBuchung());
            gui.terminErstellung().getHundeAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleHund());
            gui.terminErstellung().getMitarbeiterAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleMa());
            gui.terminErstellung().getDatumsAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleDatum());
            gui.buchungsDetails().getBtnAngabenAnpassen().addMouseListener(reiseHandhaber.getBestaetigeTermin().zurueck());
            gui.buchungsDetails().getBtnTerminBuchen().addMouseListener(reiseHandhaber.getBestaetigeTermin().bestaetige());
        }
    }

    public void initialisiere() {
        final String[] ip = new String[1];
        final GuiController controller = this;
        shell.open();
        if(ipGesetzt.get())
            anzeige.asyncExec(new IpHandhaber(globaleIp, controller));
        hauptfenster.getSetzeIP().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                super.mouseDown(mouseEvent);
                ipGesetzt.set(false);
                ip[0] = hauptfenster.getIp().getText();
                anzeige.asyncExec(new IpHandhaber(ip[0], controller));
            }
        });
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