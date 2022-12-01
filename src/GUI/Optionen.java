package GUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

public class Optionen extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Optionen(Composite parent, int style) {
		super(parent, style);
		
		Label lblHallovornamenachname = new Label(this, SWT.NONE);
		lblHallovornamenachname.setBounds(247, 100, 167, 25);
		lblHallovornamenachname.setText("Hallo [Vorname] [Nachname] !");
		
		Button btnNeuenTerminErstellen = new Button(this, SWT.NONE);
		btnNeuenTerminErstellen.setBounds(166, 184, 163, 25);
		btnNeuenTerminErstellen.setText("Neuen Termin Erstellen");
		
		Button btnBestehendenTerminLschen = new Button(this, SWT.NONE);
		btnBestehendenTerminLschen.setText("Bestehenden Termin l\u00F6schen");
		btnBestehendenTerminLschen.setBounds(367, 184, 177, 25);
		
		Button btnNeuenTerminErstellen_1_1 = new Button(this, SWT.NONE);
		btnNeuenTerminErstellen_1_1.setText("Bestehende Termine bearbeiten");
		btnNeuenTerminErstellen_1_1.setBounds(367, 267, 177, 25);
		
		Button btnNeuenTerminErstellen_1_1_1 = new Button(this, SWT.NONE);
		btnNeuenTerminErstellen_1_1_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNeuenTerminErstellen_1_1_1.setText("Bestehende Termine anzeigen");
		btnNeuenTerminErstellen_1_1_1.setBounds(166, 267, 163, 25);
		
		Button btnLogout = new Button(this, SWT.NONE);
		btnLogout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogout.setText("Logout");
		btnLogout.setBounds(43, 20, 65, 25);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
