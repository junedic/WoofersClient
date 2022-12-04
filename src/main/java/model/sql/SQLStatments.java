package model.sql;

public class SQLStatments {

    //CREATE
    protected static final String CreateAppointment   = "INSERT INTO Termin (ID, Mitarbeiter.Nr, Hund.ID, Kunde.Nr, Datum, Uhrzeit) VALUES (?,?,?,?,?,?)";
    protected static final String CreateBooking       = "INSERT INTO gebuchteDienstleistung (Termin.ID, Dienstleistung.ID) VALUES (?, ?)";
    //
    //UPDATE
    protected static final String UpdateSurname       = "UPDATE Kunde SET Nachname = ? WHERE Nr = ?;";
    protected static final String UpdateMobile        = "UPDATE Kunde SET Telefonnummer = ? WHERE Nr = ?";
    protected static final String UpdateEmail         = "UPDATE Kunde SET E-Mail = ? WHERE Nr = ?";
    //
    //DELETE
    protected static final String DeleteAppointment   = "DELETE FROM Termin WHERE ID = ?";
    protected static final String DeleteBooking       = "DELETE FROM gebuchteDienstleistung WHERE Termin.ID = ?";
    //

    public static void initMappings() {
        CRUD.mapStatement(CreateAppointment, CRUD.tableMapping.termin);
        CRUD.mapStatement(CreateBooking, CRUD.tableMapping.gebuchteDienstleistung);
    }

}
