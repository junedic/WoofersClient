import controller.sql.QueryExecutor;
import model.sql.CRUD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class WoofersClient {

    private static final CRUD.SQL DELETE = CRUD.SQL.DELETE;

    public static void main(String[] args) throws SQLException, IOException {
        QueryExecutor executor = new QueryExecutor("192.168.178.41");

        //Liste der Parameter die in Prepared Statement eingefuegt werden
        ArrayList<String> param = new ArrayList<>();
        param.add("1");
        CRUD.Delete deleteSql = (CRUD.Delete) CRUD.SQL.DELETE.getSql();
        executor.executeSQL(deleteSql.appointment(), param, CRUD.SQL.DELETE);
    }
}
