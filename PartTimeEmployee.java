// PartTimeEmployee.java
public class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, String email, double basicPay, int hoursWorked)
            throws InvalidSalaryException {
        super(id, name, email, basicPay);
        if (hoursWorked < 0) {
            throw new InvalidSalaryException("Hours cannot be negative: " + hoursWorked);
        }
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() { return hoursWorked; }

    @Override
    public double calculateSalary() {
        return getBasicPay() * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Hours Worked: %d, Type: Part-Time", hoursWorked);
    }
}
