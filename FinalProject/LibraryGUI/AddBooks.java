package FinalProject.LibraryGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Book;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtBookID;
	private JTextField txtPublisher;
	private BinarySearchTree<Book> bookTree;
	/**
	 * Create the frame.
	 */
	public AddBooks(BinarySearchTree<Book> bookTree) {
		this.bookTree = bookTree;
		setResizable(false);
		setTitle("Add Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setBounds(41, 132, 122, 25);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblBookId);
		
		JLabel lblPublisher = new JLabel("Publisher :");
		lblPublisher.setBounds(43, 203, 144, 25);
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblPublisher);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(357, 267, 128, 54);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI addBooks = new LibraryGUI();
		        addBooks.setVisible(true);
		        dispose();
		    }
		});
		
		JLabel lblNewLabel = new JLabel("Add a BOOK!!");
		lblNewLabel.setBounds(145, 1, 200, 54);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(43, 65, 94, 25);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblName);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookIdStr = txtBookID.getText();
		        String name = txtName.getText();
		        String publisher = txtPublisher.getText();
		        
		        //Check if any of the fields are empty
		        if (bookIdStr.isEmpty() || name.isEmpty() || publisher.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "All fields must be filled out.");
		            return;
		        }

		        //Check if the book ID is a valid number
		        int bookId;
		        try {
		            bookId = Integer.parseInt(bookIdStr);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Book ID must be a number.");
		            return;
		        }
		        
		        //Check if the book ID already exists in the BST
		        Book existingBook = bookTree.search(new Book(bookId, null, null));
		        if (existingBook != null) {
		            JOptionPane.showMessageDialog(null, "A book with this ID already exists.");
		            return;
		        }

		        //If all checks pass, create the new book and insert it into the BST
		        JOptionPane.showMessageDialog(null, "Book created successfully.", "Book created", JOptionPane.INFORMATION_MESSAGE);
		        Book newBook = new Book(bookId, name, publisher);
		        bookTree.insert(newBook);
		        try {
					bookTree.inorderToFile("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Books.txt");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error writing to file.");
		            return;
				}
		        System.out.println("Inserted book with ID " + bookId + " into the BinarySearchTree.");
		        
		        
		        //Clear the text fields
		        txtBookID.setText("");
		        txtName.setText("");
		        txtPublisher.setText("");

			}
		});
		btnNewButton.setBounds(43, 268, 128, 54);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBookID.setText("");
		        txtName.setText("");
		        txtPublisher.setText("");
			}
		});
		btnClear.setBounds(200, 268, 128, 54);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnClear);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setBounds(143, 59, 322, 37);
		txtName.setColumns(10);
		contentPane.add(txtName);
		
		txtBookID = new JTextField();
		txtBookID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtBookID.setColumns(10);
		txtBookID.setBounds(168, 130, 299, 37);
		contentPane.add(txtBookID);
		
		txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(185, 197, 280, 37);
		contentPane.add(txtPublisher);
		
	}
}
