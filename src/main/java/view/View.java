package view;

public interface View {
    public void init(); //aussehen der elemente initialisieren (macht sie in shell sichtbar)
    public void weiseElementeZu(); //elemente neu initialisieren (nach entsorge)
    public void entsorge(); //shell frei machen fuer neue elemente
}
