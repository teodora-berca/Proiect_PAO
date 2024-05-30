import java.sql.Connection;
import java.sql.Statement;
import jdbc.configuration.DatabaseConfiguration;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConfiguration.getDatabaseConnection();
            Statement stmt = conn.createStatement();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}