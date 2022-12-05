package view.delete;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import view.View;

import java.io.Closeable;
import java.io.IOException;

public class InputAppointmentID implements View {

	private Shell shell;
	private Label appointmentIDInput;
	private Label appointmentID;
	private Button confirm;
	private Button back;
	private Text text;

	public InputAppointmentID(Shell shell) {
		this.shell = shell;
		appointmentIDInput = new Label(shell, SWT.NONE);
		appointmentID = new Label(shell, SWT.NONE);
		confirm = new Button(shell, SWT.NONE);
		back = new Button(shell, SWT.NONE);
	}

	public void reassign() {
		appointmentIDInput = new Label(shell, SWT.NONE);
		appointmentID = new Label(shell, SWT.NONE);
		confirm = new Button(shell, SWT.NONE);
		back = new Button(shell, SWT.NONE);
	}

	public void init() {
		initShell();
		initLabels();
		initButtons();
	}

	private void initShell() {
		shell.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shell.setText("TerminID eingeben");
		shell.setLayout(null);
	}

	private void initLabels() {
		appointmentIDInput.setForeground(SWTResourceManager.getColor(255, 255, 255));
		appointmentIDInput.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		appointmentIDInput.setBackground(SWTResourceManager.getColor(64, 0, 128));
		appointmentIDInput.setBounds(57, 27, 244, 56);
		appointmentIDInput.setText("Bitte geben Sie die ID \r\ndes Termins ein");

		appointmentID.setText("TerminID");
		appointmentID.setForeground(SWTResourceManager.getColor(255, 255, 255));
		appointmentID.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		appointmentID.setBackground(SWTResourceManager.getColor(64, 0, 128));
		appointmentID.setBounds(75, 103, 110, 37);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(225, 107, 76, 21);
	}

	private void initButtons() {
		/*
		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Bestaetigungsfenster bf = new Bestaetigungsfenster("L\u00F6schen best\u00e4tigen",
						"M\u00F6chten Sie wirklich diesen Termin l\u00F6schen?");

				if (bf.getBestaetigt()) {
					try {
						// TODO Termin_Eingabe: Hier den Termin in der DB loeschen
						// TODO Termin_Eingabe: getText() liefert euch die ID. Nutzt Sie Weise!
						text.getText();
						// ...
						// ...
						// ...
						new Meldungsfenster("Termin vernichtet", "Der Termin wurde gel\u00F6scht");
						shell.close();
						Hauptfenster.main(null);
					} catch (Exception e2) {
						// TODO Termin_Eingabe: Exception muss man speifizieren (Was f�r eine Art von
						// Exception ist das?)
						new Meldungsfenster("Ung\u00fcltige TerminID", "Bitte geben Sie eine g\u00fc");
					}

				}
			}
		});
		*/
		confirm.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		confirm.setBounds(226, 179, 75, 25);
		confirm.setText("OK");

		/*
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				Hauptfenster.main(null);
			}
		});
		*/
		back.setText("Zur\u00FCck");
		back.setBounds(75, 179, 75, 25);
	}

	public Label getAppointmentIDInput() {
		return appointmentIDInput;
	}

	public Label getAppointmentID() {
		return appointmentID;
	}

	public Button getConfirm() {
		return confirm;
	}

	public Button getBack() {
		return back;
	}

	public Text getText() {
		return text;
	}

	@Override
	public void dispose() {
		appointmentIDInput.dispose();
		appointmentID.dispose();
		confirm.dispose();
		back.dispose();
		text.dispose();
		reassign();
	}
}
