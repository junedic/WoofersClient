package controller.sql;

import controller.sql.QueryAusfuerer;
import controller.sql.ResultatHandhaber;
import model.sql.CRUD;
import model.sql.SqlBefehle;
import model.sql.TabellenAbbildung;
import model.viewmodel.Reise;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QueryController {

    private ResultatHandhaber handhaber;
    private QueryAusfuerer ausfuehrer;

    public QueryController(String ip) {
        handhaber = new ResultatHandhaber(this);
        ausfuehrer = new QueryAusfuerer(handhaber, ip, this);
        try {
            aktualisiereAbbildungen();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void aktualisiereAbbildungen() throws SQLException, IOException {
        ArrayList<LinkedHashMap<String, String>> konvertiert;
        TabellenAbbildung.Tabelle[] tabellen = {CRUD.tabellenAbbildung.kunde, CRUD.tabellenAbbildung.termin, CRUD.tabellenAbbildung.gebuchteDienstleistung};
        int i = 0;
        for(TabellenAbbildung.Tabelle t : tabellen) {
            System.out.println(""+(i++));
            konvertiert = ausfuehrer.fuehreAus(String.format(SqlBefehle.LeseAlle, t.getTableName()));
            t.setTabelle(konvertiert);
        }
        System.out.print(CRUD.tabellenAbbildung.kunde.getTable().get(0).get("Email"));
    }

    public Object query(String sql, ArrayList<Object> param, Reise.ReiseResultatsTyp typ) {
        Object o;
        try {
            o = ausfuehrer.fuehreAus(sql, param, typ);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    public QueryAusfuerer getAusfuehrer() {
        return ausfuehrer;
    }

}
