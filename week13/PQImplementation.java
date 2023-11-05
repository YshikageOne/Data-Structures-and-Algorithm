package week13;

import java.util.PriorityQueue;

public class PQImplementation {
	
	public static void main(String[] args) {
		//Creating the Priority queue
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		//Insert elements into the queue
		queue.offer(10);
		queue.offer(5);
		queue.offer(15);
		queue.offer(7);
		queue.offer(20);
		
		//Prints the elements in the priority queue
		System.out.println("Elements in the priority queue\t: " + queue);
		
		//Retrieve and remove the highest priority element
		int highestPriority = queue.poll();
		System.out.println("Highest-priority element\t: " + highestPriority);
		
		//Peek at the highest-priority element without removing it
		int peekElement = queue.peek();
		System.out.println("Peeked element\t\t\t: " + peekElement);
		
		//Print the remaining elements in the priority queue
		System.out.println("Elements after removal\t\t: " + queue);
		
		//Check if the priority queue is empty
		boolean isEmpty = queue.isEmpty();
		System.out.println("Is the priority queue empty?\t: " + isEmpty);
	}

}
