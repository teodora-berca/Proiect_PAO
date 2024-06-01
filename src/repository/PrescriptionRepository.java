package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrescriptionRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Prescription" +
                "(id int PRIMARY KEY AUTO_INCREMENT, day int,month int, year int," +
                "appointment_id int, administration_id int," +
                "FOREIGN KEY (appointment_id) REFERENCES Appointment(id))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
