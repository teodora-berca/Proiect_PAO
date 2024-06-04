import database.CreateTables;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import service.DatabaseServices;
import models.department.Department;
import models.hospital.Hospital;
import models.subscription.Subscription;

public class Main {
    public static void main(String[] args) {

        CreateTables createTables = CreateTables.getInstance();
        DatabaseServices databaseServices = DatabaseServices.getInstance();

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
                System.out.println("Choose a service:");
                System.out.println("1.Add a patient");
                System.out.println("2.Edit a patient");
                System.out.println("3.Delete a patient");
                System.out.println("4.Add a department");
                System.out.println("5.Edit a department");
                System.out.println("6.Delete a department");
                System.out.println("7.Add a hospital");
                System.out.println("8.Edit a hospital");
                System.out.println("9.Delete a hospital");
                System.out.println("10.Add a subscription");
                System.out.println("11.Edit a subscription");
                System.out.println("12.Delete a subscription");
                System.out.println("13.Display patients and subscriptions");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option)
                {
                    case 1:
                        System.out.println("Add a new patient");
                        System.out.println("First Name:");
                        System.out.println("Last Name:");
                        System.out.println("Day of Birth:");
                        System.out.println("Month of Birth:");
                        System.out.println("Year of Birth:");
                        System.out.println("Phone number:");
                        System.out.println("Email address:");
                        System.out.println("Subscription:");
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("Add a new department");
                        System.out.println("Name: ");
                        String nameDepartment = scanner.nextLine();
                        System.out.println("Choose a hospital for the department");
                        List<Hospital> hospitals = databaseServices.displayHospitals(databaseServices.getConnection());
                        for(int i=0;i<hospitals.size();i++)
                        {
                            System.out.println(hospitals.get(i).getName());
                        }
                        String nameHospital = scanner.nextLine();
                        Hospital h = databaseServices.findHospital(databaseServices.getConnection(), nameHospital);
                        Department d = new Department(h, nameDepartment);
                        databaseServices.addDepartment(databaseServices.getConnection(), d);
                        break;
                    case 5:
                        System.out.println("Edit a department");
                        List<Department> departments = databaseServices.displayDepartments(databaseServices.getConnection());
                        for(int i=0;i<departments.size();i++)
                        {
                            System.out.println(departments.get(i).getName());
                        }
                        System.out.println("Name:");
                        String name1 = scanner.nextLine();
                        databaseServices.updateDepartment(databaseServices.getConnection(), name1);
                        break;
                    case 6:
                        System.out.println("Delete a department");
                        List<Department> departmentsDelete = databaseServices.displayDepartments(databaseServices.getConnection());
                        departmentsDelete.sort(Comparator.comparing(Department::getName));
                        for(int i=0;i<departmentsDelete.size();i++)
                        {
                            System.out.println(departmentsDelete.get(i).getName());
                        }
                        System.out.println("Name");
                        String nameDelete = scanner.nextLine();
                        databaseServices.deleteDepartment(databaseServices.getConnection(), nameDelete);
                        break;
                    case 7:
                        System.out.println("Add a new hospital");
                        System.out.println("Name:");
                        String name = scanner.nextLine();
                        System.out.println("Address:");
                        String address = scanner.nextLine();
                        System.out.println("Phone number:");
                        String phoneNumber = scanner.nextLine();
                        Hospital h3 = new Hospital(name,address,phoneNumber);
                        databaseServices.addHospital(databaseServices.getConnection(),h3);
                        break;
                    case 8:
                        System.out.println("Edit a hospital");
                        List<Hospital> hospitals9 = databaseServices.displayHospitals(databaseServices.getConnection());
                        for(int i=0 ;i<hospitals9.size(); i++)
                        {
                            Hospital h2 = hospitals9.get(i);
                            System.out.println(h2.getName());
                        }
                        System.out.println("Name:");
                        String name2 = scanner.nextLine();
                        databaseServices.updateHospital(databaseServices.getConnection(), name2);
                        break;
                    case 9:
                        System.out.println("Delete a hospital");
                        List<Hospital> hospitalList = databaseServices.displayHospitals(databaseServices.getConnection());
                        for(int i = 0; i<hospitalList.size(); i++)
                        {
                            Hospital h1 = hospitalList.get(i);
                            System.out.println(h1.getName());
                        }
                        System.out.println("Name:");
                        String nameH = scanner.nextLine();
                        databaseServices.deleteHospital(databaseServices.getConnection(), nameH);
                        break;
                    case 10:
                        System.out.println("Add a new subscription");
                        System.out.println("Type:");
                        String type = scanner.nextLine();
                        System.out.println("Discount:");
                        Double discount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Hospital:");
                        List<Hospital> hospitalsSub = databaseServices.displayHospitals(databaseServices.getConnection());
                        for(int i=0;i<hospitalsSub.size();i++)
                        {
                            System.out.println(hospitalsSub.get(i).getName());
                        }
                        String aux = scanner.nextLine();
                        Hospital hospital13 = databaseServices.findHospital(databaseServices.getConnection(), aux);
                        Subscription sub = new Subscription(type, discount, hospital13);
                        databaseServices.addSubscription(databaseServices.getConnection(), sub);
                        break;
                    case 11:
                        System.out.println("Edit a subscription");
                        List<Subscription> subscriptions = databaseServices.displaySubscriptions(databaseServices.getConnection());
                        for(int i=0;i<subscriptions.size();i++)
                        {
                            Subscription s14 = subscriptions.get(i);
                            System.out.println(s14.getType());
                        }
                        System.out.println("Type:");
                        String type14 = scanner.nextLine();
                        databaseServices.updateSubscription(databaseServices.getConnection(), type14);
                        break;
                    case 12:
                        System.out.println("Delete a subscription");
                        List<Subscription> subscriptions15 = databaseServices.displaySubscriptions(databaseServices.getConnection());
                        for(int i=0;i<subscriptions15.size();i++)
                        {
                            System.out.println(subscriptions15.get(i).getType());
                        }
                        System.out.println("Type:");
                        String type15 = scanner.nextLine();
                        databaseServices.deleteSubscription(databaseServices.getConnection(), type15);
                        break;
                    case 13:
                        break;
                }
        }
    }
}