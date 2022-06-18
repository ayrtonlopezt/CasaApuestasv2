package apuestas.modelos.singleton;

import apuestas.modelos.SoccerTeam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbReadNames {

    String teamName;

    public String getTeamName(Connection connection, int i) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM equiposfutbol WHERE Id="+i);
        if(resultSet.next()) {
            this.teamName = resultSet.getString(2);
        }
        return this.teamName;
    }
}
