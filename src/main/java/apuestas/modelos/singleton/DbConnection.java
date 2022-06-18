package apuestas.modelos.singleton;

import apuestas.modelos.singleton.connectionProperties.IConnectionProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection = null;

    public static Connection getConnection(IConnectionProperties connectionProperties) {
        connectionProperties.setConnectionProperties();
        try {
            if (connection == null) {
                Class.forName(connectionProperties.getDriver());
                connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword());
                System.out.println("Conexión Exitosa!");
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

}
