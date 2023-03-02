import java.time.LocalDate;

/**
 * This class represents the methods and required information for veterinary object
 * In getsalary and printdetails methods polymorphism is used
 * @author Yağmur Saygılı
 * @version 1.0
 */
public class Veterinary extends Employee{
    private boolean BScDegree;
    private LocalDate dateOfGraduation;
    private int expertiseLevel;

    private HealthTreatment healthTreatment;

    /**
     * Constructor with employee information and specific veterinary info is given
     * @param empID unique id of the veterinary (int)
     * @param gender gender of the veterinary (String)
     * @param dateOfBirth date of birth of the veterinary (Local Date)
     * @param BScDegree specifies if veterinary has degree or not (boolean)
     * @param dateOfGraduation date of graduation of the veterinary (Local date)
     * @param expertiseLevel expertise level of the veterinary (int)
     */
    public Veterinary(int empID, String gender, LocalDate dateOfBirth, boolean BScDegree, LocalDate dateOfGraduation, int expertiseLevel) {
        super(empID, gender, dateOfBirth);
        this.BScDegree = BScDegree;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
        this.healthTreatment = null;
    }

    /**
     * Constructor with only specific veterinary information is given
     * @param BScDegree specifies if veterinary has degree or not (boolean)
     * @param dateOfGraduation date of graduation of the veterinary (Local date)
     * @param expertiseLevel expertise level of the veterinary (int)
     */
    public Veterinary(boolean BScDegree, LocalDate dateOfGraduation, int expertiseLevel) {
        this.BScDegree = BScDegree;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }



    public boolean isBScDegree() {
        return BScDegree;
    }

    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }

    public void setDateOfGraduation(LocalDate dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }

    public HealthTreatment getHealthTreatment() {
        return healthTreatment;
    }

    public void setHealthTreatment(HealthTreatment healthTreatment) {
        this.healthTreatment = healthTreatment;
    }

    /**
     * Calculates and return the salary of the selected employee based on algorithm
     * @return salary of the selected Veterinary based on algorithm (double)
     */
    @Override
    public double getSalary() {
        double salary;
        double yearsOfGraduation = LocalDate.now().getYear() - this.getDateOfGraduation().getYear();
        salary = grossSalary + grossSalary*0.1*yearsOfGraduation;
        return salary;
    }


    /**
     * Print the details of the selected veterianry in order
     * Polymorphism used here
     */
    @Override
    public void printDetails() {
        System.out.println("The vet's" +
                "\nVet ID: " + this.getEmpID() +
                "\nGender : " + this.getGender() +
                "\nDate Of Birth: " + this.getDateOfBirth() +
                "\nDoes s/he have a degree: " + this.isBScDegree() +
                "\nDate of Graduation: " + this.getDateOfGraduation() +
                "\nExpertise Level: " + this.expertiseLevel +
                "\nSalary: "+ this.getSalary() + "\n"
        );


    }




}