package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicationRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Medication" +
                "(id int PRIMARY KEY AUTO_INCREMENT, price double," +
                "name varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
