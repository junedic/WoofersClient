package controller.events;

import controller.GuiController;
import controller.sql.QueryController;
import controller.sql.ResultatHandhaber;
import model.sql.CRUD;
import model.sql.SqlBefehle;
import model.sql.TabellenAbbildung;
import model.viewmodel.Reise.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import view.View;
import view.gemeinsam.Bestaetigungsfenster;
import view.gemeinsam.Meldungsfenster;
import view.entfernen.EingabeTerminId;
import view.bearbeiten.EingabeKundeId;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Logik der GUI, i.e. Verbindung zw. Fenstern und Button Listeners
 */
public class ReiseHandhaber {

    private GuiController guiController;
    private QueryController queryController;
    private EntferneTermin entferneTermin;
    private BearbeiteKunde bearbeiteKunde;
    private ArrayList<Object> param;


    public ReiseHandhaber(GuiController guiController, QueryController queryController) {
        this.guiController = guiController;
        this.queryController = queryController;
        param = new ArrayList<>();
        initAppointment();
        initCustomer();
    }

    private void openWindow(View view) {
        guiController.getAktuell().entsorge();
        guiController.setAktuell(view);
        view.init();
        guiController.oeffnen();
    }


    private void initAppointment() {
        entferneTermin = new EntferneTermin(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        openWindow(guiController.getGui().eingabeTerminId());
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

    private void initCustomer() {
        bearbeiteKunde = new BearbeiteKunde(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                super.mouseDown(e);
                openWindow(guiController.getGui().eingabeKundeId());
            }
        },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        System.out.println("texting");
                        Text textHalter = ((EingabeKundeId) guiController.getAktuell()).getText();
                        System.out.println(textHalter.getText());
                        if(textHalter.getText() != null) {
                            ArrayList<Object> params = new ArrayList<>();
                            params.add(Integer.parseInt(textHalter.getText()));
                            //queryController.query(SqlBefehle.LeseKunde, params, ReiseResultatsTyp.BearbeiteKunde);
                            TabellenAbbildung.Tabelle kunde = CRUD.tabellenAbbildung.kunde;
                            System.out.println(kunde.getTable().get(Integer.parseInt(textHalter.getText())-1).get("Email")+"");
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
                            openWindow(guiController.getGui().bearbeiteKunde());
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent mouseEvent) {
                        super.mouseDown(mouseEvent);
                        ArrayList<Object> params = new ArrayList<>();
                        params.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getName().getText());
                        params.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getMobileInput().getText());
                        params.add(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getEmailInput().getText());
                        params.add(Integer.parseInt(((view.bearbeiten.BearbeiteKunde) guiController.getAktuell()).getCustomerIdInput().getText()));
                        queryController.query(SqlBefehle.BearbeiteKunde, params, ReiseResultatsTyp.BearbeiteKunde);
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

    public EntferneTermin getDeleteAppointment() {
        return entferneTermin;
    }

    public BearbeiteKunde getEditCustomer() {
        return bearbeiteKunde;
    }
}
