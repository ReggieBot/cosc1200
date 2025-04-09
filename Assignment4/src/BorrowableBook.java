package Assignment4.src;

public class BorrowableBook extends Book implements Borrowable{
    // Flag to check if book is borrowed
    private boolean isBorrowed = false;
    // Composition to create a reference to the book (SEE README / REFERENCES)
    private Book borrowableBook;

    // Constructor
    // Call the Book constructor with the wrapped book's information
    // This maintains the Book identity while adding borrowable behavior
    public BorrowableBook(Book borrowableBook) {
        super(borrowableBook.getTitle(), borrowableBook.getAuthor(), borrowableBook.getIsbn(), borrowableBook.getYearPublished());
        // store reference to wrapped book
        this.borrowableBook = borrowableBook;
    }

    @Override
    public String get_book_type() {
        return borrowableBook.get_book_type();
    }

    @Override
    public void borrow() {
        if (borrowableBook instanceof ReferenceBook && ReferenceBook.isRestricted()) {
            System.out.println("Referene Books are not borrowable. Book: " + borrowableBook.getTitle());
        } else if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Successfully Borrowed Book: " + borrowableBook.getTitle());
        } else {
            System.out.println("Sorry, that book is already borrowed: " + borrowableBook.getTitle());
        }
    }

    @Override
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Thank you, book returned successfully: " + borrowableBook.getTitle());
        } else {
            System.out.println("This book has not been borrowed: " + borrowableBook.getTitle());
        }
    }

    @Override
    public void display_info() {
        borrowableBook.display_info();
        if (isBorrowed) {
            System.out.println("Borrow Status: Yes");
        } else {
            System.out.println("Borrow Status: No");
        }
    }


    // Getter for class vars
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public Book getReferenceBook() {
        return borrowableBook;
    }
}
