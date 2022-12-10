package model.db;

public class Auth {

    public record VerbDaten(String url, String port, String db, String usr, String pwd) { }

    //private static final String url= "jdbc:mysql://%s:%s/%s?user=%s&password=%s";
    private static final String url= "jdbc:mysql://%s:%s/%s";
    private static final String port = "3306";
    private static final String db = "Woofers";
    private static final String nutzer = "teama1";
    private static final String pass = "woofers";

    public static final VerbDaten verbDaten = new VerbDaten(url, port, db, nutzer, pass);

}
