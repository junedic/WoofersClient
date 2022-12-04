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

public class KundenNr_Eingabe {

	protected Shell shlTerminidEingeben;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KundenNr_Eingabe window = new KundenNr_Eingabe();
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
		shlTerminidEingeben.setSize(371, 273);
		shlTerminidEingeben.setText("KundenID eingeben");
		shlTerminidEingeben.setLayout(null);

		Label lblNewLabel = new Label(shlTerminidEingeben, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNewLabel.setBounds(57, 27, 244, 56);
		lblNewLabel.setText("Bitte geben Sie die ID \r\ndes Kunden ein");

		Button btnNewButton = new Button(shlTerminidEingeben, SWT.NONE);
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
					shlTerminidEingeben.close();
					Profilbearbeitung.main(null);

				} catch (Exception e2) {
					new Meldungsfenster("Ung\u00fcltige KundenID", "Bitte geben Sie eine g\u00fcltige KundenID ein!");
				}
			}
		});
		btnNewButton.setBounds(226, 179, 75, 25);
		btnNewButton.setText("OK");

		Button btnZurck = new Button(shlTerminidEingeben, SWT.NONE);
		btnZurck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlTerminidEingeben.close();
				Hauptfenster.main(null);

			}
		});
		btnZurck.setText("Zur\u00FCck");
		btnZurck.setBounds(75, 179, 75, 25);

		Label lblTerminid = new Label(shlTerminidEingeben, SWT.NONE);
		lblTerminid.setText("KundenID");
		lblTerminid.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblTerminid.setFont(SWTResourceManager.getFont("Arial", 15, SWT.NORMAL));
		lblTerminid.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblTerminid.setBounds(75, 103, 110, 37);

		text = new Text(shlTerminidEingeben, SWT.BORDER);
		text.setBounds(225, 107, 76, 21);

	}
}
