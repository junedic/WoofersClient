package controller.sql;

import model.sql.TableMapping;
import model.viewmodel.Journey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface ResultSetConverter {
    public ArrayList<LinkedHashMap<String, String>> convert(ResultSet rs, Journey.JourneyResultType type) throws SQLException;
}
