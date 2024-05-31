package models.department;
import models.hospital.Hospital;

public class Department {
    private Integer id;
    private Hospital hospital;
    private String name;
    public Department() {}
    public Department(Integer id, Hospital hospital, String name)
    {
        this.id = id;
        this.hospital = hospital;
        this.name = name;
    }
    public Department(Hospital hospital, String name)
    {
        this.hospital = hospital;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
