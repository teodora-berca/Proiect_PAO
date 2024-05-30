package models.person;
import models.department.Department;
import models.appointment.Appointment;
import java.util.List;

public class Doctor extends Employee{
    private String type;
    private String level;
    private Department department;
    private List<Appointment> appointments;
    public Doctor() {
        super();
    }
    public Doctor(Integer id, Department department, List<Appointment> appointments,
                  String type, String level, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(id, salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.type = type;
        this.level = level;
        this.department = department;
        this.appointments = appointments;
    }
    public Doctor(Department department, List<Appointment> appointments,
                  String type, String level, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.type = type;
        this.level = level;
        this.department = department;
        this.appointments = appointments;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
