package Assignment4.src;

public class BorrowableBook extends Book implements Borrowable{
    // Flag to check if book is borrowed
    private boolean isBorrowed = false;
    // Composition to create a reference to the book (SEE README / REFERENCES)
    private Book referenceBook;

    // Constructor
    public BorrowableBook(Book referenceBook) {
        super(referenceBook.getTitle(), referenceBook.getAuthor(), referenceBook.getIsbn(), referenceBook.getYearPublished());
        this.referenceBook = referenceBook;
    }

    @Override
    public String get_book_type() {
        return referenceBook.get_book_type();
    }

    @Override
    public void borrow() {
        if (referenceBook instanceof ReferenceBook) {
            System.out.println("Referene Books are not borrowable. Book: " + referenceBook.getTitle());
        } else if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Successfully Borrowed Book: " + referenceBook.getTitle());
        } else {
            System.out.println("Sorry, that book is already borrowed: " + referenceBook.getTitle());
        }
    }

    @Override
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Thank you, book returned successfully: " + referenceBook.getTitle());
        } else {
            System.out.println("This book has not been borrowed: " + referenceBook.getTitle());
        }
    }

    @Override
    public void display_info() {
        referenceBook.display_info();
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
        return referenceBook;
    }
}
