package ICE3;

// Student calss for storing student 

public class Student {
    private String name;
    private int grade;
    private boolean isPassed;

    // Constructor 
    // Created new student with given name and grade
    // throws GradeOutOfRangeException

    public Student(String name, int grade) throws GradeOutOfRangeException {
        this.name = name;
        
        // validate grade range
        if (grade < 0 || grade > 100) {
            throw new GradeOutOfRangeException("Grade must be between 0 and 100");
        }

        this.grade = grade;

        // Check if student passed
        if (grade >= 50) {
            isPassed = true;
        } else {
            isPassed = false;
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isPassed() {
        return isPassed;
    }
}
