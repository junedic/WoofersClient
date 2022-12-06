package frontend.terminErstellen;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class terminErstellen {

	/**
	 * LEGENDE
	 * c_* 	-> sind checkboxen
	 * l_* 	-> sind labels
	 * b_* 	-> sind buttons
	 * dd_* -> sind drop-downs
	 * 
	 * @version 1.2
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
		shlTerminbuchung.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlTerminbuchung.setSize(422, 660);
		shlTerminbuchung.setText("Termin erstellen");
		shlTerminbuchung.setLayout(null);
		
		DateTime date_picker = new DateTime(shlTerminbuchung, SWT.BORDER | SWT.CALENDAR);
		date_picker.setLocation(33, 349);
		date_picker.setSize(178, 143);
		
		Composite comp_zeitslot_buttons = new Composite(shlTerminbuchung, SWT.NONE);
		comp_zeitslot_buttons.setBackground(SWTResourceManager.getColor(64, 0, 128));
		comp_zeitslot_buttons.setBounds(217, 322, 161, 211);
		comp_zeitslot_buttons.setLayout(null);
		
		Label l_verfuegbare_zeitslots = new Label(comp_zeitslot_buttons, SWT.NONE);
		l_verfuegbare_zeitslots.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_verfuegbare_zeitslots.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_verfuegbare_zeitslots.setAlignment(SWT.CENTER);
		l_verfuegbare_zeitslots.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_verfuegbare_zeitslots.setBounds(10, 0, 148, 20);
		l_verfuegbare_zeitslots.setText("Verf\u00FCgbare Zeitslots");
		
		Button b_zeitslot1 = new Button(comp_zeitslot_buttons, SWT.NONE);
		b_zeitslot1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		// Eventhandler wenn Button 'Zeitslot 1' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot1.setBounds(35, 26, 90, 30);
		b_zeitslot1.setText("08:00 - 09:30");
		
		Button b_zeitslot2 = new Button(comp_zeitslot_buttons, SWT.NONE);
		b_zeitslot2.setText("09:45 - 11:15");
		// Eventhandler wenn Button 'Zeitslot 2' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot2.setBounds(35, 62, 90, 30);
		
		Button b_zeitslot3 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 3' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot3.setBounds(35, 98, 90, 30);
		b_zeitslot3.setText("12:00 - 13:30");
		
		Button b_zeitslot4 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 4' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot4.setBounds(35, 134, 90, 30);
		b_zeitslot4.setText("13:40 - 15:10");
		
		Button b_zeitslot5 = new Button(comp_zeitslot_buttons, SWT.NONE);
		// Eventhandler wenn Button 'Zeitslot 5' gewählt wurde
		// Je nachdem ob der Zeitslot bereits gebucht wurde muss dieser Button ausgegraut / selektierbar sein
		b_zeitslot5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		b_zeitslot5.setBounds(35, 170, 90, 30);
		b_zeitslot5.setText("15:20 - 16:50");
		
		Combo dd_hundauswahl = new Combo(shlTerminbuchung, SWT.NONE);
		dd_hundauswahl.setBounds(230, 220, 132, 28);
		
		Combo dd_mitarbeiterauswahl = new Combo(shlTerminbuchung, SWT.NONE);
		dd_mitarbeiterauswahl.setBounds(230, 250, 132, 28);
		
		Composite comp_dienstleistungs_labels = new Composite(shlTerminbuchung, SWT.NONE);
		comp_dienstleistungs_labels.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		comp_dienstleistungs_labels.setBackground(SWTResourceManager.getColor(64, 0, 128));
		comp_dienstleistungs_labels.setBounds(20, 77, 202, 239);
		
		Label l_preis = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_preis.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_preis.setBounds(50, 205, 70, 20);
		l_preis.setText("Preis :");
		
		Label l_hundauswahl = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_hundauswahl.setAlignment(SWT.RIGHT);
		l_hundauswahl.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_hundauswahl.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_hundauswahl.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_hundauswahl.setBounds(20, 145, 156, 20);
		l_hundauswahl.setText("W\u00E4hlen Sie ihren Hund");
		
		Label l_entfilzen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entfilzen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entfilzen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_entfilzen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_entfilzen.setBounds(50, 117, 57, 20);
		l_entfilzen.setText("Entfilzen");
		
		Label l_entlausen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entlausen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entlausen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_entlausen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_entlausen.setBounds(50, 92, 63, 20);
		l_entlausen.setText("Entlausen");
		
		Label l_schneiden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_schneiden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_schneiden.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_schneiden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_schneiden.setBounds(50, 67, 68, 20);
		l_schneiden.setText("Schneiden");
		
		Label l_massage = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_massage.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_massage.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_massage.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_massage.setBounds(50, 42, 58, 20);
		l_massage.setText("Massage");
		
		Label l_waschen_baden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_waschen_baden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_waschen_baden.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_waschen_baden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_waschen_baden.setBounds(50, 17, 114, 20);
		l_waschen_baden.setText("Waschen / Baden");
		
		Label l_mitarbeiterauswahl = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_mitarbeiterauswahl.setAlignment(SWT.RIGHT);
		l_mitarbeiterauswahl.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_mitarbeiterauswahl.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_mitarbeiterauswahl.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_mitarbeiterauswahl.setBounds(5, 175, 192, 20);
		l_mitarbeiterauswahl.setText("W\u00E4hlen Sie den Mitarbeiter");
		
		Button b_bestelluebersicht = new Button(shlTerminbuchung, SWT.NONE);
		b_bestelluebersicht.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		b_bestelluebersicht.setBounds(232, 560, 151, 30);
		b_bestelluebersicht.setText("Bestell\u00FCbersicht");
		
		Button b_zurueck = new Button(shlTerminbuchung, SWT.NONE);
		b_zurueck.setLocation(33, 560);
		b_zurueck.setSize(151, 30);
		b_zurueck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		b_zurueck.setText("Zur\u00FCck");
		
		Label l_preis_var = new Label(shlTerminbuchung, SWT.NONE);
		l_preis_var.setBounds(230, 283, 132, 20);
		l_preis_var.setText("[Preis]");
		
		Button c_waschen_baden = new Button(shlTerminbuchung, SWT.BORDER | SWT.CHECK);
		c_waschen_baden.setBounds(230, 91, 16, 19);
		c_waschen_baden.setForeground(SWTResourceManager.getColor(64, 0, 128));
		
		Button c_massage = new Button(shlTerminbuchung, SWT.BORDER | SWT.CHECK);
		c_massage.setBounds(230, 116, 16, 20);

		Button c_massage_1 = new Button(shlTerminbuchung, SWT.BORDER | SWT.CHECK);
		c_massage_1.setBounds(230, 142, 16, 20);

		Button c_massage_2 = new Button(shlTerminbuchung, SWT.BORDER | SWT.CHECK);
		c_massage_2.setBounds(230, 194, 16, 20);

		Button c_massage_3 = new Button(shlTerminbuchung, SWT.BORDER | SWT.CHECK);
		c_massage_3.setBounds(230, 168, 16, 20);

		Label l_buchbare_dienstleistungen_1 = new Label(shlTerminbuchung, SWT.NONE);
		l_buchbare_dienstleistungen_1.setText("Termin erstellen");
		l_buchbare_dienstleistungen_1.setForeground(SWTResourceManager.getColor(255, 128, 0));
		l_buchbare_dienstleistungen_1.setFont(SWTResourceManager.getFont("Lucida Handwriting", 17, SWT.BOLD));
		l_buchbare_dienstleistungen_1.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_buchbare_dienstleistungen_1.setBounds(100, 23, 239, 30);
		
		Label l_buchbare_dienstleistungen = new Label(shlTerminbuchung, SWT.NONE);
		l_buchbare_dienstleistungen.setBounds(125, 59, 176, 20);
		l_buchbare_dienstleistungen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_buchbare_dienstleistungen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_buchbare_dienstleistungen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		l_buchbare_dienstleistungen.setText("Buchbare Dienslteistungen");
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
		
		
	}
}
