// Reggie Brown
// 2/17/25
// COSC1200 - Professor Tauhid
// Assignment 2
// DESC: This program will take in a user input of integers and store them in an array
// This will then perform many operations on the array such as:
// Printing the array, finding the largest, smallest, sum, and average of the array
// There will also be an option to search for a number and check if it exists in the array
// It will also perform a bubble sort and print the sorted array


// This class is where all the array methods will be stored

package Assignment2;

import java.util.Scanner;

public class IntegerArray {
    // Initialized variables for the class
    private Scanner scanner = new Scanner(System.in);
    private int[] array;
    private int arraySize;

    // method to initialize the array
    public void initializeArray() {
        // Get array size from user
        System.out.println("Please enter the size of the array: ");
        arraySize = scanner.nextInt();

        // Loop to reprompt user if they enter invalid arraySize input (>20 - <1)
        while (arraySize > 20 || arraySize < 1) {
            System.out.println("Invalid: Please enter a number between 1-20");
            arraySize = scanner.nextInt();
        }

        // Get values from user and append to array
        // TODO: Add a loop to reprompt user if they enter invalid input (non-int)
        array = new int[arraySize];
        System.out.println("Please enter " + arraySize + " values (integers): ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
    }
    
    // Method to display array
    // Iterates through the array and prints each element with a comma
    public void displayArray() {
        System.out.println("Array: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    // Method to find the smallest number in the array
    // Iterates through the array and compares each element to the smallest variable
    public int smallestNum() {
        int smallest = array[0];
        for (int i = 0; i < arraySize; i++) {
            if (array[i] < smallest) {
                smallest = array[1];
            }
        }
        return smallest;
    }

    // Method to find the largest number in the array
    // Iterates through the array and compares each element to the largest variable
    public int largestNum() {
        int largest = array[0];
        for (int i = 0; i < arraySize; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }

    // Method to find the sum of array
    // Iterates through the array and adds each element
    public int sumArray() {
        int sum = 0;
        for (int i = 0; i < arraySize; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

}


