import java.util.ArrayList;
import java.util.Date;
/**
 * Treatment class to where all details about treatment is kept and have basic operations
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.9
 */
public class Treatment {

    private Date dateOfTreatment;
    private String details;

    private ArrayList<Medication> medications;
    /**
     * Creating treatment object with no information given
     */
    public  Treatment(){
        this.dateOfTreatment = new Date();
        this.details = "No details were given";
        medications = new ArrayList<Medication>();

    }
    /**
     * @param details details of the treatment for further explanation
     * @param dateOfTreatment the date treatment happened
     * @param medications the medications of the treatment
     * Creating treatment object with given information
     */
    public Treatment(Date dateOfTreatment, String details, ArrayList<Medication> medications) {
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        this.medications = medications;
    }
    /**
     * @param details details of the treatment for further explanation
     * @param dateOfTreatment the date treatment happened
     * Creating veterinary object with no information given
     */
    public  Treatment(Date dateOfTreatment, String details){
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        medications = new ArrayList<Medication>();

    }

    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }


    public void setDetails(String details)
    {
        this.details = details;
    }
    public  void setDateOfTreatment(Date dateOfTreatment) { this.dateOfTreatment = dateOfTreatment; }
    public String getDetails () {return this.details; }
    public Date getDateOfTreatment() {return  this.dateOfTreatment; }

    /**
     * Print method where all the details of the veterinary is displayed
     * This will be used in FarmMe class as main method
     */
    public void printTreatment(){
        System.out.println("\nThis treatment's:" +
                "\nDetails: " + details +
                "\nDate of treatment: "+ dateOfTreatment);
    }
}
