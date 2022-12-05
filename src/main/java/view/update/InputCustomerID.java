package view.update;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.io.Closeable;
import java.io.IOException;

public class InputCustomerID implements Closeable {

	private Shell shell;
	private Label customerID;
	private Label appointmentID;
	private Button confirm;
	private Button back;
	private Text text;

	public InputCustomerID(Shell shell) {
		this.shell = shell;
		initShell();
		initLabels();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setSize(371, 273);
		shell.setText("KundenID eingeben");
		shell.setLayout(null);
	}

	private void initLabels() {
		customerID = new Label(shell, SWT.CENTER);
		customerID.setAlignment(SWT.CENTER);
		customerID.setForeground(SWTResourceManager.getColor(255, 255, 255));
		customerID.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		customerID.setBackground(SWTResourceManager.getColor(64, 0, 128));
		customerID.setBounds(57, 27, 244, 56);
		customerID.setText("Bitte geben Sie die ID \r\ndes Kunden ein");

		appointmentID = new Label(shell, SWT.CENTER);
		appointmentID.setText("KundenID");
		appointmentID.setForeground(SWTResourceManager.getColor(255, 255, 255));
		appointmentID.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		appointmentID.setBackground(SWTResourceManager.getColor(64, 0, 128));
		appointmentID.setBounds(75, 103, 110, 37);
	}

	private void initButtons() {
		confirm = new Button(shell, SWT.CENTER);
		/*
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					// TODO KundenNr_Eingabe: Hier erstmal KundenID auf Gueltigkeit ueberpruefen
					// ...
					// ...
					// TODO KundenNr_Eingabe: Daten muessen an den naechsten Screen weitergegeben
					// werden
					// ...
					shell.close();
					Profilbearbeitung.main(null);

				} catch (Exception e2) {
					new Meldungsfenster("Ung\u00fcltige KundenID", "Bitte geben Sie eine g\u00fcltige KundenID ein!");
				}
			}
		});
		 */
		confirm.setBounds(226, 179, 75, 25);
		confirm.setText("OK");

		back = new Button(shell, SWT.CENTER);
		/*
		btnZurck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				Hauptfenster.main(null);

			}
		});
		 */
		back.setText("Zur\u00FCck");
		back.setBounds(75, 179, 75, 25);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(225, 107, 76, 21);
	}

	public Text getText() {
		return text;
	}

	public Button getBack() {
		return back;
	}

	public Button getConfirm() {
		return confirm;
	}

	public Label getAppointmentID() {
		return appointmentID;
	}

	public Label getCustomerID() {
		return customerID;
	}

	@Override
	public void close() throws IOException {
		shell.close();
	}
}
