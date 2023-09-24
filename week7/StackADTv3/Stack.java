package week7.StackADTv3;

import java.util.Arrays;
import javax.swing.JOptionPane;

//Made by mr Clyde Allen T. Yu
public class Stack {
	
	private String arr[];
	private int top, capacity;
	
	//Default Constructor
	public Stack() {
		top = -1;
		arr = new String[10];
	}
	
	//Parameterized Constructor
	public Stack(int capacity) {
		top = -1;
		this.capacity = capacity;
		arr = new String[capacity];
	}
	
	
	public boolean isEmpty() {
		return (top <= -1);
	}
	
	public boolean isFull() {
		return (top >= capacity-1);
	}
	
	//Setting the capacity
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		arr = new String[capacity];
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void push(String data) {
	    if (data != null && !data.isEmpty()) {
	        if (isValidWord(data)) {
	            if (!isFull()) {
	                boolean isDuplicate = false;
	                for (int i = 0; i <= top; i++) {
	                    if (arr[i].equals(data)) {
	                        isDuplicate = true;
	                        break;
	                    }
	                }
	                if (!isDuplicate) {
	                    top++;
	                    arr[top] = data;
	                } else {
	                    JOptionPane.showMessageDialog(null, data + " is already in the stack. Duplicate elements not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Stack is Full!", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, data + " is not a valid input. Only words, letters, or numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Invalid input. Null or empty values are not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	public String pop() {
		String hold = "Stack is Empty!";
		if(!isEmpty()) {
			hold = arr[top];
			top--;
		}
		return hold;
	}
	
	public String display() {
		String hold = "";
		
		if(!isEmpty()) {
			for(int i = 0; i <= top; i++) {
				hold += arr[i] + " ";
			}
		}else {
			hold = "Stack is empty!";
		}
		return hold;
	}
	
	public String elements() {
		return Arrays.toString(arr);
	}
	
	public int remaining() {
		return capacity - (top + 1);
	}
	
	//Task 4 New Methods
	//Made by mr Clyde Allen T. Yu
	public int top() {
		return top;
	}
	
	public int size() {
		return top + 1;
	}
	
	public String peek() {
		if(!isEmpty()) {
			return arr[top];
		}else {
			return "Stack is Empty!";
		}
		
	}
	
	public String first() {
		if(!isEmpty()) {
			return arr[0];
		}else {
			return "Stack is Empty!";
		}
		
	}
	
	public String last() {
		if(!isEmpty()) {
			return arr[top];
		}else {
			return "Stack is Empty!";
		}
		
	}
	
	public void edit(String oldValue, String newValue) {
	    if (oldValue != null && !oldValue.isEmpty() && newValue != null && !newValue.isEmpty()) {
	        if (isValidWord(newValue)) {
	            int index = -1;
	            for (int i = 0; i <= top; i++) {
	                if (arr[i].equals(oldValue)) {
	                    index = i;
	                    break;
	                }
	            }

	            if (index != -1) {
	                // Check for duplicates manually
	                boolean isDuplicate = false;
	                for (int i = 0; i <= top; i++) {
	                    if (i != index && arr[i].equals(newValue)) {
	                        isDuplicate = true;
	                        break;
	                    }
	                }

	                if (!isDuplicate) {
	                    String oldData = arr[index];
	                    arr[index] = newValue;
	                    JOptionPane.showMessageDialog(null, "Edited: " + oldData + " to " + newValue, "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(null, newValue + " is already in the stack. Duplicate elements not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, oldValue + " not found in the stack.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, newValue + " is not a valid input. Only words, letters, or numbers are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Invalid input. Null or empty values are not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	
	public boolean search(String data) {
		for (int i = 0; i <= top; i++) {
			if (arr[i].equals(data)) {
				return true;
			}
		}
		return false;
	}
	
	public String get(int index) {
		if (index >= 0 && index <= top) {
			return arr[index];
		} else {
			return "Index out of bounds!";
		}
	}
	
	public String clear() {
		if (!isEmpty()) {
			top = -1;
			return "Stack is cleared.";
		} else {
			return "Stack is empty!";
		}
	}
	
	public String empty() {
		return isEmpty() ? "Yes" : "No";
	}
	
	public String full() {
		return isFull() ? "Yes" : "No";
	}
	
	public boolean isValidWord(String data) {
	    //check if data is a valid word (contains only alphabets)
	    return data.matches("^[a-zA-Z0-9]+$");
	}

	public boolean isValidNumber(String data) {
		//check if data is a valid number
	    try {
	        Double.parseDouble(data);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}
