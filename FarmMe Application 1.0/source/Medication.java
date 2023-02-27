import java.util.Date;

/**
 * Medication class to where all details about medication is kept and have basic operations
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.9
 */
public class Medication  {// Is it true inheritance ??? extends Treatments ?
    private String details;
    private int duration;//Reference or variable ?
    private Date startDate;
    private double Dosage;
    private String notes;
    /**
     * Creating veterinary object with no information given
     */
    public  Medication()
    {
        this.details = "No details provided.";
        duration = 0;
        startDate = new Date();
        Dosage = 0;
        notes = "No notes are provided.";
    }
    /*Basically initializing all the parameters of the class to the given values*/

    /**
     * @param details prescription of the medication
     * @param Dosage how many times should it be taken
     * @param duration for how long the medication will be used
     * @param notes necessary notes about the medication
     * @param startDate when it will be started to use
     * Creating medication object with provided information
     */
    public  Medication(String details ,
                       int duration,Date startDate,
                       double Dosage,String notes)
    {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        this.Dosage = Dosage;
        this.notes = notes;
    }
    /**
     * @param duration for how long the medication will be used
     * @param startDate when it will be started to use
     * @param details prescription of the medication
     * @param dosage how many times should it be taken
     * Creating medication object with provided information
     */
    public Medication(String details, int duration, Date startDate, double dosage) {
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        Dosage = dosage;
    }
    /**
     * Print method where all the details of the medication is displayed
     * This will be used in FarmMe class as main method
     */
    public void printMedication()
    {
        System.out.println("Details: " + details  +
                "\nDuration: " + duration +
                "\nStart Date: " + startDate +
                "\nDosage: " + Dosage +
                "\nNotes: " + notes);
    }
    public void setDetails(String details)
    {
        this.details = details;
    }
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public void setDosage(double dosage)
    {
        this.Dosage = dosage;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
    public String getDetails () {return this.details; }
    public int getDuration () {return this.duration; }
    public Date getStartDate () {return this.startDate; }
    public double setDosage () {return  this.Dosage; }
    public  String setNotes () {return this.notes; }

}
