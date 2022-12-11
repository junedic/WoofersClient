package controller.ereignis;

import org.apache.bsf.engines.jython.JythonEngine;
import org.apache.bsf.BSFManager;
import controller.GuiController;

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
