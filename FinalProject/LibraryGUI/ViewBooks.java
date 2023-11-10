package FinalProject.LibraryGUI;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Book;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class ViewBooks extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private BinarySearchTree<Book> bookTree;
    private JTextField txtSearch;

    public ViewBooks(BinarySearchTree<Book> bookTree) {
    	setResizable(false);
    	this.bookTree = bookTree;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1048, 409);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //table model with columns.
        String[] columnNames = {"Book ID", "Name", "Publisher"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        //calling upon the method
        try {
            populateTableFromFile("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Books.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 1010, 300);
        contentPane.add(scrollPane);

        // Button for deleting selected rows.
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSelectedRows();
       	     }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(10, 336, 100, 23);
        contentPane.add(btnDelete);
        
        JButton btnBackbutton = new JButton("Back");
        btnBackbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBackbutton.setBounds(903, 336, 89, 23);
        contentPane.add(btnBackbutton);
        
        JLabel lblSearch = new JLabel("Search :");
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblSearch.setBounds(315, 326, 126, 37);
        contentPane.add(lblSearch);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSearch.setBounds(451, 336, 166, 24);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String searchText = txtSearch.getText();
                 searchTable(searchText);
        	}
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSearch.setBounds(639, 336, 108, 23);
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
        	        	bookTree.clear();

        	            // Clear the text file
        	            try {
        	                new FileWriter("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Books.txt").close();
        	            } catch (IOException e1) {
        	                JOptionPane.showMessageDialog(null, "Error clearing the file.");
        	            }
        	        }
        	}
        });
        btnClearAll.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnClearAll.setBounds(120, 336, 120, 23);
        contentPane.add(btnClearAll);
        btnBackbutton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI back = new LibraryGUI();
		        back.setVisible(true);
		        dispose();
		    }
		});
        btnDelete.addActionListener(e -> deleteSelectedRows());

    }

    
    private void deleteSelectedRows() {
    	int[] selectedRows = table.getSelectedRows();
        String filepath = "C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Books.txt";

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            String bookIdString = (String) tableModel.getValueAt(selectedRows[i], 0);
            int bookId = Integer.parseInt(bookIdString);
            Book book = new Book(bookId, null, null);  //Create a book with the same ID as the book to be deleted
            bookTree.deleteKey(book);  //Delete the book from the bookTree
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

                // Remove the line containing the book ID
                String contentStr = content.toString().replaceFirst(bookIdString + ".*\n?", "");

                // Write the modified string back to the file
                FileWriter writer = new FileWriter(filepath);
                writer.write(contentStr);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    //Method that populates table with the books from the BST
    private void populateTableFromFile(String filename) throws IOException {
        tableModel.setRowCount(0);

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 3) {
                continue;
            }
            Object[] row = {details[0], details[1], details[2]};
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
}
