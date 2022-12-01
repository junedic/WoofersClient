package GUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TerminErstellung extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TerminErstellung(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		
		Label lblNeuenTerminErstellen = new Label(this, SWT.NONE);
		lblNeuenTerminErstellen.setBounds(158, 35, 128, 15);
		lblNeuenTerminErstellen.setText("Neuen Termin Erstellen");
		
		Button btnTerminBuchen = new Button(this, SWT.NONE);
		btnTerminBuchen.setBounds(23, 432, 102, 25);
		btnTerminBuchen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnTerminBuchen.setText("Zur\u00FCck");
		
		Button btnTerminBuchen_1 = new Button(this, SWT.NONE);
		btnTerminBuchen_1.setBounds(291, 432, 102, 25);
		btnTerminBuchen_1.setText("Termin Buchen");
		
		Label lblAngeboteneDienstleistungen = new Label(this, SWT.NONE);
		lblAngeboteneDienstleistungen.setBounds(35, 73, 170, 15);
		lblAngeboteneDienstleistungen.setText("Angebotene Dienstleistungen :");
		
		List list = new List(this, SWT.BORDER);
		list.setBounds(35, 95, 266, 104);
		list.setItems(new String[] {"DL 1", "DL 2", "DL 3", "DL 4", "DL 5", "DL 6"});
		
		Label lblPreispreis = new Label(this, SWT.NONE);
		lblPreispreis.setBounds(35, 205, 128, 15);
		lblPreispreis.setText("Preis : [Preis Summe]");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
