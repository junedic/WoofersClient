package frontend.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import frontend.meldungsfenster.Fehlermeldung;

public class Kundeneingabe {

	protected Shell shlKundendatenEingeben;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Kundeneingabe window = new Kundeneingabe();
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
		shlKundendatenEingeben.open();
		shlKundendatenEingeben.layout();
		while (!shlKundendatenEingeben.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlKundendatenEingeben = new Shell();
		shlKundendatenEingeben.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlKundendatenEingeben.setSize(453, 298);
		shlKundendatenEingeben.setText("Kundendaten eingeben");

		Label lblBitteGebenSie = new Label(shlKundendatenEingeben, SWT.NONE);
		lblBitteGebenSie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBitteGebenSie.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblBitteGebenSie.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblBitteGebenSie.setBounds(43, 46, 359, 38);
		lblBitteGebenSie.setText("Bitte geben Sie die Daten des Kunden ein");

		text = new Text(shlKundendatenEingeben, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text.setBounds(197, 99, 143, 25);

		Label lblVorname = new Label(shlKundendatenEingeben, SWT.NONE);
		lblVorname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblVorname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblVorname.setText("Vorname");
		lblVorname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblVorname.setBounds(91, 101, 91, 38);

		Label lblNachname = new Label(shlKundendatenEingeben, SWT.NONE);
		lblNachname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNachname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNachname.setText("Nachname");
		lblNachname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblNachname.setBounds(91, 145, 91, 38);

		text_1 = new Text(shlKundendatenEingeben, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text_1.setBounds(197, 143, 143, 25);

		Button btnNewButton = new Button(shlKundendatenEingeben, SWT.NONE);
		btnNewButton.setBounds(43, 199, 75, 25);
		btnNewButton.setText("Zur\u00FCck");

		Button btnWeiter = new Button(shlKundendatenEingeben, SWT.NONE);
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					// TODO kundendatenEingabe: Sind die eingegebenen Daten ueberhaupt gueltig?
					// TODO kundendatenEingabe: Daten des Kunden speichern in Variablen
				} catch (Exception e2) {
					new Fehlermeldung("Kundendaten ung\u00fcltig",
							"Ex existiert kein Kunde mit den eingegebenen Daten!");

				}
			}
		});
		btnWeiter.setText("Weiter");
		btnWeiter.setBounds(327, 199, 75, 25);

	}
}
