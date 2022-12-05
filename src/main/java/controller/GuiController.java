package controller;

import controller.events.GuiJourney;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import view.Hauptfenster;
import view.View;
import view.commons.Bestaetigungsfenster;
import view.commons.Meldungsfenster;
import view.delete.InputAppointmentID;

import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;
import java.util.Iterator;
import java.util.function.Consumer;

public class GuiController {

    public record GUI(Hauptfenster mainWin, InputAppointmentID inputAppointmentID) {}

    private Display display;
    private Monitor primary;
    public View current;
    private Hauptfenster mainWin;
    public InputAppointmentID inputAppointmentID;
    private Shell shell;
    public GUI gui;
    private GuiJourney journey;

    public GuiController() {
        mainWin = new Hauptfenster();
        current = mainWin;
        shell = mainWin.getShell();
        inputAppointmentID = new InputAppointmentID(shell);
        gui = new GUI(mainWin, inputAppointmentID);
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
        shell.open();
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
        mainWin.getSetIp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                super.mouseDown(mouseEvent);
                ip[0] = mainWin.getIp().getText();
                Meldungsfenster m = new Meldungsfenster("IP Adresse", "Adresse gesetzt");
                journey = new GuiJourney(controller, new QueryController(ip[0]));
                mainWin.getDeleteAppointment().addMouseListener(journey.getDeleteAppointment().deleteAppointment());
                inputAppointmentID.getConfirm().addMouseListener(journey.getDeleteAppointment().confirm());
                inputAppointmentID.getBack().addMouseListener(journey.getDeleteAppointment().back());
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

    public void reset() {
        current.dispose();
        current = mainWin;
        mainWin.reassign();
        mainWin.init();
        shell = mainWin.getShell();
        initialize();
    }
}
