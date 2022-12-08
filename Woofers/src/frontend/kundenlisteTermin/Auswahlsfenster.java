package frontend.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import view.View;

public class Auswahlsfenster implements View {

	private Shell shell;
	private Label lblAnscheinendGibtEs;
	private Label lblVorname;
	private Button btnZurueck;
	private Button btnWeiter;
	private Label lblWelchenGenauMeinen;
	private List list;

	public Auswahlsfenster(Shell shell) {
		this.shell = shell;
		assignElements();
	}

	public void open() {
		Display display = Display.getDefault();
		init();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	@Override
	public void init() {
		initShell();
		initLabels();
		initButtons();
		initList();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(497, 462);
		shell.setText("Mehrere gleichnamige Kunden");
	}

	private void initLabels() {
		// I. Label: Textabsatz - "Anscheinend gibt es mehrere"
		lblAnscheinendGibtEs.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblAnscheinendGibtEs.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblAnscheinendGibtEs.setAlignment(SWT.CENTER);
		lblAnscheinendGibtEs.setText("Anscheinend gibt es mehrere");
		lblAnscheinendGibtEs.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblAnscheinendGibtEs.setBounds(65, 46, 359, 38);

		// II. Label: Platzhalter fuer den Vornamen
		lblVorname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblVorname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblVorname.setText("Vorname + Nachname");
		lblVorname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblVorname.setAlignment(SWT.CENTER);
		lblVorname.setBounds(139, 90, 198, 38);

		// III. Label: Textabsatz - "Welchen genau meinen Sie?"
		lblWelchenGenauMeinen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblWelchenGenauMeinen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblWelchenGenauMeinen.setText("Welchen genau meinen Sie?");
		lblWelchenGenauMeinen.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblWelchenGenauMeinen.setAlignment(SWT.CENTER);
		lblWelchenGenauMeinen.setBounds(108, 141, 272, 38);

	}

	private void initButtons() {
		// I. Button: Mit Aufschrift - "Zurueck"
		btnZurueck.setText("Zur\u00FCck");
		btnZurueck.setBounds(65, 344, 75, 25);
		btnWeiter.setText("Weiter");
		btnWeiter.setBounds(349, 344, 75, 25);
	}

	private void initList() {
		list.setBounds(65, 179, 359, 136);
	}

	@Override
	public void assignElements() {
		lblAnscheinendGibtEs = new Label(shell, SWT.NONE);
		lblVorname = new Label(shell, SWT.NONE);
		btnZurueck = new Button(shell, SWT.NONE);
		btnWeiter = new Button(shell, SWT.NONE);
		lblWelchenGenauMeinen = new Label(shell, SWT.NONE);
		list = new List(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

	}

	@Override
	public void dispose() {
		lblAnscheinendGibtEs.dispose();
		lblVorname.dispose();
		btnZurueck.dispose();
		btnWeiter.dispose();
		lblWelchenGenauMeinen.dispose();
		list.dispose();
		assignElements();
	}

	public Button getBtnZurueck() {
		return btnZurueck;
	}

	public Button getBtnWeiter() {
		return btnWeiter;
	}

	public Label getLblVorname() {
		return lblVorname;
	}

	public void setLblVorname(Label lblVorname) {
		this.lblVorname = lblVorname;
	}

	/**
	 * 
	 * Dies ist eine Liste, welche mit einem String-Array gesetzt wird
	 * 
	 * @param inhalte Format: "+Vorname+" "+Nachname+" mit ID:"+ID+" und dem Hund
	 *                "+Hund"
	 */
	public void setList(String[] inhalte) {
		this.list.setItems(inhalte);
	}

}
