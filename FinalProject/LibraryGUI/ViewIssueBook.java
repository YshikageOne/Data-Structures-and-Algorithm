package FinalProject.LibraryGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import FinalProject.ADT.BinarySearchTree;
import FinalProject.ADT.Issue;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class ViewIssueBook extends JFrame {
	
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private BinarySearchTree<Issue> issueTree;

  
    private Object[][] tableData = {
        
    };

    private String[] columnNames = {
        "Issue ID", "Book ID", "Member Name", "Book Name", "Issue Date", "Return Date"
    };
    private JButton btnBack;
    private JTextField txtSearch;

    /**
     * Create the frame.
     */
    public ViewIssueBook(BinarySearchTree<Issue> issueTree) {
    	setResizable(false);
    	this.issueTree = issueTree;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 951, 494);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 900, 400);
        contentPane.add(scrollPane);

       
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        
        //calling upon the method
        try {
            populateTableFromFile("C:\\Users\\ausus\\Desktop\\Coding Stuff\\Java\\lol.zip_expanded\\SchoolWork\\Data Structures\\FinalProject\\Datasets\\Issue.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        scrollPane.setViewportView(table);
        
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 19));
        btnBack.setBounds(20, 412, 98, 36);
        btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI Back = new LibraryGUI();
		        Back.setVisible(true);
		        dispose();
		    }
		});
        contentPane.add(btnBack);
        
        JLabel lblNewLabel = new JLabel("Search :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(128, 411, 98, 39);
        contentPane.add(lblNewLabel);
        
        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtSearch.setBounds(208, 420, 150, 28);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searchText = txtSearch.getText();
                searchTable(searchText);
        	}
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
        btnSearch.setBounds(368, 420, 131, 28);
        contentPane.add(btnSearch);
    }
    
    private void populateTableFromFile(String filename) throws IOException {
        tableModel.setRowCount(0);

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("\\|");
            if (details.length < 7) {
                continue;
            }
            Object[] row = {details[0], details[3], details[2], details[4], details[5], details[6], details[6]};
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

