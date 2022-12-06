package controller.events;

import controller.GuiController;
import controller.QueryController;
import model.sql.CRUD;
import model.sql.SQLStatments;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import view.View;
import view.commons.Bestaetigungsfenster;
import view.commons.Meldungsfenster;
import view.delete.InputAppointmentID;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Logik der GUI, i.e. Verbindung zw. Fenstern und Button Listeners
 */
public class GuiJourney {

    public record DeleteAppointment(MouseAdapter deleteAppointment, MouseAdapter confirm, MouseAdapter back) {}
    public record EditCustomer(MouseAdapter adapter) {}

    private GuiController guiController;
    private QueryController queryController;
    private DeleteAppointment deleteAppointment;
    private EditCustomer editCustomer;
    private ArrayList<Object> param;


    public GuiJourney(GuiController guiController, QueryController queryController) {
        this.guiController = guiController;
        this.queryController = queryController;
        param = new ArrayList<>();
        initAppointment();
        initCustomer();
    }

    private void initAppointment() {
        deleteAppointment = new DeleteAppointment(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        guiController.current.dispose();
                        guiController.setCurrent(guiController.current = guiController.inputAppointmentID);
                        guiController.inputAppointmentID.init();
                        guiController.open();
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        Bestaetigungsfenster bf = new Bestaetigungsfenster("Best\u00e4tigen", "Wollen Sie den Termin wirklich absagen");
                        if(bf.getBestaetigt()) {
                            Text text = ((InputAppointmentID) guiController.current).getText();
                            param.add(Integer.parseInt(text.getText()));
                            System.out.println(Integer.parseInt(text.getText()));
                            queryController.query(SQLStatments.DeleteAppointment, param, CRUD.SQL.DELETE);
                            new Meldungsfenster("Termin abgesagt", "Der Termin wurde gel\u00F6scht");
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        guiController.reset();
                    }
                }
        );
    }

    private void initCustomer() {
        editCustomer = new EditCustomer(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
            }
        });
    }

    public DeleteAppointment getDeleteAppointment() {
        return deleteAppointment;
    }

    public EditCustomer getEditCustomer() {
        return editCustomer;
    }
}
