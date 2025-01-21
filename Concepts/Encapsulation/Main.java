package Concepts.Encapsulation;

public class Main {
    public static void main(String[] args) {
        // Create a new student
        Student student = new Student("Reggie Brown", 20);

        // Try to access student's data using the getter methods
        System.out.println("Student name: " + student.getName());
        System.out.println("Student age: " + student.getAge());
        System.out.println("Student GPA: " + student.getGpa());

        // Update student's GPA using the setter method
        student.setGpa(4.0);
        System.out.println("Student GPA: " + student.getGpa());
        
        // Create a new course
        Course oopClass = new Course("Intro to OOP", 30);
        
        // Add some students to the course
        oopClass.addStudent(); // First Student
        oopClass.addStudent(); // Second Student

        System.out.println("\nCourse Information:");
        System.out.println("Course Name: " + oopClass.getCourseName());
        System.out.println("Current Students: " + oopClass.getCurrentStudents());
        System.out.println("Maximum Students: " + oopClass.getMaxStudents());
    }
}
