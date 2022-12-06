package view;

import org.eclipse.swt.widgets.Shell;

public interface View {
    public void init(); //aussehen der elemente initialisieren (macht sie in shell sichtbar)
    public void reassign(); //elemente neu initialisieren (nach dispose)
    public void dispose(); //shell frei machen fuer neue elemente
}
