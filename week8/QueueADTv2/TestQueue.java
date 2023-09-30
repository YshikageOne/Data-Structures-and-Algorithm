package week8.QueueADTv2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Made by mr Clyde Allen T. Yu
public class TestQueue {
	
	public static void main(String[] args) {
		QueueADTv2 queue = new QueueADTv2();
		
		String menu[] = {"Enqueue", 
				         "Dequeue", 
				         "Set New Capacity",
				         "Clear Queue",
				         "Exit"};
		String choice = "", hold = "";
		JOptionPane pane = new JOptionPane();
		
		do {
			hold = "Empty\t: " + queue.isEmpty() + "\tFull\t: " + queue.isFull() +
					"\nCapacity\t: " + queue.getCapacity() + "\tCurrent Size\t: " + queue.getCurrentSize() +
					"\nPeek\t: " + queue.peek() + "\tLast\t: " + queue.last() +
					"\nElements\t: " + queue.display();
			
			choice = pane.showInputDialog(null, new JTextArea(hold),
					 "Made by Clyde Yu", 1, null, menu, menu[0]).toString();
			
			switch (choice) {
			case "Enqueue":
			    String input = pane.showInputDialog("Enter the element to enqueue:");
			    queue.enqueue(input);
			    break;
			    
			case "Dequeue":
			        Object dequeued = queue.dequeue();
			        if (dequeued instanceof Integer) {
			            int dequeuedInt = (Integer) dequeued;
			            JOptionPane.showMessageDialog(null, "Dequeued Integer: " + dequeuedInt);
			        } else if (dequeued instanceof String) {
			            String dequeuedStr = (String) dequeued;
			            JOptionPane.showMessageDialog(null, "Dequeued String: " + dequeuedStr);
			        }
			    break;
			    
			case "Set New Capacity":
			    String newCapacityInput = pane.showInputDialog("Enter the new capacity:");
			    try {
		            int newCapacity = Integer.parseInt(newCapacityInput);
		            queue.setCapacity(newCapacity);
			    } catch (NumberFormatException e) {
		            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for the new capacity.");
		        }
			    break;

			case "Clear Queue":
			    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the queue?", "Confirmation", JOptionPane.YES_NO_OPTION);
			    if (confirmation == JOptionPane.YES_OPTION) {
			        queue.clear();
			        JOptionPane.showMessageDialog(null, "The queue has been cleared.");
			    } else {
			        JOptionPane.showMessageDialog(null, "Queue clearing canceled. The queue remains unchanged.");
			    }
			    break;
			}
			
		}while (!choice.equals("Exit"));
	}
	
}
