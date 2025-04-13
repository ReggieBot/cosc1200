package FinalProject.src;

public class BorrowRequest {

// class used to represent a borrow request from the user
// contains the name of the requester and the book requested
    private String requester;
    private BorrowableBook book;

    // Constructor
    public BorrowRequest(String requester, BorrowableBook book) {
        this.requester = requester;
        this.book = book;
    }

    // Getters
    public String getRequester() {
        return requester;
    }

    public BorrowableBook getBook() {
        return book;
    }
}

