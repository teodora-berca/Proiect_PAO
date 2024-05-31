package models.administration;
import models.prescription.Prescription;
import models.medication.Medication;

public class Administration {
    private Integer id;
    private Prescription prescription;
    private Medication medication;
    private Integer quantity;
    private Integer frequency;
    public Administration() {}
    public Administration(Integer id, Prescription prescription, Medication medication,
                          Integer quantity, Integer frequency)
    {
        this.id = id;
        this.prescription = prescription;
        this.medication = medication;
        this.quantity = quantity;
        this.frequency = frequency;
    }
    public Administration(Prescription prescription, Medication medication,
                          Integer quantity, Integer frequency)
    {
        this.prescription = prescription;
        this.medication = medication;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
