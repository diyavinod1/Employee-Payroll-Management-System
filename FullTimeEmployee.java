//FullTimeEmployee.java
public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int id, String name, String email, double basicPay, double bonus)
            throws InvalidSalaryException {
        super(id, name, email, basicPay);
        if (bonus < 0) {
            throw new InvalidSalaryException("Bonus cannot be negative: " + bonus);
        }
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }

    @Override
    public double calculateSalary() {
        return getBasicPay() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Bonus: $%.2f, Type: Full-Time", bonus);
    }
}
