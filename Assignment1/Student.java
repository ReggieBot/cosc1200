package Assignment1;

public class Student {
    // Initializing private variables
    private String name;
    private int age;
    private String studentID;

    // Constructor
    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentID() {
        return studentID;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentID(String studentID) {
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
