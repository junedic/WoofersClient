package model.db;

public class Auth {

    public record ConData(String url, String port, String db, String usr, String pwd) { }

    //private static final String url= "jdbc:mysql://%s:%s/%s?user=%s&password=%s";
    private static final String url= "jdbc:mysql://%s:%s/%s";
    private static final String port = "3306";
    private static final String db = "Woofers";
    private static final String usr = "teama1";
    private static final String pwd = "woofers";

    public static final ConData conData = new ConData(url, port, db, usr, pwd);

}
