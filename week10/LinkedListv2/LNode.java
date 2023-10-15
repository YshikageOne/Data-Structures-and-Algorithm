package week10.LinkedListv2;

import javax.swing.JOptionPane;

import week10.LinkedListStudent.Student;

/*
 * LinkedList is an algorithm that stores data dynamically as it uses memory address.
 * Storing may happen at the beginning, in the middle and at the last. 
 * Same goes to 3 deletion. 
 * It does NOT store the data in a sequential manner, 
 * instead it uses the Node(data, address) 
 * that link between them to forming a chain or link list.
 * 
 * @author Clyde Allen T. Yu
 */

public class LNode<Object> {
	
	private Object data;
	private LNode next; //pointer to next node
	private LNode head; //pointer to head/first node
	
	//method that shows the error message
	public void error_message(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	//constructor
	public LNode() {
		next = head = null;
	}
	
	//indicator that checks the list is empty or not
	public boolean isEmpty() {
		return head == null;
	}
	
	//adding the nodes
	public void addAtFirst(Object value) {
		LNode newNode = new LNode();
		
		if(isEmpty()) {
			newNode.data = value;
			newNode.next = null;
			head = newNode;
		}else {
			newNode.data = value;
			newNode.next = head;
			head = newNode;
		}
	}
	
	//adding the nodes on the last
	public void addAtLast(Object value) {
		if(isEmpty()) {
			addAtFirst(value);
		}else {
			LNode link = head;
			while(link.next != null) {
				link = link.next;
			}
			LNode newNode = new LNode();
			newNode.data = value;
			newNode.next = null;
			link.next = newNode;
		}
	}
	
	//adding the nodes on a specific position
	public void addAtPosition(Object value, int position) {
		if(isEmpty()) {
			error_message("List is Empty. Node is added at the Beginning");
			addAtFirst(value);
		}else if(position == 0) {
			error_message("Node is added at the beginning");
			addAtFirst(value);
		}else if (position < 0 || position > currentSize()) {
			error_message(position + " is NOT valid");
		}else {
			LNode visit, link;
			visit = link = head;
			int ctr = 1;
			while(ctr != position) {
				link = link.next;
				ctr++;
			}
			while(link.next != visit) {
				visit = visit.next;
			}
			LNode newNode = new LNode();
			newNode.data = value;
			newNode.next = visit;
			link.next = newNode;
		}
	}
	
	//shows the current size of the list
	public int currentSize() {
		int counter = 1;
		if(isEmpty()) {
			error_message("List is Empty");
		}else {
			LNode link = head;
			while(link.next != null) {
				link = link.next;
				counter++;
			}
		}
		return counter;
	}
	
	
	//displaying the List
	public String traverse() {
		if(isEmpty()) {
			return "List is Empty";
		}else {
			String hold = "";
			LNode link = head;
			while (link != null) {
				hold += "|" + link.data + "|" + link.next + "|\n";
				link = link.next;
			}
			return "head Node|" + head + "\n" + hold;
		}
	}
	
	//Deleting nodes at first
	public void deleteAtFirst() {
		if(isEmpty()) {
			error_message("Deleting Not Allowed. Linked List is empty");
		}else {
			LNode link = head;
			head = link.next;
			System.out.println("Deleting is Successful!");
		}
	}
	
	//Deleting nodes at last
	public void deleteAtLast() {
		if(isEmpty()) {
			error_message("Deleting Not Allowed. Linked List is empty");
		}else {
			LNode visit, link;
			visit = link = head;
			while(visit.next != null) {
				visit = visit.next;
			}
			while(link.next != visit) {
				link = link.next;
			}
			link.next = null;
			System.out.println("Deleting is Successful");
		}
	}
	
	//Deleting nodes at a specific position
	public void deleteAtPosition(int position) {
		if(isEmpty()) {
			error_message("The list is empty. Try to add a value");
		}else if (position == 0) {
			deleteAtFirst();
		}else if (position < 0 || position >= currentSize()) {
			error_message("Position is NOT valid");
		}else {
			LNode visit, link, pointer;
			visit = link = pointer = head;
			int ctr = 0;
			while(ctr != position) {
				visit = visit.next;
				ctr++;
			}
			while(link.next != visit) {
				link = link.next;
			}
			ctr = 0;
			while(ctr != position + 1) {
				pointer = pointer.next;
				ctr++;
			}
			link.next = pointer;
		}
	}
	
	//getting the first node
	public Object getFirst() {
		 if(isEmpty()) {
			 error_message("The list is empty");
			 return null;
		 }
		 return (Object) head.data;
    }
	
	//getting the last node
	public Object getLast() {
		int ctr = 1;
		if(isEmpty()) {
			error_message("The list is empty");
			return null;
		}else {
			LNode visit = head;
			while(visit.next != null) {
				visit = visit.next;
			}
			return (Object) visit.data;
		}
	}
	
	//Made by mr Clyde Allen T. Yu :D
	//Adding a node in the middle of the list
	public void addInMiddle(Object value) {
		if(isEmpty()) {
			addAtFirst(value);
		}else {
			LNode newNode = new LNode();
			LNode current = head;
			newNode.data = value;
			int position = 0;
			
			while(position < currentSize() / 2 - 1) {
				current = current.next;
				position++;
			}
			
			newNode.next = current.next;
			current.next = newNode;
			
		}
		
	}
    
	//Made by mr Clyde Allen T. Yu :D
	//deleting a node in the middle of the list
	public void deleteInMiddle() {
		if(isEmpty()) { 
			error_message("Deleting Not Allowed. Linked List is empty");
		}else {
			LNode prev = null;
			LNode current = head;
			int position = 0;
			
			 while (position < currentSize() / 2) {
		            prev = current;
		            current = current.next;
		            position++;
		        }

		        if (prev != null) {
		            prev.next = current.next;
		        } else {
		            head = current.next;
		        }
		        
		        System.out.println("Deleting in the middle is Successful!");
		}
	}
	//Made by mr Clyde Allen T. Yu :D
	//deleting a value from the list
	public void deleteValue(Object value) {
		if(isEmpty()) {
			error_message("The list is empty");
		}else {
			LNode current = head;
			LNode prev = null;
			
			while(current != null && !current.data.equals(value)) {
				prev = current;
				current = current.next;
			}
			
			if(current != null) {
				prev.next = current.next;
				 System.out.println("Deleting value is Successful!");
			}
		}
	}
	//Made by mr Clyde Allen T. Yu :D
	//getting the position/index of a value
	public int indexAt(Object value) {
		int position = 0;
		LNode current = head;
		
		while(current != null) {
			if(current.data.equals(value)) {
				return position;
			}
			current = current.next;
			position++;
		}
		
		return -1; //if the value isn't found
	}
	//Made by mr Clyde Allen T. Yu :D
	//getting the value in a specific position
	public Object get(int position) {
		if(position < 0 || position >= currentSize()) {
			error_message("Position is NOT valid");
			return null;
		}
		
		LNode current = head;
		for(int i = 0; i < position; i++) {
			current = current.next;
		}
		return (Object) current.data;
	}
	
	public Object getNode(int position) {
		Object value = null;
		
		if(isEmpty()) {
			error_message("The list is empty");
		}else {
			LNode<Object> pointer = head;
			int ctr = 0;
			
			while(ctr != position) {
				pointer = pointer.next;
				ctr++;
			}
			value = (Object) pointer.data;
		}
		return value;
	}
	
	public String traverseNode() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "List is empty";
		}else {
			LNode<Student> pointer = head;
			int ctr = 0;
			
			while(pointer != null) {
				hold += pointer.data.getStudent() + "\n";
				pointer = pointer.next;
			}
		}
		return hold;
	}
}
