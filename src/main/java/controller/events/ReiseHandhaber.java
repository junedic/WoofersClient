package controller.events;

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
import java.util.LinkedHashMap;

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
    private ArrayList<Object> param;
    private Display anzeige;
    private ArrayList<Object> params;


    public ReiseHandhaber(GuiController guiController, QueryController queryController, Display anzeige) {
        this.guiController = guiController;
        this.queryController = queryController;
        param = new ArrayList<>();
        this.anzeige = anzeige;
        params = new ArrayList<>();
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
                                        add(mitarbeiter.get("Nr")+" - "+mitarbeiter.get("Vorname")+" "+mitarbeiter.get("Nachname"));
                            }
                            for (LinkedHashMap<String, String> hund : hunde) {
                                guiController.getGui().terminErstellung().getHundeAuswahl().
                                        add(hund.get("ID")+" - "+hund.get("Name"));
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
                        if(allow) {
                            System.out.println("Diese nR:"+Integer.parseInt(er.getMitarbeiterAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Integer.parseInt(er.getMitarbeiterAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Integer.parseInt(er.getHundeAuswahl().getText().replaceAll("[^0-9]", "")));
                            params.add(Date.valueOf(er.getDatumsAuswahl().getYear()+"-"+(er.getDatumsAuswahl().getMonth()+1)+"-"+er.getDatumsAuswahl().getDay()));
                            params.add(Time.valueOf(er.getZeitAuswahl().getText()));
                            params.forEach((o) -> {
                                System.out.println("Param: "+o.toString());
                            });
                            oeffneFenster(guiController.getGui().buchungsDetails());
                        }
                        else anzeige.asyncExec(new GuiController.FehlerHandhaber("Fehler", "Bitte f\u00FCllen Sie alle Felder aus"));
                    }
                }
        );
        bestaetigeTermin = new BestaetigeTermin(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        queryController.query(SqlBefehle.ErstelleTermin, params, ReiseResultatsTyp.ErstelleTermin);
                        params.clear();
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
                        paramsLocal.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getName().getText());
                        paramsLocal.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getMobileInput().getText());
                        paramsLocal.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getEmailInput().getText());
                        paramsLocal.add(Integer.parseInt(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getCustomerIdInput().getText()));
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
