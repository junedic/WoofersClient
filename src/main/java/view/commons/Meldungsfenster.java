package view.commons;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Meldungsfenster {

	public Meldungsfenster(String ueberschrift, String beschreibung) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, beschreibung, ueberschrift, JOptionPane.INFORMATION_MESSAGE);
	}

}