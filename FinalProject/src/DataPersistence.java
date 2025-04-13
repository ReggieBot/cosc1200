package FinalProject.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class DataPersistence {
    // Name of the file where book data is stored
    private static final String FILE_NAME = "data.txt";
    
    // Saves available books to file
    // Uses a linked list to store
    // Throws an IOException if error occurs
    public static void saveData(LinkedList<BorrowableBook> availableBooks) throws IOException {
        // Create a writer to write to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        
        // Loop through all the available books
        for (int i = 0; i < availableBooks.size(); i++) {
            // Get each book one by one
            BorrowableBook book = availableBooks.get(i);
            
            // Create a line with all the book information separated by |
            String line = book.get_book_type() + "|" + 
                          book.getTitle() + "|" +
                          book.getAuthor() + "|" + 
                          book.getIsbn() + "|" +
                          book.getYearPublished() + "|" + 
                          "N/A";
            
            // Write the line to the file
            writer.write(line);
            // Move to the next
            writer.newLine();
        }
        
        // Close writer (this kept giving me an error and it was annoying)
        writer.close();
    }
    
    // load data from file
    // returns a linked list of available books
    // also throws an IOException if error occurs
    public static LinkedList<BorrowableBook> loadData() throws IOException {
        LinkedList<BorrowableBook> availableBooks = new LinkedList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        
        String line;
        
        // kee reading lines until there are no more
        while ((line = reader.readLine()) != null) {
            // split the line into parts using | as the separator
            // need to escape the | by using \\ as | is reserved for regex??
            String[] parts = line.split("\\|");
            
            // Make sure we have enough parts
            if (parts.length < 5) {
                // if not skip
                continue; 
            }
            
            // get the book information from the parts
            String bookType = parts[0];
            String title = parts[1];
            String author = parts[2];
            String isbn = parts[3];
            int year = Integer.parseInt(parts[4]);
            
            // Variable to store the new book
            Book newBook = null;
            
            // create the right type of book based on the book type
            if (bookType.equals("Fiction")) {
                String genre = "N/A";
                if (parts.length > 5) {
                    genre = parts[5];
                }
                newBook = new FictionBook(title, author, isbn, year, genre);
            } 
            else if (bookType.equals("Non-Fiction")) {
                String subject = "N/A";
                if (parts.length > 5) {
                    subject = parts[5];
                }
                newBook = new NonFictionBook(title, author, isbn, year, subject);
            } 
            else if (bookType.equals("Reference")) {
                newBook = new ReferenceBook(title, author, isbn, year);
            }
            
            // create a new book
            availableBooks.add(new BorrowableBook(newBook));


        
        // Close the reader when done
        reader.close();
        
        // Close the reader when done
        reader.close();
    }

    // Return the list of books we loaded
    return availableBooks;
}
}