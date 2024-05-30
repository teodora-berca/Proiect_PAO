package models.department;
import models.hospital.Hospital;
import models.person.Nurse;
import models.person.Doctor;
import models.consultationroom.ConsultationRoom;
import java.util.List;

public class Department {
    private Integer id;
    private Hospital hospital;
    private List<Nurse> nurses;
    private List<Doctor> doctors;
    private List<ConsultationRoom> consultationRooms;
    private String name;
    public Department() {}
    public Department(Integer id, Hospital hospital, List<Nurse> nurses, List<Doctor> doctors,
                      List<ConsultationRoom> consultationRooms, String name)
    {
        this.id = id;
        this.hospital = hospital;
        this.nurses = nurses;
        this.doctors = doctors;
        this.consultationRooms = consultationRooms;
        this.name = name;
    }
    public Department(Hospital hospital, List<Nurse> nurses, List<Doctor> doctors,
                      List<ConsultationRoom> consultationRooms, String name)
    {
        this.hospital = hospital;
        this.nurses = nurses;
        this.doctors = doctors;
        this.consultationRooms = consultationRooms;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<ConsultationRoom> getConsultationRooms() {
        return consultationRooms;
    }

    public void setConsultationRooms(List<ConsultationRoom> consultationRooms) {
        this.consultationRooms = consultationRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
