package resources;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnector {

    public Connection connection = null;
    private static volatile MySqlConnector mySqlConnector = null;

    private MySqlConnector() {

        String url = null;
        String db = null;
        String driver = null;
        String user = null;
        String password = null;

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
