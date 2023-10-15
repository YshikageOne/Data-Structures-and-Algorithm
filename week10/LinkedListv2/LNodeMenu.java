package week10.LinkedListv2;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class LNodeMenu extends JFrame implements ActionListener, ItemListener, KeyListener {
	
	 private JLabel lblChoose, lblValue, lblPosition;
	 private JTextField txtValue, txtPosition;
	 private JComboBox cboChoose;
	 private JTextArea txtAreaUp, txtAreaDown;
	 private JButton btnProcess, btnClose;
	 private LNode myNode;
	 String hold = "";
	 
	 LNodeMenu(){
		 
		 myNode = new LNode();
		 lblChoose = new JLabel("Choose");
		 
		 //Creating a menu list
		 String menu[] = {
			"Add at First", "Add at Position", "Add at Last", 
			"Delete at First", "Delete at Position", "Delete at Last",
			"Get First", "Get Position", "IndexAt", "Get Last",
			"Add in Middle", "Delete in Middle"
		 };
		 
		 cboChoose = new JComboBox(menu);
		 txtAreaUp = new JTextArea();
		 txtAreaDown = new JTextArea();
		 btnProcess = new JButton("Process");
		 btnClose = new JButton("Close");
		 lblValue = new JLabel("Value");
		 lblPosition = new JLabel("Position");
		 txtValue = new JTextField();
		 txtPosition = new JTextField();
		 txtPosition.setEditable(false);
		 
		 //setting the title and size of the window
		 setTitle("Made by Clyde Allen T. Yu");
		 setSize(400, 300);
		 
		 //setting the background
		 getContentPane().setBackground(new Color(100, 50, 90, 80));
		 setLayout(null);
		 
		 //making the textFields not editable
		 txtAreaUp.setEditable(false);
		 txtAreaDown.setEditable(false);
		 
		 //Observers for the node
		 hold = "Empty\t: " + myNode.isEmpty() + 
				 "\tCurrentSize\t: " + myNode.currentSize();
		 txtAreaUp.setText(hold);
		 
		 //Positioning
		 add(txtAreaUp).setBounds(20,20,330,20);
		 add(new JScrollPane(txtAreaDown)).setBounds(20,40,330,100);
		 add(lblChoose).setBounds(20,140,60,20);
		 add(cboChoose).setBounds(80,140,150,20);
		 add(btnProcess).setBounds(240,140,110,60);
		 add(lblValue).setBounds(20,160,100,20);
		 add(lblPosition).setBounds(20,180,100,20);
		 add(txtValue).setBounds(80,160,150,20);
		 add(txtPosition).setBounds(80,180,150,20);
		 
		 setLocationRelativeTo(null);
		 setVisible(true);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setResizable(false); 	
		 
		 //Clicky Functions
		 btnProcess.addActionListener(this);
		 cboChoose.addItemListener(this);
		 txtPosition.addKeyListener(this);
		 txtValue.addKeyListener(this);
		 btnProcess.setEnabled(false);
	 }
	 
	 public static void main(String[] args) {
		new LNodeMenu();
	}

	 //Adding the Listeners
	 
	 public void actionPerformed(ActionEvent e) {
		 
		 //returns the index value of the combobox
		 int chosen = cboChoose.getSelectedIndex();
		 int pos;
		 		 
		 //selection for each index
		 switch (chosen) {
		 case 0: //Add at First
			 myNode.addAtFirst(txtValue.getText());
			 break;
		 case 1: //Add at Position
			 myNode.addAtPosition(txtValue.getText(), Integer.parseInt(txtPosition.getText()));
			 break;
		 case 2: //Add at Last
			 myNode.addAtLast(txtValue.getText());
			 break;
		 case 3: //Delete at First
			 myNode.deleteAtFirst();
			 break;
		 case 4: //Delete at Position
			 myNode.deleteAtPosition(Integer.parseInt(txtPosition.getText()));
			 break;
		 case 5: //Delete at Last
			 myNode.deleteAtLast();
			 break;
		 case 6: //Get First
			 String hold = "The first node is " + myNode.getFirst();
			 JOptionPane.showMessageDialog(null, hold);
			 break;
		 case 7: //Get Position
			 String hold1 = "The value of index " + Integer.parseInt(txtPosition.getText()) + " is " + myNode.get(Integer.parseInt(txtPosition.getText()));
			 JOptionPane.showMessageDialog(null, hold1);
			 break;
		 case 8: //IndexAt
			 String hold2 = "The position/index of " + txtValue.getText() + " is " + myNode.indexAt(txtValue.getText());
			 JOptionPane.showMessageDialog(null, hold2);
			 break;
		 case 9: //Get Last
			 String hold3 = "The last node is " + myNode.getLast();
			 JOptionPane.showMessageDialog(null, hold3);
			 break;
		 case 10: //Add in Middle
			 myNode.addInMiddle(txtValue.getText());
			 break;
		 case 11: //Delete in Middle
			 myNode.deleteInMiddle();
			 break;
		 }
		 
		 //Displaying the elements of LinkedList to TextArea
		 txtAreaDown.setText(myNode.traverse());
		 
		 //Clearing the text area
		 txtPosition.setText("");
		 txtValue.setText("");
		 
		 hold = "Empty\t: " + myNode.isEmpty() + "\tCurrent Size: " + myNode.currentSize();
		 
		 txtAreaUp.setText(hold);
		 btnProcess.setEnabled(false);
	 }
	 
	 //Activating and Deactivating components based on the combo box selection
	 public void itemStateChanged(ItemEvent e) {
		 
		 int i = cboChoose.getSelectedIndex();
		 
		 switch(i) {
		 case 0: //Add at First
			 disable();
			 btnProcess.setEnabled(true);
			 break;
		 case 1: //Add at Position
			 enable();
			 btnProcess.setEnabled(true);
			 break;
		 case 2: //Add at Last
			 disable();
			 btnProcess.setEnabled(true);
			 break;
		 case 3: //Delete at First
			 disableAll();
			 btnProcess.setEnabled(true);
			 break;
		 case 4: //Delete at Position
			 disableAll();
			 btnProcess.setEnabled(true);
			 txtPosition.setEditable(true);
			 break;
		 case 5: //Delete at Last
			 disableAll();
			 btnProcess.setEnabled(true);
			 break;
		 case 6: //Get First
			 disableAll();
			 btnProcess.setEnabled(true);
			 break;
		 case 7: //Get Position
			 disableAll();
			 txtPosition.setEditable(true);
			 btnProcess.setEnabled(true);
			 break;
		 case 8: //IndexAt
			 disable();
			 btnProcess.setEnabled(true);
			 break;
		 case 9: //Get Last
			 disableAll();
			 btnProcess.setEnabled(true);
		 case 10: //Add in Middle
			 disable();
			 btnProcess.setEnabled(true);
			 break;
		 case 11: //Delete in Middle
			 disableAll();
			 btnProcess.setEnabled(true);
			 break;
		 }
		 
	 }
	 
	 //Methods for the itemStateChange
	 public void enable() {
		 txtValue.setEditable(true);
		 txtPosition.setEditable(true);
	 }
	 public void disable() {
		 txtValue.setEditable(true);
		 txtPosition.setEditable(false);
	 }
	 public void disableAll() {
		 txtValue.setEditable(false);
		 txtPosition.setEditable(false);
	 }
	 
	 //Other Implementations
	 public void keyPressed(KeyEvent arg0) {
		 
	 }
	 
	 //Activate or Deactivate button when correct data is entered in a textfield
	 public void keyReleased(KeyEvent e) {
		 if(e.getSource().equals(txtValue)) {
			 if(txtValue.getText().isEmpty()) {
				 btnProcess.setEnabled(false);
			 }else {
				 btnProcess.setEnabled(true);
			 }
		 }else if(e.getSource().equals(txtPosition)) {
			 if(txtPosition.getText().isEmpty()) {
				 btnProcess.setEnabled(false);
			 }else {
				 btnProcess.setEnabled(true);
			 }
		 }
	 }
	 
	 public void keyTyped(KeyEvent e) {
		 if(e.getSource().equals(txtPosition)) {
			 if(!(Character.isDigit(e.getKeyChar()))) {
				 e.consume();
			 }
		 }else if(e.getSource().equals(txtValue)) {
			 if(!(Character.isAlphabetic(e.getKeyChar()))) {
				 e.consume();
			 }
		 }

	 }
	 
}
