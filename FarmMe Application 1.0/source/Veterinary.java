import java.util.Date;
/**
 * Veterinary class where the necessary information of the veterinary kept and creation of the veterinary happens
 * @author Yağmur Saygılı 2385698 saygili.yagmur@metu.edu.tr
 * @version 1.5
 */
public class Veterinary  {//Extends Farm me ?

    private int vetID;
    private String gender;
    private Date dateOfBirth;
    private double salary;

    private Treatment treatment; // Every treatment is unique and belongs to only one veterinary

    /**
     * Creates veterinary with no parameters if any given
     */
    public Veterinary() {
        this.vetID = 0;
        this.gender = "null";
        this.dateOfBirth = new Date();
        this.salary = 0;
        this.treatment = null;
    }
    /**
    * Creating veterinary object with provided information
     * @param vetID unique veterinary identification number
     * @param gender gender of the veterinary / male or female
     * @param salary the salary s/he makes
     * @param dateOfBirth date of birth of the veterinary
     */
    public Veterinary(int vetID, String gender, Date dateOfBirth, double salary) {
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        treatment = null;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getVetID() {
        return vetID;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Print method where all the details of the veterinary is displayed
     * This will be used in FarmMe class as main method
     */
    public  void printDetails(){
        System.out.println("The vet's" +
                "\nVet ID: " + this.getVetID() +
                "\nGender : " + this.gender +
                "\nDate Of Birth: " + this.dateOfBirth +
                "\nSalary: "+ this.getSalary() );
        System.out.println("\nThe end of the list");
    }

}
