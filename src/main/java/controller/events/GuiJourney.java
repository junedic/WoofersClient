package controller.events;

import controller.GuiController;
import controller.QueryController;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import view.View;
import view.commons.Bestaetigungsfenster;
import view.commons.Meldungsfenster;
import view.delete.InputAppointmentID;

import java.io.IOException;

public class GuiJourney {

    public record DeleteAppointment(MouseAdapter deleteAppointment, MouseAdapter confirm, MouseAdapter back) {}
    public record EditCustomer(MouseAdapter adapter) {}

    private GuiController guiController;
    private QueryController queryController;
    private View current;
    private Shell shell;
    private DeleteAppointment deleteAppointment;
    private EditCustomer editCustomer;
    private GuiController.GUI gui;
    /*
    private MouseAdapter deleteAppointment;
    private MouseAdapter editCustomer;
     */


    public GuiJourney(GuiController guiController, Shell shell, View current, GuiController.GUI gui) {
        this.guiController = guiController;
        this.shell = shell;
        this.current = current;
        this.gui = gui;
        queryController = new QueryController();
        initAppointment();
        initCustomer();
    }

    private void initAppointment() {
        deleteAppointment = new DeleteAppointment(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        current.dispose();
                        guiController.setCurrent(current = gui.inputAppointmentID());
                        ((InputAppointmentID) current).init();
                        guiController.open();
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
                        System.out.println("confirmed");
                        Bestaetigungsfenster bf = new Bestaetigungsfenster("Best\u00e4tigen", "Wollen Sie den Termin wirklich l\u00F6schen");
                        if (bf.getBestaetigt()) {
                            Text text = ((InputAppointmentID) current).getText();
                            new Meldungsfenster("Termin vernichtet", "Der Termin wurde gel\u00F6scht");
                            //guiController.reset();
                        } else {
                            guiController.dispose();
                            guiController.reset();
                        }
                    }
                },
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        super.mouseDown(e);
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
