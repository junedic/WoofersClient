package controller.ereignis;

import controller.GuiController;
import controller.sql.QueryController;
import model.sql.CRUD;
import model.sql.SqlBefehle;
import model.sql.TabellenAbbildung;
import model.viewmodel.Reise.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import view.View;
import view.erstellen.Terminerstellung;
import view.gemeinsam.Bestaetigungsfenster;
import view.gemeinsam.Meldungsfenster;
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Logik der GUI, i.e. Verbindung zw. Fenstern und Button Listeners
 */
public class ReiseHandhaber {

    private GuiController guiController;
    private QueryController queryController;
    private EntferneTermin entferneTermin;
    private BearbeiteKunde bearbeiteKunde;
    private ErstelleTermin erstelleTermin;
    private BestaetigeTermin bestaetigeTermin;
    private Display anzeige;

    private volatile ArrayList<Object> param;
    private volatile ArrayList<Object> params;
    private volatile ConcurrentHashMap<String, Boolean> gebDienste;


    public ReiseHandhaber(GuiController guiController, QueryController queryController, Display anzeige) {
        this.guiController = guiController;
        this.queryController = queryController;
        param = new ArrayList<>();
        this.anzeige = anzeige;
        params = new ArrayList<>();
        gebDienste = new ConcurrentHashMap<>();
        initTermin();
        initKunde();
    }

    private void oeffneFenster(View view) {
        guiController.getAktuell().entsorge();
        guiController.setAktuell(view);
        view.init();
        guiController.oeffnen();
    }

    private class FreieUhrzeitHandhaber implements Runnable {

        private Time[] uhrzeiten = { Time.valueOf("15:00:00"), Time.valueOf("16:00:00"), Time.valueOf("17:00:00"), Time.valueOf("18:00:00"), Time.valueOf("19:00:00") };
        private ArrayList<LinkedHashMap<String, String>> freiUhrzeiten;

        FreieUhrzeitHandhaber() {
            freiUhrzeiten = new ArrayList<>();
        }

