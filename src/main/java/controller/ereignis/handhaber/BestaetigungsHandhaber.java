package controller.ereignis.handhaber;

import org.eclipse.swt.widgets.Display;
import view.gemeinsam.Bestaetigungsfenster;
import view.gemeinsam.Meldungsfenster;

public class BestaetigungsHandhaber implements Runnable {

        String ueberschrift;
        String beschreibung;
        Display anzeige;

        public BestaetigungsHandhaber(String ueberschrift, String beschreibung, Display anzeige) {
            this.ueberschrift = ueberschrift;
            this.beschreibung = beschreibung;
            this.anzeige = anzeige;
        }

        @Override
        public void run() {
            new Bestaetigungsfenster(ueberschrift, beschreibung, anzeige);
        }

    }
