package model.sql;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * Rohe SQL Daten
 */
public class SQLStatments {

    //CREATE
    public static final String CreateAppointment   = "INSERT INTO Termin (ID, Mitarbeiter.Nr, Hund.ID, Kunde.Nr, Datum, Uhrzeit) VALUES (?,?,?,?,?,?)";
    public static final String CreateBooking       = "INSERT INTO gebuchteDienstleistung (Termin.ID, Dienstleistung.ID) VALUES (?, ?)";
    //
    //UPDATE
    public static final String UpdateSurname       = "UPDATE Kunde SET Nachname = ? WHERE Nr = ?;";
    public static final String UpdateMobile        = "UPDATE Kunde SET Telefonnummer = ? WHERE Nr = ?";
    public static final String UpdateEmail         = "UPDATE Kunde SET E-Mail = ? WHERE Nr = ?";
    //
    //DELETE
    public static final String DeleteAppointment   = "DELETE FROM Termin WHERE ID = ?";
    public static final String DeleteBooking       = "DELETE FROM gebuchteDienstleistung WHERE Termin_ID = ?";
    /**
     * Position und Datentyp der SQL Parameter vgl. ?
     */
    public static final Map<String, Map<Integer, Class>> DeleteParamMap = Map.of(
            DeleteAppointment, Map.of(0, Integer.class)
    );
    //

    public static void initMappings() {
        CRUD.mapStatement(CreateAppointment, CRUD.tableMapping.termin);
        CRUD.mapStatement(CreateBooking, CRUD.tableMapping.gebuchteDienstleistung);
    }

}
