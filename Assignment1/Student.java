package Assignment1;

public class Student {
    // Initializing private variables
    private String name;
    private int age;
    private String studentID;

    // Static variable (task 3)
    /* 
     * I wasn't sure if you wanted the static field to be private or public, so I made it private.
     * If I was to make it public I wouldn't have to use a getter method to access it.
     */
    private static String collegeName = "Durham College";
    

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

    // Static getter method
    public static String getCollegeName() {
        return collegeName;
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

    // Static setter method
    public static void setCollegeName(String newName) {
        collegeName = newName;
    }

    // Displays student details
    public void displayDetails() {
        System.out.println("---Student Details---");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Student ID: " + getStudentID());
        System.out.println("College Name: " + getCollegeName());
    }
}
