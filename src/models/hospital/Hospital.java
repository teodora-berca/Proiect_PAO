package models.hospital;
import models.subscription.Subscription;
import models.department.Department;
import java.util.List;

public class Hospital {
    private Integer id;
    private List<Department> departments;
    private List<Subscription> subscriptions;
    private String name;
    private String address;
    private String phoneNumber;
    public Hospital() {}
    public Hospital(Integer id, List<Department> departments, List<Subscription> subscriptions,
                    String name, String address, String phoneNumber)
    {
        this.id = id;
        this.departments = departments;
        this.subscriptions = subscriptions;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Hospital(List<Department> departments, List<Subscription> subscriptions,
                    String name, String address, String phoneNumber)
    {
        this.departments = departments;
        this.subscriptions = subscriptions;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
