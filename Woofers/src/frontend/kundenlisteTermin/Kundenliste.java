package frontend.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import frontend.terminal.Hauptfenster;

public class Terminliste {

	protected Shell shlMehrereGleichnamigeKunden;

	/**
	 * Launch the application..
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Terminliste window = new Terminliste();
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
		shlMehrereGleichnamigeKunden.open();
		shlMehrereGleichnamigeKunden.layout();
		while (!shlMehrereGleichnamigeKunden.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMehrereGleichnamigeKunden = new Shell();
		shlMehrereGleichnamigeKunden.setTouchEnabled(true);
		shlMehrereGleichnamigeKunden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlMehrereGleichnamigeKunden.setSize(497, 462);
		shlMehrereGleichnamigeKunden.setText("Mehrere gleichnamige Kunden");

		Button btnNewButton = new Button(shlMehrereGleichnamigeKunden, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Hauptfenster.main(null);
				shlMehrereGleichnamigeKunden.dispose();

			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnNewButton.setText("Zur\u00FCck zum Hauptemen\u00FC");
		btnNewButton.setBounds(111, 348, 271, 25);

		Label lblWelchenGenauMeinen = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblWelchenGenauMeinen.setForeground(SWTResourceManager.getColor(255, 128, 0));
		lblWelchenGenauMeinen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblWelchenGenauMeinen.setText("Terminliste");
		lblWelchenGenauMeinen.setFont(SWTResourceManager.getFont("Ink Free", 26, SWT.BOLD));
		lblWelchenGenauMeinen.setAlignment(SWT.CENTER);
		lblWelchenGenauMeinen.setBounds(100, 119, 272, 38);

		List list = new List(shlMehrereGleichnamigeKunden, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list.setTouchEnabled(true);
		list.setBounds(65, 179, 359, 136);
		list.setItems(new String[] { "1. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Bello",
				"2. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Bello",
				"3. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Werner",
				"4. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Bello",
				"5. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Bello",
				"6. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Wiener",
				"7. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Wiener",
				"8. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Wiener",
				"9. Termin am DD.MM.YYYY um HH:MM Uhr bis HH:MM Uhr | Hund: Wiener" });

		Label lblKundenid = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblKundenid.setText("KundenID:");
		lblKundenid.setForeground(SWTResourceManager.getColor(255, 128, 0));
		lblKundenid.setFont(SWTResourceManager.getFont("Arial", 19, SWT.NORMAL));
		lblKundenid.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblKundenid.setAlignment(SWT.CENTER);
		lblKundenid.setBounds(141, 50, 143, 38);

		Label lblX = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblX.setText("X");
		lblX.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblX.setFont(SWTResourceManager.getFont("Arial", 19, SWT.NORMAL));
		lblX.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblX.setAlignment(SWT.CENTER);
		lblX.setBounds(273, 50, 44, 38);

	}
}
