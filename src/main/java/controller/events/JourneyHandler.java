package controller.events;

import controller.GuiController;
import controller.QueryController;
import model.viewmodel.Journey.*;
import model.sql.CRUD;
import model.sql.SQLStatments;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import view.View;
import view.commons.Bestaetigungsfenster;
import view.commons.Meldungsfenster;
import view.delete.InputAppointmentID;
import view.update.InputCustomerID;

import java.util.ArrayList;

/**
 * Logik der GUI, i.e. Verbindung zw. Fenstern und Button Listeners
 */
public class JourneyHandler {

    private GuiController guiController;
    private QueryController queryController;
    private DeleteAppointment deleteAppointment;
    private EditCustomer editCustomer;
    private ArrayList<Object> param;


    public JourneyHandler(GuiController guiController, QueryController queryController) {
        this.guiController = guiController;
        this.queryController = queryController;
        param = new ArrayList<>();
        initAppointment();
        initCustomer();
    }

    private void openWindow(View view) {
        guiController.getCurrent().dispose();
        guiController.setCurrent(view);
        view.init();
        guiController.open();
    }


    private void initAppointment() {
        deleteAppointment = new DeleteAppointment(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        openWindow(guiController.getGui().inputAppointmentID());
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        Bestaetigungsfenster bf = new Bestaetigungsfenster("Best\u00e4tigen", "Wollen Sie den Termin wirklich absagen");
                        if(bf.getBestaetigt()) {
                            Text text = ((InputAppointmentID) guiController.getCurrent()).getText();
                            param.add(Integer.parseInt(text.getText()));
                            System.out.println(Integer.parseInt(text.getText()));
                            queryController.query(SQLStatments.DeleteAppointment, param, JourneyResultType.DeleteAppointment);
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
                super.mouseDown(e);
                openWindow(guiController.getGui().inputCustomerId());
                Text params = ((InputCustomerID) guiController.getCurrent()).getText();
            }
        },
        new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                super.mouseDown(e);
                openWindow(guiController.getGui().updateCustomer());
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
