package Concepts.Encapsulation;

public class Student {
    // Private fields: Can only be accessed within the class
    private String name;
    private int age;
    private double gpa;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.gpa = 0.0;
    }

    // Getter methods: These allow reading of private fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    // Setter methods: Allow controlled modification of private fields
    public void setName(String name) {
        // Basic validation to ensure name is not empty. 
        // If name == null, new value will not be stored
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age > 0 && age <=120) {
            this.age = age;
        }
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }
}
