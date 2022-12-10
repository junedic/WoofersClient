package controller.sql;

import model.sql.CRUD;
import model.sql.TabellenAbbildung;
import model.viewmodel.Reise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * ResultSet verarbeiten und in TableMapping ueberfuehren
 */
public class ResultatHandhaber {

    private QueryController queryController;
    private TabellenAbbildung abbildung;

    public ResultatHandhaber(QueryController queryController) {
        abbildung = CRUD.tabellenAbbildung;
    }

    class StandardKonvertierer implements ResultSetKonvertierer {
        @Override
        public ArrayList<LinkedHashMap<String, String>> convert(ResultSet rs) throws SQLException {
            ArrayList<LinkedHashMap<String, String>> data = new ArrayList<>();
            int columnCount = rs.getMetaData().getColumnCount();
            if(columnCount == 0) return data;
            while(rs.next()) {
                LinkedHashMap<String, String> dataset = new LinkedHashMap<>();
                for(int i = 1; i <= columnCount; i++) {
                    String name = rs.getMetaData().getColumnName(i);
                    String value = rs.getString(name);
                    if(value != null) dataset.put(name, value);
                    else dataset.put(name, "");
                }
                data.add(dataset);
            }
            return data;
        }
    }

    public ArrayList<LinkedHashMap<String, String>> konvertiereResultat(ResultSet rs) {
        ArrayList<LinkedHashMap<String, String>> konvertiert;
        StandardKonvertierer konvertierer = new StandardKonvertierer();
        try {
            konvertiert = konvertierer.convert(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return konvertiert;
    }

    public ArrayList<LinkedHashMap<String, String>> handhabeResultat(ResultSet rs, Reise.ReiseResultatsTyp type) {
        ArrayList<LinkedHashMap<String, String>> table = new ArrayList<>();
        switch(type.getCrudTyp()) {
            case UPDATE, READ:
                System.out.println("reached");
                table = konvertiereResultat(rs);
                break;
            default:
                break;
        }
        CRUD.tabellenAbbildung.kunde.setTabelle(table);
        return table;
    }


    public ArrayList<LinkedHashMap<String, String>> handhabeResultat(ResultSet rs, Reise.ReiseResultatsTyp type, ResultSetKonvertierer converter) throws SQLException {
        return converter.convert(rs);
    }


}
