package ICE_1;
import java.util.Scanner;

public class PayrollSystem {
    // Initializing employee variables 
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private int employeeCount;

    public PayrollSystem() {
        employeeCount = 0;
    }

    // Adds employee to the payroll system
    public void addEmployee() {
        // Checks if max employes have been reached
        if (employeeCount >= 5) {
            System.out.println("Max Employees reached");
            return;
        }
        // gets employee details
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter employee details: ");

        System.out.println("Employee ID: ");
        int id = scanner.nextInt();

        System.out.println("Employee Name: ");
        String name = scanner.nextLine();

        System.out.println("Employee Department: ");
        String department = scanner.nextLine();

        System.out.println("Employee Salary: ");
        double salary = scanner.nextDouble();

        // Creates new employee object
        Employee newEmployee = new Employee(id, name, department, salary);

        // Adds employee to the payroll system and increments employee count
        if (employee1 == null) {
            employee1 = newEmployee;
        } else if (employee2 == null) {
            employee2 = newEmployee;
        } else if (employee3 == null) {
            employee3 = newEmployee;
        } else if (employee4 == null) {
            employee4 = newEmployee;
        } else if (employee5 == null) {
            employee5 = newEmployee;
        }

        employeeCount++;
        System.out.println("Employee added");
    }

    // Displays employee details
    public void displayEmployeeDetails() {
        // Error check if no employees have been added
        if (employeeCount == 0) {
            System.out.println("No employees added");
            return;
        }
        
        System.out.println("\nEmployee Details: ");
        if (employee1 != null) {
            employee1.employeeDetails();
        }
        if (employee2 != null) {
            employee2.employeeDetails();
        }
        if (employee3 != null) {
            employee3.employeeDetails();
        }
        if (employee4 != null) {
            employee4.employeeDetails();
        }
        if (employee5 != null) {
            employee5.employeeDetails();
        }
    }

    // Searches for employee
    public void searchEmployee() {
        // Error check if no employees have been added
        if (employeeCount == 0) {
            System.out.println("No employees added");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID to search: ");
        int id = scanner.nextInt();

        // Checks if employee exists and if id matches
        if (employee1 != null && employee1.getID() == id) {
            employee1.employeeDetails();
        } else if (employee2 != null && employee2.getID() == id) {
            employee2.employeeDetails();
        } else if (employee3 != null && employee3.getID() == id) {
            employee3.employeeDetails();
        } else if (employee4 != null && employee4.getID() == id) {
            employee4.employeeDetails();
        } else if (employee5 != null && employee5.getID() == id) {
            employee5.employeeDetails();
        } else {
            System.out.println("Employee not found");
        }
    }

    
}
