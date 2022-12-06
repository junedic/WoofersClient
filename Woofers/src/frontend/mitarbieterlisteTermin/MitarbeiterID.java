package frontend.mitarbieterlisteTermin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import frontend.terminal.Hauptfenster;

public class MitarbeiterID {

	protected Shell shlMitarbeiterAuswhlen;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MitarbeiterID window = new MitarbeiterID();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window..
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMitarbeiterAuswhlen.open();
		shlMitarbeiterAuswhlen.layout();
		while (!shlMitarbeiterAuswhlen.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMitarbeiterAuswhlen = new Shell();
		shlMitarbeiterAuswhlen.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlMitarbeiterAuswhlen.setSize(275, 212);
		shlMitarbeiterAuswhlen.setText("Mitarbeiter ausw\u00E4hlen");

		Combo combo = new Combo(shlMitarbeiterAuswhlen, SWT.NONE);
		combo.setItems(new String[] { "1", "2", "4", "21", "32", "123" });
		combo.setBounds(32, 71, 198, 30);

		Label lblBitteWhlenSie = new Label(shlMitarbeiterAuswhlen, SWT.NONE);
		lblBitteWhlenSie.setAlignment(SWT.CENTER);
		lblBitteWhlenSie.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblBitteWhlenSie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBitteWhlenSie.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblBitteWhlenSie.setBounds(22, 22, 222, 43);
		lblBitteWhlenSie.setText("Bitte w\u00E4hlen Sie die ID eines Mitarbiters");

		Button btnNewButton = new Button(shlMitarbeiterAuswhlen, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Hauptfenster.main(null);
				shlMitarbeiterAuswhlen.close();

			}
		});
		btnNewButton.setBounds(32, 115, 93, 25);
		btnNewButton.setText("Zur\u00FCck");

		Button btnOk = new Button(shlMitarbeiterAuswhlen, SWT.NONE);
		btnOk.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnOk.setText("OK");
		btnOk.setBounds(131, 115, 99, 25);

	}
}
