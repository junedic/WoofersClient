package view.gemeinsam;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import javax.swing.*;

	public class Meldungsfenster {
		Display display;
		Shell shell;

		Button button;
		public Meldungsfenster(String ueberschrift, String beschreibung, Display display) {
			this.display = display;
			shell = new Shell(display);
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.CLOSE);
			messageBox.setText(ueberschrift);
			messageBox.setMessage(beschreibung);
			messageBox.open();
		}

}