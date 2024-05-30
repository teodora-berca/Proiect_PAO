package models.person;
import models.appointment.Appointment;
import models.department.Department;

import java.util.List;

public class Nurse extends Employee {
    private Department department;
    public Nurse() {
        super();
    }
    public Nurse(Integer id, Department department,
                  Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(id, salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.department = department;

    }
    public Nurse(Department department, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                  Integer dayOfEmployment, String employmentStatus, String firstName,
                  String lastName, String phoneNumber, String emailAddress,
                  Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth) {
        super(salary, yearOfEmployment, monthOfEmployment, dayOfEmployment, employmentStatus, firstName,
                lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
