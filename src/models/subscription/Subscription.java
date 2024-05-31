package models.subscription;
import models.hospital.Hospital;
import models.person.Patient;
import java.util.List;

public class Subscription {
    private Integer id;
    private String type;
    private Float discount;
    private Hospital hospital;
    public Subscription() {}
    public Subscription(Integer id, String type,
                        Float discount, Hospital hospital)
    {
        this.id = id;
        this.type = type;
        this.discount = discount;
        this.hospital = hospital;
    }
    public Subscription(String type, Float discount, Hospital hospital)
    {
        this.type = type;
        this.discount = discount;
        this.hospital = hospital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
