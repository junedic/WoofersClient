package view;

public interface View {
    public void init(); //aussehen der elemente initialisieren (macht sie in shell sichtbar)
    public void assignElements(); //elemente neu initialisieren (nach dispose)
    public void dispose(); //shell frei machen fuer neue elemente
}
