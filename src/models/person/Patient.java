package models.person;
import models.appointment.Appointment;
import models.subscription.Subscription;
import java.util.List;

public class Patient extends Person {
    private Subscription subscription;
    private List<Appointment> appointments;
    public Patient()
    {
        super();
    }
    public Patient(Subscription subscription, List<Appointment> appointments, String firstName,
                   String lastName, String phoneNumber, String emailAddress,
                   Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(firstName, lastName, phoneNumber, emailAddress,
                yearOfBirth, monthOfBirth, dayOfBirth);
        this.subscription = subscription;
        this.appointments = appointments;
    }
    public Patient(Integer id, Subscription subscription, List<Appointment> appointments, String firstName,
                   String lastName, String phoneNumber, String emailAddress,
                   Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(id, firstName, lastName, phoneNumber, emailAddress,
                yearOfBirth, monthOfBirth, dayOfBirth);
        this.subscription = subscription;
        this.appointments = appointments;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
