# 🌟 Employee Payroll Management System

 Welcome to the Employee Payroll System, a simple yet cleanly structured project that demonstrates how a Java backend can work together with a browser-based frontend to manage employees and generate payslips.

<br> This project handles only two types of employees:

🟦 Full-Time Employees

🟪 Part-Time Employees

and computes their salary using well-designed OOP classes in Java.

## 🎯 Project Overview

The system allows the user to:


✔ Add Employees

<i> You can register full-time or part-time employees with essential details like ID, name, email, basic pay, hours worked or bonus.</i>

✔ View All Employees

<i> Displays stored employees along with their type and pay structure.</i>

✔ Calculate Salary

<i> The backend computes salary based on employee type: </i>

- <i> Full-Time: basicPay + bonus </i>

- <i> Part-Time: basicPay * hoursWorked </i>

✔ Generate Payslip

<i> Creates a neat payslip text file with all employee details + calculated salary + date. </i>

✔ Save & Load Employees

<i> Employee data is serialized in Java and loaded automatically when the system starts. </i>

# 🏗 Technology Stack

This project blends frontend presentation with a robust backend:

🔹 Frontend

- <i> HTML </i>

- <i> CSS </i>

🔸 Backend

- <i> Core Java (OOP) </i>

- <i> Custom Exceptions </i>

- <i> Inheritance & Polymorphism </i>

- <i> Serialization (Saving data) </i>

- <i> File Handling (payslip generation) </i>

🔹 Execution

<i> The backend runs as a Java console program, while the HTML/CSS interface represents the visual prototype of the system. </i>

# 🧠 Object-Oriented Design Highlights

The system is structured using clean OOP principles:

🧩 Employee (Abstract Class)

<i> Base class with shared properties (ID, name, email, basic pay) and an abstract calculateSalary() method. </i>

🧩 FullTimeEmployee

<i> Adds a bonus and defines salary as basic + bonus. </i>

🧩 PartTimeEmployee

<i> Defines salary using basic pay × hours worked. </i>

🧩 InvalidSalaryException

<i> Custom exception for negative salary or invalid inputs. </i>

🧩 PayrollManager

<i> Handles: </i>

- <i> In-memory employee storage </i>

- <i> Salary calculation </i>

- <i> Payslip creation </i>

- <i> Serialization </i>

🧩 EmployeePayrollSystem

<i> Main controller — shows menu, takes input, and triggers backend functions. </i>

# 📁 Files Included

- Employee.java

- FullTimeEmployee.java

- PartTimeEmployee.java

- InvalidSalaryException.java

- PayrollManager.java

- EmployeePayrollSystem.java

- payslip_*.txt (generated)

- employees.ser (auto-created)

- Frontend mockup files (HTML, CSS)

# 📝 Features That Make This Project Stand Out

⭐ Uses abstraction, inheritance, polymorphism, and exception handling effectively

⭐ Generates real files (payslips)

⭐ Stores employee data even after program exit

⭐ Covers both full-time & part-time variations cleanly

⭐ Includes a frontend prototype for visual presentation

⭐ Perfect for academic submission (complete + well-structured)

# 📌 Future Enhancements (Optional for submission)

- Connect Java backend with HTML using Servlets or Spring Boot

- Convert payslip to PDF

- Add admin login system

- Add search, sorting, and filters

- Expand employee types

# 🎉 Final Note

This project is a great combination of Java OOP concepts and a simple web interface.<br>
Perfect for demonstrating backend logic, file handling, inheritance, and data storage — all in one compact system.

# 👥✨ Team Members

<i> “Great code is born when great minds collide… and debug together.” </i>

🚀 The Crew Behind the Payroll System

| Avatar | Name            | Superpower                                                    | Role in Project / Files Worked On |
|--------|-----------------|---------------------------------------------------------------|-----------------------------------|
| 🧠     | **Aishwarya S**   | Masters both UI and serialization — dual-wielding frontend & backend 😎        | `Employee.java`, `index.html`     |
| ⚙️     | **Aswanth R**     | Protects the project with custom exceptions like a guardian 🛡️     | `InvalidSalaryException.java`             |
| 🛡️     | **Diya Vinod**     | Turns logic into clean UI & integrates the whole system beautifully 🌟 | `EmployeePayrollSystem.java`, `index.html`     |
| 🧮     | **Maheswari M**   | Calculates part-time salaries with flawless precision 📊   | `PartTimeEmployee.java`           |
| 💼     | **Naren J**         | Manages full-time payroll like a professional HR wizard 💰                | `FullTimeEmployee.java`           |
| 🎨     | **Sarvesh S**    | Makes payroll logic run smoother than a well-oiled JVM ⚡ | `PayrollManager.java` |




