import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class env {
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String urlDB = "jdbc:mysql://localhost:3306/dbkuliah";
    private static final String user = "root";
    private static final String password = "";

    public static Statement dbConnection() {
        Statement statement;
        try {
            Class.forName(className);
            Connection koneksi = DriverManager.getConnection(urlDB, user, password);
            statement = koneksi.createStatement();
            return statement;
        } catch (Exception e) {
            return statement = null;
        }
    }
}