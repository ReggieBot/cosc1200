package Assignment4.src;

public class ReferenceBook extends Book {
    private boolean restricted = true;

    // Constructor
    public ReferenceBook(String title, String author, String isbn, int yearPublished) {
        super(title, author, isbn, yearPublished);
    }

    @Override
    public String get_book_type() {
        return "Reference";
    }

    @Override
    public void display_info() {
        super.display_info();
        System.out.println("This is a reference book and cannot be borrowed.");
    }  
}
