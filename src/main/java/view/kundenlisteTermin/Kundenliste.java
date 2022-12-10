package view.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import view.View;

public class Kundenliste implements View {

	private Shell shell;
	private Button btnNewButton;
	private Label lblWelchenGenauMeinen;
	private Label lblKundenid;
	private Label lblX;
	private List list;

	public Kundenliste(Shell shell) {
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
		shell.setTouchEnabled(true);
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(497, 462);
		shell.setText("Mehrere gleichnamige Kunden");
	}

	private void initLabels() {
		// I. Label: "Terminliste"
		lblWelchenGenauMeinen.setForeground(SWTResourceManager.getColor(255, 128, 0));
		lblWelchenGenauMeinen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblWelchenGenauMeinen.setText("Terminliste");
		lblWelchenGenauMeinen.setFont(SWTResourceManager.getFont("Ink Free", 26, SWT.BOLD));
		lblWelchenGenauMeinen.setAlignment(SWT.CENTER);
		lblWelchenGenauMeinen.setBounds(100, 119, 272, 38);

		// II. Label: "KundenID"
		lblKundenid.setText("KundenID:");
		lblKundenid.setForeground(SWTResourceManager.getColor(255, 128, 0));
		lblKundenid.setFont(SWTResourceManager.getFont("Arial", 19, SWT.NORMAL));
		lblKundenid.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblKundenid.setAlignment(SWT.CENTER);
		lblKundenid.setBounds(141, 50, 143, 38);

		// III. Label: Platzhalter f�r die KundenID
		lblX.setText("X");
		lblX.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblX.setFont(SWTResourceManager.getFont("Arial", 19, SWT.NORMAL));
		lblX.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblX.setAlignment(SWT.CENTER);
		lblX.setBounds(273, 50, 44, 38);
	}

	private void initButtons() {
		// I. Button: Zurueck zum Hauptmenue
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnNewButton.setText("Zur\u00FCck zum Hauptemen\u00FC");
		btnNewButton.setBounds(111, 348, 271, 25);

	}

	private void initList() {
		// I. List: Enthaelt alle Termine eines Kunden
		list.setTouchEnabled(true);
		list.setBounds(65, 179, 359, 136);
	}

	@Override
	public void assignElements() {
		lblWelchenGenauMeinen = new Label(shell, SWT.NONE);
		list = new List(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		lblKundenid = new Label(shell, SWT.NONE);
		lblX = new Label(shell, SWT.NONE);

	}

	@Override
	public void dispose() {
		lblWelchenGenauMeinen.dispose();
		list.dispose();
		lblKundenid.dispose();
		lblX.dispose();
		assignElements();

	}

	public Button getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(Button btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public Label getLblWelchenGenauMeinen() {
		return lblWelchenGenauMeinen;
	}

	public void setLblWelchenGenauMeinen(Label lblWelchenGenauMeinen) {
		this.lblWelchenGenauMeinen = lblWelchenGenauMeinen;
	}

	public Label getLblKundenid() {
		return lblKundenid;
	}

	public void setLblKundenid(Label lblKundenid) {
		this.lblKundenid = lblKundenid;
	}

	public Label getLblX() {
		return lblX;
	}

	public void setLblX(Label lblX) {
		this.lblX = lblX;
	}

	public List getList() {
		return list;
	}

	public void setList(String[] inhalte) {
		this.list.setItems(inhalte);
	}

}
