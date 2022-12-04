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

    protected Table kunde = new Table();
    protected Table termin = new Table();
    protected Table gebuchteDienstleistung;

    protected TableMapping() {

    }

}
