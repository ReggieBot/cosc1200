package FinalProject.src;

public class FictionBook extends Book {
    private String genre;
    
    // Constructor
    public FictionBook(String title, String author, String isbn, int yearPublished, String genre) {
        super(title, author, isbn, yearPublished);
        this.genre = genre;
    }

    // Implementing the abstract method from Book class
    // Using @Override annotation to show that this method is overriding a method from its superclass
    @Override
    public String get_book_type() {
        return "Fiction";
    }
}
