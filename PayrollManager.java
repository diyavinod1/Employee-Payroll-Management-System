//PayrollManager.java

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PayrollManager {
    private Map<Integer, Employee> employees;
    private static final String DATA_FILE = "employees.ser";

    public PayrollManager() {
        employees = new HashMap<>();
    }

    public boolean addEmployee(Employee employee) {
        if (employees.containsKey(employee.getId())) {
            System.out.println("Employee with ID " + employee.getId() + " already exists.");
            return false;
        }
        employees.put(employee.getId(), employee);
        return true;
    }

    public boolean removeEmployee(int id) {
        return employees.remove(id) != null;
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public double calculateSalary(int id) {
        Employee e = employees.get(id);
        return (e != null) ? e.calculateSalary() : 0;
    }

    // ✅ Updated payslip saving logic
    public boolean generatePayslip(int id) {
        Employee e = employees.get(id);
        if (e == null) {
            System.out.println("Employee not found!");
            return false;
        }

        double salary = e.calculateSalary();
        String fileName = "payslip_" + e.getId() + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("=================================");
            writer.println("           PAYSLIP");
            writer.println("=================================");
            writer.println("Employee ID: " + e.getId());
            writer.println("Name: " + e.getName());
            writer.println("Email: " + e.getEmail());
            writer.println("Type: " + e.getType());
            writer.println("Basic Pay: $" + e.getBasicPay());

            if (e instanceof FullTimeEmployee) {
                FullTimeEmployee fte = (FullTimeEmployee) e;
                writer.println("Bonus: $" + fte.getBonus());
            } else if (e instanceof PartTimeEmployee) {
                PartTimeEmployee pte = (PartTimeEmployee) e;
                writer.println("Hours Worked: " + pte.toString());
            }

            writer.println("Total Salary: $" + String.format("%.2f", salary));
            writer.println("Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            writer.println("=================================");
        } catch (IOException ex) {
            System.out.println("Error writing payslip: " + ex.getMessage());
            return false;
        }

        File file = new File(fileName);
        System.out.println("✅ Payslip generated successfully at: " + file.getAbsolutePath());
        return true;
    }

    // Serialization methods
    public void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            employees = (Map<Integer, Employee>) ois.readObject();
            System.out.println("Employees loaded successfully!");
        } catch (Exception e) {
            System.out.println("No saved employees found.");
        }
    }
}
