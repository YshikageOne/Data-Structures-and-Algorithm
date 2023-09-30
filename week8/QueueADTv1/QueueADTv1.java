package week8.QueueADTv1;

import javax.swing.JOptionPane;

/** Queue is a FIFO(First-in First-out) algorithm
 * @author Clyde Allen T. Yu
 */
public class QueueADTv1 {

	private int num[];
	private int front, rear, capacity;
	
	//Default Constructor
	public QueueADTv1() {
		capacity = 5;
		num = new int[capacity];
		front = rear = -1;
	}
	
	//Paramenterized Constructor
	public QueueADTv1(int capacity) {
		this.capacity = capacity;
		num = new int[capacity];
		front = rear = -1;
	}
	
	public boolean isEmpty() {
		return (rear == -1);
	}
	
	public boolean isFull() {
		return (rear == capacity - 1);
	}
	
	//Error Message
	private void errorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Full", JOptionPane.ERROR_MESSAGE);
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			errorMessage("Queue is Full!");
		}else {
			num[++rear] = data;
			front = 0;
		}
	}
	
	public int dequeue() {
		int val = 0;
		if(isEmpty()) {
			errorMessage("Queue is Empty!");
			front = -1;
		}else {
			val = num[front];
			
			for(int i = 0; i<rear; i++) {
				num[i] = num[i+1];
			}
			
			rear--;
		}
		
		return val;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.err.println("Queue is empty");
			return - 1;
		} else {
			return num[front];
		}
	}
	
	public int last() {
		if(isEmpty()) {
			errorMessage("Queue is empty");
			return - 1;
		}else {
			return num[rear];
		}
	}
	
	public int frontValue() {
		return num[front];
	}
	
	public int rearValue() {
		return num[rear];
	}
	
	public int getCurrentSize() {
		return capacity - (capacity - (rear + 1));
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String display() {
		String hold = "";
		if(!isEmpty()) {
			for(int i = front; i <= rear; i++) {
				hold += num[i] + " ";
			}
		}else {
			hold = "Queue is empty";
		}
		
		return hold;
	}

	public String display2() {
		
		String hold = "head<-";
		
		if(!isEmpty()) {
			for(int i = front; i <= rear; i++) {
				hold += num[i] + " ";
			}
		}else {
			hold = "Queue is empty";
		}
		
		return hold + "<-rear";
	}

	public String display3() {
		String hold = "";
		
		if(!isEmpty()) {
			for(int i = front; i<= rear; i++) {
				hold = num[i] + " " + hold;
			}
		}else {
			hold = "Queue is empty";
		}
		
		return "rear->" + hold + "->head";
	}
	
}
