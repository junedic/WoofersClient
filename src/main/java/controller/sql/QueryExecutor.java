package controller.sql;

import model.sql.CRUD;
import model.db.DB;
import model.sql.SQLStatments;
import model.viewmodel.Journey;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SQL ausfuehren
 */
public class QueryExecutor {

    private PreparedStatement ps;
    private final ResultHandler handler;
    private final String ip;

    public QueryExecutor(ResultHandler handler, String ip) {
        this.handler = handler;
        this.ip = ip;
    }

    /**
     * korrekte Set-Methode auswaehlen
     * @param ps
     * @param c
     * @param o der Parameter
     * @param counter Parameterindex
     * @throws SQLException
     */
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

    /**
     * CRUD Typus bestimmen, Parameter Typus auslesen und setzen
     * @param sql
     * @param ps
     * @param counter
     * @param o
     * @param type
     * @throws SQLException
     */
    private void handleSetParam(String sql, PreparedStatement ps, int counter, Object o, CRUD.SQL type) throws SQLException {
        System.out.println(counter);
        System.out.println(sql);
        System.out.println(SQLStatments.DeleteParamMap.get(sql).get(counter-1));
        switch(type) {
            case CREATE: break;
            case READ: break;
            case UPDATE: break;
            case DELETE:
                Class c = SQLStatments.DeleteParamMap.get(sql).get(counter-1);
                setParam(ps, c, o, counter);
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
    public void executeSQL(String sql, ArrayList<Object> param, Journey.JourneyResultType type) throws IOException, SQLException {
        try(DB db = new DB(ip)) {
            Connection con = db.getCon();
            ps = con.prepareStatement(sql);

            AtomicInteger paramCounter = new AtomicInteger(1);
            param.forEach((o) -> {  try { handleSetParam(sql, ps, paramCounter.get(), o, type.getCrudType()); }
                                    catch (SQLException e) { throw new RuntimeException(e); }
                                    paramCounter.getAndIncrement(); });

            if(type.getCrudType().equals(CRUD.SQL.READ)) {
                ResultSet rs = ps.executeQuery(); //wird an ResultHandler uebergeben
                handler.handleResult(rs, type);
            } else {
                ps.execute();
                handler.handleResult(type);
            }
        }
    }

    public ResultSet executeSQL(String sql) throws IOException, SQLException {
        try(DB db = new DB(ip)) {
            Connection con = db.getCon();
            ps = con.prepareStatement(sql);
            if(ps.getParameterMetaData().getParameterCount() == 0)
                return ps.executeQuery();
            return null;
        }
    }
}
