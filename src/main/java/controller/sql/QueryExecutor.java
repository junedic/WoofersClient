package controller.sql;

import model.sql.CRUD;
import model.DB;
import model.sql.SQLStatments;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class QueryExecutor {

    private PreparedStatement ps;
    private final ResultHandler handler;
    private final String ip;

    public QueryExecutor(ResultHandler handler, String ip) {
        this.handler = handler;
        this.ip = ip;
    }

    private void setParam(PreparedStatement ps, Class c, Object o, int counter) throws SQLException {
        System.out.println(c.getName());
        switch(c.getName()) {
            case "java.lang.Integer":
                System.out.println("henlo");
                ps.setInt(counter, ((Integer) o).intValue());
                break;
            case "java.lang.String":
                ps.setString(counter, (String) o);
                break;
            case "java.lang.Boolean":
                ps.setBoolean(counter, (((Boolean) o).booleanValue()));
                break;
        }
    }

    private void handleSetParam(String sql, PreparedStatement ps, int counter, Object o, CRUD.SQL type) throws SQLException {
        switch(type) {
            case CREATE: break;
            case READ: break;
            case UPDATE: break;
            case DELETE:
                Map m = SQLStatments.DeleteParamMap.get(sql);
                setParam(ps, Integer.class, o, counter);
                break;
            //ps.setString(counter, (String) o);
        }
    }

    /**
     * Open connection, execute and close
     * @param sql statement
     * @throws IOException
     * @throws SQLException
     */
    public void executeSQL(String sql, ArrayList<Object> param, CRUD.SQL type) throws IOException, SQLException {
        try(DB db = new DB(ip)) {
            Connection con = db.getCon();
            ps = con.prepareStatement(sql);

            AtomicInteger paramCounter = new AtomicInteger(1);
            param.forEach((o) -> {  try { handleSetParam(sql, ps, paramCounter.get(), o, type); }
                                    catch (SQLException e) { throw new RuntimeException(e); }
                                    paramCounter.getAndIncrement(); });

            if(type.equals(CRUD.SQL.READ)) {
                ResultSet rs = ps.executeQuery();
            } else {
                ps.execute();
            }
        }
    }
}
