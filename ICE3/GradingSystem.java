package ICE3;

import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        // declaring constants
        final int MAX_STUDENTS = 5;
        final int PASSING_GRADE = 50;

        // counters
        int passCount = 0;
        int failCount = 0;

        // display weclome message
        System.out.println("---Durham College Grading System---");
        System.out.println("Enter information for " + MAX_STUDENTS + " students");

        // using try with resources for auto closing scanner
        try (Scanner scanner = new Scanner(System.in)) {

            // loop through each student
            for (int i = 0; i < MAX_STUDENTS; i++) {
                // print student number
                // add 1 to i because of 0 based index
                System.out.println("\nStudent # " + (i + 1));

                // get student name
                System.out.print("Enter Student name; ");
                String name = scanner.nextLine();

                // get student grade
                System.out.print("Enter grade for " + name + ": ");
                String gradeInput = scanner.nextLine();

                // process input with exception handling
                try {
                    // Try to convert string to integer using parseInt
                    // https://www.tutorialspoint.com/java/number_parseint.htm
                    int grade = Integer.parseInt(gradeInput);

                    // create new student object
                    // may throw GradeOutofRangeException
                    Student student = new Student(name, grade);

                    // print info for student
                    System.out.println("Student: " + student.getName() + " received grade: " + student.getGrade());

                    // Update counters
                    if (student.isPassed()) {
                        System.out.println("STUDENT PASSED");
                        passCount = passCount + 1;
                    } else {
                        System.out.println("STUDENT FAILED");
                        failCount = failCount + 1;
                    }
                } catch (NumberFormatException exception) {
                    // Catch exception if parseInt fails
                    System.out.println("Grade must be a number. Try again.");
                    // decrement i in loop to retry same student
                    i = i - 1;
                } catch (GradeOutOfRangeException exception) {
                    // Catch exception if grade is out of range
                    System.out.println("Error: " + exception.getMessage() + ". Please try again.");
                    // decrement i in loop to retry same student
                    i = i - 1;
                } catch (Exception exception) {
                    // catch any other exceptions if they occur
                    System.out.println("Error: " + exception.getMessage() + ". Please try again.");
                    // decrement i in loop to retry same student
                    i = i - 1;
                }
            }
        } // scanner is auto closed here
          // If not using try with resources, close scanner here using a finally block

        // Display Final stats
        System.out.println("\n---Grade Summary---");
        System.out.println("Total Students: " + MAX_STUDENTS);
        System.out.println("Passing Grade: " + PASSING_GRADE);
        System.out.println("Number of students passed: " + passCount);
        System.out.println("Number of students failed: " + failCount);
        }
    }
