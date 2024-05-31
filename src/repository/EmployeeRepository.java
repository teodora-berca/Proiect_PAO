package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepository {
    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id int PRIMARY KEY, " +
                "salary double," +
                "year_of_employment int, month_of_employment int, day_of_employment int, " +
                "FOREIGN KEY (id) REFERENCES Person(id))";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
