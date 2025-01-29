package ICE_1;

public class Employee {
        // Initializing variablees
        private int id;
        private String name;
        private String department;
        private double salary;
        private double taxRate;
    

    // Constructor
    public Employee(int id, String name, String department, double salary, double taxRate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.taxRate = taxRate;
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

    public double getTaxRate() {
        return taxRate;
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
    
}
