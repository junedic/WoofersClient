package frontend.kundenBearbeiten;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class kundennrEingabe {

	protected Shell shlSwtApplication;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			kundennrEingabe window = new kundennrEingabe();
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
		shlSwtApplication.open();
		shlSwtApplication.layout();
		while (!shlSwtApplication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSwtApplication = new Shell();
		shlSwtApplication.setBackground(SWTResourceManager.getColor(64, 0, 128));
		shlSwtApplication.setSize(483, 366);
		shlSwtApplication.setText("Kundennummer eingeben");
		
		Label lblBitteGebenSie = new Label(shlSwtApplication, SWT.NONE);
		lblBitteGebenSie.setAlignment(SWT.CENTER);
		lblBitteGebenSie.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBitteGebenSie.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblBitteGebenSie.setBackground(SWTResourceManager.getColor(64, 0, 128));
		lblBitteGebenSie.setBounds(65, 64, 352, 64);
		lblBitteGebenSie.setText("Bitte geben Sie die \r\nKundenNr ein");
		
		text = new Text(shlSwtApplication, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		text.setBounds(163, 153, 132, 55);
		
		Button btnNewButton = new Button(shlSwtApplication, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnNewButton.setBounds(70, 245, 105, 35);
		btnNewButton.setText("Zur\u00FCck");
		
		Button btnOk = new Button(shlSwtApplication, SWT.NONE);
		btnOk.setForeground(SWTResourceManager.getColor(64, 0, 64));
		btnOk.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnOk.setText("OK");
		btnOk.setBounds(312, 245, 105, 35);

	}
}
