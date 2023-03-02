import java.time.LocalDate;

public class CleaningTreatment extends Treatment {
    private String materialused;

    /**
     * Additional constructor just if only material used given
     * @param materialused the material used in treatment
     */
    public CleaningTreatment(String materialused) {
        this.materialused = materialused;
    }

    /**
     * Additional constructor for the cleaning treatment
     * @param dateOfTreatment date of the treatment given
     * @param materialused material used
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialused) {
        super(dateOfTreatment);
        this.materialused = materialused;
    }

    /**
     * Overridden method of print treatment method
     * Displays all the details of Cleaning Treatment to the user
     */
    @Override
    public void printTreatment(){
        super.printTreatment();
        System.out.print("\nType of treatment: Cleaning Treatment");
        System.out.print("\nMaterial used: "+ this.materialused + "\n\n");

    }
}
