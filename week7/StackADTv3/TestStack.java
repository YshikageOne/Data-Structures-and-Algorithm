package week7.StackADTv3;

import javax.swing.*;

public class TestStack {
	
	//Made by mr Clyde Allen T. Yu
	public static void main(String[] args) {
		Stack st = new Stack(3);
		String menu[] = {"Push", "Pop", "Set Capacity", "Edit", "Search", "Get", "Clear", "End"};
		String choice = "", hold = "";
		String data;
		JOptionPane jop = new JOptionPane();
		
		do {
			
			hold = "Empty\t: " + st.isEmpty() + "\tFull\t: " + st.isFull()
			       + "\nCapacity: " + st.getCapacity() + "\tAvailable\t: " + (st.remaining())
			       + "\nSize\t: " + st.size() + "\tTop\t: " + st.top()
			       + "\nFirst\t: " + st.first() + "\tLast\t: " + st.last()
			       + "\nPeek\t: " + st.peek() + "\nElements\t: " + st.display()
			       + "\nChose";
			
			choice = jop.showInputDialog(null, new JTextArea(hold),
					 "Made by Clyde Yu", 1, null, menu, menu[0]).toString();
			
			switch (choice) {
			case "Push":
			    boolean validInput = false;
			    do {
			        data = jop.showInputDialog("Type data (Non-Empty, Unique, Only alphabet and number): ");
			        if (data != null && !data.isEmpty()) {
			            //check if data is a valid string or a number
			            if (!st.search(data)) { //check for duplicates in the stack
			                if (st.isValidWord(data) || st.isValidNumber(data)) {
			                    st.push(data);
			                    jop.showMessageDialog(null, data + " is inserted.");
			                    validInput = true; //valid input, exit the loop
			                } else {
			                    data = jop.showInputDialog("Invalid! Contains special characters or is not a valid string/number. Type valid data:");
			                }
			            } else {
			                data = jop.showInputDialog(data + " is already in the stack. Duplicate elements not allowed. Type valid data:");
			            }
			        } else {
			            data = jop.showInputDialog("Invalid! Empty value. Type valid data:");
			        }
			    } while (!validInput);
			    break;
			    
		    case "Pop":
		        hold = st.pop();
		        jop.showMessageDialog(null, hold + " is removed.");
		        break;

		    case "Set Capacity":
		        int newCapacity;
		        boolean validInput1 = false;

		        do {
		            try {
		                newCapacity = Integer.parseInt(jop.showInputDialog("Enter new capacity (positive integer):"));
		                if (newCapacity > 0) {
		                    if (!st.isEmpty()) {
		                        int choice1 = JOptionPane.showConfirmDialog(null, "Stack is Not Empty! Do you want to clear the Stack?", "Clear?", JOptionPane.YES_NO_OPTION);
		                        if (choice1 == JOptionPane.YES_OPTION) {
		                            st.clear();
		                            jop.showMessageDialog(null, "Stack cleared.");
		                        }
		                    }
		                    st.setCapacity(newCapacity);
		                    jop.showMessageDialog(null, "Capacity set to " + newCapacity);
		                    validInput1 = true;
		                } else {
		                    jop.showMessageDialog(null, "Invalid input. Please enter a positive integer for capacity.");
		                }
		            } catch (NumberFormatException e) {
		                jop.showMessageDialog(null, "Invalid input. Please enter a valid positive integer for capacity.");
		            }
		        } while (!validInput1);

		        break;



		    case "Edit":
		        String oldValue = jop.showInputDialog("Enter the value to edit:");
		        if (oldValue != null && !oldValue.isEmpty()) {
		            String newValue = jop.showInputDialog("Enter the new value (Words, Letters, Numbers):");
		            if (newValue != null) {
		                st.edit(oldValue, newValue);
		            } else {
		                jop.showMessageDialog(null, "Invalid input for the new value.");
		            }
		        } else {
		            jop.showMessageDialog(null, "Invalid input for the old value.");
		        }
		        break;



		    case "Search":
		        data = jop.showInputDialog("Enter data to search:");
		        if (st.search(data)) {
		            jop.showMessageDialog(null, data + " found in the stack.");
		        } else {
		            jop.showMessageDialog(null, data + " not found in the stack.");
		        }
		        break;

		    case "Get":
		        int getIndex = Integer.parseInt(jop.showInputDialog("Enter the index to get"));
		        if (getIndex >= 0 && getIndex < st.size()) {
		            String element = st.get(getIndex);
		            jop.showMessageDialog(null, "Element at index " + getIndex + ": " + element);
		        } else {
		            jop.showMessageDialog(null, "Invalid index.");
		        }
		        break;


		    case "Clear":
		        jop.showMessageDialog(null, st.clear());
		        break;
		}
			
			
			
		}while(!choice.equals("End"));
	}
}
