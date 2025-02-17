// Reggie Brown
// 2/17/25
// COSC1200 - Professor Tauhid
// Assignment 2
// DESC: This program will take in a user input of integers and store them in an array
// This will then perform many operations on the array such as:
// Printing the array, finding the largest, smallest, sum, and average of the array
// There will also be an option to search for a number and check if it exists in the array
// It will also perform a bubble sort and print the sorted array

// This class is where the main method will be stored, methods will be called from the IntegerArray class

package Assignment2;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the IntegerArray class
        IntegerArray array = new IntegerArray();

        // Call initializeArray method to get user input and store in array
        array.initializeArray();

        // Call displayArray method to print current array
        array.displayArray();

        // Call the largestNum and smallestNum methods to find largest/smallest num in array
        System.out.println("\nLargest number: " + array.largestNum());
        System.out.println("Smallest number: " + array.smallestNum());

        // Call the sum and average method and print
        System.out.println("Sum: " + array.sumArray());
        System.out.println("Average: " + array.averageArray());


        // Call the method to search for number in the array
        if (array.searchArray()) {
            System.out.println(searchNum + " exists in the array");
        }
    }
}
