package controller.sql;

import model.sql.CRUD;
import model.DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class QueryExecutor {

    private PreparedStatement ps;
    private final ResultHandler handler;
    private final String ip;

    public QueryExecutor(ResultHandler handler, String ip) {
        this.handler = handler;
        this.ip = ip;
    }

    /**
     * Open connection, execute and close
     * @param sql statement
     * @throws IOException
     * @throws SQLException
     */
    public void executeSQL(String sql, ArrayList<String> param, CRUD.SQL type) throws IOException, SQLException {
        try(DB db = new DB(ip)) {
            Connection con = db.getCon();
            ps = con.prepareStatement(sql);

            AtomicInteger paramCounter = new AtomicInteger(1);
            param.forEach((p) -> {  try { ps.setString(paramCounter.get(), p); }
                                    catch (SQLException e) { throw new RuntimeException(e); }
                                    paramCounter.getAndIncrement(); });

            if(type.equals(CRUD.SQL.READ)) {
                ResultSet rs = ps.executeQuery();
            } else {
                ps.execute();
            }
            System.out.println("Success");
        }
    }
}
