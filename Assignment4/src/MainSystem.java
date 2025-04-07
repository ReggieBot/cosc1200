package Assignment4.src;

// Main class to simulate a library system
// Uses a switch-case to handle user input
// Users can do the the following
// - Add a new book to inventory
// - Enqueue a borrow request
// - Process Borrow Requests
// - Return a book
// - Display available books, borrowed books, return history

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class MainSystem {
    public static void main(String[] args) {
        // Data structures for library system
        // availableBooks = linkedlist to store available books for borrowing
        // borrowedBooks = linked list to store borrowed books
        // borrowRequests = queue to hold borrow requests (FIFO)
        // returnHistory = stack to hold return history (LIFO)

        LinkedList<BorrowableBook> availableBooks = new LinkedList<>();
        LinkedList<BorrowableBook> borrowedBooks = new LinkedList<>();
        Queue<BorrowRequest> borrowRequests = new LinkedList<>();
        Stack<BorrowableBook> returnHistory = new Stack<>();








        // using try-with-resources to ensure scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {

        }
    }
}
