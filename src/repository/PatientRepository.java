package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientRepository {
    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Patient (" +
                "id int PRIMARY KEY," +
                "subscription_id int," +
                "FOREIGN KEY (id) REFERENCES Person(id)," +
                "FOREIGN KEY (subscription_id) REFERENCES Subscription(id))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
