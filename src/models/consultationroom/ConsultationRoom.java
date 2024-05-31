package models.consultationroom;
import models.department.Department;

public class ConsultationRoom {
    private Integer id;
    private Department department;
    private String number;
    public ConsultationRoom() {}
    public ConsultationRoom(Integer id, Department department,
                            String number)
    {
        this.id = id;
        this.department = department;
        this.number = number;
    }
    public ConsultationRoom(Department department,
                            String number)
    {
        this.department = department;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
