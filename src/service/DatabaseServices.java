package service;
import models.department.Department;
import models.hospital.Hospital;

import jdbc.configuration.DatabaseConfiguration;
import models.person.Patient;
import models.subscription.Subscription;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

   public void addSubscription(Connection connection, Subscription subscription)
   {
       PreparedStatement p = null;
       try{
           String insertSubscriptionSQL = "INSERT INTO subscription(type, discount, hospital_id) VALUES (?,?,?)";
           p = connection.prepareStatement(insertSubscriptionSQL);
           p.setString(1, subscription.getType());
           p.setDouble(2, subscription.getDiscount());
           p.setInt(3,subscription.getHospital().getId());
           p.executeUpdate();
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       finally
       {
           try
           {
               if(p!=null)
                   p.close();

           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
   }
   public Subscription findSubscription(Connection connection, String subscriptionType)
   {
       PreparedStatement p = null;
       Subscription s = null;
       try{
           String findSubscriptionSQL = "SELECT s.id, s.type, s.discount, s.hospital_id " +
                   "FROM subscription s " +
                   "WHERE s.type = ?";
           p = connection.prepareStatement(findSubscriptionSQL);
           p.setString(1, subscriptionType);
           ResultSet resultSet = p.executeQuery();
           if(resultSet.next())
           {
               Integer id = resultSet.getInt("id");
               String type = resultSet.getString("type");
               Double discount = resultSet.getDouble("discount");
               Integer hospitalId = resultSet.getInt("hospital_id");
               Hospital h = findHospitalById(connection, hospitalId);
               s = new Subscription(id, type, discount, h);
           }
       }catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       return s;
   }
    public Subscription findSubscriptionById(Connection connection, Integer idSubscription)
    {
        PreparedStatement p = null;
        Subscription s = null;
        try{
            String findSubscriptionSQL = "SELECT s.id, s.type, s.discount, s.hospital_id " +
                    "FROM subscription s " +
                    "WHERE UPPER(s.id) = ?";
            p = connection.prepareStatement(findSubscriptionSQL);
            p.setInt(1, idSubscription);
            ResultSet resultSet = p.executeQuery();
            if(resultSet.next())
            {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                Double discount = resultSet.getDouble("discount");
                Integer hospitalId = resultSet.getInt("hospital_id");
                Hospital h = findHospitalById(connection, hospitalId);
                s = new Subscription(id, type, discount, h);
            }
        }catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        return s;
    }
   public void updateSubscription(Connection connection, String subscriptionType)
   {
        Subscription s = findSubscription(connection, subscriptionType);
        if(s==null)
        {
            System.out.println("Subscription not found.");
        }
        else
        {
            System.out.println("If you don't want to change a field leave it blank.");
            System.out.println("Edit type: "+s.getType());
            Scanner scanner = new Scanner(System.in);
            String newType = scanner.nextLine();
            if(newType.isEmpty())
            {
                newType = s.getType();
            }
            System.out.println("Edit discount: "+s.getDiscount());
            String input = scanner.nextLine();
            Double newDiscount;
            if(input.isEmpty())
            {
                newDiscount = s.getDiscount();
            }
            else
            {
                newDiscount = Double.valueOf(input);
            }
            PreparedStatement p = null;
            String updateDiscountSQL = "UPDATE subscription SET type = ?, discount = ?" +
                    "WHERE id = ?";
            try{
                p = connection.prepareStatement(updateDiscountSQL);
                p.setString(1, newType);
                p.setDouble(2, newDiscount);
                p.setInt(3, s.getHospital().getId());
                p.executeUpdate();
            }
            catch(SQLException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
   }
   public void deleteSubscription(Connection connection, String subscriptionType)
   {
        Subscription s = findSubscription(connection, subscriptionType);
        if(s==null)
        {
            System.out.println("Subscription not found.");
            return;
        }
        else
        {
            String deleteSubscriptionSQL = "DELETE FROM subscription WHERE id = ?";
            PreparedStatement p = null;
            try{
                p = connection.prepareStatement(deleteSubscriptionSQL);
                p.setInt(1, s.getId());
                p.executeUpdate();
            }
            catch(SQLException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
   }
   public List<Subscription> displaySubscriptions(Connection connection)
   {
       List<Subscription> subscriptions = new ArrayList<>();
       PreparedStatement p = null;
       ResultSet s = null;
       try{
           String selectAllSubscriptions = "SELECT * FROM subscription";
           p = connection.prepareStatement(selectAllSubscriptions);
           s = p.executeQuery();
           while(s.next())
           {
               Integer id = s.getInt("id");
               String type = s.getString("type");
               Double discount = s.getDouble("discount");
               Hospital h = findHospitalById(connection, s.getInt("hospital_id"));
               Subscription subscription = new Subscription(id, type, discount, h);
               subscriptions.add(subscription);
           }
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       return subscriptions;
   }
   public void addPatient(Connection connection, Patient patient)
   {
       PreparedStatement p = null;
       try{
           String insertPatientSQL = "INSERT INTO patient(first_name, last_name, phone_number, email_address, " +
                   "year_of_birth, month_of_birth, day_of_birth, subscription_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           p = connection.prepareStatement(insertPatientSQL);
           p.setString(1, patient.getFirstName());
           p.setString(2, patient.getLastName());
           p.setString(3, patient.getPhoneNumber());
           p.setString(4, patient.getEmailAddress());
           p.setInt(5, patient.getYearOfBirth());
           p.setInt(6, patient.getMonthOfBirth());
           p.setInt(7, patient.getDayOfBirth());
           p.setInt(8, patient.getSubscription().getId());
           p.executeUpdate();
           AuditService.logAction("AddPatient");
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       finally
       {
           try
           {
               if(p!=null)
                   p.close();

           }
           catch(SQLException e)
           {
               e.printStackTrace();
           }
       }
   }
   public Patient findPatientById(Connection connection, Integer idPatient)
   {
       PreparedStatement p = null;
       Patient patient = null;
       try{
           String findPatientSQL = "SELECT p.id, p.first_name, p.last_name, p.phone_number, p.email_address, " +
                   "p.year_of_birth, p.month_of_birth, p.day_of_birth, p.subscription_id " +
                   "FROM patient p " +
                   "WHERE p.id = ?";
           p = connection.prepareStatement(findPatientSQL);
           p.setInt(1, idPatient);
           ResultSet resultSet = p.executeQuery();
           if(resultSet.next())
           {
               Integer id = resultSet.getInt("id");
               String firstName = resultSet.getString("first_name");
               String lastName = resultSet.getString("last_name");
               String phoneNumber = resultSet.getString("phone_number");
               String emailAddress = resultSet.getString("email_address");
               Integer yearOfBirth = resultSet.getInt("year_of_birth");
               Integer monthOfBirth = resultSet.getInt("month_of_birth");
               Integer dayOfBirth = resultSet.getInt("day_of_birth");
               Integer subscriptionId = resultSet.getInt("subscription_id");
               Subscription subscription = findSubscriptionById(connection,subscriptionId);
               patient = new Patient(id, subscription, firstName, lastName, phoneNumber,
                       emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);

           }
           AuditService.logAction("FindPatient");
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       return patient;
   }
   public void updatePatient(Connection connection, Integer idPatient)
   {
       Patient patient = findPatientById(connection, idPatient);
       if(patient == null)
       {
           System.out.println("Patient not found");
       }
       else
       {
           System.out.println("If you don't want to change a field leave blank");
           System.out.println("Edit first name: " + patient.getFirstName());
           Scanner scanner = new Scanner(System.in);
           String newFirstName = scanner.nextLine();
           if(newFirstName.isEmpty()) {
               newFirstName = patient.getFirstName();
           }

           System.out.println("Edit last name: " + patient.getLastName());
           String newLastName = scanner.nextLine();
           if(newLastName.isEmpty()) {
               newLastName = patient.getLastName();
           }

           System.out.println("Edit phone number: " + patient.getPhoneNumber());
           String newPhoneNumber = scanner.nextLine();
           if(newPhoneNumber.isEmpty()) {
               newPhoneNumber = patient.getPhoneNumber();
           }

           System.out.println("Edit email address: " + patient.getEmailAddress());
           String newEmailAddress = scanner.nextLine();
           if(newEmailAddress.isEmpty()) {
               newEmailAddress = patient.getEmailAddress();
           }

           System.out.println("Edit year of birth: " + patient.getYearOfBirth());
           String newYearOfBirth = scanner.nextLine();
           if(newYearOfBirth.isEmpty()) {
               newYearOfBirth = String.valueOf(patient.getYearOfBirth());
           }


           System.out.println("Edit month of birth: " + patient.getMonthOfBirth());
           String newMonthOfBirth = scanner.nextLine();
           if(newMonthOfBirth.isEmpty()) {
               newMonthOfBirth = String.valueOf(patient.getMonthOfBirth());
           }

           System.out.println("Edit day of birth: " + patient.getDayOfBirth());
           String newDayOfBirth = scanner.nextLine();
           if(newDayOfBirth.isEmpty()) {
               newDayOfBirth = String.valueOf(patient.getDayOfBirth());
           }

           String updatePatientSQL = "UPDATE patient SET first_name = ?, " +
                   "last_name = ?, phone_number = ?, email_address = ?, " +
                   "year_of_birth = ?, month_of_birth = ?, day_of_birth = ? " +
                   "WHERE id = ?";
           PreparedStatement p = null;
           try {
               p = connection.prepareStatement(updatePatientSQL);
               p.setString(1, newFirstName);
               p.setString(2, newLastName);
               p.setString(3, newPhoneNumber);
               p.setString(4, newEmailAddress);
               p.setInt(5, Integer.parseInt(newYearOfBirth));
               p.setInt(6, Integer.parseInt(newMonthOfBirth));
               p.setInt(7, Integer.parseInt(newDayOfBirth));
               p.setInt(8, patient.getId());
               p.executeUpdate();
               AuditService.logAction("UpdatePatient");

           } catch (SQLException e) {
               System.out.println("Error: " + e.getMessage());
           } finally {
               if (p != null) {
                   try {
                       p.close();
                   } catch (SQLException e) {
                       System.out.println("Error: " + e.getMessage());
                   }
               }
           }
       }
   }
   public void deletePatient(Connection connection, Integer patientId)
   {
       Patient patient = findPatientById(connection, patientId);
       if (patient == null) {
           System.out.println("Patient not found.");
           return;
       } else {
           String deletePatientSQL = "DELETE FROM patient WHERE id = ?";
           PreparedStatement p = null;
           try {
               p = connection.prepareStatement(deletePatientSQL);
               p.setInt(1, patient.getId());
               p.executeUpdate();
               AuditService.logAction("DeletePatient");
           } catch (SQLException e) {
               System.out.println("Error: " + e.getMessage());
           } finally {
               if (p != null) {
                   try {
                       p.close();
                   } catch (SQLException e) {
                       System.out.println("Error: " + e.getMessage());
                   }
               }
           }
       }
   }
    public List<Patient> displayPatients(Connection connection) {
        List<Patient> patients = new ArrayList<>();
        PreparedStatement p = null;
        ResultSet resultSet = null;
        try {
            String selectAllPatientsSQL = "SELECT * FROM patient";
            p = connection.prepareStatement(selectAllPatientsSQL);
            resultSet = p.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String emailAddress = resultSet.getString("email_address");
                int yearOfBirth = resultSet.getInt("year_of_birth");
                int monthOfBirth = resultSet.getInt("month_of_birth");
                int dayOfBirth = resultSet.getInt("day_of_birth");
                int subscriptionId = resultSet.getInt("subscription_id");

                Subscription subscription = findSubscriptionById(connection, subscriptionId);

                Patient patient = new Patient(id, subscription, firstName,lastName,phoneNumber,emailAddress,yearOfBirth,
                        monthOfBirth, dayOfBirth);
                patients.add(patient);
            }
            AuditService.logAction("DisplayPatients");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            if (p != null) {
                try {
                    p.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return patients;
    }

    public void addDepartment(Connection connection, Department d)
   {
        PreparedStatement p = null;
        try{
            String insertDepartmentSQL = "INSERT INTO department(name, hospital_id) VALUES (?, ?)";
            p = connection.prepareStatement(insertDepartmentSQL);
            p.setString(1, d.getName());
            p.setInt(2, d.getHospital().getId());
            p.executeUpdate();
            AuditService.logAction("AddDepartment");
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        finally{
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
   public Department findDepartment(Connection connection, String departmentName)
   {
       PreparedStatement p = null;
       Department d = null;
       try{
           String findDepartmentSQL = "SELECT d.id, d.name, d.hospital_id " +
                   "FROM department d " +
                   "WHERE UPPER(d.name) = ?";
           p = connection.prepareStatement(findDepartmentSQL);
           p.setString(1, departmentName);
           ResultSet resultSet = p.executeQuery();
           if(resultSet.next())
           {
               Integer id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               Integer hospitalId = resultSet.getInt("hospital_id");
               Hospital h = findHospitalById(connection, hospitalId);
               d = new Department(id, h, name);
           }
           AuditService.logAction("FindDepartment");
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
       return d;
   }
   public void updateDepartment(Connection connection, String departmentName)
   {
        Department department = findDepartment(connection, departmentName);
        if(department == null)
        {
            System.out.println("Department not found");
        }
        else
        {
            System.out.println("If you don't want to change a field leave blank");
            System.out.println("Edit name: "+department.getName());
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            if(newName.isEmpty())
            {
                newName = department.getName();
            }
            String updateDepartmentSQL = "UPDATE department SET name = ? " +
                    "WHERE id = ?";
            PreparedStatement p = null;
            try{
                p = connection.prepareStatement(updateDepartmentSQL);
                p.setString(1, newName);
                p.setInt(2, department.getId());
                p.executeUpdate();
                AuditService.logAction("UpdateDepartment");
            }
            catch(SQLException e)
            {
                System.out.println("Error "+e.getMessage());
            }
        }
   }
   public void deleteDepartment(Connection connection, String departmentName)
   {
        Department department = findDepartment(connection, departmentName);
        if(department == null)
        {
            System.out.println("Department not found.");
            return;
        }
        else
        {
            String deleteDepartmentSQL = "DELETE FROM department WHERE id = ?";
            PreparedStatement p = null;
            try{
                p = connection.prepareStatement(deleteDepartmentSQL);
                p.setInt(1, department.getId());
                p.executeUpdate();
                AuditService.logAction("DeleteDepartment");
            }
            catch(SQLException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
        }
   }
   public List<Department> displayDepartments(Connection connection)
   {
       List<Department> departments = new ArrayList<>();
       PreparedStatement p = null;
       ResultSet resultSet = null;
       try{
           String selectAllDepartmentsSQL = "SELECT * FROM department";
           p = connection.prepareStatement(selectAllDepartmentsSQL);
           resultSet = p.executeQuery();
           while(resultSet.next()) {
               String name = resultSet.getString("name");
               Integer hospitalId = resultSet.getInt("hospital_id");
               Hospital h = findHospitalById(connection, hospitalId);
               Department d = new Department(h, name);
               departments.add(d);
           }
           AuditService.logAction("DisplayDepartments");
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       return departments;
   }
   public void addHospital(Connection connection, Hospital hospital)
   {
       PreparedStatement p = null;
       try {
            String insertHospitalSql = "INSERT INTO hospital(name, address, phone_number) VALUES (?,?,?)";
            p = connection.prepareStatement(insertHospitalSql);
            p.setString(1, hospital.getName());
            p.setString(2, hospital.getAddress());
            p.setString(3, hospital.getPhoneNumber());
            p.executeUpdate();
            AuditService.logAction("AddHospital");
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
   public Hospital findHospital(Connection connection, String hospitalName)
   {
       String searchHospitalSQL = "SELECT h.id, h.address, h.phone_number " +
               "FROM hospital h " +
               "WHERE UPPER(h.name) = ?";
       PreparedStatement p = null;
       Hospital h1 = null;
       try{
           p = connection.prepareStatement(searchHospitalSQL);
           p.setString(1, hospitalName);
           ResultSet resultSet = p.executeQuery();
           if(resultSet.next())
           {
               Integer id = resultSet.getInt("id");
               String address = resultSet.getString("address");
               String phoneNumber = resultSet.getString("phone_number");
               h1 = new Hospital();
               h1.setId(id);
               h1.setName(hospitalName);
               h1.setAddress(address);
               h1.setPhoneNumber(phoneNumber);
           }
           AuditService.logAction("FindHospital");
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e.getMessage());
       }
       return h1;
   }
    public Hospital findHospitalById(Connection connection, Integer idHospital)
    {
        String searchHospitalSQL = "SELECT h.id, h.name, h.address, h.phone_number " +
                "FROM hospital h " +
                "WHERE h.id = ?";
        PreparedStatement p = null;
        try{
            p = connection.prepareStatement(searchHospitalSQL);
            p.setInt(1, idHospital);
            ResultSet resultSet = p.executeQuery();
            Hospital h1 = new Hospital();
            if(resultSet.next())
            {
                Integer id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                h1.setId(id);
                h1.setName(name);
                h1.setAddress(address);
                h1.setPhoneNumber(phoneNumber);
            }
            AuditService.logAction("FindHospitalById");
            return h1;
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }
   public void updateHospital(Connection connection, String hospitalName)
   {
            Hospital hospital = findHospital(connection, hospitalName);
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
                    AuditService.logAction("UpdateHospital");
                }
                catch(SQLException e)
                {
                    System.out.println("Error "+e.getMessage());
                }
            }
   }
   public void deleteHospital(Connection connection, String hospitalName)
   {
            Hospital hospital = findHospital(connection, hospitalName);
            if(hospital == null)
            {
                System.out.println("Hospital not found.");
                return;
            }
            else
            {
                String deleteHospitalSQL = "DELETE FROM hospital WHERE id = ?";
                PreparedStatement p = null;
                try{
                    p = connection.prepareStatement(deleteHospitalSQL);
                    p.setInt(1, hospital.getId());
                    p.executeUpdate();
                    AuditService.logAction("DeleteHospital");
                }
                catch(SQLException e){
                    System.out.println("Error: "+e.getMessage());
                }
            }

   }
   public List<Hospital> displayHospitals(Connection connection)
   {
        List<Hospital> hospitals = new ArrayList<>();
        PreparedStatement p = null;
        ResultSet resultSet = null;
        try{
            String selectAllHospitalsSQL = "SELECT * FROM hospital";
            p = connection.prepareStatement(selectAllHospitalsSQL);
            resultSet = p.executeQuery();
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                Hospital h = new Hospital(name, address, phoneNumber);
                hospitals.add(h);
            }
            AuditService.logAction("DisplayHospitals");

        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        finally{
            try{
                if(resultSet!=null)
                {
                    resultSet.close();
                }
                if(p!=null)
                {
                    p.close();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return hospitals;
   }

    public void subscriptionPatientMap(Connection connection) {

        List<Subscription> subscriptions = displaySubscriptions(connection);
        List<Patient> patients = displayPatients(connection);

        HashMap<String, String> subscriptionPatientMap = new HashMap<>();

        for (Patient patient : patients) {

            String fullName = patient.getLastName()+" "+patient.getFirstName();
            String subscription = patient.getSubscription().getType();
            subscriptionPatientMap.put(fullName, subscription);
            }

        for (HashMap.Entry<String, String> entry : subscriptionPatientMap.entrySet()) {
            System.out.println("Patient name: " + entry.getKey() + " - Subscription: " + entry.getValue());
        }
    }
}
