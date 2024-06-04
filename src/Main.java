import database.CreateTables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.DatabaseServices;
import models.department.Department;
import models.hospital.Hospital;

public class Main {
    public static void main(String[] args) {

        CreateTables createTables = CreateTables.getInstance();
        DatabaseServices databaseServices = DatabaseServices.getInstance();

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Choose a profile:");
            System.out.println("1.Patient");
            System.out.println("2.Administrator");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==1)
            {
                System.out.println("Enter your id:");
                scanner.nextInt();
                scanner.nextLine();
                //print a line with hello .......
                System.out.println("Choose a service:");
                System.out.println("1.Make an appointment");
                System.out.println("2.Add a subscription");
                System.out.println("3.Change your subscription");
                System.out.println("4.Show your prescription");
                System.out.println("5.Show your history");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option)
                {
                    case 1:

                    case 2:

                    case 3:

                    case 4:

                    case 5:

                }
            }
            else
            if(choice==2)
            {
                System.out.println("Choose a service:");
                System.out.println("1.Add a patient");
                System.out.println("2.Add a doctor");
                System.out.println("3.Delete a patient");
                System.out.println("4.Delete a doctor");
                System.out.println("5.Add a department");
                System.out.println("6.Delete a department");
                System.out.println("7.Add a hospital");
                System.out.println("8.Delete a hospital");
                System.out.println("9.Edit a hospital");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option)
                {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        System.out.println("Add a new department");
                        System.out.println("Name: ");
                        String nameDepartment = scanner.nextLine();
                        System.out.println("Choose a hospital for the department");
                        List<Hospital> hospitals = databaseServices.DisplayHospitals(databaseServices.getConnection());
                        for(int i=0;i<hospitals.size();i++)
                        {
                            System.out.println(hospitals.get(i).getName());
                        }
                        String nameHospital = scanner.nextLine();
                        Hospital h = databaseServices.FindHospital(databaseServices.getConnection(), nameHospital);
                        Department d = new Department(h, nameDepartment);
                        databaseServices.AddDepartment(databaseServices.getConnection(), d);
                        break;
                    case 6:
                    case 7:
                        System.out.println("Add a new hospital");
                        System.out.println("Name:");
                        String name = scanner.nextLine();
                        System.out.println("Address:");
                        String address = scanner.nextLine();
                        System.out.println("Phone number:");
                        String phoneNumber = scanner.nextLine();
                        Hospital h3 = new Hospital(name,address,phoneNumber);
                        databaseServices.AddHospital(databaseServices.getConnection(),h3);
                        break;
                    case 8:
                        System.out.println("Delete a hospital");
                        List<Hospital> hospitalList = new ArrayList();
                        hospitalList = databaseServices.DisplayHospitals(databaseServices.getConnection());
                        for(int i = 0; i<hospitalList.size(); i++)
                        {
                            Hospital h1 = hospitalList.get(i);
                            System.out.println(h1.getName());
                        }
                        System.out.println("Name:");
                        String name1 = scanner.nextLine();
                        databaseServices.DeleteHospital(databaseServices.getConnection(), name1);
                        break;
                    case 9:
                        System.out.println("Update a hospital");
                        List<Hospital> hospitals9 = new ArrayList();
                        hospitals9 = databaseServices.DisplayHospitals(databaseServices.getConnection());
                        for(int i=0 ;i<hospitals9.size(); i++)
                        {
                            Hospital h2 = hospitals9.get(i);
                            System.out.println(h2.getName());
                        }
                        System.out.println("Name:");
                        String name2 = scanner.nextLine();
                        databaseServices.UpdateHospital(databaseServices.getConnection(), name2);
                        break;

                }
            }
            else
            {
                System.out.println("Nu este o optiune valida");
            }
        }
    }
}