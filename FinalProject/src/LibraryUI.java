package FinalProject.src;

// This is the main class for the library system UI


// wildcards used for imports - ease of use
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LibraryUI extends JFrame implements ActionListener {
    
    // data structures
    // Linked list for available books & borrowed books
    // Queue for borrow requests
    // Stack for return history
    private LinkedList<BorrowableBook> availableBooks = new LinkedList<BorrowableBook>();
    private LinkedList<BorrowableBook> borrowedBooks = new LinkedList<BorrowableBook>();
    private Queue<BorrowRequest> borrowRequests = new LinkedList<BorrowRequest>();
    private Stack<BorrowableBook> returnHistory = new Stack<BorrowableBook>();

    // GUI componenets for displaying books available
    private DefaultTableModel tableModel;
    private JTable bookTable;

    // GUI components for add new book form
    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField yearField;
    private JTextField typeField;
    private JRadioButton fictionRadio;
    private JRadioButton nonFictionRadio;
    private JRadioButton referenceRadio;
    private ButtonGroup typeGroup;

    private JButton addButton;
    private JButton issueButton;
    private JButton processRequestsButton;
    private JButton returnButton;
    private JButton viewHistoryButton;

    // Menu componenets for file operations
    private JMenuItem openMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem aboutMenuItem;
    private JMenuItem exitMenuItem;

    // Constructor
    // Initializes UI and its components
    public LibraryUI() {
        setTitle("Durham College Library System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // center window
        setLocationRelativeTo(null);

        // Initialize
    }
}
