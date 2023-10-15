package week10;

import java.util.LinkedList;

/*
 * 
 * 
 * LinkedList
 * 
 * Singly LinkedList
 * 
 *      Node				Node				Node
 * [data | address] -> [data | address] -> [data | address]
 * 
 * 
 * Doubly LinkedList
 * 
 *  		Node    					   Node
 * [address | data | address] <--> [address | data | address]
 * 
 * 
 * 
 */
public class LinkedListv1 {
	
	public static void main(String[] args) {
		
		//Create a new LinkedList
		LinkedList<String> list = new LinkedList<String>();
		
		//Adding elements to the list
		list.add("FirstElement");
		list.add("SecondElement");
		list.add("ThirdElement");
		list.add("FourthElement");
		
		//Access the elements
		/*
		String firstElement = list.getFirst();
		String lastElement = list.getLast();
		
		System.out.println("First element: " + firstElement);
		System.out.println("Last element: " + lastElement);
		*/
		
		System.out.println("LinkedList: " + list);
		
		//Remove Elements from the list
		list.removeFirst();
		list.removeLast();
		
		System.out.println("\nUpdated LinkedList:	" + list);
		
		//Iterating over the elements
		System.out.println("\nUpdated LinkedList: ");
		for(String element : list) {
			System.out.println(element);
		}
		
		
		//Check if the LinkedList contains a specified element
		boolean containsElement = list.contains("SecondElement");
		System.out.println("\nContains SecondElement: " + containsElement);
		
		//Get the size of the LinkedList
		System.out.println("\nLinkedList size: " + list.size());
		
		//Clear
		list.clear();
		System.out.println("LinkedList is empty: " + list.isEmpty());
		
	}

}
