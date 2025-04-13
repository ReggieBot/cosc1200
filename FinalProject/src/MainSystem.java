package FinalProject.src;

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
            int userChoice = 0;
            boolean menuActive = true;
            // Main loop to handle user input

            while(menuActive) {
                // Display menu
                System.out.println("----Durham College Library System----");
                System.out.println("1. Add a new book");
                System.out.println("2. Enqueue a borrow request");
                System.out.println("3. Process borrow requests");
                System.out.println("4. Return a book");
                System.out.println("5. Display available books");
                System.out.println("6. Display borrowed books");
                System.out.println("7. Display return history");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                // Read user choice
                userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline char - prevents error when reading next line

                // switch case 
                switch(userChoice) {
                    case 1:
                        // add a new book
                        System.out.println("Select book type: ");
                        System.out.println("1. Fiction");
                        System.out.println("2. Non-Fiction");
                        System.out.println("3. Reference");
                        System.out.println("Please enter your choice: ");
                        int bookType = scanner.nextInt();
                        scanner.nextLine(); // consume newline char

                        // Get book details (universal)
                        System.out.println("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter book author: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter book ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.println("Enter year published: ");
                        int yearPublished = scanner.nextInt();
                        scanner.nextLine(); // consume newline char

                        // create book obj based on type (1-3)
                        Book newBook = null;
                        if (bookType == 1) {
                            System.out.println("Enter book genre: ");
                            String genre = scanner.nextLine();
                            newBook = new FictionBook(title, author, isbn, yearPublished, genre);
                        } else if (bookType == 2) {
                            System.out.println("Enter book subject: ");
                            String subject = scanner.nextLine();
                            newBook = new NonFictionBook(title, author, isbn, yearPublished, subject);
                        } else if (bookType == 3) {
                            newBook = new ReferenceBook(title, author, isbn, yearPublished);
                        } else {
                            System.out.println("Invalid book type. Please try again.");
                            break;
                        }

                        // wrap book in BorrowableBook 
                        BorrowableBook borrowableBook = new BorrowableBook(newBook);
                        // add to available books linkedlist
                        availableBooks.add(borrowableBook);
                        System.out.println("Added book successfully.");
                        break;

                    case 2:
                        // Enqueue a borrow request
                        if (availableBooks.isEmpty()) {
                            System.out.println("No books available to borrow.");
                            break;
                        }

                        System.out.println("----Available books----");
                        // list books
                        for (int i = 0; i < availableBooks.size(); i++) {
                            System.out.print((i +1 ) + ". ");
                            availableBooks.get(i).display_info();
                            System.out.println("-------------------------");
                        }

                        System.out.println("Enter the number of the book you wish to borrow: ");
                        int borrowBookIndex = scanner.nextInt();
                        scanner.nextLine(); // consume newline char

                        if (borrowBookIndex < 1 || borrowBookIndex > availableBooks.size()) {
                            System.out.println("Invalid book number.");
                            break;
                        }

                        BorrowableBook selectedBook = availableBooks.get(borrowBookIndex - 1);
                        System.out.println("Please enter your name: ");
                        String requester = scanner.nextLine();

                        // create a neww borrow request & add to queue
                        BorrowRequest request = new BorrowRequest(requester, selectedBook);
                        borrowRequests.add(request);
                        System.out.println("Borrow request added successfully.");
                        break;

                    case 3: 
                        // process borrow requests
                        if (borrowRequests.isEmpty()) {
                            System.out.println("No requests to process.");
                            break;
                        }

                        System.out.println("Processing borrow requests: ");
                        while (!borrowRequests.isEmpty()) {
                            // retrieve and remove the head of the queue
                            BorrowRequest req = borrowRequests.poll();
                            BorrowableBook reqBook = req.getBook();
                            System.out.println(req.getRequester() + " requested: " + reqBook.getTitle());
                            
                            // Check if book is available
                            if (availableBooks.contains(reqBook)) {
                                // Borrow the book
                                reqBook.borrow();
                                // move book to borrowed books list
                                if (reqBook.isBorrowed()) {
                                    availableBooks.remove(reqBook);
                                    borrowedBooks.add(reqBook);
                                    System.out.println("Book borrowed.");
                                }
                            } else {
                                System.out.println("Book is not available.");
                            }
                        }
                        break;

                    case 4:    
                        // Return a book
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No books to return.");
                            break;
                        }

                        System.out.println("----Borrowed Books----");
                        for (int i = 0; i < borrowedBooks.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            borrowedBooks.get(i).display_info();
                            System.out.println("-------------------------");
                        }

                        System.out.println("Enter the number of book you wish to return: ");
                        int returnBookIndex = scanner.nextInt();
                        scanner.nextLine(); // consume newLine char

                        if (returnBookIndex < 1 || returnBookIndex > borrowedBooks.size()) {
                            System.out.println("Invalid selection.");
                            break;
                        }

                        // Remove the book from borrowed books list
                        // add to available books
                        // push to return history stack
                        BorrowableBook bookToReturn = borrowedBooks.get(returnBookIndex - 1);
                        bookToReturn.returnBook();
                        borrowedBooks.remove(bookToReturn);
                        availableBooks.add(bookToReturn);
                        returnHistory.push(bookToReturn);
                        System.out.println("Successfully returned book.");
                        break;

                    case 5: 
                        // Display books available
                        System.out.println("----Available Books----");
                        if (availableBooks.isEmpty()) {
                            System.out.println("Sorry, no books available.");
                        } else {
                            for (int i = 0; i < availableBooks.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                availableBooks.get(i).display_info();
                                System.out.println("-------------------------");
                            }
                        }
                        break;
                    
                    case 6:
                        // Display borrowed books
                        System.out.println("----Borrowed Books----");
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No books have been borrowed");
                        } else {
                            for (int i = 0; i < borrowedBooks.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                borrowedBooks.get(i).display_info();
                                System.out.println("-------------------------");
                            }
                        }
                        break;
                    
                    case 7: 
                        // Display return history
                        System.out.println("----Return History----");
                        if (returnHistory.isEmpty()) {
                            System.out.println("No books have been returned.");
                        } else {
                            // display books in reverse order (most recent first)
                            for (int i = returnHistory.size() - 1; i >= 0; i--) {
                                returnHistory.get(i).display_info();
                                System.out.println("-------------------------");
                            }
                        }
                        break;
                    
                    case 8: 
                        // Exit
                        System.out.println("Exiting Durham College Library System.");
                        menuActive = false;
                        break;

                 
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        
            // scanner is auto-closed here (trywithresources)
        }
    }
}
