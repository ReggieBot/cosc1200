// Reggie Brown
// 2/17/25
// COSC1200 - Professor Tauhid
// Assignment 2
// DESC: This program will take in a user input of integers and store them in an array
// This will then perform many operations on the array such as:
// Printing the array, finding the largest, smallest, sum, and average of the array
// There will also be an option to search for a number and check if it exists in the array
// It will also perform a bubble sort and print the sorted array




package Assignment2;

import java.util.Scanner;

public class IntegerArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for array size
        System.out.println("Please enter the size of the array: ");
        int arraySize = scanner.nextInt();

        // Input validation 
        while (arraySize > 20 || arraySize < 1) {
            System.out.println("Please enter a array size between 1-20");
            arraySize = scanner.nextInt();
        }

        // Create array with user input size
        int[] array = new int[arraySize];

        // Ask user for array elements and append to array
        System.out.println("Please enter the elements of the array: ");
        
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }



        
    }
}