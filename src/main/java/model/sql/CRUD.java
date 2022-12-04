package model.sql;

import java.util.HashMap;
import static model.sql.SQLStatments.*;

public class CRUD {

    /**
     * @param appointment Params: ID, Mitarbeiter.Nr, Hund.ID, Kunde.Nr, Datum, Uhrzeit
     * @param booking     Params: Termin.ID, Dienstleistung.ID
     */
    public record Create(String appointment, String booking) {}
    public record Read() {}
    /**
     * @param surname Params Nachname, Nr
     * @param mobile  Params Telefonnummer, Nr
     * @param email   Params Email, Nr
     */
    public record Update(String surname, String mobile, String email) {}
    /**
     * @param appointment Params: ID
     * @param booking     Params: Termin.ID
     */
    public record Delete(String appointment, String booking) {}

    public static final Create  CSQL        = new Create(CreateAppointment, CreateBooking);
    public static final Read    RSQL        = new Read();
    public static final Update  USQL        = new Update(UpdateSurname, UpdateMobile, UpdateEmail);
    public static final Delete  DSQL        = new Delete(DeleteAppointment, DeleteBooking);

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

    public static TableMapping tableMapping = new TableMapping();
    private static final HashMap<String, TableMapping.Table> sqlToTable = new HashMap();
    protected static void mapStatement(String sql, TableMapping.Table table) {
        sqlToTable.put(sql, table);
    }
    public static TableMapping.Table getMapping(String sql) {
        return sqlToTable.get(sql);
    }
}
