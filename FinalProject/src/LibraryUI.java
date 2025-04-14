package FinalProject.src;

// This is the main class for the library system UI


// wildcards used for imports - ease of use
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
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

    // constructor
    // initializes UI and its components
    public LibraryUI() {
        setTitle("Durham College Library System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // center window
        setLocationRelativeTo(null);

        // Initialize the toolbar, menu, table, and form panel
        initMenu();
        initToolbar();
        JPanel formPanel = formPanel();
        initTable();

        // using BorderLayout to arrange comp.
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(createToolBarPanel(), BorderLayout.NORTH);
        contentPane.add(formPanel, BorderLayout.WEST);
        contentPane.add(new JScrollPane(bookTable), BorderLayout.CENTER);

        // set visible
        setVisible(true);

    }

    // create panel for toolbar
    // contains buttons for adding, issuing, processing requests, returning books, and viewing history
    private JPanel createToolBarPanel() {
        JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT));
        panel.add(addButton);
        panel.add(issueButton);
        panel.add(processRequestsButton);
        panel.add(returnButton);
        panel.add(viewHistoryButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        panel.add(exitButton);
        
        return panel;
    }

    // initialize toolbar buttons
    private void initToolbar() {
        addButton = new JButton("Add");
        issueButton = new JButton("Issue"); // enqueue borrow request
        processRequestsButton = new JButton("Process Requests"); // process queued requests
        returnButton = new JButton("Return"); // process return
        viewHistoryButton = new JButton("View History"); // view return history

        addButton.addActionListener(this);
        issueButton.addActionListener(this);
        processRequestsButton.addActionListener(this);
        returnButton.addActionListener(this);
        viewHistoryButton.addActionListener(this);
    }

    // initialize menu bar (help and file menus)
    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        // file menu
        JMenu fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // help menu
        JMenu helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);

        // sets menu bar to the frame
        setJMenuBar(menuBar);

    }

    // create form panel for adding new books
    private JPanel formPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(new TitledBorder("Add New Book"));
        
        // type of book selection
        // using radio buttons
        panel.add(new JLabel("Type: "));
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fictionRadio = new JRadioButton("Fiction");
        nonFictionRadio = new JRadioButton("Non-Fiction");
        referenceRadio = new JRadioButton("Reference");
        typeGroup = new ButtonGroup();
        typeGroup.add(fictionRadio);
        typeGroup.add(nonFictionRadio);
        typeGroup.add(referenceRadio);
        radioPanel.add(fictionRadio);
        radioPanel.add(nonFictionRadio);
        radioPanel.add(referenceRadio);
        
        // add radio panel to form
        panel.add(radioPanel);

        // title field
        panel.add(new JLabel("Title: "));
        titleField = new JTextField();
        panel.add(titleField);

        // author field
        panel.add(new JLabel("Author: "));
        authorField = new JTextField();
        panel.add(authorField);

        // ISBN field
        panel.add(new JLabel("ISBN: "));
        isbnField = new JTextField();
        panel.add(isbnField);

        // year field
        panel.add(new JLabel("Year: "));
        yearField = new JTextField();
        panel.add(yearField);

        // type field
        panel.add(new JLabel("Type: "));
        typeField = new JTextField();
        panel.add(typeField);

        // add button
        JButton formAddButton = new JButton("Add Book");
        formAddButton.addActionListener(this);
        panel.add(addButton);

        return panel;

    }

    // initialize table for displaying available books
    private void initTable() {
        String[] columnNames = {"Title", "Author", "ISBN", "Year", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        bookTable = new JTable(tableModel);
    }

    // handle action events from btns/menu items
    // overrides actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Add") || command.equals("Add Book")) {
            addBook();
        } else if (command.equals("Issue")) {
            enqueueBorrowRequest();
        } else if (command.equals("Process Requests")) {
            processBorrowRequests();
        } else if (command.equals("Return")) {
            returnBook();
        } else if (command.equals("View History")) {
            viewReturnHistory();
        } else if (command.equals("Exit")) {
            System.exit(0);
        } else if (e.getSource() == openMenuItem) {
            try {
                availableBooks = DataPersistence.loadData();
                refreshTable();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == saveMenuItem) {
            try {
                System.out.println("Save menu item clicked. About to call saved data");
                DataPersistence.saveData(availableBooks);
            } catch (IOException ex) {
                System.err.println("Exception during save: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == aboutMenuItem) {
            JOptionPane.showMessageDialog(this, "Hello!\nDurham College Library System\nDeveloped By Reggie Brown\nProfessor Tauhid", "About", JOptionPane.INFORMATION_MESSAGE);

        }

    }


    // method to refresh table if needed
    // 

    private void refreshTable() {
         // Clear existing rows
        tableModel.setRowCount(0);
    
        if (availableBooks != null) {
            // Loop using an index
            for (int i = 0; i < availableBooks.size(); i++) {
                BorrowableBook book = availableBooks.get(i);

                // Object is used because it allows for different types and integrates well with the table model
                // https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/table/DefaultTableModel.html
                // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html
                Object[] row = {
                    book.getTitle(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.getYearPublished(),
                    book.get_book_type()
                };

                // Add the row to the model
                tableModel.addRow(row); 
            }
        } else {
            System.err.println("AvailableBooks is empty!");
        }
    }

    // method to clear form fields after book added
    private void clearForm() {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        yearField.setText("");
        typeField.setText("");
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String isbn = isbnField.getText().trim();
        String yearText = yearField.getText().trim();
    
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || yearText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Make sure all fields are filled out", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        int year;
        try {
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Year must be numeric", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        Book newBook = null;
        if (fictionRadio.isSelected()) {
            String genre = typeField.getText().trim();
            if (genre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Genre is required!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            newBook = new FictionBook(title, author, isbn, year, genre);
        } else if (nonFictionRadio.isSelected()) {
            String subject = typeField.getText().trim();
            if (subject.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Subject is required!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            newBook = new NonFictionBook(title, author, isbn, year, subject);
        } else if (referenceRadio.isSelected()) {
            newBook = new ReferenceBook(title, author, isbn, year);
        }
    
        BorrowableBook borrowableBook = new BorrowableBook(newBook);
        availableBooks.add(borrowableBook);
        JOptionPane.showMessageDialog(this, "Added book successfully!", 
            "Success", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
        clearForm();
    
    }

    // enqueues new borrow request
    // logic taken from Assignment 4
    private void enqueueBorrowRequest() {
        // https://docs.oracle.com/javase/8/docs/api/javax/swing/JTable.html
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a book to request.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BorrowableBook selectedBook = availableBooks.get(selectedRow);

        String requester = JOptionPane.showInputDialog(this, "Enter your name:");
        if (requester == null || requester.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Requester name cannot be empty.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Create and enqueue a new borrow request.
        BorrowRequest request = new BorrowRequest(requester, selectedBook);
        borrowRequests.add(request);
        JOptionPane.showMessageDialog(this, "Borrow request added.", 
            "Info", JOptionPane.INFORMATION_MESSAGE);
    }


    // process return of book
    // logic taken from Assignment 4
    private void processBorrowRequests() {

        // check for requests
        if (borrowRequests.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No borrow requests to process.", 
                "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // start a string to hold processed requests
        // then concatenate each request to it
        String processed = "Processed Borrow Requests:\n";
        
        // process each request in the queue.
        while (!borrowRequests.isEmpty()) {
            // get and remove the head request.
            BorrowRequest req = borrowRequests.poll();
            BorrowableBook reqBook = req.getBook();
            processed = processed + req.getRequester() + " requested: " + reqBook.getTitle() + "\n";
            
            // If book availabe, borrow
            if (availableBooks.contains(reqBook)) {
                reqBook.borrow();
                if (reqBook.isBorrowed()) {
                    // remove from available books and add to borrowed books
                    availableBooks.remove(reqBook);
                    borrowedBooks.add(reqBook);
                    processed = processed + "Processed - Book borrowed.\n";
                }
            } else {
                processed = processed + "Book not available.\n";
            }
        }

        refreshTable();  
        JOptionPane.showMessageDialog(this, processed, "Processed Borrow Requests", JOptionPane.INFORMATION_MESSAGE);

    }

    // return book
    // logic taken from Assignment 4
    private void returnBook() {
        // check if empty
        if (borrowedBooks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books to return.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // size of array determined by borrowedBooks.size()
        String[] borrowedTitles = new String[borrowedBooks.size()];
        // fill array with titles of borrowed books
        for (int i = 0; i < borrowedBooks.size(); i++) {
            borrowedTitles[i] = borrowedBooks.get(i).getTitle();
        }
        String selectedTitle = (String) JOptionPane.showInputDialog(this, "Select a book to return:",
            "Return Book", JOptionPane.QUESTION_MESSAGE, null, borrowedTitles, borrowedTitles[0]);

        // check if user selected a book
        // if not, return
        if (selectedTitle == null)
            return;

        // find the book in the borrowed list
        BorrowableBook bookToReturn = null;
        if (borrowedBooks != null) {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                BorrowableBook currentBook = borrowedBooks.get(i);
                if (currentBook.getTitle().equals(selectedTitle)) {
                    bookToReturn = currentBook;
                    break;
                }
            }
    }

        if (bookToReturn != null) {
            bookToReturn.returnBook();
            borrowedBooks.remove(bookToReturn);
            availableBooks.add(bookToReturn);
            // Push returned book into return history stack
            returnHistory.push(bookToReturn);
            JOptionPane.showMessageDialog(this, "Book returned successfully", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }

    // view return history
    // logic taken from Assignment 4
    private void viewReturnHistory() {
        if (returnHistory.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No return history", 
                "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String historyText = "Return History:\n";
        // display history in reverse (LIFO)
        for (int i = returnHistory.size() - 1; i >= 0; i--) {
            historyText += returnHistory.get(i).getTitle() + "\n";
        }
        JOptionPane.showMessageDialog(this, historyText.toString(), 
            "Return History", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryUI();
            }
        });
    }
}
