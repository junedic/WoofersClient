package view.bearbeiteKunden;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import view.commons.Hauptfenster;
import view.commons.Meldungsfenster;

public class Profilbearbeitung {

	protected Shell shlTerminidEingeben;
	private Text text;
	private Text text_1;
	private Text txtGntherwebde;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Profilbearbeitung window = new Profilbearbeitung();
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

		/** get the size of the screen */
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bounds = primary.getBounds();
		/** get the size of the window */
		Rectangle rect = shlTerminidEingeben.getBounds();
		/** calculate the centre */
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		/** set the new location */
		shlTerminidEingeben.setLocation(x, y);

		shlTerminidEingeben.open();
		shlTerminidEingeben.layout();
		while (!shlTerminidEingeben.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTerminidEingeben = new Shell();
		shlTerminidEingeben.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlTerminidEingeben.setSize(391, 437);
		shlTerminidEingeben.setText("Kunden bearbeiten");
		shlTerminidEingeben.setLayout(null);

		Label lblNewLabel = new Label(shlTerminidEingeben, SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 128));
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNewLabel.setBounds(5, 48, 120, 37);
		lblNewLabel.setText("KundeID:");

		Button btnZurck = new Button(shlTerminidEingeben, SWT.NONE);
		btnZurck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				try {
					// TODO Profilbearbeitung: Kundendaten m�ssen in DB aktualisiert werden
					new Meldungsfenster("Kundendaten gespeichert", "Ihre Kundendaten wurden aktualisiert!");
					shlTerminidEingeben.close();
					Hauptfenster.main(null);
				} catch (Exception e2) {

				}
			}
		});
		btnZurck.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnZurck.setText("Speichern");
		btnZurck.setBounds(143, 325, 75, 25);

		Label lblTerminid = new Label(shlTerminidEingeben, SWT.NONE);
		lblTerminid.setText("Nachname");
		lblTerminid.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTerminid.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblTerminid.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblTerminid.setBounds(46, 122, 110, 37);

		text = new Text(shlTerminidEingeben, SWT.BORDER);
		// TODO Profilbearbeitung: Eigentlichen Nachnamen reinklatschen
		text.setText("G�nther");
		text.setBounds(200, 122, 130, 21);

		Label lblTelefonnummer = new Label(shlTerminidEingeben, SWT.NONE);
		lblTelefonnummer.setText("Telefonnummer");
		lblTelefonnummer.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTelefonnummer.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblTelefonnummer.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblTelefonnummer.setBounds(46, 190, 145, 37);

		Label lblMail = new Label(shlTerminidEingeben, SWT.NONE);
		lblMail.setText("Mail");
		lblMail.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblMail.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblMail.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblMail.setBounds(46, 258, 145, 37);

		text_1 = new Text(shlTerminidEingeben, SWT.BORDER);
		// TODO Profilbearbeitung: Eigentlichen Telefonnummer einsetzen
		text_1.setText("+49 5252");
		text_1.setBounds(200, 190, 130, 21);

		txtGntherwebde = new Text(shlTerminidEingeben, SWT.BORDER);
		txtGntherwebde.setText("G\u00FCnther@web.de");
		txtGntherwebde.setBounds(200, 258, 130, 21);

		Label lblNewLabel_1 = new Label(shlTerminidEingeben, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 255, 0));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblNewLabel_1.setBounds(132, 48, 75, 25);
		// TODO Profilbearbeitung: Eigentlichen KundenID einsetzen
		lblNewLabel_1.setText("X");

		Label lblProfil = new Label(shlTerminidEingeben, SWT.NONE);
		lblProfil.setAlignment(SWT.CENTER);
		lblProfil.setText("Profil");
		lblProfil.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblProfil.setFont(SWTResourceManager.getFont("Brush Script MT", 28, SWT.NORMAL));
		lblProfil.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblProfil.setBounds(207, 38, 110, 47);

	}
}
