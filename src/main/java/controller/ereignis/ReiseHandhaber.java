package controller.ereignis;

import controller.GuiController;
import controller.ereignis.handhaber.FehlerHandhaber;
import controller.sql.QueryController;
import model.sql.CRUD;
import model.sql.SqlBefehle;
import model.sql.TabellenAbbildung;
import model.viewmodel.Reise.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
import view.View;
import view.erstellen.Buchungsdetails;
import view.erstellen.Terminerstellung;
import view.gemeinsam.Bestaetigungsfenster;
import view.gemeinsam.Meldungsfenster;
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
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
    private ListeMaTermine listeMaTermine;
    private ListeKuTermine listeKuTermine;
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
        try {
            queryController.aktualisiereAbbildungen();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            } catch (Exception e) {
                anzeige.asyncExec(new FehlerHandhaber("Fehler", "Waehlen Sie zunaechst einen Mitarbeiter aus", anzeige));
            }
        }
    }

    private enum DienstZuId {
        Schneiden("Schneiden", 1),
        WaschenBaden("Waschen/ Baden", 2),
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
                                if(!v) gebDienste.remove(k);
                            });

                            Buchungsdetails details = guiController.getGui().buchungsDetails();
                            details.getLblMitarbeitername().setText(er.getMitarbeiterAuswahl().getText());
                            details.getLblHundename().setText(er.getHundeAuswahl().getText());
                            details.getLblDatum().setText(er.getDatumsAuswahl().toString());
                            details.getLblUhrzeit().setText(er.getZeitAuswahl().getText());

                            TabellenAbbildung abb = CRUD.tabellenAbbildung;
                            List l = details.getList();
                            Label p = details.getLblPreis();
                            AtomicInteger i = new AtomicInteger(0);
                            AtomicInteger preis = new AtomicInteger(0);
                            gebDienste.forEach((k,v) -> {
                                l.add(k);
                                abb.dienstleistung.getTable().forEach((m) -> {
                                    if(m.get("Bezeichnung").equals(k)) preis.set(preis.get()+Integer.parseInt(m.get("Preis")));
                                });
                                i.set(i.getAndIncrement());
                            });
                            p.setText(String.valueOf(preis));
                            oeffneFenster(guiController.getGui().buchungsDetails());
                        } else {
                            anzeige.asyncExec(new FehlerHandhaber("Fehler", "Bitte f\u00FCllen Sie alle Felder aus", anzeige));
                        }
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
                        Bestaetigungsfenster bf = new Bestaetigungsfenster("Best\u00e4tigen", "Wollen Sie den Termin wirklich absagen", anzeige);
                        if(bf.getBestaetigt()) {
                            Text text = ((EingabeTerminId) guiController.getAktuell()).getText();
                            param.add(Integer.parseInt(text.getText()));
                            System.out.println(Integer.parseInt(text.getText()));
                            queryController.query(SqlBefehle.EntferneTermin, param, ReiseResultatsTyp.EntferneTermin);
                            new Meldungsfenster("Termin abgesagt", "Der Termin wurde gel\u00F6scht", anzeige);
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
        listeMaTermine = new ListeMaTermine(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        oeffneFenster(guiController.getGui().eingabeMitarbeiterId());
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        int maId = Integer.parseInt(guiController.getGui().eingabeMitarbeiterId().getText().getText());
                        guiController.getGui().listeMaTermine().getLblX().setText(maId+"");
                        try {
                            ArrayList<LinkedHashMap<String, String>> terminListe;
                            queryController.aktualisiereAbbildungen();
                            terminListe = queryController.getAusfuehrer().fuehreAus(SqlBefehle.LeseMaTermine, new ArrayList<>(){{add(maId);}});

                            TabellenAbbildung.Tabelle m = CRUD.tabellenAbbildung.mitarbeiter;
                            TabellenAbbildung.Tabelle k = CRUD.tabellenAbbildung.kunde;
                            TabellenAbbildung.Tabelle d = CRUD.tabellenAbbildung.dienstleistung;
                            TabellenAbbildung.Tabelle gd = CRUD.tabellenAbbildung.gebuchteDienstleistung;
                            TabellenAbbildung.Tabelle h = CRUD.tabellenAbbildung.hund;
                            TabellenAbbildung.Tabelle r = CRUD.tabellenAbbildung.rasse;
                            List l = guiController.getGui().listeMaTermine().getList();

                            terminListe.forEach((map) -> {
                                String item = "";
                                int tNr = Integer.parseInt(map.get("ID"));
                                int kNr = Integer.parseInt(map.get("Kunde_Nr"))-1;
                                int hNr = Integer.parseInt(map.get("Hund_ID"))-1;
                                item = item.concat(map.get("Datum")+" um "+map.get("Uhrzeit"));
                                item = item.concat(" Kunde: "+(kNr+1)+" - "+k.getTable().get(kNr).get("Nachname")
                                                    +" Tel.: "+k.getTable().get(kNr).get("Telefonnummer"));
                                item = item.concat(" mit einem "+r.getTable().get(Integer.parseInt(h.getTable().get(hNr).get("Rasse_ID"))-1).get("Rasse"));
                                item = item.concat(" "+h.getTable().get(hNr).get("Geschlecht")+" im Alter von "+
                                        (Year.now().getValue()-Integer.parseInt(h.getTable().get(hNr).get("Geburtsjahr").split("-")[0])));
                                item = item.concat(" fuer:");
                                for(LinkedHashMap<String, String> gebucht : gd.getTable()) {
                                    if(gebucht.get("Termin_ID").equals(String.valueOf(tNr))) {
                                        item = item.concat(
                                                " "+d.getTable().get(Integer.parseInt(gebucht.get("Dienstleistung_ID"))-1).get("Bezeichnung")
                                        );
                                    }
                                }
                                System.out.println("Item: "+item);
                                l.add(item);
                            });
                            oeffneFenster(guiController.getGui().listeMaTermine());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
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
        listeKuTermine = new ListeKuTermine(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                super.mouseDown(mouseEvent);
                oeffneFenster(guiController.getGui().eingabeKundeId_ListeTermin());
            }
        },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        int kuId = Integer.parseInt(guiController.getGui().eingabeKundeId_ListeTermin().getText().getText());
                        guiController.getGui().listeKuTermine().getLblX().setText(kuId+"");
                        try {
                            ArrayList<LinkedHashMap<String, String>> terminListe;
                            queryController.aktualisiereAbbildungen();
                            terminListe = queryController.getAusfuehrer().fuehreAus(SqlBefehle.LeseKuTermine, new ArrayList<>(){{add(kuId);}});

                            TabellenAbbildung.Tabelle m = CRUD.tabellenAbbildung.mitarbeiter;
                            TabellenAbbildung.Tabelle k = CRUD.tabellenAbbildung.kunde;
                            TabellenAbbildung.Tabelle d = CRUD.tabellenAbbildung.dienstleistung;
                            TabellenAbbildung.Tabelle gd = CRUD.tabellenAbbildung.gebuchteDienstleistung;
                            TabellenAbbildung.Tabelle h = CRUD.tabellenAbbildung.hund;
                            TabellenAbbildung.Tabelle r = CRUD.tabellenAbbildung.rasse;
                            List l = guiController.getGui().listeMaTermine().getList();

                            terminListe.forEach((map) -> {
                                String item = "";
                                int preis = 0;
                                int tNr = Integer.parseInt(map.get("ID"));
                                int mNr = Integer.parseInt(map.get("Mitarbeiter_Nr"))-1;
                                int hNr = Integer.parseInt(map.get("Hund_ID"))-1;
                                item = item.concat(map.get("Datum")+" um "+map.get("Uhrzeit"));
                                item = item.concat(" MA: "+(mNr+1)+" - "+m.getTable().get(mNr).get("Nachname")
                                        +" Tel.: "+m.getTable().get(mNr).get("Telefonnummer"));
                                item = item.concat(" mit "+r.getTable().get(Integer.parseInt(h.getTable().get(hNr).get("Rasse_ID"))-1).get("Rasse"));
                                item = item.concat(" "+h.getTable().get(hNr).get("Geschlecht")+" im Alter von "+
                                        (Year.now().getValue()-Integer.parseInt(h.getTable().get(hNr).get("Geburtsjahr").split("-")[0])));
                                item = item.concat(" fuer:");
                                for(LinkedHashMap<String, String> gebucht : gd.getTable()) {
                                    if(gebucht.get("Termin_ID").equals(String.valueOf(tNr))) {
                                        preis += Integer.parseInt(d.getTable().get(Integer.parseInt(gebucht.get("Dienstleistung_ID"))-1).get("Preis"));
                                        item = item.concat(
                                                " "+d.getTable().get(Integer.parseInt(gebucht.get("Dienstleistung_ID"))-1).get("Bezeichnung")
                                        );
                                    }
                                }
                                item = item.concat(" zum Preis von: "+preis+" Euro");
                                System.out.println("Item: "+item);
                                l.add(item);
                            });
                            oeffneFenster(guiController.getGui().listeMaTermine());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        guiController.zuruecksetzen();
                    }
                });
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
                        if (textHalter.getText() != null) {
                            ArrayList<Object> params = new ArrayList<>();
                            params.add(Integer.parseInt(textHalter.getText()));
                            TabellenAbbildung.Tabelle kunde = CRUD.tabellenAbbildung.kunde;
                            (guiController.getGui().bearbeiteKunde()).getCustomerIdInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText()) - 1).get("Nr")
                            );
                            (guiController.getGui().bearbeiteKunde()).getName().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText()) - 1).get("Nachname")
                            );
                            (guiController.getGui().bearbeiteKunde()).getMobileInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText()) - 1).get("Telefonnummer")
                            );
                            (guiController.getGui().bearbeiteKunde()).getEmailInput().setText(
                                    kunde.getTable().get(Integer.parseInt(textHalter.getText()) - 1).get("Email")
                            );
                            oeffneFenster(guiController.getGui().bearbeiteKunde());
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        guiController.zuruecksetzen();
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

    public ListeMaTermine getListeMaTermine() {
        return listeMaTermine;
    }

    public ListeKuTermine getListeKuTermine() {
        return listeKuTermine;
    }
}
