package view.bearbeiten;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import view.View;

public class BearbeiteKunde implements View {

	protected Shell shell;

	private Label customerId;
	private Label surnameId;
	private Label mobile;
	private Label email;
	private Label customerIdInput;
	private Label profile;

	private Text name;
	private Text mobileInput;
	private Text emailInput;

	private Button save;

	public BearbeiteKunde(Shell shell) {
		this.shell = shell;
		weiseElementeZu();
	}

	@Override
	public void init() {
		initShell();
		initLabels();
		initButtons();
		initText();
	}

	@Override
	public void weiseElementeZu() {
		customerId = new Label(shell, SWT.NONE);
		surnameId = new Label(shell, SWT.NONE);
		mobile = new Label(shell, SWT.NONE);
		email = new Label(shell, SWT.NONE);
		customerIdInput = new Label(shell, SWT.NONE);
		profile = new Label(shell, SWT.NONE);
		name = new Text(shell, SWT.BORDER);
		mobileInput = new Text(shell, SWT.BORDER);
		emailInput = new Text(shell, SWT.BORDER);
		save = new Button(shell, SWT.NONE);
	}

	@Override
	public void entsorge() {
		customerId.dispose();
		surnameId.dispose();
		mobile.dispose();
		email.dispose();
		customerIdInput.dispose();
		profile.dispose();
		name.dispose();
		mobileInput.dispose();
		emailInput.dispose();
		save.dispose();
		weiseElementeZu();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(391, 437);
		shell.setText("Kunden bearbeiten");
		shell.setLayout(null);
	}

	private void initLabels() {
		customerId.setAlignment(SWT.RIGHT);
		customerId.setForeground(SWTResourceManager.getColor(255, 255, 128));
		customerId.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		customerId.setBackground(SWTResourceManager.getColor(64, 0, 128));
		customerId.setBounds(5, 48, 120, 37);
		customerId.setText("KundeID:");

		surnameId.setText("Nachname");
		surnameId.setForeground(SWTResourceManager.getColor(255, 255, 255));
		surnameId.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		surnameId.setBackground(SWTResourceManager.getColor(64, 0, 128));
		surnameId.setBounds(46, 122, 110, 37);

		mobile.setText("Telefonnummer");
		mobile.setForeground(SWTResourceManager.getColor(255, 255, 255));
		mobile.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		mobile.setBackground(SWTResourceManager.getColor(64, 0, 128));
		mobile.setBounds(46, 190, 145, 37);

		email.setText("Mail");
		email.setForeground(SWTResourceManager.getColor(255, 255, 255));
		email.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		email.setBackground(SWTResourceManager.getColor(64, 0, 128));
		email.setBounds(46, 258, 145, 37);

		customerIdInput.setForeground(SWTResourceManager.getColor(255, 255, 0));
		customerIdInput.setBackground(SWTResourceManager.getColor(64, 0, 128));
		customerIdInput.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		customerIdInput.setBounds(132, 48, 75, 25);
		// TODO Profilbearbeitung: Eigentlichen KundenID einsetzen

		profile.setAlignment(SWT.CENTER);
		profile.setText("Profil");
		profile.setForeground(SWTResourceManager.getColor(255, 255, 255));
		profile.setFont(SWTResourceManager.getFont("Brush Script MT", 28, SWT.NORMAL));
		profile.setBackground(SWTResourceManager.getColor(64, 0, 128));
		profile.setBounds(207, 38, 110, 47);
	}

	private void initButtons() {
				/*
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				try {
					// TODO Profilbearbeitung: Kundendaten m�ssen in DB aktualisiert werden
					new Meldungsfenster("Kundendaten gespeichert", "Ihre Kundendaten wurden aktualisiert!");
					shell.close();
					Hauptfenster.main(null);
				} catch (Exception e2) {

				}
			}
		});
		 */
		save.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		save.setText("Speichern");
		save.setBounds(143, 325, 75, 25);
	}

	private void initText() {
		// TODO Profilbearbeitung: Eigentlichen Nachnamen reinklatschen
		name.setBounds(200, 122, 130, 21);


		// TODO Profilbearbeitung: Eigentlichen Telefonnummer einsetzen
		mobileInput.setBounds(200, 190, 130, 21);

		emailInput.setBounds(200, 258, 130, 21);
	}

	public Shell getShell() {
		return shell;
	}

	public Label getCustomerId() {
		return customerId;
	}

	public Label getSurnameId() {
		return surnameId;
	}

	public Label getMobile() {
		return mobile;
	}

	public Label getEmail() {
		return email;
	}

	public Label getCustomerIdInput() {
		return customerIdInput;
	}

	public Label getProfile() {
		return profile;
	}

	public Text getName() {
		return name;
	}

	public Text getMobileInput() {
		return mobileInput;
	}

	public Text getEmailInput() {
		return emailInput;
	}

	public Button getSave() {
		return save;
	}

}
