import repository.SubscriptionRepository;
import repository.HospitalRepository;
import repository.DepartmentRepository;
import repository.MedicationRepository;
import repository.AdministrationRepository;
import repository.AppointmentRepository;
import repository.ConsultationRoomRepository;
import repository.DoctorRepository;
import repository.EmployeeRepository;
import repository.NurseRepository;
import repository.PatientRepository;
import repository.PersonRepository;
import repository.PrescriptionRepository;

public class Main {
    public static void main(String[] args) {
        HospitalRepository hospitalRepository = new HospitalRepository();
        hospitalRepository.createTable();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        departmentRepository.createTable();
        SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
        subscriptionRepository.createTable();
        MedicationRepository medicationRepository = new MedicationRepository();
        medicationRepository.createTable();
        PersonRepository personRepository = new PersonRepository();
        personRepository.createTable();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.createTable();
        DoctorRepository doctorRepository = new DoctorRepository();
        doctorRepository.createTable();
        NurseRepository nurseRepository = new NurseRepository();
        nurseRepository.createTable();
        PatientRepository patientRepository = new PatientRepository();
        patientRepository.createTable();
        ConsultationRoomRepository consultationRoomRepository = new ConsultationRoomRepository();
        consultationRoomRepository.createTable();
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.createTable();
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();
        prescriptionRepository.createTable();
        AdministrationRepository administrationRepository = new AdministrationRepository();
        administrationRepository.createTable();

    }
}