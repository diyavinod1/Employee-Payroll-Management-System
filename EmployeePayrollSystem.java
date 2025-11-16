import java.util.*;

public class EmployeePayrollSystem {
    private final PayrollManager payrollManager;
    private final Scanner scanner;

    public EmployeePayrollSystem() {
        payrollManager = new PayrollManager();
        scanner = new Scanner(System.in);
    }

    public void run() {
        payrollManager.loadEmployees();
        boolean running = true;

        while (running) {
            showMenu();
            int choice = getInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> viewAll();
                    case 3 -> calculateSalary();
                    case 4 -> generatePayslip();
                    case 5 -> removeEmployee();
                    case 6 -> payrollManager.saveEmployees();
                    case 7 -> running = false;
                    default -> System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n=== Employee Payroll System ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Calculate Salary");
        System.out.println("4. Generate Payslip");
        System.out.println("5. Remove Employee");
        System.out.println("6. Save Employees");
        System.out.println("7. Exit");
    }

    private void addEmployee() throws InvalidSalaryException {
        int id = getInt("Enter ID: ");
        String name = getString("Enter name: ");
        String email = getString("Enter email: ");
        double basic = getDouble("Enter basic pay: ");

        System.out.println("1. Full-Time  2. Part-Time");
        int type = getInt("Select type: ");
        Employee e;

        if (type == 1) {
            double bonus = getDouble("Enter bonus: ");
            e = new FullTimeEmployee(id, name, email, basic, bonus);
        } else {
            int hours = getInt("Enter hours worked: ");
            e = new PartTimeEmployee(id, name, email, basic, hours);
        }

        if (payrollManager.addEmployee(e))
            System.out.println("Employee added successfully!");
    }

    private void viewAll() {
        List<Employee> list = payrollManager.getAllEmployees();
        if (list.isEmpty()) System.out.println("No employees found.");
        else list.forEach(System.out::println);
    }

    private void calculateSalary() {
        int id = getInt("Enter employee ID: ");
        double salary = payrollManager.calculateSalary(id);
        if (salary > 0)
            System.out.println("Total Salary: $" + salary);
        else
            System.out.println("Employee not found!");
    }

    private void generatePayslip() {
        int id = getInt("Enter employee ID: ");
        payrollManager.generatePayslip(id);
    }

    private void removeEmployee() {
        int id = getInt("Enter employee ID to remove: ");
        if (payrollManager.removeEmployee(id))
            System.out.println("Removed successfully!");
        else
            System.out.println("Employee not found!");
    }

    // Utility methods
    private int getInt(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Enter valid number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private double getDouble(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter valid number: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    private String getString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        new EmployeePayrollSystem().run();
    }
}
