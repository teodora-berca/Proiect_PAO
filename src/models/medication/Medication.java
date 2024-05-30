package models.medication;
import models.administration.Administration;
import java.util.List;
public class Medication {
    private Integer id;
    private List<Administration> administrations;
    private Float price;
    private String name;
    public Medication() {}
    public Medication(Integer id, List<Administration> administrations, Float price, String name)
    {
        this.id = id;
        this.administrations = administrations;
        this.price = price;
        this.name = name;
    }
    public Medication(List<Administration> administrations, Float price, String name)
    {
        this.administrations = administrations;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Administration> getAdministrations() {
        return administrations;
    }

    public void setAdministrations(List<Administration> administrations) {
        this.administrations = administrations;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
