package view.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import view.View;

public class Kundeneingabe implements View {

	private Shell shell;
	private Text text;
	private Text text_1;
	private Label lblBitteGebenSie;
	private Label lblVorname;
	private Label lblNachname;
	private Button btnNewButton;
	private Button btnWeiter;

	public Kundeneingabe(Shell shell) {
		this.shell = shell;
		assignElements();
	}

	/**
	 * Open the window..
	 */
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
		initText();
		initLabel();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(453, 298);
		shell.setText("Kundendaten eingeben");

	}

	private void initText() {
		// I. Text
		text.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text.setBounds(197, 99, 143, 25);

		// II. Text
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_1.setBounds(197, 143, 143, 25);

	}

	private void initLabel() {
		// I. Label: "Bitte geben Sie die Daten des Kunden ein"
		lblBitteGebenSie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBitteGebenSie.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblBitteGebenSie.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblBitteGebenSie.setBounds(43, 46, 359, 38);
		lblBitteGebenSie.setText("Bitte geben Sie die Daten des Kunden ein");

		// II. Label: Vorname
		lblVorname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblVorname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblVorname.setText("Vorname");
		lblVorname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblVorname.setBounds(91, 101, 91, 38);

		// III. Label: Nachname
		lblNachname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNachname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNachname.setText("Nachname");
		lblNachname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblNachname.setBounds(91, 145, 91, 38);
	}

	private void initButtons() {
		// I. Button: Zurueck
		btnNewButton.setBounds(43, 199, 75, 25);
		btnNewButton.setText("Zur\u00FCck");

		btnWeiter.setBounds(320, 199, 75, 25);
		btnWeiter.setText("Weiter");
	}

	@Override
	public void assignElements() {
		lblBitteGebenSie = new Label(shell, SWT.NONE);
		text = new Text(shell, SWT.BORDER);
		lblVorname = new Label(shell, SWT.NONE);
		lblNachname = new Label(shell, SWT.NONE);
		text_1 = new Text(shell, SWT.BORDER);
		btnNewButton = new Button(shell, SWT.NONE);
		btnWeiter = new Button(shell, SWT.NONE);

	}

	@Override
	public void dispose() {
		text.dispose();
		text_1.dispose();
		lblBitteGebenSie.dispose();
		lblVorname.dispose();
		lblNachname.dispose();
		btnNewButton.dispose();
		btnWeiter.dispose();
		assignElements();

	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText_1() {
		return text_1;
	}

	public void setText_1(Text text_1) {
		this.text_1 = text_1;
	}

	public Label getLblBitteGebenSie() {
		return lblBitteGebenSie;
	}

	public void setLblBitteGebenSie(Label lblBitteGebenSie) {
		this.lblBitteGebenSie = lblBitteGebenSie;
	}

	public Label getLblVorname() {
		return lblVorname;
	}

	public void setLblVorname(Label lblVorname) {
		this.lblVorname = lblVorname;
	}

	public Label getLblNachname() {
		return lblNachname;
	}

	public void setLblNachname(Label lblNachname) {
		this.lblNachname = lblNachname;
	}

	public Button getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(Button btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public Button getBtnWeiter() {
		return btnWeiter;
	}

	public void setBtnWeiter(Button btnWeiter) {
		this.btnWeiter = btnWeiter;
	}

}
