package Assignment3;
import java.util.Scanner;

// This is the main class of the program
// All the other classes are called from here
// It uses a terminal based menu to display options to user (which method to call)
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Set menu = true, this keeps menu running until user exits
        boolean menu = true;

        while(menu = true) {
            
            // Display menu options
            System.out.println("--- Assignment 3 ---");
            System.out.println("1. Calculate Sum (Method definition)");
            System.out.println("2. Multiply Numbers (overloading)");
            System.out.println("3. Find Maximum (Array as param)");
            System.out.println("4. Reverse String (Recursion)");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            // Get user input for choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Newline character gets left behind, this removes it. Prevents skipping of next input
            // Spent hours trying to debug this in a side project I did
            // https://www.freecodecamp.org/news/java-scanner-nextline-call-gets-skipped-solved/

            // Switch case to call the user chosen method
            switch (choice) {
                case 1:
            }
        }
    }
}
