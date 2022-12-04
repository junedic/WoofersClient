package view.commons;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import view.bearbeiteKunden.KundenNr_Eingabe;
import view.loescheTermin.Termin_Eingabe;

public class Hauptfenster {

	protected Shell shlTerminidEingeben;

	/**
	 * Launch thimport org.eclipse.swt.events.SelectionAdapter; import
	 * org.eclipse.swt.events.SelectionEvent;
	 * 
	 * public class Hauptfenster {
	 * 
	 * protected Shell shlTerminidEingeben;
	 * 
	 * /** Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Hauptfenster window = new Hauptfenster();
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
		shlTerminidEingeben.setSize(570, 418);
		shlTerminidEingeben.setText("Hauptfenster");
		shlTerminidEingeben.setLayout(null);

		Label lblNewLabel = new Label(shlTerminidEingeben, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("Eras Demi ITC", 22, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblNewLabel.setBounds(91, 75, 370, 37);
		lblNewLabel.setText("wOOfers TERMINAL");

		Button btnNewButton = new Button(shlTerminidEingeben, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		btnNewButton.setBounds(143, 143, 122, 37);
		btnNewButton.setText("Termin erstellen");

		// Button: Termin loeschen
		Button btnTerminLschen = new Button(shlTerminidEingeben, SWT.NONE);
		btnTerminLschen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlTerminidEingeben.close();
				Termin_Eingabe.main(null);
			}
		});
		btnTerminLschen.setText("Termin l\u00F6schen");
		btnTerminLschen.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnTerminLschen.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		btnTerminLschen.setBounds(269, 143, 122, 37);

		Button btnTerminlisteVonKunden = new Button(shlTerminidEingeben, SWT.NONE);
		btnTerminlisteVonKunden.setText("Terminliste von Mitarbeiter ausgeben");
		btnTerminlisteVonKunden.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnTerminlisteVonKunden.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		btnTerminlisteVonKunden.setBounds(143, 186, 248, 37);

		Button btnTerminlisteVonKunden_1 = new Button(shlTerminidEingeben, SWT.NONE);
		btnTerminlisteVonKunden_1.setText("Terminliste von Kunden ausgeben");
		btnTerminlisteVonKunden_1.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnTerminlisteVonKunden_1.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		btnTerminlisteVonKunden_1.setBounds(143, 229, 248, 37);

		Button btnTerminlisteVonKunden_1_1 = new Button(shlTerminidEingeben, SWT.NONE);
		btnTerminlisteVonKunden_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlTerminidEingeben.close();
				KundenNr_Eingabe.main(null);
			}
		});
		btnTerminlisteVonKunden_1_1.setText("Kundenprofil bearbeiten");
		btnTerminlisteVonKunden_1_1.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnTerminlisteVonKunden_1_1.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		btnTerminlisteVonKunden_1_1.setBounds(143, 272, 248, 37);

		Label label = new Label(shlTerminidEingeben, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBackground(SWTResourceManager.getColor(255, 128, 0));
		label.setForeground(SWTResourceManager.getColor(255, 128, 0));
		label.setText("\u00F6\u00F6");
		label.setBounds(-12, 118, 572, 2);

		Label lblD = new Label(shlTerminidEingeben, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblD.setText("d");
		lblD.setBounds(0, 67, 560, 2);

	}
}
