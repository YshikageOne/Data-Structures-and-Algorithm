package FinalProject.LibraryGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Member;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddMembers extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentID;
	private JTextField txtName;
	private JTextField txtAge;
	private BinarySearchTree<Member> memberTree;

	/**
	 * Create the frame.
	 */
	public AddMembers(BinarySearchTree<Member> memberTree) {
		this.memberTree = memberTree;
		setTitle("Add Members!!!!!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Info");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(116, 10, 208, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lbID = new JLabel("ID :");
		lbID.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbID.setBounds(57, 63, 48, 28);
		contentPane.add(lbID);
		
		JLabel Name = new JLabel("Name :");
		Name.setFont(new Font("Tahoma", Font.BOLD, 25));
		Name.setBounds(57, 114, 98, 28);
		contentPane.add(Name);
		
		JLabel Age = new JLabel("Age :");
		Age.setFont(new Font("Tahoma", Font.BOLD, 25));
		Age.setBounds(56, 166, 78, 28);
		contentPane.add(Age);
		
		JLabel lblCourse_1 = new JLabel("Course :");
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCourse_1.setBounds(57, 218, 115, 28);
		contentPane.add(lblCourse_1);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblYear.setBounds(57, 277, 97, 28);
		contentPane.add(lblYear);
		
		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtStudentID.setColumns(10);
		txtStudentID.setBounds(126, 57, 272, 37);
		contentPane.add(txtStudentID);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setColumns(10);
		txtName.setBounds(158, 109, 241, 37);
		contentPane.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAge.setColumns(10);
		txtAge.setBounds(146, 163, 255, 37);
		contentPane.add(txtAge);
		
		JComboBox cboCourse = new JComboBox();
		cboCourse.setModel(new DefaultComboBoxModel(new String[] {"CS", "IS", "IT", "EMC"}));
		cboCourse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cboCourse.setBounds(169, 211, 232, 42);
		contentPane.add(cboCourse);
		
		JComboBox cboYear = new JComboBox();
		cboYear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cboYear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cboYear.setBounds(158, 270, 240, 42);
		contentPane.add(cboYear);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentIDStr = txtStudentID.getText();
		        String name = txtName.getText();
		        String ageStr = txtAge.getText();
		        String course = cboCourse.getSelectedItem().toString();
		        String yearStr = cboYear.getSelectedItem().toString();

		        //Check if any of the fields are empty
		        if (studentIDStr.isEmpty() || name.isEmpty() || ageStr.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "All fields must be filled out.");
		            return;
		        }

		        //Check if the student ID, age, and year are valid numbers
		        int studentID, age, year;
		        try {
		            studentID = Integer.parseInt(studentIDStr);
		            age = Integer.parseInt(ageStr);
		            year = Integer.parseInt(yearStr);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Student ID, Age, and Year must be numbers.");
		            return;
		        }

		        //Check if the student ID already exists in the BST
		        Member existingMember = memberTree.search(new Member(studentID, null, 0, null, 0));
		        if (existingMember != null) {
		            JOptionPane.showMessageDialog(null, "A member with this ID already exists.");
		            return;
		        }

		        //If all checks pass, create the new member and insert it into the BST
		        JOptionPane.showMessageDialog(null, "Member created successfully.", "Member created", JOptionPane.INFORMATION_MESSAGE);
		        Member newMember = new Member(studentID, name, age, course, year);
		        memberTree.insert(newMember);
		        try {
		            memberTree.inorderToFile("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Members.txt");
		        } catch (IOException e1) {
		            JOptionPane.showMessageDialog(null, "Error writing to file.");
		            return;
		        }
		        System.out.println("Inserted member with ID " + studentID + " into the BinarySearchTree.");

		        // Clear the text fields
		        txtStudentID.setText("");
		        txtName.setText("");
		        txtAge.setText("");
		        cboCourse.setSelectedIndex(0);
				cboYear.setSelectedIndex(0);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegister.setBounds(50, 333, 122, 35);
		contentPane.add(btnRegister);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStudentID.setText("");
				txtName.setText("");
				txtAge.setText("");
				cboCourse.setSelectedIndex(0);
				cboYear.setSelectedIndex(0);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(179, 333, 122, 35);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryGUI addBooks = new LibraryGUI();
		        addBooks.setVisible(true);
		        dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(311, 333, 122, 35);
		contentPane.add(btnBack);
	}
}