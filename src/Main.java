import database.CreateTables;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import models.person.Patient;
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
                System.out.println("14.Display hospitals.");
                System.out.println("15.Display departments.");
                System.out.println("16.Display subscriptions.");
                System.out.println("17.Display patients.");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch(option)
                {
                    case 1:
                        System.out.println("Add a new patient");
                        System.out.println("First Name:");
                        String firstName = scanner.nextLine();
                        System.out.println("Last Name:");
                        String lastName = scanner.nextLine();
                        System.out.println("Phone number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Email address:");
                        String emailAddress = scanner.nextLine();
                        System.out.println("Day of Birth:");
                        Integer dayOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Month of Birth:");
                        Integer monthOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Year of Birth:");
                        Integer yearOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Subscription:");
                        List<Subscription> subscriptions = databaseServices.displaySubscriptions(databaseServices.getConnection());
                        for(int i=0;i<subscriptions.size();i++)
                        {
                            System.out.println(subscriptions.get(i).getType());
                        }
                        String subscriptionType = scanner.nextLine();
                        Subscription subscription = databaseServices.findSubscription(databaseServices.getConnection(), subscriptionType);
                        Patient patient = new Patient(subscription, firstName, lastName,
                                phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
                        databaseServices.addPatient(databaseServices.getConnection(), patient);
                        break;
                    case 2:
                        System.out.println("Edit a patient");
                        List<Patient> patients = databaseServices.displayPatients(databaseServices.getConnection());
                        for(int i=0;i<patients.size();i++)
                        {
                            System.out.println(patients.get(i).getId() + " " + patients.get(i).getFirstName()+" "+ patients.get(i).getLastName());
                        }
                        System.out.println("Id:");
                        Integer idPatient = scanner.nextInt();
                        scanner.nextLine();
                        databaseServices.updatePatient(databaseServices.getConnection(), idPatient);
                        break;
                    case 3:
                        System.out.println("Delete a patient");
                        List<Patient> patientsDelete = databaseServices.displayPatients(databaseServices.getConnection());
                        patientsDelete.sort(Comparator.comparing(Patient::getLastName));
                        for(int i=0;i<patientsDelete.size();i++)
                        {
                            System.out.println(patientsDelete.get(i).getId() + patientsDelete.get(i).getLastName() + patientsDelete.get(i).getFirstName());
                        }
                        System.out.println("Id:");
                        Integer idDelete = scanner.nextInt();
                        scanner.nextLine();
                        databaseServices.deletePatient(databaseServices.getConnection(), idDelete);
                        break;
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
                        String phoneNumber2 = scanner.nextLine();
                        Hospital h3 = new Hospital(name,address,phoneNumber2);
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
                        List<Subscription> subscriptions2 = databaseServices.displaySubscriptions(databaseServices.getConnection());
                        for(int i=0;i<subscriptions2.size();i++)
                        {
                            Subscription s14 = subscriptions2.get(i);
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
                        databaseServices.subscriptionPatientMap(databaseServices.getConnection());
                        break;
                    case 14:
                        System.out.println("Hospitals:");
                        List<Hospital> hospitals14 = databaseServices.displayHospitals(databaseServices.getConnection());
                        for(int i=0;i<hospitals14.size();i++)
                        {
                            System.out.println(hospitals14.get(i).getName());
                        }
                        break;
                    case 15:
                        System.out.println("Departments:");
                        List<Department> departments15 = databaseServices.displayDepartments(databaseServices.getConnection());
                        for(int i=0;i<departments15.size();i++)
                        {
                            System.out.println(departments15.get(i).getName());
                        }
                        break;
                    case 16:
                        System.out.println("Subscriptions:");
                        List<Subscription> subscriptions16 = databaseServices.displaySubscriptions(databaseServices.getConnection());
                        for(int i=0;i<subscriptions16.size();i++)
                        {
                            System.out.println(subscriptions16.get(i).getType());
                        }
                        break;
                    case 17:
                        System.out.println("Patients:");
                        List<Patient> patients17 = databaseServices.displayPatients(databaseServices.getConnection());
                        for(int i=0;i<patients17.size();i++)
                        {
                            System.out.println(patients17.get(i).getId() + " " + patients17.get(i).getFirstName()+" "+ patients17.get(i).getLastName());
                        }
                        break;
                }
        }
    }
}