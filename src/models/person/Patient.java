package models.person;
import models.subscription.Subscription;


public class Patient extends Person {
    private Subscription subscription;
    public Patient()
    {
        super();
    }
    public Patient(Subscription subscription,String firstName,
                   String lastName, String phoneNumber, String emailAddress,
                   Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(firstName, lastName, phoneNumber, emailAddress,
                yearOfBirth, monthOfBirth, dayOfBirth);
        this.subscription = subscription;
    }
    public Patient(Integer id, Subscription subscription,String firstName,
                   String lastName, String phoneNumber, String emailAddress,
                   Integer yearOfBirth, Integer monthOfBirth, Integer dayOfBirth)
    {
        super(id, firstName, lastName, phoneNumber, emailAddress,
                yearOfBirth, monthOfBirth, dayOfBirth);
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
