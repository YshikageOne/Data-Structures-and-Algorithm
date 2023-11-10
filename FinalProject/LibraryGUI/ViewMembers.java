package FinalProject.LibraryGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Member;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ViewMembers extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private BinarySearchTree<Member> memberTree;
    private JTextField txtSearch;


    public ViewMembers(BinarySearchTree<Member> memberTree) {
    	setResizable(false);
    	this.memberTree = memberTree;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 347);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Define the columns for the table
        String[] columnNames = {"ID", "Name", "Age", "Course", "Year"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        //calling upon the method
        try {
            populateTableFromFile("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Members.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add the table to a scroll pane in case the data overflows the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 0, 924, 273);
        contentPane.add(scrollPane);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSelectedRows();
        	}
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnDelete.setBounds(20, 284, 89, 23);
        contentPane.add(btnDelete);
        
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBack.setBounds(835, 284, 89, 23);
        contentPane.add(btnBack);
        
        JLabel lblNewLabel = new JLabel("Search :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(297, 283, 89, 24);
        contentPane.add(lblNewLabel);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSearch.setBounds(384, 283, 176, 25);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searchText = txtSearch.getText();
                searchTable(searchText);
        	}
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnSearch.setBounds(582, 284, 89, 23);
        contentPane.add(btnSearch);
        
        JButton btnClearAll = new JButton("Clear All");
        btnClearAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all?", "Confirm",
        	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	        if (response == JOptionPane.YES_OPTION) {
        	        	DefaultTableModel model = (DefaultTableModel) table.getModel();
        	        	model.setRowCount(0);

        	            // Clear the BST
        	        	memberTree.clear();

        	            // Clear the text file
        	            try {
        	                new FileWriter("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Members.txt").close();
        	            } catch (IOException e1) {
        	                JOptionPane.showMessageDialog(null, "Error clearing the file.");
        	            }
        	        }
        	}
        });
        btnClearAll.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnClearAll.setBounds(119, 283, 114, 23);
        contentPane.add(btnClearAll);
        btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI back = new LibraryGUI();
		        back.setVisible(true);
		        dispose();
		    }
		});
    }
    
    private void populateTableFromFile(String filename) throws IOException {
        tableModel.setRowCount(0);

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 5) {
                continue;
            }
            Object[] row = {details[0], details[1], details[2], details[3], details[4]};
            tableModel.addRow(row);
        }
        reader.close();
    }
    
    //Method that searches the table
    private void searchTable(String searchText) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchText));
    }
    
    private void deleteSelectedRows() {
        int[] selectedRows = table.getSelectedRows();
        String filepath = "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Members.txt";

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            String studentIDString = (String) tableModel.getValueAt(selectedRows[i], 0);
            int studentID = Integer.parseInt(studentIDString);
            Member member = new Member(studentID, null, 0, null, 0);  //Create a member with the same ID as the member to be deleted
            memberTree.deleteKey(member);  //Delete the member from the memberTree
            tableModel.removeRow(selectedRows[i]);  //Remove the row from the table

            try {
                // Read the file into a string
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();

                // Remove the line containing the student ID
                String contentStr = content.toString().replaceFirst(studentIDString + ".*\n?", "");

                // Write the modified string back to the file
                FileWriter writer = new FileWriter(filepath);
                writer.write(contentStr);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}