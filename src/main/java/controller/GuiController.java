package controller;

import controller.events.GuiJourney;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import view.Hauptfenster;
import view.View;
import view.delete.InputAppointmentID;

import java.awt.event.MouseAdapter;

public class GuiController {

    public record GUI(Hauptfenster mainWin, InputAppointmentID inputAppointmentID) {}

    private Display display;
    private Monitor primary;
    private View current;
    private Hauptfenster mainWin;
    private InputAppointmentID inputAppointmentID;
    private Shell shell;
    private GUI gui;

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
        GuiJourney journey = new GuiJourney(this, shell, current, gui);
        mainWin.getDeleteAppointment().addMouseListener(journey.getDeleteAppointment().deleteAppointment());
        inputAppointmentID.getConfirm().addMouseListener(journey.getDeleteAppointment().confirm());
        inputAppointmentID.getBack().addMouseListener(journey.getDeleteAppointment().back());
        open();
    }

    public View getCurrent() {
        return current;
    }

    public void setCurrent(View current) {
        this.current = current;
    }

    public void reset() {
        current = (mainWin = new Hauptfenster());
        shell = mainWin.getShell();
    }

    public void dispose() {
        current.dispose();
    }
}
