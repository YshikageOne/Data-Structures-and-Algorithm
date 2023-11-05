package week13;

import java.util.Arrays;

public class TestMaxHeap {
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(6);
		
		heap.upHeap(4);
		heap.upHeap(8);
		heap.upHeap(2);
		heap.upHeap(1);
		heap.upHeap(7);
		heap.upHeap(10);
		
		System.out.println("Tested by Clyde Allen Yu");
		System.out.println("Heap Elements\t: " + heap.displayHeap());
		
		System.out.println("Extracting Maximum element\t: " + heap.extractMax());
		
		System.out.println("\nBefore Deleting\nHeap elements\t: " + heap.displayHeap());
		heap.deleteNode(1);
		System.out.println("\nAfter Deleting\nHeap elements\t: " + heap.displayHeap());
		
		
		
		
	}

}
