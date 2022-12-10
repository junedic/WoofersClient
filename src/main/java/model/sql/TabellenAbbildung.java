package model.sql;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public  class TabellenAbbildung {

    public class Tabelle {

        private String tabellenName;
        private ArrayList<LinkedHashMap<String, String>> tabelle;

        private Tabelle(String tabellenName) {
            this.tabellenName = tabellenName;
            tabelle = new ArrayList<>();
        }

        public String getTableName() {
            return tabellenName;
        }

        public ArrayList<LinkedHashMap<String, String>> getTable() {
            return tabelle;
        }

        public void setTabelle(ArrayList<LinkedHashMap<String, String>> tabelle) {
            this.tabelle.clear();
            this.tabelle.addAll(tabelle);
        }
    }

    public Tabelle kunde = new Tabelle("Kunde");
    public Tabelle termin = new Tabelle("Termin");
    public Tabelle gebuchteDienstleistung = new Tabelle("gebuchteDienstleistung");

    protected TabellenAbbildung() {
        initialisiereTabellen();
    }

    private void initialisiereTabellen() {

    }

}
