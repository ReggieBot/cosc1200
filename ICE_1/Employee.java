package ICE_1;

public class Employee {
        // Initializing variablees
        private int id;
        private String name;
        private String department;
        private double salary;
        private final double TAX_RATE = 0.10;
    

    // Constructor
    public Employee(int id, String name, String department, double salary, double taxRate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Calculates net salary of employee
    public double calculateNetSalary() {
        return salary - (salary * TAX_RATE);
    }

    // method to print employee details
    public void employeeDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Department: " + department);
        System.out.println("Employee Salary: " + salary);
        System.out.println("Employee Tax Rate: " + TAX_RATE);
        System.out.println("Employee Net Salary: " + calculateNetSalary());
        System.out.println("\n");
    }
}

