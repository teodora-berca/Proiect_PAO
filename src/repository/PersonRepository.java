package repository;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonRepository {
    public void createTable()
    {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Person(" +
            "id int PRIMARY KEY AUTO_INCREMENT," +
            "first_name varchar(30),last_name varchar(30),phone_number varchar(15)," +
            "email_address varchar(50)," +
            "year_of_birth int, month_of_birth int, day_of_birth int);";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
