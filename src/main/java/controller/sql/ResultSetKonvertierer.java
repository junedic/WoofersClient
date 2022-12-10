package controller.sql;

import model.viewmodel.Reise;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ResultSetKonvertierer {
    public ArrayList<LinkedHashMap<String, String>> convert(ResultSet rs) throws SQLException;
}
