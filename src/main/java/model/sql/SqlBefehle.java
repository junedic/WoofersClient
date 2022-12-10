package model.sql;

import java.util.HashMap;

/**
 * Rohe SQL Daten
 */
public class SqlBefehle {

    //CREATE
    public static final String ErstelleTermin    = "INSERT INTO Termin (ID, Mitarbeiter.Nr, Hund.ID, Kunde.Nr, Datum, Uhrzeit) VALUES (?,?,?,?,?,?)";
    public static final String ErstelleBuchung   = "INSERT INTO gebuchteDienstleistung (Termin.ID, Dienstleistung.ID) VALUES (?, ?)";
    //
    //READ
    public static final String LeseAlle          = "SELECT * FROM %s";
    public static final String LeseKunde         = "SELECT * FROM Kunde WHERE Nr = ?";
    public static final HashMap<String, HashMap<Integer, Class>> LesenParamMap;
    static {
        HashMap<String, HashMap<Integer, Class>> temp = new HashMap<>();
        HashMap<Integer, Class> tempInternal = new HashMap<>();
        tempInternal.put(0, Integer.class);
        temp.put(LeseKunde, tempInternal);
        LesenParamMap = temp;
    }
    //
    //UPDATE
    public static final String BearbeiteKunde    = "UPDATE Kunde SET Nachname = ?, Telefonnummer = ?, Email = ? WHERE Nr = ?;";
    public static final HashMap<String, HashMap<Integer, Class>> AktualisiereParamMap;
    static {
        HashMap<String, HashMap<Integer, Class>> temp = new HashMap<>();
        HashMap<Integer, Class> tempInternal = new HashMap<>();
        tempInternal.put(0, String.class);
        tempInternal.put(1, String.class);
        tempInternal.put(2, String.class);
        tempInternal.put(3, Integer.class);
        temp.put(BearbeiteKunde, tempInternal);
        AktualisiereParamMap = temp;
    }
    //
    //DELETE
    public static final String EntferneTermin = "DELETE FROM Termin WHERE ID = ?";
    public static final String EntferneBuchung     = "DELETE FROM gebuchteDienstleistung WHERE Termin_ID = ?";
    /**
     * Position und Datentyp der SQL Parameter vgl. ?
     */
    public static final HashMap<String, HashMap<Integer, Class>> EntferneParamMap;
    static {
        HashMap<String, HashMap<Integer, Class>> temp = new HashMap<>();
        HashMap<Integer, Class> tempInternal = new HashMap<>();
        tempInternal.put(0, Integer.class);
        temp.put(EntferneTermin, tempInternal);
        EntferneParamMap = temp;
    }

    public static void initMappings() {
        CRUD.bildeBefehlAb(ErstelleTermin, CRUD.tabellenAbbildung.termin);
        CRUD.bildeBefehlAb(ErstelleBuchung, CRUD.tabellenAbbildung.gebuchteDienstleistung);
    }

}
