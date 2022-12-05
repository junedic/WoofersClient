package model.sql;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public  class TableMapping {

    public class Table {
        ArrayList<LinkedHashMap<String, String>> table;

        private Table() {
            table = new ArrayList<>();
        }
    }

    public Table kunde = new Table();
    public Table termin = new Table();
    public Table gebuchteDienstleistung;

    protected TableMapping() {
        initializeTables();
    }

    private void initializeTables() {

    }

}
