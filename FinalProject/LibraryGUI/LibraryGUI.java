package FinalProject.LibraryGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Book;
import FinalProject.ADT.Issue;
import FinalProject.ADT.Member;

public class LibraryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtLibraryManagment;
	
	//Initialize the BST here
    public static BinarySearchTree<Book> bookTree = new BinarySearchTree<>();
    public static BinarySearchTree<Member> memberTree = new BinarySearchTree<>();
    public static BinarySearchTree<Issue> issueTree = new BinarySearchTree<>();
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//Populate the tree from the file before starting the application
                    populateBookFromFile(bookTree, "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Books.txt");
                    populateMemberFromFile(memberTree, "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Members.txt");
                    populateIssueFromFile(issueTree, "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Issue.txt");
                    
					LibraryGUI frame = new LibraryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibraryGUI() {
		setResizable(false);
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(410, 538, 262, 54);
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       System.exit(0);
		    }
		});
		contentPane.add(Exit);
		
		txtLibraryManagment = new JTextField();
		txtLibraryManagment.setEditable(false);
		txtLibraryManagment.setText("Library Management System");
		txtLibraryManagment.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtLibraryManagment.setBounds(305, 0, 436, 54);
		contentPane.add(txtLibraryManagment);
		txtLibraryManagment.setColumns(10);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnIssueBook.setBounds(410, 410, 262, 54);
		btnIssueBook.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        navigateToIssueBook();
		    }
		});
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnReturnBook.setBounds(410, 474, 262, 54);
		btnReturnBook.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        navigateToReturnBook();
		    }
		});
		contentPane.add(btnReturnBook);
		
		
		JButton btnAddBooks = new JButton("Add books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAddBooks.setBounds(410, 90, 262, 54);
		btnAddBooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	navigateToAddBooks();
		    }
		});
		contentPane.add(btnAddBooks);
		
		JButton btnViewbooks = new JButton("View Books");
		btnViewbooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewbooks.setBounds(410, 154, 262, 54);
		btnViewbooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	navigateToViewBooks();
		    }
		});
		contentPane.add(btnViewbooks);
		
		JButton btnViewissuebooks = new JButton("View Issue Books");
		btnViewissuebooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewissuebooks.setBounds(410, 346, 262, 54);
		btnViewissuebooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	navigateToViewIssue();
		    }
		});
		contentPane.add(btnViewissuebooks);
		
		JButton btnAddmembers = new JButton("Add members");
		btnAddmembers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAddmembers.setBounds(410, 218, 262, 54);
		btnAddmembers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	navigateToAddMembers();
		    }
		});
		contentPane.add(btnAddmembers);
		
		JButton btnViewMembers = new JButton("View Members");
		btnViewMembers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewMembers.setBounds(410, 282, 262, 54);
		contentPane.add(btnViewMembers);
		btnViewMembers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        navigateToViewMembers();
		    }
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\assets\\librarybackground.jpg"));
		lblNewLabel.setBounds(0, 0, 1100, 695);
		contentPane.add(lblNewLabel);
	}
	
	//Methods to open the other windows
	public void navigateToAddBooks() {
        AddBooks addBooksFrame = new AddBooks(bookTree);
        addBooksFrame.setVisible(true);
        this.dispose();
    }

    public void navigateToViewBooks() {
        ViewBooks viewBooksFrame = new ViewBooks(bookTree);
        viewBooksFrame.setVisible(true);
        this.dispose();
    }
    
    public void navigateToAddMembers() {
    	AddMembers addMembersFrame = new AddMembers(memberTree);
    	addMembersFrame.setVisible(true);
    	this.dispose();
    }
    
    public void navigateToViewMembers() {
    	ViewMembers viewMembersFrame = new ViewMembers(memberTree);
    	viewMembersFrame.setVisible(true);
    	this.dispose();
    }
    
    public void navigateToIssueBook() {
    	IssueBook issueBookFrame = new IssueBook(issueTree, bookTree, memberTree);
    	issueBookFrame.setVisible(true);
    	this.dispose();
    }
    
    public void navigateToViewIssue() {
    	ViewIssueBook viewIssueFrame = new ViewIssueBook(issueTree);
    	viewIssueFrame.setVisible(true);
    	this.dispose();
    }
    
    public void navigateToReturnBook() {
    	ReturnBook returnBookFrame = new ReturnBook(issueTree);
    	returnBookFrame.setVisible(true);
    	this.dispose();
    }
    
    private static void populateBookFromFile(BinarySearchTree<Book> bookTree, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 3) {
                continue;
            }
            int bookId = Integer.parseInt(details[0]);
            String name = details[1];
            String publisher = details[2];
            Book book = new Book(bookId, name, publisher);
            bookTree.insert(book);
        }
        reader.close();
    }
    
    private static void populateMemberFromFile(BinarySearchTree<Member> memberTree, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 5) {
                continue;
            }
            int studentID = Integer.parseInt(details[0]);
            String name = details[1];
            int age = Integer.parseInt(details[2]);
            String course = details[3];
            int year = Integer.parseInt(details[4]);
            Member member = new Member(studentID, name, age, course, year);
            memberTree.insert(member);
        }
        reader.close();
    }
    
    private static void populateIssueFromFile(BinarySearchTree<Issue> issueTree, String filename) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 7) {
                continue;
            }
            int issueID = Integer.parseInt(details[0]);
            int memberID = Integer.parseInt(details[1]);
            String memberName = details[2];
            int bookID = Integer.parseInt(details[3]);
            String bookName = details[4];
            String issueDate = details[5];
            String returnDate = details[6];
            boolean isReturned = details.length > 7 && Boolean.parseBoolean(details[7]);
            Issue issue = new Issue(issueID, memberID, memberName, bookID, bookName, issueDate, returnDate);
            issueTree.insert(issue);
        }
        reader.close();
    }
    
    
    
}
