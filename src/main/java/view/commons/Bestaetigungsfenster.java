package view.commons;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
