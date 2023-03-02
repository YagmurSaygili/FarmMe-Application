import java.time.LocalDate;

/**
 * Abstract class for all employee in the farm where similar attributes are saved.
 * @author Yağmur Saygılı
 * @version 1.0
 */

public abstract class Employee implements Payment, Comparable<Employee>  {
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    private Treatment assignedTreatment;

    /**
     * Basic default constructor for employee
     */
    public Employee() {
        empID = 0;
        gender = "Not provided";
        dateOfBirth = null;
    }

    /**
     * Main constructor for creating employee with all the necessary information taken from user
     * Treatment will be assigned later
     * @param empID employee ID (unique) of the worker
     * @param gender gender of the worker
     * @param dateOfBirth date of birth of the worker
     */
    public Employee(int empID, String gender, LocalDate dateOfBirth) {
        this.empID = empID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Abstract method to print details of employees
     * The body is implemented in farmworker and veterinary classes
     */
    public abstract void printDetails();



    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Treatment getAssignedTreatment() {
        return assignedTreatment;
    }

    public void setAssignedTreatment(Treatment assignedTreatment) {
        this.assignedTreatment = assignedTreatment;
    }

    /**
     * This method will compare two employee based on their salary
     * @param otherEmployee the object to be compared. İts salary is compared
     * @return If the compared one's salary is higher than the base one return -1,
     * If their salaries are equal return 0,
     * If the base one's salary is higher than compared one return 1
     */
    @Override
    public int compareTo(Employee otherEmployee) {
        int result = 0;

        if (this.getSalary() > otherEmployee.getSalary())
        {
            result = 1;
        }
        else if (otherEmployee.getSalary() > this.getSalary())
        {
            result = -1;
        }
        else {
            result = 0;
        }
        return  result;
    }

}
