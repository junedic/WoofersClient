package view.entfernen;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import view.View;

public class EingabeTerminId implements View {

	private Shell shell;
	private Label appointmentIDInput;
	private Label appointmentID;
	private Button confirm;
	private Button back;
	private Combo terminIdAuswahl;

	public EingabeTerminId(Shell shell) {
		this.shell = shell;
		weiseElementeZu();
	}

	@Override
	public void init() {
		initShell();
		initLabels();
		initButtons();
	}

	@Override
	public void weiseElementeZu() {
		appointmentIDInput = new Label(shell, SWT.NONE);
		appointmentID = new Label(shell, SWT.NONE);
		confirm = new Button(shell, SWT.NONE);
		back = new Button(shell, SWT.NONE);
		terminIdAuswahl = new Combo(shell, SWT.READ_ONLY);
	}

	@Override
	public void entsorge() {
		appointmentIDInput.dispose();
		appointmentID.dispose();
		confirm.dispose();
		back.dispose();
		terminIdAuswahl.dispose();
		weiseElementeZu();
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

		terminIdAuswahl.setBounds(225, 107, 76, 21);
	}

	private void initButtons() {
		/*
		bestaetige.addMouseListener(new MouseAdapter() {
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
		zurueck.addMouseListener(new MouseAdapter() {
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

	public Combo getTerminIdAuswahl() {
		return terminIdAuswahl;
	}
}