        @Override
        public void run() {
            try {
                    Terminerstellung erstellung = guiController.getGui().terminErstellung();
                    ArrayList<Object> param = new ArrayList<>();
                    param.add(Integer.parseInt(erstellung.getMitarbeiterAuswahl().getText().replaceAll("[^0-9]", "")));
                    param.add(Date.valueOf(erstellung.getDatumsAuswahl().getYear()+"-"+(erstellung.getDatumsAuswahl().getMonth()+1)+"-"+erstellung.getDatumsAuswahl().getDay()));
                    System.out.println("Datum: "+erstellung.getDatumsAuswahl().getYear()+"-"+(erstellung.getDatumsAuswahl().getMonth()+1)+"-"+erstellung.getDatumsAuswahl().getDay());
                    freiUhrzeiten = queryController.getAusfuehrer().fuehreAus(SqlBefehle.LeseMaZeiten, param);
                    for(LinkedHashMap<String, String> zeile : freiUhrzeiten) {
                        for (Time t : uhrzeiten) {
                            if (zeile.containsValue(t.toString())) {
                                System.out.println("Imma here");
                                guiController.getGui().terminErstellung().getZeitAuswahl().remove(t.toString());
                            }
                        }
                    }
                    freiUhrzeiten.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private enum DienstZuId {
        Schneiden("Schneiden", 1),
        WaschenBaden("Waschen/Baden", 2),
        Entfilzen("Entfilzen", 3),
        Entlausen("Entlausen", 4),
        Massage("Massage", 5);


        private String text;
        private int id;

        private DienstZuId(String text, int id) {
            this.text = text;
            this.id = id;
        }

        public static int getIdFromText(String text) {
            DienstZuId[] d = DienstZuId.values();
            for(DienstZuId i : d) {
                if(i.getText().equals(text)) return i.getId();
            }
            return -1;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }
    }


    private void initTermin() {

        erstelleTermin = new ErstelleTermin(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        oeffneFenster(guiController.getGui().eingabeKundeId_TerminErstellen());
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        params.add(Integer.parseInt(guiController.getGui().eingabeKundeId_TerminErstellen().getText().getText()));
                        try {
                            ArrayList<LinkedHashMap<String, String>> ma = queryController.getAusfuehrer().fuehreAus(SqlBefehle.LeseMa);
                            ArrayList<Object> param = new ArrayList<>();
                            param.add(Integer.parseInt(guiController.getGui().eingabeKundeId_TerminErstellen().getText().getText()));
                            ArrayList<LinkedHashMap<String, String>> hunde = queryController.getAusfuehrer().fuehreAus(SqlBefehle.LeseHunde, param);

                            for (LinkedHashMap<String, String> mitarbeiter : ma) {
                                guiController.getGui().terminErstellung().getMitarbeiterAuswahl().
                                        add(mitarbeiter.get("Nr") + " - " + mitarbeiter.get("Vorname") + " " + mitarbeiter.get("Nachname"));
                            }
                            for (LinkedHashMap<String, String> hund : hunde) {
                                guiController.getGui().terminErstellung().getHundeAuswahl().
                                        add(hund.get("ID") + " - " + hund.get("Name"));
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        oeffneFenster(guiController.getGui().terminErstellung());
                    }
                },
                new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent selectionEvent) {
                        super.widgetSelected(selectionEvent);
                    }
                },
                new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent selectionEvent) {
                        super.widgetSelected(selectionEvent);
                    }
                },
                new SelectionAdapter() {
                    @Override
                    public void widgetDefaultSelected(SelectionEvent selectionEvent) {
                        super.widgetDefaultSelected(selectionEvent);
                        widgetSelected(selectionEvent);
                    }

                    @Override
                    public void widgetSelected(SelectionEvent selectionEvent) {
                        super.widgetSelected(selectionEvent);
                        guiController.getGui().terminErstellung().initZeit();
                        anzeige.asyncExec(new FreieUhrzeitHandhaber());
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        Terminerstellung er = guiController.getGui().terminErstellung();

                        boolean allow = ((er.getEntfilzenCheck().getSelection() || er.getEntlausenCheck().getSelection()
                                || er.getMassageCheck().getSelection() || er.getSchneidenCheck().getSelection()
                                || er.getWaschenBadenCheck().getSelection()) && er.getHundeAuswahl().getSelectionIndex() >= 0
                                && er.getMitarbeiterAuswahl().getSelectionIndex() >= 0 && er.getZeitAuswahl().getSelectionIndex() >= 0);
                        if (allow) {
                            System.out.println("Diese nR:" + Integer.parseInt(er.getMitarbeiterAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Integer.parseInt(er.getMitarbeiterAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Integer.parseInt(er.getHundeAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Date.valueOf(er.getDatumsAuswahl().getYear() + "-" + (er.getDatumsAuswahl().getMonth() + 1) + "-" + er.getDatumsAuswahl().getDay()));
                            params.add(Time.valueOf(er.getZeitAuswahl().getText()));
                            params.forEach((o) -> {
                                System.out.println("Param: " + o.toString());
                            });

                            gebDienste.put(er.getEntfilzen().getText(), er.getEntfilzenCheck().getSelection());
                            gebDienste.put(er.getEntlausen().getText(), er.getEntlausenCheck().getSelection());
                            gebDienste.put(er.getMassage().getText(), er.getMassageCheck().getSelection());
                            gebDienste.put(er.getSchneiden().getText(), er.getSchneidenCheck().getSelection());
                            gebDienste.put(er.getWaschenBaden().getText(), er.getWaschenBadenCheck().getSelection());
                            gebDienste.forEach((k, v) -> {
                                gebDienste.remove(false);
                            });
                            oeffneFenster(guiController.getGui().buchungsDetails());
                        } else
                            anzeige.asyncExec(new GuiController.FehlerHandhaber("Fehler", "Bitte f\u00FCllen Sie alle Felder aus"));
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        guiController.zuruecksetzen();
                    }
                }
        );
        bestaetigeTermin = new BestaetigeTermin(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        int terminId = ((Integer)queryController.query(SqlBefehle.ErstelleTermin, params, ReiseResultatsTyp.ErstelleTermin)).intValue();
                        params.clear();
                        gebDienste.forEach((k, v) -> {
                            int dienstId = DienstZuId.getIdFromText(k);
                            System.out.println("Execute for Checkbox "+k+" with id="+dienstId);
                            if(v && dienstId > 0) queryController.query(SqlBefehle.ErstelleBuchung, new ArrayList<Object>(){{add(terminId); add(dienstId);}}, ReiseResultatsTyp.ErstelleTermin);
                            System.out.println("Executed Checkbox");
                        });
                        gebDienste.clear();

                        guiController.zuruecksetzen();
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        params.clear();
                        guiController.zuruecksetzen();
                    }
                }
        );
        entferneTermin = new EntferneTermin(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        oeffneFenster(guiController.getGui().eingabeTerminId());
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        Bestaetigungsfenster bf = new Bestaetigungsfenster("Best\u00e4tigen", "Wollen Sie den Termin wirklich absagen");
                        if(bf.getBestaetigt()) {
                            Text text = ((EingabeTerminId) guiController.getAktuell()).getText();
                            param.add(Integer.parseInt(text.getText()));
                            System.out.println(Integer.parseInt(text.getText()));
                            queryController.query(SqlBefehle.EntferneTermin, param, ReiseResultatsTyp.EntferneTermin);
                            new Meldungsfenster("Termin abgesagt", "Der Termin wurde gel\u00F6scht");
                            guiController.zuruecksetzen();
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        guiController.zuruecksetzen();
                    }
                }
        );
    }

    private void initKunde() {
        bearbeiteKunde = new BearbeiteKunde(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                super.mouseDown(e);
                oeffneFenster(guiController.getGui().eingabeKundeId_BearbeiteKunde());
            }
        },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        Text textHalter = ((EingabeKundeId) guiController.getAktuell()).getText();
                        if(textHalter.getText() != null) {
                            ArrayList<Object> params = new ArrayList<>();
                            params.add(Integer.parseInt(textHalter.getText()));
                            //queryController.query(SqlBefehle.LeseKunde, params, ReiseResultatsTyp.BearbeiteKunde);
                            TabellenAbbildung.Tabelle kunde = CRUD.tabellenAbbildung.kunde;
                            (guiController.getGui().bearbeiteKunde()).getCustomerIdInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText())-1).get("Nr")
                            );
                            (guiController.getGui().bearbeiteKunde()).getName().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText())-1).get("Nachname")
                            );
                            (guiController.getGui().bearbeiteKunde()).getMobileInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText())-1).get("Telefonnummer")
                            );
                            (guiController.getGui().bearbeiteKunde()).getEmailInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText())-1).get("Email")
                            );
                            oeffneFenster(guiController.getGui().bearbeiteKunde());
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        ArrayList<Object> paramsLocal = new ArrayList<>();
                        paramsLocal.add(guiController.getGui().bearbeiteKunde().getName().getText());
                        paramsLocal.add(guiController.getGui().bearbeiteKunde().getMobileInput().getText());
                        paramsLocal.add(guiController.getGui().bearbeiteKunde().getEmailInput().getText());
                        paramsLocal.add(Integer.parseInt(guiController.getGui().bearbeiteKunde().getCustomerIdInput().getText()));
                        queryController.query(SqlBefehle.BearbeiteKunde, paramsLocal, ReiseResultatsTyp.BearbeiteKunde);
                        try {
                            queryController.aktualisiereAbbildungen();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        guiController.zuruecksetzen();
                    }
                });
    }

    public ErstelleTermin getErstelleTermin() {
        return erstelleTermin;
    }

    public BestaetigeTermin getBestaetigeTermin() {
        return bestaetigeTermin;
    }

    public EntferneTermin getEntferneTermin() {
        return entferneTermin;
    }

    public BearbeiteKunde getBearbeiteKunde() {
        return bearbeiteKunde;
    }
}
