package model;

import com.mysql.cj.jdbc.Driver;
import java.io.Closeable;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB Anbindung
 */
public class DB implements Closeable {

    private final Connection con;
    private final Driver driver;

    public DB(String ip) {
        try {
            driver = new Driver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Auth.ConData conData = Auth.conData;
        String conInit = String.format(conData.url(), ip, conData.port(), conData.db());
        System.out.println("\n"+conInit+"\n");
        try {
            con = DriverManager.getConnection(conInit, conData.usr(), conData.pwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getCon() {
        return con;
    }

    @Override
    public void close() throws IOException {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
