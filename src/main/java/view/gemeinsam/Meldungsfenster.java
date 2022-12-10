package view.gemeinsam;

import javax.swing.*;

public class Meldungsfenster {

	public Meldungsfenster(String ueberschrift, String beschreibung) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, beschreibung, ueberschrift, JOptionPane.INFORMATION_MESSAGE);
	}

	public Meldungsfenster(String ueberschrift, String beschreibung, boolean wait) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, beschreibung, ueberschrift, JOptionPane.WARNING_MESSAGE);
	}

}