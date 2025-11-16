import java.io.Serializable;

public abstract class Employee implements Serializable {
    private int id;
    private String name;
    private String email;
    private double basicPay;

    public Employee(int id, String name, String email, double basicPay) throws InvalidSalaryException {
        if (basicPay < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + basicPay);
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.basicPay = basicPay;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getBasicPay() { return basicPay; }

    public void setBasicPay(double basicPay) throws InvalidSalaryException {
        if (basicPay < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + basicPay);
        }
        this.basicPay = basicPay;
    }

    public abstract double calculateSalary();

    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Email: %s, Basic Pay: $%.2f",
                id, name, email, basicPay);
    }
}
