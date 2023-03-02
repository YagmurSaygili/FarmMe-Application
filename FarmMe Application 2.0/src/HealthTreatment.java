import java.time.LocalDate;
import java.util.ArrayList;

public class HealthTreatment extends Treatment{
    private boolean emergency;

    private ArrayList<Medication> medications;

    /**
     * Constructor with only emergency field is given
     * @param emergency emergency or not
     */
    public HealthTreatment(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     * Constructor with all necessary information given to complete HealthTreatment/Treatment object
     * @param dateOfTreatment date of the treatment
     * @param emergency emergency or not ? (Boolean)
     */
    public HealthTreatment(LocalDate dateOfTreatment, boolean emergency) {
        super(dateOfTreatment);
        this.emergency = emergency;
        this.medications = new ArrayList<Medication>();
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    /**
     * Prints every treatment information with their medication information too if any
     */
    @Override
    public void printTreatment(){
        super.printTreatment();
        System.out.print("\nType of treatment: Health Treatment");
        System.out.print("\nEmergency: " + emergency);

        if (this.medications.size() > 0){
            for (int i = 0; i < this.medications.size(); i++){
                System.out.println("For number " + i + "medication: ");
                medications.get(i).printMedication();
                System.out.print("\n\n");
            }
        }
        else {
            System.out.print("\nNo medication assigned\n\n");
        }
    }
}
