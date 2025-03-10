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
                    runSum();
                    break;
                case 2:
                    runMultiply();
                    break;
                case 3:
                    runMax();
                    break;
                case 4: 
                    runReverse();
                    break;
                case 5:
                    System.out.println("exiting...");
                    menu = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }

    // Method to run the sum method (q1)
    // These methods will be void because the methods they call will return the result
    private static void runSum() {
        // Display header
        System.out.println("--- Calculate Sum ---");

        // Get user input 
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        scanner.nextLine(); // removing newLine char, see above comment

        // Call the caclulateSum method from the CalculateSum class
        // We don't need to create an object of the class because the method is static
        int sum = CalculateSum.calculateSum(num1, num2);
        System.out.println("Sum = " + sum);
    }

    // Method to run the multiply method (q2)
    private static void runMultiply() {
        // Display header
        System.out.println("--- Multiply Numbers ---");

        // Get user input
        System.out.println("Enter second number: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter second number: ");
        int number2 = scanner.nextInt();

        System.out.println("Enter third number: ");
        int number3 = scanner.nextInt();
        scanner.nextLine(); // removing newLine char, see above comment

        int productOf2 = MethodOverloading.multiply(number1, number2);
        System.out.println("Product of 2 numbers = " + productOf2);

        int productof3 = MethodOverloading.multiply(number1, number2, number3);
        System.out.println("Product of 3 numbers = " + productof3);
    }

    // Method to run the findMax method (q3)
    private static void runMax() {
        // Display header
        System.out.println("--- Find Maximum ---");

        // Get user input
        System.out.println("How many integers would you like to enter? ");
        int arraySize = scanner.nextInt();

        int[] numbers = new int[arraySize];

        // For loop to get user input for array
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Enter numbers: ");
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine(); // removing newLine char, see above comment

        // Call the findMax method to find the maximum number
        int max = FindMax.findMax(numbers);
        System.out.println("Maximum number = " + max);
    }

    // Method to run the reverseString method (q4)
    private static void runReverse() {
        // Display header
        System.out.println("--- Reverse String ---");

        // Get user input
        System.out.println("Enter a string to be reversed: ");
        String input = scanner.nextLine();

        // Call the reverseString method to reverse the string
        String reversed = StringReverse.stringReverse(input);
        System.out.println("Reversed string = " + reversed);
        
    }

}
