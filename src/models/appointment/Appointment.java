package models.appointment;
import models.person.Doctor;
import models.person.Patient;
import models.prescription.Prescription;
import models.consultationroom.ConsultationRoom;

public class Appointment {
    private Integer id;
    private Doctor doctor;
    private Patient patient;
    private Prescription prescription;
    private ConsultationRoom consultationRoom;
    private Float price;
    public Appointment() {}
    public Appointment(Integer id, Doctor doctor, Patient patient, Prescription prescription,
                       ConsultationRoom consultationRoom, Float price)
    {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.prescription = prescription;
        this.consultationRoom = consultationRoom;
        this.price = price;
    }
    public Appointment(Doctor doctor, Patient patient, Prescription prescription,
                       ConsultationRoom consultationRoom, Float price)
    {
        this.doctor = doctor;
        this.patient = patient;
        this.prescription = prescription;
        this.consultationRoom = consultationRoom;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public ConsultationRoom getConsultationRoom() {
        return consultationRoom;
    }

    public void setConsultationRoom(ConsultationRoom consultationRoom) {
        this.consultationRoom = consultationRoom;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
