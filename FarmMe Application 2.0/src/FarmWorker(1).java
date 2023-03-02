import java.time.LocalDate;

/**
 * Child of Employee abstract class FarmWorker. Instantiates the workers in the farm
 * Keeps the relevant info about the farm-workers
 * @author Yağmur Saygılı
 * @version 1.0
 */
public class FarmWorker extends Employee{
    private String previousFarmName;
    private int workexperience;

    private CleaningTreatment cleaningTreatment;
    /**
     * Constructor with only specific farmworker info is given
     * @param previousFarmName name of the farm that farmworker used to work (String)
     * @param workexperience  number of years of experience that farmworker has (int)
     */
    public FarmWorker(String previousFarmName, int workexperience) {
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
        this.cleaningTreatment = null;
    }

    /**
     * Constructor with all employee and specific farmworker info is given
     * @param empID unique employee ID (int)
     * @param gender gender of the farmworker (String)
     * @param dateOfBirth date of birth of the farmworker (Local Date)
     * @param previousFarmName name of the farm that farmworker used to work (String)
     * @param workexperience number of years of experience that farmworker has (int)
     */
    public FarmWorker(int empID, String gender, LocalDate dateOfBirth, String previousFarmName, int workexperience) {
        super(empID, gender, dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
    }

    public String getPreviousFarmName() {
        return previousFarmName;
    }

    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    public int getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }



    public void setCleaningTreatment(CleaningTreatment cleaningTreatment) {
        this.cleaningTreatment = cleaningTreatment;
    }

    /**
     * Calculates and return the salary of the selected employee based on algorithm
     * @return salary of the selected Farmworker based on algorithm
     */
    @Override
    public double getSalary() {
        double salary;

        salary = grossSalary + grossSalary*0.02*this.getWorkexperience();
        return salary;
    }


    /**
     * Print the details of the specified farmworker's information in order
     * Polymorphism used here
     */
    @Override
    public void printDetails() {
        System.out.println("The farmworker's" +
                "\nEmp ID: " + this.getEmpID() +
                "\nGender : " + this.getGender() +
                "\nDate Of Birth: " + this.getDateOfBirth() +
                "\nPrevious Farm Name: " + this.getPreviousFarmName() +
                "\nThe years of work experience: " + this.getWorkexperience() +
                "\nSalary: "+ this.getSalary() + "\n"
        );

    }





}
