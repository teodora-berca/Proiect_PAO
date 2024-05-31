package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministrationRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Administration" +
                "(id int PRIMARY KEY AUTO_INCREMENT, quantity int," +
                "frequency int, prescription_id int, medication_id int," +
                "FOREIGN KEY (prescription_id) REFERENCES Prescription(id)," +
                "FOREIGN KEY (medication_id) REFERENCES Medication(id))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
