package FinalProject.LibraryGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Book;
import FinalProject.ADT.Issue;
import FinalProject.ADT.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtReturnDate;
	private JTextField txtMemberID;
	private JTextField txtBookID;
	private int nextIssueId;
	
	/**
	 * Create the frame.
	 */
	public IssueBook(BinarySearchTree<Issue> issueTree, BinarySearchTree<Book> bookTree, BinarySearchTree<Member> memberTree) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(108, 10, 163, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Member ID :");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentId.setBounds(51, 53, 143, 33);
		contentPane.add(lblStudentId);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBookId.setBounds(51, 106, 124, 33);
		contentPane.add(lblBookId);
		
		JLabel lblReturnDate = new JLabel("Return Date :");
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReturnDate.setBounds(51, 170, 143, 33);
		contentPane.add(lblReturnDate);
		
		txtReturnDate = new JTextField();
		txtReturnDate.setColumns(10);
		txtReturnDate.setBounds(203, 170, 163, 33);
		contentPane.add(txtReturnDate);
		
		nextIssueId = issueTree.isEmpty() ? 1 : issueTree.maxValue().getIssueId() + 1;
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookIDStr = txtBookID.getText();
		        String memberIDStr = txtMemberID.getText();
		        String returnDateStr = txtReturnDate.getText();
		        
		        //Check if any of the fields are empty
		        if (bookIDStr.isEmpty() || memberIDStr.isEmpty() || returnDateStr.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "All fields must be filled out.");
		            return;
		        }
		        
		        //Check if the book ID and member ID are valid numbers
		        int bookID, memberID;
		        try {
		            bookID = Integer.parseInt(bookIDStr);
		            memberID = Integer.parseInt(memberIDStr);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Book ID and Member ID must be numbers.");
		            return;
		        }
		        
		        //Check if the book ID and member ID exist in the BSTs
		        Book book = bookTree.search(new Book(bookID, null, null));
		        Member member = memberTree.search(new Member(memberID, null, 0, null, 0));
		        if (book == null || member == null) {
		            JOptionPane.showMessageDialog(null, "Book ID or Member ID does not exist.");
		            return;
		        }
		        
		        //Check if the book is already issued and not returned
		        for (Issue existingIssue : issueTree.inorder()) {
		            if (existingIssue.getBookId() == bookID) {
		                JOptionPane.showMessageDialog(null, "This book is already issued.");
		                return;
		            }
		        }
		        
		        //If all checks pass, create the new issue and insert it into the BST
		        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		        Date issueDate = new Date();
		        Date returnDate;
		        try {
		            returnDate = sdf.parse(returnDateStr);
		        } catch (ParseException ex) {
		            JOptionPane.showMessageDialog(null, "Return Date must be in the format of MM/dd/yy.");
		            return;
		        }
		        if (returnDate.before(issueDate)) {
		            JOptionPane.showMessageDialog(null, "Return Date must be later than the Issue Date.");
		            return;
		        }
		        Issue issue = new Issue(nextIssueId++, memberID, member.getName(), bookID, book.getName(), sdf.format(issueDate), sdf.format(returnDate));
		        issueTree.insert(issue);
		        JOptionPane.showMessageDialog(null, "Book issued successfully.", "Book issued", JOptionPane.INFORMATION_MESSAGE);
		        
		       
		        //Save the issue to a text file
		        String filepath = "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Issue.txt";
		        try {
		            FileWriter writer = new FileWriter(filepath, true); //Open the file in append mode
		            writer.write(issue.toString() + "\n"); //Write the issue to the file
		            writer.close();
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, "Error writing to file.");
		            return;
		        }
		        
		        //Clear the text fields
		        txtMemberID.setText("");
		        txtBookID.setText("");
		        txtReturnDate.setText("");
		        
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.setBounds(22, 259, 108, 60);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMemberID.setText("");
		        txtBookID.setText("");
		        txtReturnDate.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(140, 259, 108, 60);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(258, 259, 108, 60);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI Library = new LibraryGUI();
		        Library.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnBack);
		
		txtMemberID = new JTextField();
		txtMemberID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(184, 53, 182, 33);
		contentPane.add(txtMemberID);
		
		txtBookID = new JTextField();
		txtBookID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBookID.setColumns(10);
		txtBookID.setBounds(158, 106, 208, 33);
		contentPane.add(txtBookID);
		
		JLabel lblInAFormat = new JLabel("in a format of mm/dd/yy");
		lblInAFormat.setHorizontalAlignment(SwingConstants.CENTER);
		lblInAFormat.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInAFormat.setBounds(51, 213, 315, 33);
		contentPane.add(lblInAFormat);
	}
}

