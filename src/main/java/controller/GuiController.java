package controller;

import controller.ereignis.handhaber.FehlerHandhaber;
import controller.ereignis.ReiseHandhaber;
import controller.sql.QueryController;
import model.db.DB;
import model.viewmodel.Reise;
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
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;
import view.bearbeiten.BearbeiteKunde;
import view.lesen.EingabeMitarbeiterId;
import view.lesen.Kundenliste;
import view.lesen.Mitarbeiterliste;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * zentraler State der GUI
 */
public class GuiController {

    public record GUI(EingabeTerminId eingabeTerminId, EingabeKundeId eingabeKundeId_BearbeiteKunde, EingabeKundeId eingabeKundeId_TerminErstellen,
                      EingabeKundeId eingabeKundeId_ListeTermin ,EingabeMitarbeiterId eingabeMitarbeiterId,
                      BearbeiteKunde bearbeiteKunde, Terminerstellung terminErstellung, Buchungsdetails buchungsDetails, Mitarbeiterliste listeMaTermine, Kundenliste listeKuTermine) {}

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
        gui = new GUI(new EingabeTerminId(shell), new EingabeKundeId(shell), new EingabeKundeId(shell), new EingabeKundeId(shell), new EingabeMitarbeiterId(shell), new BearbeiteKunde(shell),
                new Terminerstellung(shell), new Buchungsdetails(shell), new Mitarbeiterliste(shell), new Kundenliste(shell));
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
                    anzeige.asyncExec(new FehlerHandhaber("Fehler", "IP Adresse ung\u00FCltig", anzeige));
                    ipGesetzt.set(false);
                    globaleIp = null;
                    return;
                }
                ipGesetzt.set(true);
                globaleIp = ip;
                anzeige.asyncExec(new FehlerHandhaber("Erfolg", "IP Adresse gesetzt", anzeige));
            }
            reiseHandhaber = new ReiseHandhaber(controller, new QueryController(ip), anzeige);
            hauptfenster.getIp().setText(globaleIp);
            hauptfenster.getEntferneTermin().addMouseListener(reiseHandhaber.getEntferneTermin().entferneTermin());
            gui.eingabeTerminId().getConfirm().addMouseListener(reiseHandhaber.getEntferneTermin().bestaetige());
            gui.eingabeTerminId().getBack().addMouseListener(reiseHandhaber.getEntferneTermin().zurueck());

            hauptfenster.getBearbeiteKunde().addMouseListener(reiseHandhaber.getBearbeiteKunde().eingabeKundenId());
            gui.eingabeKundeId_BearbeiteKunde().getConfirm().addMouseListener(reiseHandhaber.getBearbeiteKunde().bestaetige());
            gui.eingabeKundeId_BearbeiteKunde().getBack().addMouseListener(reiseHandhaber.getBearbeiteKunde().zurueck());
            gui.bearbeiteKunde().getSave().addMouseListener(reiseHandhaber.getBearbeiteKunde().bearbeiteKunde());
            gui.bearbeiteKunde().getCancel().addMouseListener(reiseHandhaber.getBearbeiteKunde().zurueck());

            hauptfenster.getErstelleTermin().addMouseListener(reiseHandhaber.getErstelleTermin().eingabeKundenId());
            gui.eingabeKundeId_TerminErstellen().getConfirm().addMouseListener(reiseHandhaber.getErstelleTermin().erstelleTermin());
            gui.eingabeKundeId_TerminErstellen().getBack().addMouseListener(reiseHandhaber.getErstelleTermin().zurueck());
            gui.terminErstellung().getBestellUebersicht().addMouseListener(reiseHandhaber.getErstelleTermin().zeigeBuchung());
            gui.terminErstellung().getHundeAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleHund());
            gui.terminErstellung().getMitarbeiterAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleMa());
            gui.terminErstellung().getDatumsAuswahl().addSelectionListener(reiseHandhaber.getErstelleTermin().waehleDatum());
            gui.terminErstellung().getZurueck().addMouseListener(reiseHandhaber.getErstelleTermin().zurueck());
            gui.buchungsDetails().getBtnAngabenAnpassen().addMouseListener(reiseHandhaber.getBestaetigeTermin().zurueck());
            gui.buchungsDetails().getBtnTerminBuchen().addMouseListener(reiseHandhaber.getBestaetigeTermin().bestaetige());

            hauptfenster.getTerminMitarbeiter().addMouseListener(reiseHandhaber.getListeMaTermine().eingabeMitarbeiterId());
            gui.eingabeMitarbeiterId().getConfirm().addMouseListener(reiseHandhaber.getListeMaTermine().bestaetige());
            gui.eingabeMitarbeiterId().getBack().addMouseListener(reiseHandhaber.getListeMaTermine().zurueck());
            gui.listeMaTermine().getBtnZurueck().addMouseListener(reiseHandhaber.getListeMaTermine().zurueck());

            hauptfenster.getTerminKunde().addMouseListener(reiseHandhaber.getListeKuTermine().eingabeKundenId());
            gui.eingabeKundeId_ListeTermin().getConfirm().addMouseListener(reiseHandhaber.getListeKuTermine().bestaetige());
            gui.eingabeKundeId_ListeTermin().getBack().addMouseListener(reiseHandhaber.getListeKuTermine().zurueck());
            gui.listeMaTermine().getBtnZurueck().addMouseListener(reiseHandhaber.getListeKuTermine().zurueck());
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
