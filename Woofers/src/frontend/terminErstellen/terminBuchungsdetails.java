package frontend.terminErstellen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class terminBuchungsdetails {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			terminBuchungsdetails window = new terminBuchungsdetails();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(642, 463);
		shell.setText("SWT Application");
		
		
		/*
		 * Je nachdem welche Dienstleistungen gebucht werden müssen diese auch angezeigt werden
		 * gebuchte dienstleistungen können aus nem boolean array ausgelesen werden
		 * 
		 */
		
		Label lblBuchungsdetails = new Label(shell, SWT.NONE);
		lblBuchungsdetails.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblBuchungsdetails.setBounds(212, 33, 200, 30);
		lblBuchungsdetails.setText("Buchungsdetails");
		
		Composite comp_dienstleistungs_labels = new Composite(shell, SWT.NONE);
		comp_dienstleistungs_labels.setBounds(47, 86, 251, 252);
		
		Label l_buchbare_dienstleistungen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_buchbare_dienstleistungen.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		l_buchbare_dienstleistungen.setText("Gebuchte Dienstleistungen");
		l_buchbare_dienstleistungen.setBounds(0, 0, 241, 20);
		
		Label l_entfilzen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entfilzen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entfilzen.setText("[Entfilzen]");
		l_entfilzen.setBounds(0, 138, 68, 20);
		
		Label l_entlausen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_entlausen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entlausen.setText("[Entlausen]");
		l_entlausen.setBounds(0, 109, 77, 20);
		
		Label l_schneiden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_schneiden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_schneiden.setText("[Schneiden]");
		l_schneiden.setBounds(0, 84, 77, 20);
		
		Label l_massage = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_massage.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_massage.setText("[Massage]");
		l_massage.setBounds(0, 59, 68, 20);
		
		Label l_waschen_baden = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_waschen_baden.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_waschen_baden.setText("[Waschen / Baden]");
		l_waschen_baden.setBounds(0, 34, 136, 20);
		
		Label l_preis = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_preis.setText("Preis :");
		l_preis.setBounds(0, 164, 49, 20);
		
		Label l_preis_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1.setText("[Preis]");
		l_preis_1.setBounds(48, 164, 49, 20);
		
		Composite comp_dienstleistungs_labels_1 = new Composite(shell, SWT.NONE);
		comp_dienstleistungs_labels_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		comp_dienstleistungs_labels_1.setBounds(324, 86, 261, 252);
		
		Label l_buchbare_dienstleistungen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_buchbare_dienstleistungen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_buchbare_dienstleistungen_1.setText("Für Ihren Hund");
		l_buchbare_dienstleistungen_1.setBounds(0, 34, 102, 20);
		
		Label l_hundauswahl_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_hundauswahl_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_hundauswahl_1.setText("Um");
		l_hundauswahl_1.setBounds(0, 138, 33, 20);
		
		Label l_entfilzen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_entfilzen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_entfilzen_1.setText("[Datum]");
		l_entfilzen_1.setBounds(39, 112, 57, 20);
		
		Label l_entlausen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_entlausen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entlausen_1.setText("Am");
		l_entlausen_1.setBounds(0, 112, 33, 20);
		
		Label l_schneiden_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_schneiden_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_schneiden_1.setText("[Mitarbeitername]");
		l_schneiden_1.setBounds(0, 86, 132, 20);
		
		Label l_massage_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_massage_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_massage_1.setText("Bei unserem Mitarbeiter :");
		l_massage_1.setBounds(0, 60, 175, 20);
		
		Label l_waschen_baden_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_waschen_baden_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_waschen_baden_1.setText("[Hundname]");
		l_waschen_baden_1.setBounds(102, 34, 114, 20);
		
		Label l_mitarbeiterauswahl_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_mitarbeiterauswahl_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_mitarbeiterauswahl_1.setText("[UhrzeitZeitslot]");
		l_mitarbeiterauswahl_1.setBounds(39, 138, 122, 20);
		
		Label l_buchbare_dienstleistungen_2 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_buchbare_dienstleistungen_2.setText("Weitere Informationen");
		l_buchbare_dienstleistungen_2.setFont(SWTResourceManager.getFont("Arial", 11, SWT.BOLD));
		l_buchbare_dienstleistungen_2.setBounds(0, 0, 241, 20);
		
		Button btnAngabenAnpassen = new Button(shell, SWT.NONE);
		btnAngabenAnpassen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnAngabenAnpassen.setBounds(45, 359, 137, 30);
		btnAngabenAnpassen.setText("Angaben anpassen");
		
		Button btnTerminBuchen = new Button(shell, SWT.NONE);
		btnTerminBuchen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnTerminBuchen.setText("Termin buchen");
		btnTerminBuchen.setBounds(467, 359, 118, 30);

	}
}
