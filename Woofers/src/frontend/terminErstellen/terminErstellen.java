package frontend.terminErstellen;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class terminErstellen {

	/**
	 * LEGENDE
	 * c_* 	-> sind checkboxen
	 * l_* 	-> sind labels
	 * b_* 	-> sind buttons
	 * dd_* -> sind drop-downs
	 * 
	 * @version 1.1
	 */
	
	protected Shell shlTerminbuchung;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			terminErstellen window = new terminErstellen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTerminbuchung.open();
		shlTerminbuchung.layout();
		while (!shlTerminbuchung.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTerminbuchung = new Shell();
		shlTerminbuchung.setSize(483, 624);
		shlTerminbuchung.setText("Terminbuchung");
		shlTerminbuchung.setLayout(null);
		
		DateTime date_picker = new DateTime(shlTerminbuchung, SWT.BORDER | SWT.CALENDAR);
		date_picker.setLocation(22, 264);
		date_picker.setSize(202, 211);
		
		Composite comp_zeitslot_buttons = new Composite(shlTerminbuchung, SWT.NONE);
		comp_zeitslot_buttons.setBounds(265, 264, 161, 211);
		comp_zeitslot_buttons.setLayout(null);
		
		Label l_verfuegbare_zeitslots = new Label(comp_zeitslot_buttons, SWT.NONE);
		l_verfuegbare_zeitslots.setBounds(0, 0, 148, 20);
		l_verfuegbare_zeitslots.setText("Verfuegbaren Zeitslots");
		
		Button b_zeitslot1 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 1' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot1.setBounds(35, 26, 90, 30);
		b_zeitslot1.setText("New Button");
		
		Button b_zeitslot2 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 2' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot2.setBounds(35, 62, 90, 30);
		b_zeitslot2.setText("New Button");
		
		Button b_zeitslot3 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 3' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot3.setBounds(35, 98, 90, 30);
		b_zeitslot3.setText("New Button");
		
		Button b_zeitslot4 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 4' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot4.setBounds(35, 134, 90, 30);
		b_zeitslot4.setText("New Button");
		
		Button b_zeitslot5 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 5' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot5.setBounds(35, 170, 90, 30);
		b_zeitslot5.setText("New Button");
		
		Composite comp_dienstleistungs_buttons = new Composite(shlTerminbuchung, SWT.NONE);
		comp_dienstleistungs_buttons.setBounds(332, 61, 16, 120);
		
		Button c_waschen_baden = new Button(comp_dienstleistungs_buttons, SWT.CHECK);
		c_waschen_baden.setBounds(0, 0, 16, 20);
		
		Button c_massage = new Button(comp_dienstleistungs_buttons, SWT.CHECK);
		c_massage.setBounds(0, 25, 16, 20);
		
		Button c_schneiden = new Button(comp_dienstleistungs_buttons, SWT.CHECK);
		c_schneiden.setBounds(0, 50, 16, 20);
		
		Button c_entlausen = new Button(comp_dienstleistungs_buttons, SWT.CHECK);
		c_entlausen.setBounds(0, 75, 16, 20);
		
		Button c_entfilzen = new Button(comp_dienstleistungs_buttons, SWT.CHECK);
		c_entfilzen.setBounds(0, 100, 16, 20);
		
		// Eventhandler wenn Checklist 'Entflizen' gecheked wurde  
		c_entfilzen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		// Eventhandler wenn Checklist 'Entlausen' gecheked wurde 
		c_entlausen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		// Eventhandler wenn Checklist 'Schneiden' gecheked wurde 
		c_schneiden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		// Eventhandler wenn Checklist 'Massage' gecheked wurde 
		c_massage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		// Eventhandler wenn Checklist 'Waschen / Baden' gecheked wurde 
		c_waschen_baden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		
		Combo dd_hundauswahl = new Combo(shlTerminbuchung, SWT.NONE);
		dd_hundauswahl.setBounds(291, 187, 97, 28);
		
		Composite comp_dienstleistungs_labels = new Composite(shlTerminbuchung, SWT.NONE);
		comp_dienstleistungs_labels.setBounds(22, 32, 185, 183);
		
		Label l_buchbare_dienstleistungen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_buchbare_dienstleistungen.setBounds(0, 0, 176, 20);
		l_buchbare_dienstleistungen.setText("Buchbare Dienslteistungen");
		
		Label l_hundauswahl = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_hundauswahl.setBounds(0, 158, 156, 20);
		l_hundauswahl.setText("Waehlen Sie ihren Hund");
		
		Label l_entfilzen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entfilzen.setBounds(0, 129, 57, 20);
		l_entfilzen.setText("Entfilzen");
		
		Label l_entlausen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entlausen.setBounds(0, 100, 63, 20);
		l_entlausen.setText("Entlausen");
		
		Label l_schneiden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_schneiden.setBounds(0, 75, 68, 20);
		l_schneiden.setText("Schneiden");
		
		Label l_massage = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_massage.setBounds(0, 50, 58, 20);
		l_massage.setText("Massage");
		
		Label l_waschen_baden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_waschen_baden.setBounds(0, 25, 114, 20);
		l_waschen_baden.setText("Waschen / Baden");
		
		Button b_termin_buchen = new Button(shlTerminbuchung, SWT.NONE);
		b_termin_buchen.setBounds(278, 520, 132, 30);
		b_termin_buchen.setText("Termin Buchen");
		
		Button b_zurueck = new Button(shlTerminbuchung, SWT.NONE);
		b_zurueck.setLocation(22, 519);
		b_zurueck.setSize(62, 30);
		b_zurueck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		b_zurueck.setText("Zurueck");
		
		
	}
}
