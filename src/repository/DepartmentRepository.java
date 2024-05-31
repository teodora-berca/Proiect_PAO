package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentRepository {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Department" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "hospital_id int, FOREIGN KEY (hospital_id) REFERENCES Hospital(id))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
