package controller.ereignis;

import org.eclipse.swt.widgets.Display;
import view.gemeinsam.Meldungsfenster;

public class FehlerHandhaber implements Runnable {

    String ueberschrift;
    String beschreibung;
    Display anzeige;

    public FehlerHandhaber(String ueberschrift, String beschreibung, Display anzeige) {
        this.ueberschrift = ueberschrift;
        this.beschreibung = beschreibung;
        this.anzeige = anzeige;
    }

    @Override
    public void run() {
        Meldungsfenster m = new Meldungsfenster(ueberschrift, beschreibung, anzeige);
    }
}
/*
public class FehlerHandhaberEx implements Runnable {

    private FehlerTyp typ;

    protected class FehlerTyp {

    }

    public FehlerHandhaberEx(FehlerTyp typ) {
        typ = new FehlerTyp();
    }

    private String genFehlerScript() {

        return "";
    }

    @Override
    public void run() {

    }
}
 */
