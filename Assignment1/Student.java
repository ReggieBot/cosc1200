package Assignment1;

public class Student {
    // Initializing variables
    String name;
    int age;
    String studentID;

    // Constructor
    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }
    
    // Displays student details
    public void displayDetails() {
        System.out.println("---Student Details---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentID);
    }
}
