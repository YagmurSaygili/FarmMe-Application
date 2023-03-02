/**
 * Payment interface for employee's salary payment calculation
 * getSalary method is implemented in two different ways inside Veterinary and FarmWorker classes
 */
public interface Payment {
    public double grossSalary = 10000;
    public double getSalary();
}
