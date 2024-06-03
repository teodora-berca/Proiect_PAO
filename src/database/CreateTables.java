package database;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    private static CreateTables instance;
    private CreateTables() {
        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        // Create Hospital table
        String createTableSql = "CREATE TABLE IF NOT EXISTS Hospital" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "address varchar(30), phone_number varchar(30))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Department table
        createTableSql = "CREATE TABLE IF NOT EXISTS Department" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "hospital_id int, FOREIGN KEY (hospital_id) REFERENCES Hospital(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Subscription table
        createTableSql = "CREATE TABLE IF NOT EXISTS Subscription" +
                "(id int PRIMARY KEY AUTO_INCREMENT, type varchar(30)," +
                "discount double, hospital_id int, FOREIGN KEY (hospital_id) REFERENCES Hospital(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Medication table
        createTableSql = "CREATE TABLE IF NOT EXISTS Medication" +
                "(id int PRIMARY KEY AUTO_INCREMENT, price double," +
                "name varchar(30))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Person table
        createTableSql = "CREATE TABLE IF NOT EXISTS Person(" +
                "id int PRIMARY KEY AUTO_INCREMENT," +
                "first_name varchar(30),last_name varchar(30),phone_number varchar(15)," +
                "email_address varchar(50)," +
                "year_of_birth int, month_of_birth int, day_of_birth int);";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Employee table
        createTableSql = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id int PRIMARY KEY, " +
                "salary double," +
                "year_of_employment int, month_of_employment int, day_of_employment int, " +
                "FOREIGN KEY (id) REFERENCES Person(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Doctor table
        createTableSql = "CREATE TABLE IF NOT EXISTS Doctor (" +
                "id int PRIMARY KEY, type varchar(30), level varchar(30)," +
                "department_id int,  " +
                "FOREIGN KEY (department_id) REFERENCES Department(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Nurse table
        createTableSql = "CREATE TABLE IF NOT EXISTS Nurse (" +
                "id int PRIMARY KEY," +
                "department_id int," +
                "FOREIGN KEY (id) REFERENCES Employee(id)," +
                "FOREIGN KEY (department_id) REFERENCES Department(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Patient table
        createTableSql = "CREATE TABLE IF NOT EXISTS Patient (" +
                "id int PRIMARY KEY," +
                "subscription_id int," +
                "FOREIGN KEY (id) REFERENCES Person(id)," +
                "FOREIGN KEY (subscription_id) REFERENCES Subscription(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create ConsultationRoom table
        createTableSql = "CREATE TABLE IF NOT EXISTS ConsultationRoom" +
                "(id int PRIMARY KEY AUTO_INCREMENT, number varchar(30)," +
                "department_id int," +
                "FOREIGN KEY (department_id) REFERENCES Department(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Appointment table
        createTableSql = "CREATE TABLE IF NOT EXISTS Appointment" +
                "(id int PRIMARY KEY AUTO_INCREMENT, price double," +
                "doctor_id int, patient_id int, consultation_room_id int," +
                "FOREIGN KEY (doctor_id) REFERENCES Doctor(id)," +
                "FOREIGN KEY (patient_id) REFERENCES Patient(id)," +
                "FOREIGN KEY (consultation_room_id) REFERENCES ConsultationRoom(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Prescription table
        createTableSql = "CREATE TABLE IF NOT EXISTS Prescription" +
                "(id int PRIMARY KEY AUTO_INCREMENT, day int,month int, year int," +
                "appointment_id int, administration_id int," +
                "FOREIGN KEY (appointment_id) REFERENCES Appointment(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Administration table
        createTableSql = "CREATE TABLE IF NOT EXISTS Administration" +
                "(id int PRIMARY KEY AUTO_INCREMENT, quantity int," +
                "frequency int, prescription_id int, medication_id int," +
                "FOREIGN KEY (prescription_id) REFERENCES Prescription(id)," +
                "FOREIGN KEY (medication_id) REFERENCES Medication(id))";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static CreateTables getInstance() {
        if (instance == null) {
            instance = new CreateTables();
        }
        return instance;
    }
}
