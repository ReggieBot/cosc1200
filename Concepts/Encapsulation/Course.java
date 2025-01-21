package Concepts.Encapsulation;

public class Course {
    // Private fields
    private String courseName;
    private int maxStudents;
    private int currentStudents;

    // Constructor
    public Course(String courseName, int maxStudents) {
        this.courseName = courseName;
        this.maxStudents = maxStudents;
        this.currentStudents = 0;
    }

    // Getter methods
    public String getCourseName() {
        return courseName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }
}
