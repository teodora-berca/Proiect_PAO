package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorRepository {
    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Doctor (" +
                "id int PRIMARY KEY, type varchar(30), level varchar(30)," +
                "department_id int,  " +
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
