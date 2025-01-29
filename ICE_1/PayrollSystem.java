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
        if (employeeCount >= 5) {
            System.out.println("Max Employees reached");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter employee details: ");
        
    }
    
}
