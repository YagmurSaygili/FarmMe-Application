import java.time.LocalDate;

/**
 * Medication class where all the relevant information about medication is kept
 * This class has no parents/childs or interfaces
 * @author Yağmur Saygılı
 * @version 1.0
 */
public class Medication {
    private String details;
    private int duration;//Reference or variable ?
    private LocalDate startDate;
    private double Dosage;
    private String notes;

    /**
     * Constructor with no parameters, default
     */
    public Medication() {
    }

    /**
     * Constructor with only notes information missing
     * @param details details of the medication
     * @param duration duration that must be taken
     * @param startDate start Date of the medication
     * @param dosage dosage of the medication
     */
    public Medication(String details, int duration, LocalDate startDate, double dosage) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        Dosage = dosage;
    }

    /**
     * Constructor with all the necessary information provided
     * @param details details of the medication
     * @param duration duration that must be taken
     * @param startDate start Date of the medication
     * @param dosage dosage of the medication
     * @param notes notes for medication if any
     */
    public Medication(String details, int duration, LocalDate startDate, double dosage, String notes) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        Dosage = dosage;
        this.notes = notes;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getDosage() {
        return Dosage;
    }

    public void setDosage(double dosage) {
        Dosage = dosage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Display method for medication
     * Displays all the information about medication to the user
     */
    public void printMedication(){
        System.out.println("Details: " + details  +
                "\nDuration: " + duration +
                "\nStart Date: " + startDate +
                "\nDosage: " + Dosage +
                "\nNotes: " + notes);
    }
}