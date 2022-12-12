package view.gemeinsam;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Bestaetigungsfenster {

	private Display display;
	private Shell shell;
	MessageBox messageBox;
	private boolean bestaetigt;
	private int i;

	public Bestaetigungsfenster(String ueberschrift, String beschreibung, Display display) {
		this.display = display;
		shell = new Shell(display);
		messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
		messageBox.setText(ueberschrift);
		messageBox.setMessage(beschreibung);
		i =messageBox.open();
	}

	public boolean getBestaetigt() {
		switch(i) {
			case SWT.YES:
				bestaetigt = true;
				break;
			case SWT.NO:
				bestaetigt = false;
				break;
		}
		shell.close();
		return bestaetigt;
	}

}
/*
public class Bestaetigungsfenster {

	private boolean bestaetigt;

	public Bestaetigungsfenster(String ueberschrift, String beschreibung) {
		int n = JOptionPane.showConfirmDialog(new JFrame(), beschreibung, ueberschrift, JOptionPane.YES_NO_OPTION);
		setBestaetigt(n == 0);
	}

	public boolean getBestaetigt() {
		return bestaetigt;
	}

	public void setBestaetigt(boolean bestaetigt) {
		this.bestaetigt = bestaetigt;
	}

}

 */
