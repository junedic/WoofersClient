package model.sql;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;

/**
 * Rohe SQL Daten
 */
public class SqlBefehle {

    //CREATE
    public static final String ErstelleTermin    = "INSERT INTO Termin (Kunde_Nr, Mitarbeiter_Nr, Hund_ID, Datum, Uhrzeit) VALUES (?,?,?,?,?)";
    public static final String ErstelleBuchung   = "INSERT INTO gebuchteDienstleistung (Termin_ID, Dienstleistung_ID) VALUES (?, ?)";
    public static final HashMap<String, HashMap<Integer, Class>> ErstelleParamMap;
    static {
        ErstelleParamMap = new HashMap<>();
        ErstelleParamMap.put(ErstelleTermin, new HashMap<>());
        ErstelleParamMap.get(ErstelleTermin).put(0, Integer.class);
        ErstelleParamMap.get(ErstelleTermin).put(1, Integer.class);
        ErstelleParamMap.get(ErstelleTermin).put(2, Integer.class);
        ErstelleParamMap.get(ErstelleTermin).put(3, Date.class);
        ErstelleParamMap.get(ErstelleTermin).put(4, Time.class);
    }
    //
    //READ
    public static final String LeseAlle          = "SELECT * FROM %s";
    public static final String LeseKunde         = "SELECT * FROM Kunde WHERE Nr = ?";
    public static final String LeseMaZeiten      = "SELECT Uhrzeit FROM Termin WHERE Mitarbeiter_Nr = ? AND DATE(Datum) = ?";
    public static final String LeseMa            = "SELECT Nr, Vorname, Nachname FROM Mitarbeiter";
    public static final String LeseHunde         = "SELECT ID, Name FROM Hund WHERE Kunde_Nr = ?";
    public static final HashMap<String, HashMap<Integer, Class>> LesenParamMap;
    static {
        LesenParamMap = new HashMap<>();
        LesenParamMap.put(LeseKunde, new HashMap<>());
        LesenParamMap.get(LeseKunde).put(0, Integer.class);

        LesenParamMap.put(LeseMaZeiten, new HashMap<>());
        LesenParamMap.get(LeseMaZeiten).put(0, Integer.class);
        LesenParamMap.get(LeseMaZeiten).put(1, Date.class);

        LesenParamMap.put(LeseHunde, new HashMap<>());
        LesenParamMap.get(LeseHunde).put(0, Integer.class);
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
