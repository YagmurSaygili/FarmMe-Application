import java.time.LocalDate;

/**
 * Treatment class where all the treatments for farm animals is kept
 * @author Yağmur Saygılı
 * @version 1.0
 */
public class Treatment {
    private LocalDate dateOfTreatment;

    /**
     * Constructor wth no paramater, default
     */
    public Treatment() {
    }

    /**
     * Constructor with the given dateofTreatment info
     * @param dateOfTreatment date of the treatment
     */
    public Treatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    public void printTreatment() {
        System.out.print("\nDate of treatment is: " + this.dateOfTreatment);
    }

    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }
}