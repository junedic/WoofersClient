package controller.sql;

import model.db.DB;
import model.sql.CRUD;
import model.sql.SqlBefehle;
import model.viewmodel.Reise;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SQL ausfuehren
 */
public class QueryAusfuerer {

    private PreparedStatement ps;
    private final ResultatHandhaber handhaber;
    private final String ip;

    public QueryAusfuerer(ResultatHandhaber handhaber, String ip) {
        this.handhaber = handhaber;
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
            case "java.sql.Date":
                System.out.println("henlo2");
                ps.setDate(counter, (Date) o);
                break;
            case "java.sql.Time":
                ps.setTime(counter, (Time) o);
                break;
        }
    }

    /**
     * CRUD Typus bestimmen, Parameter Typus auslesen und setzen
     * @param sql
     * @param ps
     * @param zaehler
     * @param o
     * @param type
     * @throws SQLException
     */
    private void handhabeSetParam(String sql, PreparedStatement ps, int zaehler, Object o, CRUD.SQL type) throws SQLException {
        System.out.println(zaehler);
        System.out.println(sql);
        Class c = null;
        switch(type) {
            case CREATE:
                c = SqlBefehle.ErstelleParamMap.get(sql).get(zaehler-1);
                setParam(ps, c, o, zaehler);
                break;
            case READ:
                c = SqlBefehle.LesenParamMap.get(sql).get(zaehler-1);
                setParam(ps, c, o, zaehler);
                break;
            case UPDATE:
                c = SqlBefehle.AktualisiereParamMap.get(sql).get(zaehler-1);
                setParam(ps, c, o, zaehler);
                break;
            case DELETE:
                c = SqlBefehle.EntferneParamMap.get(sql).get(zaehler-1);
                setParam(ps, c, o, zaehler);
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
    public void fuehreAus(String sql, ArrayList<Object> param, Reise.ReiseResultatsTyp typ) throws IOException, SQLException {
        try(DB db = new DB(ip)) {
            Connection con = db.getVerbindung();
            ps = con.prepareStatement(sql);
            param.forEach((o) -> {
                System.out.println("Param2: "+o.toString());
            });
            AtomicInteger paramZaehler = new AtomicInteger(1);
            param.forEach((o) -> {  try {
                                            handhabeSetParam(sql, ps, paramZaehler.get(), o, typ.getCrudTyp());
                                    } catch (SQLException e) { throw new RuntimeException(e); }
                                    paramZaehler.getAndIncrement(); });

            if(typ.getCrudTyp().equals(CRUD.SQL.READ)) {
                ResultSet rs = ps.executeQuery(); //wird an ResultHandler uebergeben
                handhaber.handhabeResultat(rs, typ);
            } else {
                ps.execute();
            }
        }
    }

    public ArrayList<LinkedHashMap<String, String>> fuehreAus(String sql, ArrayList<Object> param) throws IOException, SQLException {
        ArrayList<LinkedHashMap<String, String>> tabelle = new ArrayList<>();
        ResultSet rs = null;
        try(DB db = new DB(ip)) {
            Connection con = db.getVerbindung();
            ps = con.prepareStatement(sql);

            AtomicInteger paramZaehler = new AtomicInteger(1);
            param.forEach((o) -> {  try {
                handhabeSetParam(sql, ps, paramZaehler.get(), o, CRUD.SQL.READ);
            } catch (SQLException e) { throw new RuntimeException(e); }
                paramZaehler.getAndIncrement(); });
            rs = ps.executeQuery(); //wird an ResultHandler uebergeben
            tabelle = handhaber.konvertiereResultat(rs);
        }
        return tabelle;
    }

    public ArrayList<LinkedHashMap<String, String>> fuehreAus(String sql) throws IOException, SQLException {
        ArrayList<LinkedHashMap<String, String>> tabelle = new ArrayList<>();
        ResultSet rs = null;
        try(DB db = new DB(ip)) {
            Connection con = db.getVerbindung();
            ps = con.prepareStatement(sql);
            if(ps.getParameterMetaData().getParameterCount() == 0) {
                rs = ps.executeQuery();
                tabelle = handhaber.konvertiereResultat(rs);
            }
        }
        return tabelle;
    }
}
