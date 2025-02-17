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
    Scanner scanner = new Scanner(System.in);
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

    // Method to find the average of array
    // Calls the sumArray method and divides by arraySize
    public double averageArray() {
        return sumArray() / arraySize;
    }

    // Method to search for a user inputted number in the array
    // Iterates through the array and compares each element to user input
    // Returns true if the number is found, otherwise returns false
    public boolean searchArray(int searchNum) {
        for (int i = 0; i < arraySize; i++) {
            if (array[i] == searchNum) {
                return true;
            }
        } return false;
    }

    // Method to perform bubble sort on the array
    // Iterates through the array and compares each element to the next element
    // if the next element is smaller than the current, swap them
    // Continues to iterate until no more swaps can be performed
    // https://www.geeksforgeeks.org/bubble-sort-algorithm/

    public void bubbleSort() {
        // Outer loop - How many times to iterate through the array
        for (int i = 0; i < arraySize; i++) {
            // Boolean to check if any swaps were made
            boolean swapped = false;
            // Inner loop - Compares each element to the next element 
            for (int j = 0; j < arraySize - i - 1; j++) {
                // If the next element is smaller than current index, swap them
                if (array[j] > array[j + 1]) {
                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                    swapped = true;
                }
            }
            // If no swaps were made, break the loop
            // If none were made, the array is already sorted
            // This optimizes the array so that it doesn't iterate if already sorted
            if (!swapped) {
                break;
            }
        }    
    }
    
    // Method to close the scanner, as it can't be closed in main method
    public void closeScanner() {
        scanner.close();
    }
}




