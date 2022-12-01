package GUI;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class Willkommen extends org.eclipse.swt.widgets.Composite {
	private Text txtBenutzerId;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Willkommen(Willkommen parent, int style) {
		super(parent, style);
		setLayout(null);
		
		Button btnAbschicken = new Button(this, SWT.NONE);
		btnAbschicken.setBounds(159, 207, 75, 25);
		btnAbschicken.setText("Abschicken");
		
		txtBenutzerId = new Text(this, SWT.BORDER);
		txtBenutzerId.setText("Benutzer ID");
		txtBenutzerId.setBounds(159, 118, 76, 21);
		
		Label lblWillkommenBeiWoofers = new Label(this, SWT.NONE);
		lblWillkommenBeiWoofers.setBounds(122, 47, 157, 15);
		lblWillkommenBeiWoofers.setText("Willkommen bei WOOFERS !");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
