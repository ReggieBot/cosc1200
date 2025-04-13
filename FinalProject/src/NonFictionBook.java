package FinalProject.src;

public class NonFictionBook extends Book {
    private String subject;

    // Constructor
    public NonFictionBook(String title, String author, String isbn, int yearPublished, String subject) {
        super(title, author, isbn, yearPublished);
        this.subject = subject;
    }

    // Implementing the abstract method from Book class
    @Override
    public String get_book_type() {
        return "Non-Fiction";
    }
}
