package week11;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class BinaryTreeMenu extends JFrame implements ActionListener, ItemListener, KeyListener{
	
	//Data attributes
	private JLabel lblChoose, lblValue;
	private JTextField txtValue;
	private JComboBox cboChoose;
	private JTextArea txtAreaUp, txtAreaDown;
	private JButton btnProcess, btnClose;
	private BinaryTree tree;
	String hold = "", traversal = "";
	
	
	//Constructor
	BinaryTreeMenu(){
		
		tree = new BinaryTree();
		
		String menu[] = {"Add Node",
				         "Remove Node",
				         "Search",
				         "Cut the Tree",
				         "End"};
		
		cboChoose = new JComboBox(menu);
		txtAreaUp = new JTextArea();
		txtAreaDown = new JTextArea();
		btnProcess = new JButton("Process");
		btnClose = new JButton("Close");
		txtValue = new JTextField();
		txtAreaUp.setEditable(false);
		txtAreaDown.setEditable(false);
		lblChoose = new JLabel("Choose: ");
		lblValue = new JLabel("Value: ");
		
		setTitle("Binary Tree Application by Clyde Yu");
		setSize(400,300);
		getContentPane().setBackground(new Color(100,50,90,80));
		setLayout(null);
		setResizable(false);
		
		display();
	
		add(txtAreaUp).setBounds(20,20,330,60);
		add(new JScrollPane(txtAreaDown)).setBounds(20,80,330,100);
		add(lblChoose).setBounds(20,200,60,20);
		add(cboChoose).setBounds(80,200,150,20);
		add(btnProcess).setBounds(240,200,110,60);
		add(lblValue).setBounds(20,230,100,20);
		add(txtValue).setBounds(80,230,150,20);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btnProcess.addActionListener(this);
		cboChoose.addItemListener(this);
		txtValue.addKeyListener(this);
		btnProcess.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new BinaryTreeMenu();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		int i = cboChoose.getSelectedIndex();
		int value = Integer.parseInt(txtValue.getText());
		
		switch(i){
		case 0: //add node
			tree.addNode(value);
			break;
		case 1: //remove Node
			tree.remove(value);
			break;
		case 2: //search node
			tree.searchAndDisplay(value);
			break;
		case 3: //cut the tree
			tree.cutTheTree();
			break;
		case 4: //exit
			System.exit(0);
		};
		
		display();
		btnProcess.setEnabled(false);
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		int i = cboChoose.getSelectedIndex();
		
		switch(i){
		case 0: //add node
			enable();
			break;
		case 1: //remove Node
			enable();
			break;
		case 2: //search node
			enable();
			break;
		case 3: //cut the tree
			disable();
			btnProcess.setEnabled(true);
			break;
		case 4: //exit
			txtValue.setText("0");
			txtValue.setEditable(false);
			btnProcess.setEnabled(true);
		};
		
	}
	
	public void enable() {
		txtValue.setEditable(true);
	}
	public void disable() {
		txtValue.setEditable(false);
	}	

	
	public void keyPressed(KeyEvent arg0) {
		
	}

	
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtValue)) {
			if(!(Character.isDigit(e.getKeyChar()))) {
				e.consume();
			}
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtValue)) {
			if(txtValue.getText().isEmpty()) {
				btnProcess.setEnabled(false);
			}else {
				btnProcess.setEnabled(true);
			}
		}
	}
	
	void display() {
		traversal = "Level Order\t: " + tree.printLevelOrder() +
				    "\nIn-Order\t: " + tree.printInOrder() +
				    "\nPre-Order\t: " + tree.printPreOrder() +
				    "\nPost-Order\t: " + tree.printPostOrder() +
				    "\nInternal Nodes\t: " + tree.printParents() +
				    "\nLeaves\t: " + tree.printLeaves();
		
		txtAreaDown.setText(traversal);
		
		hold = "Empty\t: " + tree.isEmpty() +
			   "\tCurrent Nodes\t: " + tree.count() +
			   "\nDepth\t: " + tree.depth() + 
			   "\tHeight\t: " + tree.height() +
			   "\nLevel\t: " + tree.level() +
			   "\tType\t: " + tree.treeType();
		
		txtAreaUp.setText(hold);
				    
	}
	
}
