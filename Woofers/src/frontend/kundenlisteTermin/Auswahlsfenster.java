package frontend.kundenlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Auswahlsfenster {

	protected Shell shlMehrereGleichnamigeKunden;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Auswahlsfenster window = new Auswahlsfenster();
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
		shlMehrereGleichnamigeKunden.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlMehrereGleichnamigeKunden.setSize(497, 462);
		shlMehrereGleichnamigeKunden.setText("Mehrere gleichnamige Kunden");

		Label lblAnscheinendGibtEs = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblAnscheinendGibtEs.setForeground(SWTResourceManager.getColor(255, 128, 128));
		lblAnscheinendGibtEs.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblAnscheinendGibtEs.setAlignment(SWT.CENTER);
		lblAnscheinendGibtEs.setText("Anscheinend gibt es mehrere");
		lblAnscheinendGibtEs.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblAnscheinendGibtEs.setBounds(65, 46, 359, 38);

		Label lblVorname = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblVorname.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblVorname.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblVorname.setText("Vorname + Nachname");
		lblVorname.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblVorname.setAlignment(SWT.CENTER);
		lblVorname.setBounds(139, 90, 198, 38);

		Button btnNewButton = new Button(shlMehrereGleichnamigeKunden, SWT.NONE);
		btnNewButton.setText("Zur\u00FCck");
		btnNewButton.setBounds(65, 344, 75, 25);

		Button btnWeiter = new Button(shlMehrereGleichnamigeKunden, SWT.NONE);
		btnWeiter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnWeiter.setText("Weiter");
		btnWeiter.setBounds(349, 344, 75, 25);

		Label lblWelchenGenauMeinen = new Label(shlMehrereGleichnamigeKunden, SWT.NONE);
		lblWelchenGenauMeinen.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblWelchenGenauMeinen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblWelchenGenauMeinen.setText("Welchen genau meinen Sie?");
		lblWelchenGenauMeinen.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		lblWelchenGenauMeinen.setAlignment(SWT.CENTER);
		lblWelchenGenauMeinen.setBounds(108, 141, 272, 38);

		List list = new List(shlMehrereGleichnamigeKunden, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list.setBounds(65, 179, 359, 136);
		list.setItems(new String[] { "Uli Maier mit ID:21 und dem Hund Bello", "Uli Maier mit ID:34 und dem Hund Anna",
				"Uli Maier mit ID:28 und dem Hund Bello", "Uli Maier mit ID:22 und dem Hund Willo",
				"Uli Maier mit ID:12 und dem Hund Shaban", "Uli Maier mit ID:42 und dem Hund Kila",
				"Uli Maier mit ID:16 und dem Hund Lifa", "Uli Maier mit ID:16 und dem Hund Lifa",
				"Uli Maier mit ID:16 und dem Hund Lifa", "Uli Maier mit ID:16 und dem Hund Lifa",
				"Uli Maier mit ID:16 und dem Hund Lifa", "Uli Maier mit ID:16 und dem Hund Lifa" });

	}
}
