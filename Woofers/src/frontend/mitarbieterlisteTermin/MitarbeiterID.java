package frontend.mitarbieterlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import view.View;

public class MitarbeiterID implements View {

	private Shell shell;
	private Combo combo;
	private Label lblBitteWhlenSie;
	private Button btnNewButton;
	private Button btnOk;

	public MitarbeiterID(Shell shell) {
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
		initCombo();
		initLabels();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(275, 212);
		shell.setText("Mitarbeiter ausw\u00E4hlen");
	}

	private void initCombo() {
		combo.setBounds(32, 71, 198, 30);
	}

	private void initLabels() {
		// I. Label: "Bitte waehlen Sie die ID eines Mitarbeiters"
		lblBitteWhlenSie.setAlignment(SWT.CENTER);
		lblBitteWhlenSie.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblBitteWhlenSie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBitteWhlenSie.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblBitteWhlenSie.setBounds(22, 22, 222, 43);
		lblBitteWhlenSie.setText("Bitte w\u00E4hlen Sie die ID eines Mitarbiters");
	}

	private void initButtons() {
		// I. Button: Zurueck
		btnNewButton.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnNewButton.setBounds(32, 115, 93, 25);
		btnNewButton.setText("Zur\u00FCck");

		// II. Button: Ok
		btnOk.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnOk.setText("OK");
		btnOk.setBounds(131, 115, 99, 25);
	}

	@Override
	public void assignElements() {
		combo = new Combo(shell, SWT.READ_ONLY);
		lblBitteWhlenSie = new Label(shell, SWT.NONE);
		btnNewButton = new Button(shell, SWT.NONE);
		btnOk = new Button(shell, SWT.NONE);
	}

	@Override
	public void dispose() {
		combo.dispose();
		lblBitteWhlenSie.dispose();
		btnNewButton.dispose();
		btnOk.dispose();
		assignElements();

	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(String[] inhalte) {
		this.combo.setItems(inhalte);
	}

	public Label getLblBitteWhlenSie() {
		return lblBitteWhlenSie;
	}

	public void setLblBitteWhlenSie(Label lblBitteWhlenSie) {
		this.lblBitteWhlenSie = lblBitteWhlenSie;
	}

	public Button getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(Button btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public Button getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(Button btnOk) {
		this.btnOk = btnOk;
	}

}
