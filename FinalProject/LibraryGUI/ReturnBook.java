package FinalProject.LibraryGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Issue;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookID;


	/**
	 * Create the frame.
	 */
	public ReturnBook(BinarySearchTree<Issue> issueTree) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return A Book NOW");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(99, 10, 268, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBookId.setBounds(35, 110, 104, 21);
		contentPane.add(lblBookId);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String bookIDstr = txtBookID.getText();
                String filepath = "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Issue.txt";
                
                //Check if any of the fields are empty
		        if (bookIDstr.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "All fields must be filled out.");
		            return;
		        }
		        
		        //Check if the book ID and member ID are valid numbers
		        int bookID, memberID;
		        try {
		            bookID = Integer.parseInt(bookIDstr);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Book ID must be a number.");
		            return;
		        }
		        
		        try {
		        	// Read the file into a string
		            BufferedReader reader = new BufferedReader(new FileReader(filepath));
		            StringBuilder content = new StringBuilder();
		            String line;
		            while ((line = reader.readLine()) != null) {
		                // Only append lines which do not have bookIDstr as the fourth field
		                String[] fields = line.split("\\|");
		                if (fields.length < 4 || !fields[3].equals(bookIDstr)) {
		                    content.append(line).append("\n");
		                }
		            }
		            reader.close();

		            // The content now does not include lines with the book ID in the fourth field
		            String contentStr = content.toString();
		            JOptionPane.showMessageDialog(null, "Book returned successfully.", "Book returned", JOptionPane.INFORMATION_MESSAGE);

		            // Write the modified string back to the file
		            FileWriter writer = new FileWriter(filepath);
		            writer.write(contentStr);
		            writer.close();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		        
		        txtBookID.setText("");

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmit.setBounds(35, 233, 104, 37);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBookID.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBounds(149, 233, 104, 37);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBounds(263, 233, 104, 37);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI Back = new LibraryGUI();
		        Back.setVisible(true);
		        dispose();
		    }
		});
		contentPane.add(btnBack);
		
		txtBookID = new JTextField();
		txtBookID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBookID.setColumns(10);
		txtBookID.setBounds(149, 105, 218, 30);
		contentPane.add(txtBookID);
	}
}