package Assignment4.src;

public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private int yearPublished;

    // Constructor
    public Book(String title, String author, String isbn, int yearPublished) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
    }

    // Abstract method to get book type
    // This method will be implemented in subclass
    public abstract String get_book_type();

    // Print book details
    public void display_info() {
        System.out.println("-------------------------");
        System.out.println("-------Book Details------");
        System.out.println("-------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("-------------------------");
    }

    // Getters
    // These are needed because we are using composition (a reference to Book) in BorrowableBook class

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
