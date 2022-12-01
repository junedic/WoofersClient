package frontend.meldungsfenster;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Meldungsfenster {

	private boolean hatBestaetigt;

	public Meldungsfenster(JFrame f) {

		Object[] options = { "Ja", "Nein" };
		int n = JOptionPane.showOptionDialog(f, "Möchten Sie wirklich den Termin löschen?", "Terminlöschung bestätigen",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (n == 0)
			setHatBestaetigt(true);
		else
			setHatBestaetigt(false);
	}

	public boolean hatBestaetigt() {
		return hatBestaetigt;
	}

	public void setHatBestaetigt(boolean hatBestaetigt) {
		this.hatBestaetigt = hatBestaetigt;
	}
}
