package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NurseRepository {
    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Nurse (" +
                "id int PRIMARY KEY," +
                "department_id int," +
                "FOREIGN KEY (id) REFERENCES Employee(id)," +
                "FOREIGN KEY (department_id) REFERENCES Department(id))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
