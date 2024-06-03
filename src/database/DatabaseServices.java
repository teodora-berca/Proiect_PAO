package database;
import models.hospital.Hospital;
import models.person.Doctor;

import jdbc.configuration.DatabaseConfiguration;

import java.sql.*;
import java.util.Scanner;

public class DatabaseServices {
    private static DatabaseServices instance;
    private Connection connection;

    private DatabaseServices() {
        this.connection = DatabaseConfiguration.getDatabaseConnection();
    }

    public Connection getConnection()
    {
        return connection;
    }
    public static DatabaseServices getInstance() {
        if (instance == null) {
            instance = new DatabaseServices();
        }
        return instance;
    }

   public void AddHospital(Connection connection, Hospital hospital)
   {
       PreparedStatement p = null;
       try {
            String insertHospitalSql = "INSERT INTO hospital(name, address, phone_number) VALUES (?,?,?)";
            p = connection.prepareStatement(insertHospitalSql);
            p.setString(1, hospital.getName());
            p.setString(2, hospital.getAddress());
            p.setString(3, hospital.getPhoneNumber());
            p.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Error adding a new hospital to the database:"+e.getMessage());
        }
        finally
        {
            try
            {
                if (p != null)
                    p.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
   }
   public Hospital FindHospital(Connection connection, String hospitalName)
   {
       String searchHospitalSQL = "SELECT h.id, h.address, h.phone_number " +
               "FROM hospital h " +
               "WHERE UPPER(h.name) = ?";
       PreparedStatement p = null;
       try{
           p = connection.prepareStatement(searchHospitalSQL);
           p.setString(1, hospitalName);
           ResultSet resultSet = p.executeQuery();
           Hospital h1 = new Hospital();
           if(resultSet.next())
           {
               Integer id = resultSet.getInt("id");
               String address = resultSet.getString("address");
               String phoneNumber = resultSet.getString("phone_number");
               h1.setId(id);
               h1.setName(hospitalName);
               h1.setAddress(address);
               h1.setPhoneNumber(phoneNumber);
           }
           return h1;
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
           return null;
       }
   }
   public void UpdateHospital(Connection connection, String hospitalName)
   {
            Hospital hospital = FindHospital(connection, hospitalName);
            if(hospital==null)
            {
                System.out.println("Hospital not found.");
                return;
            }
            else
            {
                System.out.println("If you don't want to change a field leave blank");
                System.out.println("Edit name: "+hospital.getName());
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                if(newName.isEmpty())
                {
                    newName = hospital.getName();
                }
                System.out.println("Edit address "+hospital.getAddress());
                String newAddress = scanner.nextLine();
                if(newAddress.isEmpty())
                {
                    newAddress = hospital.getAddress();
                }
                System.out.println("Phone number: "+hospital.getPhoneNumber());
                String newPhoneNumber = scanner.nextLine();
                if(newPhoneNumber.isEmpty())
                {
                    newPhoneNumber = hospital.getPhoneNumber();
                }
                String updateHospitalSQL = "UPDATE hospital SET name = ?, address = ?, phone_number = ? " +
                        "WHERE id = ?";
                PreparedStatement p = null;
                try{
                    p = connection.prepareStatement(updateHospitalSQL);
                    p.setString(1, newName);
                    p.setString(2, newAddress);
                    p.setString(3, newPhoneNumber);
                    p.setInt(4, hospital.getId());
                    p.executeUpdate();
                }
                catch(SQLException e)
                {
                    System.out.println("Error "+e.getMessage());
                }
            }
   }
   public void DeleteHospital()
   {

   }
   public void DisplayHospitals()
   {

   }















}
