import database.CreateTables;
import java.util.Scanner;
import database.DatabaseServices;
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
            System.out.println("3.Doctor");
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
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option)
                {
                    case 1:

                    case 2:
                        System.out.println("First name:");
                        String firstName = scanner.nextLine();
                        System.out.println("Last name:");
                        String lastName = scanner.nextLine();
                        System.out.println("Day of birth:");
                        Integer dayOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Month of birth:");
                        Integer monthOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        Integer yearOfBirth = scanner.nextInt();
                        scanner.nextLine();
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        System.out.println("Add a new hospital");
                        System.out.println("Name:");
                        String name = scanner.nextLine();
                        System.out.println("Address:");
                        String address = scanner.nextLine();
                        System.out.println("Phone number:");
                        String phoneNumber = scanner.nextLine();
                        Hospital h = new Hospital(name,address,phoneNumber);
                        databaseServices.AddHospital(databaseServices.getConnection(),h);
                    case 8:
                        System.out.println("Delete a hospital");
                        System.out.println("Name:");
                        String name1 = scanner.nextLine();



                }
            }
            else if(choice==3)
            {

            }
            else
            {
                System.out.println("Nu este o optiune valida");
            }
        }
    }
}