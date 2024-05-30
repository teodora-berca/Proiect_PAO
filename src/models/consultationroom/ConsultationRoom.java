package models.consultationroom;
import models.department.Department;
import models.appointment.Appointment;
import java.util.List;

public class ConsultationRoom {
    private Integer id;
    private Department department;
    private List<Appointment> appointments;
    private String number;
    public ConsultationRoom() {}
    public ConsultationRoom(Integer id, Department department, List<Appointment> appointments,
                            String number)
    {
        this.id = id;
        this.department = department;
        this.appointments = appointments;
        this.number = number;
    }
    public ConsultationRoom(Department department, List<Appointment> appointments,
                            String number)
    {
        this.department = department;
        this.appointments = appointments;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
