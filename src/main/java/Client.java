import controller.GuiController;
import model.sql.CRUD;

import java.io.IOException;
import java.sql.SQLException;

public class Client {

    private static final CRUD.SQL DELETE = CRUD.SQL.DELETE;

    public static void main(String[] args) throws SQLException, IOException {
        /*
        QueryExecutor executor = new QueryExecutor(new ResultHandler(), "192.168.178.41");

        //Liste der Parameter die in Prepared Statement eingefuegt werden
        ArrayList<String> param = new ArrayList<>();
        param.add("1");
        CRUD.Delete deleteSql = (CRUD.Delete) CRUD.SQL.DELETE.getSql();
        executor.fuehreAus(deleteSql.appointment(), param, CRUD.SQL.DELETE);
         */

        GuiController controller = new GuiController();
        controller.initialisiere();
        controller.oeffnen();
    }
}
