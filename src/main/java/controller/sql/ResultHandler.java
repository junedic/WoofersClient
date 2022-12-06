package controller.sql;

import controller.QueryController;
import model.sql.CRUD;
import model.sql.SQLStatments;
import model.sql.TableMapping;
import model.viewmodel.Journey;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * ResultSet verarbeiten und in TableMapping ueberfuehren
 */
public class ResultHandler {

    private QueryController queryController;
    private TableMapping mapping;

    public ResultHandler(QueryController queryController) {
        mapping = CRUD.tableMapping;
    }

    class StandardConverter implements ResultSetConverter {
        @Override
        public ArrayList<LinkedHashMap<String, String>> convert(ResultSet rs, Journey.JourneyResultType type) throws SQLException {
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

    private ArrayList<LinkedHashMap<String, String>> convertResult(ResultSet rs, Journey.JourneyResultType type) {
        ArrayList<LinkedHashMap<String, String>> converted = new ArrayList<>();
        StandardConverter converter = new StandardConverter();
        try {
            converted = converter.convert(rs, type);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return converted;
    }

    public ArrayList<LinkedHashMap<String, String>> handleResult(ResultSet rs, Journey.JourneyResultType type) {
        ArrayList<LinkedHashMap<String, String>> table = new ArrayList<>();
        switch(type.getCrudType()) {
            case READ:
                table = convertResult(rs, type);
                break;
            default:
                break;
        }
        return table;
    }

    private void updateTable(Journey.JourneyResultType type) {
        try {
            convertResult(queryController.getExecutor().executeSQL(String.format(SQLStatments.readAll, (CRUD.getMapping(type.getResultOfSql())).getTableName())), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleResult(Journey.JourneyResultType type) {
        switch(type.getCrudType()) {
            case CREATE, READ, UPDATE, DELETE:
                updateTable(type);
                break;
            default:
                break;
        }
    }

    public ArrayList<LinkedHashMap<String, String>> handleResult(ResultSet rs, Journey.JourneyResultType type, ResultSetConverter converter) throws SQLException {
        return converter.convert(rs, type);
    }


}
