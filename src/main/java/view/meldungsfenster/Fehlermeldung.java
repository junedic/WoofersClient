package view.meldungsfenster;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fehlermeldung {

	public Fehlermeldung(String message, String titel) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, message, titel, JOptionPane.INFORMATION_MESSAGE);
	}
}
