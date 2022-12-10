package model.sql;

import java.util.HashMap;
import static model.sql.SqlBefehle.*;

public class CRUD {

    /**
     * @param termin Params: ID, Mitarbeiter.Nr, Hund.ID, Kunde.Nr, Datum, Uhrzeit
     * @param buchung     Params: Termin.ID, Dienstleistung.ID
     */
    public record Erstelle(String termin, String buchung) {}
    public record Lese() {}
    /**
     * @param kunde Params: ID, Nachname, Email, Telefonnummer
     */
    public record Bearbeite(String kunde) {}
    /**
     * @param termin Params: ID
     * @param buchung     Params: Termin.ID
     */
    public record Entferne(String termin, String buchung) {}

    /**
     * Sammlung der SQL statements je Typus
     */
    public static final Erstelle  CSQL      = new Erstelle(ErstelleTermin, ErstelleBuchung);
    public static final Lese      RSQL      = new Lese();
    public static final Bearbeite USQL      = new Bearbeite(BearbeiteKunde);
    public static final Entferne  DSQL      = new Entferne(EntferneTermin, EntferneBuchung);

    /**
     * Bestimmung von Typus eines Statements
     */
    public enum SQL {
        CREATE (CSQL), READ (RSQL), UPDATE (USQL), DELETE (DSQL);

        private Record sql;
        SQL(Record sql) {
            this.sql = sql;
        }

        public Record getSql() {
            return sql;
        }
    }

    //evtl. irrelevant
    public static TabellenAbbildung tabellenAbbildung = new TabellenAbbildung();
    private static final HashMap<String, TabellenAbbildung.Tabelle> sqlZuTabelle = new HashMap();
    protected static void bildeBefehlAb(String sql, TabellenAbbildung.Tabelle tabelle) {
        sqlZuTabelle.put(sql, tabelle);
    }
    public static TabellenAbbildung.Tabelle getAbbildung(String sql) {
        return sqlZuTabelle.get(sql);
    }
    
}
