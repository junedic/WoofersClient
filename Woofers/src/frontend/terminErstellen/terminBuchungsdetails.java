package frontend.terminErstellen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class terminBuchungsdetails {

	protected Shell shlBuchungBesttigen;

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
		shlBuchungBesttigen.open();
		shlBuchungBesttigen.layout();
		while (!shlBuchungBesttigen.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBuchungBesttigen = new Shell();
		shlBuchungBesttigen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlBuchungBesttigen.setSize(642, 459);
		shlBuchungBesttigen.setText("Buchungsinformationen");
		
		
		/*
		 * Je nachdem welche Dienstleistungen gebucht werden müssen diese auch angezeigt werden
		 * gebuchte dienstleistungen können aus nem boolean array ausgelesen werden
		 * 
		 */
		
		Label lblBuchungsdetails = new Label(shlBuchungBesttigen, SWT.NONE);
		lblBuchungsdetails.setBackground(SWTResourceManager.getColor(64, 0, 64));
		lblBuchungsdetails.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBuchungsdetails.setAlignment(SWT.CENTER);
		lblBuchungsdetails.setFont(SWTResourceManager.getFont("Cascadia Mono", 14, SWT.BOLD));
		lblBuchungsdetails.setBounds(0, 37, 634, 30);
		lblBuchungsdetails.setText("Buchungsdetails");
		
		Composite comp_dienstleistungs_labels = new Composite(shlBuchungBesttigen, SWT.NONE);
		comp_dienstleistungs_labels.setBackground(SWTResourceManager.getColor(64, 0, 64));
		comp_dienstleistungs_labels.setBounds(47, 86, 251, 252);
		
		Label l_buchbare_dienstleistungen = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_buchbare_dienstleistungen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_buchbare_dienstleistungen.setBackground(SWTResourceManager.getColor(0, 0, 64));
		l_buchbare_dienstleistungen.setAlignment(SWT.CENTER);
		l_buchbare_dienstleistungen.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		l_buchbare_dienstleistungen.setText("Gebuchte Dienstleistungen");
		l_buchbare_dienstleistungen.setBounds(0, 0, 251, 20);
		
		Label l_preis = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis.setAlignment(SWT.RIGHT);
		l_preis.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_preis.setText("Preis :");
		l_preis.setBounds(82, 204, 49, 20);
		
		Label l_preis_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_preis_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1.setAlignment(SWT.CENTER);
		l_preis_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1.setText("10000");
		l_preis_1.setBounds(137, 204, 49, 20);

		Label l_preis_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1.setText("- Waschen/ Baden");
		l_preis_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1.setBounds(36, 50, 139, 20);

		Label l_preis_1_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1_1.setText("- Massage");
		l_preis_1_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1_1.setBounds(36, 76, 89, 20);

		Label l_preis_1_1_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1_1_1.setText("- Schneiden");
		l_preis_1_1_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1_1_1.setBounds(36, 102, 89, 20);

		Label l_preis_1_1_1_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1_1_1_1.setText("- Entlausen");
		l_preis_1_1_1_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1_1_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1_1_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1_1_1_1.setBounds(36, 128, 89, 20);

		Label l_preis_1_1_1_1_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1_1_1_1_1.setText("- Entfilzen");
		l_preis_1_1_1_1_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1_1_1_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1_1_1_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1_1_1_1_1.setBounds(36, 153, 89, 20);

		Label l_preis_1_1_1_1_1_1_1 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_1_1_1_1_1_1_1.setText("_____________________________________________");
		l_preis_1_1_1_1_1_1_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_preis_1_1_1_1_1_1_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_preis_1_1_1_1_1_1_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_1_1_1_1_1_1_1.setBounds(0, 178, 251, 20);

		Label l_preis_2 = new Label(comp_dienstleistungs_labels, SWT.NONE);
		l_preis_2.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_preis_2.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_preis_2.setText("\u20AC");
		l_preis_2.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_preis_2.setBounds(192, 204, 49, 20);
		
		Composite comp_dienstleistungs_labels_1 = new Composite(shlBuchungBesttigen, SWT.NONE);
		comp_dienstleistungs_labels_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		comp_dienstleistungs_labels_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		comp_dienstleistungs_labels_1.setBounds(324, 86, 261, 252);
		
		Label l_buchbare_dienstleistungen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_buchbare_dienstleistungen_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_buchbare_dienstleistungen_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_buchbare_dienstleistungen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_buchbare_dienstleistungen_1.setText("F\u00FCr Ihren Hund:");
		l_buchbare_dienstleistungen_1.setBounds(60, 41, 112, 20);
		
		Label l_hundauswahl_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_hundauswahl_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_hundauswahl_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_hundauswahl_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_hundauswahl_1.setText("Um");
		l_hundauswahl_1.setBounds(76, 193, 33, 20);
		
		Label l_entfilzen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_entfilzen_1.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_entfilzen_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_entfilzen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_entfilzen_1.setText("[Datum]");
		l_entfilzen_1.setBounds(115, 167, 57, 20);
		
		Label l_entlausen_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_entlausen_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_entlausen_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_entlausen_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_entlausen_1.setText("Am");
		l_entlausen_1.setBounds(76, 167, 33, 20);
		
		Label l_schneiden_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_schneiden_1.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_schneiden_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_schneiden_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_schneiden_1.setText("[Mitarbeitername]");
		l_schneiden_1.setBounds(76, 123, 132, 20);
		
		Label l_massage_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_massage_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_massage_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_massage_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		l_massage_1.setText("Bei unserem Mitarbeiter :");
		l_massage_1.setBounds(60, 96, 175, 20);
		
		Label l_waschen_baden_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_waschen_baden_1.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_waschen_baden_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_waschen_baden_1.setFont(SWTResourceManager.getFont("Arial", 13, SWT.BOLD));
		l_waschen_baden_1.setText("BELLO");
		l_waschen_baden_1.setBounds(76, 67, 70, 20);
		
		Label l_mitarbeiterauswahl_1 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_mitarbeiterauswahl_1.setForeground(SWTResourceManager.getColor(255, 128, 128));
		l_mitarbeiterauswahl_1.setBackground(SWTResourceManager.getColor(64, 0, 64));
		l_mitarbeiterauswahl_1.setFont(SWTResourceManager.getFont("Arial", 9, SWT.BOLD));
		l_mitarbeiterauswahl_1.setText("[UhrzeitZeitslot]");
		l_mitarbeiterauswahl_1.setBounds(113, 193, 122, 20);
		
		Label l_buchbare_dienstleistungen_2 = new Label(comp_dienstleistungs_labels_1, SWT.NONE);
		l_buchbare_dienstleistungen_2.setBackground(SWTResourceManager.getColor(0, 0, 64));
		l_buchbare_dienstleistungen_2.setForeground(SWTResourceManager.getColor(255, 255, 255));
		l_buchbare_dienstleistungen_2.setAlignment(SWT.CENTER);
		l_buchbare_dienstleistungen_2.setText("Weitere Informationen");
		l_buchbare_dienstleistungen_2.setFont(SWTResourceManager.getFont("Cascadia Code", 11, SWT.NORMAL));
		l_buchbare_dienstleistungen_2.setBounds(0, 0, 261, 20);
		
		Button btnAngabenAnpassen = new Button(shlBuchungBesttigen, SWT.NONE);
		btnAngabenAnpassen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnAngabenAnpassen.setBounds(47, 359, 137, 30);
		btnAngabenAnpassen.setText("Angaben anpassen");
		
		Button btnTerminBuchen = new Button(shlBuchungBesttigen, SWT.NONE);
		btnTerminBuchen.setForeground(SWTResourceManager.getColor(0, 0, 0));
		btnTerminBuchen.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnTerminBuchen.setText("Termin buchen");
		btnTerminBuchen.setBounds(467, 359, 118, 30);

	}
}
