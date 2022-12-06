package controller;

import controller.events.JourneyHandler;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import view.Hauptfenster;
import view.View;
import view.commons.Meldungsfenster;
import view.delete.InputAppointmentID;
import view.update.InputCustomerID;
import view.update.UpdateCustomer;

/**
 * zentraler State der GUI
 */
public class GuiController {

    public record GUI(InputAppointmentID inputAppointmentID, InputCustomerID inputCustomerId,
                      UpdateCustomer updateCustomer) {}

    private Display display;
    private Monitor primary;
    private View current;
    private Hauptfenster mainWin;
    private Shell shell;
    private GUI gui;
    private JourneyHandler journey;

    public GuiController() {
        mainWin = new Hauptfenster();
        current = mainWin;
        shell = mainWin.getShell();
        gui = new GUI(new InputAppointmentID(shell), new InputCustomerID(shell), new UpdateCustomer(shell));
        initView();
    }

    private void initView() {
        display = Display.getDefault();
        /** get the size of the screen */
        primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        /** get the size of the window */
        Rectangle rect = shell.getBounds();
        /** calculate the centre */
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        /** set the new location */
        shell.setLocation(x, y);
    }

    public void open() {
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    public void initialize() {
        final String[] ip = new String[1];
        final GuiController controller = this;
        shell.open();
        mainWin.getSetIp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                super.mouseDown(mouseEvent);
                ip[0] = mainWin.getIp().getText();
                Meldungsfenster m = new Meldungsfenster("IP Adresse", "Adresse gesetzt");
                journey = new JourneyHandler(controller, new QueryController(ip[0]));
                mainWin.getDeleteAppointment().addMouseListener(journey.getDeleteAppointment().deleteAppointment());
                gui.inputAppointmentID().getConfirm().addMouseListener(journey.getDeleteAppointment().confirm());
                gui.inputAppointmentID().getBack().addMouseListener(journey.getDeleteAppointment().back());

                mainWin.getEditCustomer().addMouseListener(journey.getEditCustomer().inputCustomerId());
                gui.inputCustomerId.getConfirm().addMouseListener(journey.getEditCustomer().updateCustomer());
            }
        });
        open();
    }

    public View getCurrent() {
        return current;
    }

    public void setCurrent(View current) {
        this.current = current;
    }

    public GUI getGui() {
        return gui;
    }

    //alle fenster in gleicher shell -> disposed elemente muessen neu initialisiert werden
    public void reset() {
        current.dispose();
        current = mainWin;
        mainWin.assignElements();
        mainWin.init();
        shell = mainWin.getShell();
        initialize();
    }
}
