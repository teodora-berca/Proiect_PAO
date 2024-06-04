package models.subscription;
import models.hospital.Hospital;
import models.person.Patient;
import java.util.List;

public class Subscription {
    private Integer id;
    private String type;
    private Double discount;
    private Hospital hospital;
    public Subscription() {}
    public Subscription(Integer id, String type,
                        Double discount, Hospital hospital)
    {
        this.id = id;
        this.type = type;
        this.discount = discount;
        this.hospital = hospital;
    }
    public Subscription(String type, Double discount, Hospital hospital)
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
