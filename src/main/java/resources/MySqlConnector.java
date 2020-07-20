package resources;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnector {

    public Connection connection = null;
    private static volatile MySqlConnector mySqlConnector = null;

    private MySqlConnector() {

        String url = "jdbc:mysql://localhost:3306/";
        String db = "imdb_Api";
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver);
            connection = (Connection)DriverManager.getConnection(url + db, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MySqlConnector getConnection() {
        if (mySqlConnector == null) {
            synchronized (MySqlConnector.class) {
                if (mySqlConnector == null) {
                    mySqlConnector = new MySqlConnector();
                }
            }
        }
        return mySqlConnector;
    }
}
