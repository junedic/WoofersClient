package model.db;

import com.mysql.cj.jdbc.Driver;
import model.db.Auth;

import java.io.Closeable;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB Anbindung
 */
public class DB implements Closeable {

    private final Connection verb;
    private final Driver treiber;

    public DB(String ip) {
        try {
            treiber = new Driver();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Auth.VerbDaten verbDaten = Auth.verbDaten;
        String verbInit = String.format(verbDaten.url(), ip, verbDaten.port(), verbDaten.db());
        System.out.println("\n"+verbInit+"\n");
        try {
            verb = DriverManager.getConnection(verbInit, verbDaten.usr(), verbDaten.pwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getVerbindung() {
        return verb;
    }

    @Override
    public void close() throws IOException {
        try {
            verb.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
