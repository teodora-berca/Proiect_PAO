package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AppointmentRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Appointment" +
                "(id int PRIMARY KEY AUTO_INCREMENT, price double," +
                "doctor_id int, patient_id int, prescription_id int, consultation_room_id int," +
                "FOREIGN KEY (doctor_id) REFERENCES Doctor(id)," +
                "FOREIGN KEY (patient_id) REFERENCES Patient(id)," +
                "FOREIGN KEY (prescription_id) REFERENCES Prescription(id)," +
                "FOREIGN KEY (consultation_room_id) REFERENCES ConsultationRoom(id))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
