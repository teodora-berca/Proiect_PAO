package models.person;

public class Employee extends Person{
    private Float salary;
    private Integer yearOfEmployment;
    private Integer monthOfEmployment;
    private Integer dayOfEmployment;
    private String employmentStatus;
    public Employee()
    {
        super();
    }
    public Employee(Integer id, Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                    Integer dayOfEmployment, String employmentStatus, String firstName,
                    String lastName, String phoneNumber, String emailAddress,
                    Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(id, firstName, lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.salary = salary;
        this.yearOfEmployment = yearOfEmployment;
        this.monthOfEmployment = monthOfEmployment;
        this.dayOfEmployment = dayOfEmployment;
        this.employmentStatus = employmentStatus;
    }
    public Employee(Float salary, Integer yearOfEmployment, Integer monthOfEmployment,
                    Integer dayOfEmployment, String employmentStatus, String firstName,
                    String lastName, String phoneNumber, String emailAddress,
                    Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(firstName, lastName, phoneNumber, emailAddress, yearOfBirth, monthOfBirth, dayOfBirth);
        this.salary = salary;
        this.yearOfEmployment = yearOfEmployment;
        this.monthOfEmployment = monthOfEmployment;
        this.dayOfEmployment = dayOfEmployment;
        this.employmentStatus = employmentStatus;
    }
    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getYearOfEmployment() {
        return yearOfEmployment;
    }

    public void setYearOfEmployment(Integer yearOfEmployment) {
        this.yearOfEmployment = yearOfEmployment;
    }

    public Integer getMonthOfEmployment() {
        return monthOfEmployment;
    }

    public void setMonthOfEmployment(Integer monthOfEmployment) {
        this.monthOfEmployment = monthOfEmployment;
    }

    public Integer getDayOfEmployment() {
        return dayOfEmployment;
    }

    public void setDayOfEmployment(Integer dayOfEmployment) {
        this.dayOfEmployment = dayOfEmployment;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
