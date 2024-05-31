package models.prescription;
import models.appointment.Appointment;
import models.administration.Administration;

public class Prescription {
    private Integer id;
    private Appointment appointment;
    private Administration administration;
    private Integer day;
    private Integer month;
    private Integer year;
    public Prescription() {}
    public Prescription(Integer id, Appointment appointment,
                        Administration administration, Integer day,
                        Integer month, Integer year)
    {
        this.id = id;
        this.appointment = appointment;
        this.administration = administration;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Prescription(Appointment appointment, Administration administration,
                        Integer year, Integer month, Integer day)
    {
        this.appointment = appointment;
        this.administration = administration;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Administration getAdministration() {
        return administration;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
