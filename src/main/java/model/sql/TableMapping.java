package model.sql;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public  class TableMapping {

    public class Table {

        private String tableName;
        private ArrayList<LinkedHashMap<String, String>> table;

        private Table(String tableName) {
            this.tableName = tableName;
            table = new ArrayList<>();
        }

        public String getTableName() {
            return tableName;
        }

        public ArrayList<LinkedHashMap<String, String>> getTable() {
            return table;
        }

        public void setTable(ArrayList<LinkedHashMap<String, String>> table) {
            this.table.clear();
            this.table.addAll(table);
        }
    }

    public Table kunde = new Table("Kunde");
    public Table termin = new Table("Termin");
    public Table gebuchteDienstleistung = new Table("gebuchteDienstleistung");

    protected TableMapping() {
        initializeTables();
    }

    private void initializeTables() {

    }

}
