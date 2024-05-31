package models.person;
import models.department.Department;
import models.appointment.Appointment;
import java.util.List;

public class Doctor extends Employee{
    private String type;
    private String level;
    private Department department;
    public Doctor() {
        super();
    }
    public Doctor(Integer id, Department department,
                  String type, String level, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(id, salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.type = type;
        this.level = level;
        this.department = department;
    }
    public Doctor(Department department,
                  String type, String level, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.type = type;
        this.level = level;
        this.department = department;
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
}
