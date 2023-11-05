package week13;

/**Abstract data type of Binary Heap
 * arrays[0] is always empty or null 0
 * Starting on the array[1]
 * @author Clyde Allen T. Yu
 */

public class MaxHeap {

	//Data attributes
	private int[] array;
	private int count, capacity, index;
	
	//Default Contructor
	public MaxHeap() {
		capacity = 5;
		array = new int[setArrayMaxIndex(capacity)];
		count = 0;
	}
	
	//Contructor with parameter
	public MaxHeap(int capacity) {
		this.capacity = capacity;
		array = new int[setArrayMaxIndex(capacity)];
		count = 0;
	}
	
	/*Setting the array length twice its capacity to address
	 * issues on ArrayIndexOutOfBounds error due to math formula
	 * in accessing elements in the heap
	 * @param capacity
	 * @return*/
	private int setArrayMaxIndex(int capacity) {
		index = (capacity * 2) + 2;
		return index;
	}
	
	//Returns the number of elements in the heap
	public int heapCount() {
		return count;
	}

	//Checks the capacity 
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count >= (capacity);
	}
	
	//Setters and Getters
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		array = new int[setArrayMaxIndex(capacity)];
		System.out.println(setArrayMaxIndex(capacity));
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	//Insert a value into the heap and maintains the heap property
	public void upHeap(int value) {
		array[count + 1] = value;
		count++;
		int index = count;
		
		while(index > 1 && array[index] > array[index / 2]) {
			//Swap the current element with its parents if it is larger
			int temp = array[index];
			array[index] = array[index / 2];
			array[index / 2] = temp;
			
			index = index / 2; //Move up to the parent index
		}
	}
	
	//Restores the heap property by moving the elements down the heap
	public void heapify() {
		if(count <= 1) {
			return; //No need to down-heap if there's onely one element or no elements
		}
		
		int index = 1;
		
		while(index <= count / 2) {
			int leftChild = index * 2;
			int rightChild = index * 2 + 1;
			//Finding the larger child
			int largerChild = (rightChild <= count && array[rightChild] > array[leftChild]) ? rightChild : leftChild;
			
			//If the larger child is greater than the current element, swap them
			if(array[largerChild] > array[index]) {
				int temp = array[largerChild];
				array[largerChild] = array[index];
				array[index] = temp;
				
				index = largerChild; //Move down to the larger child index
			}else {
				break; //Heap property is restored, stop down-heaping
			}
		}
	}
	
	/*
	 * @author Clyde Allen T. Yu
	 */
	//Delete a specific node from the heap
	public void deleteNode(int value) {
		int index = getIndex(value);
		if(index == -1) {
			return; //Value not found in the heap
		}
		
		//Swap the node with the last element in the heap
		array[index] = array[count];
		count--;
		
		//Perform upHeap or heapify to restore the heap property
		if(index > 1 && array[index] > array[index / 2]) {
			upHeap(array[index]);
		}else {
			heapify();
		}
	}
	
	//Getting the maximum element from the heap
	public int extractMax() {
		if(isEmpty()) {
			return -1; //Heap is empty
		}
		
		//The maximum element is at the root
		int max = array[1];
		
		//Swap the root with the last element
		array[1] = array[count];
		count--;
		
		//Restore the heap
		heapify();
		
		return max;
	}
	
	//Sorts the elements in the heap in descending order
	public int[] heapSort() {
		int sorted[] = new int[count + 1];
		int index = 0;
		
		for(int i = count; i >= i; i--, index++) {
			sorted[index] = array[1]; //Store the maximum element in the sorted array
			array[1] = array[i]; //Move the last element to the root
			count--;
			
			heapify(); //Restore the heap property
		}
		//You can copy the sorted array back to the original array
		return sorted;
	}
	
	public String heapSorting() {
		String hold = "";
		for(int i = count; i >= 1; i--) {
			hold += array[1] + " "; //Store the maximum element in the sorted array
			array[1] = array[i]; //Move the last element to the root
			count--;
			
			heapify(); //Restore the heap property
		}
		return hold;
	}
	
	//Checks if a value already exists in the heap
	public boolean checkDuplicate(int value) {
		for(int i = 1; i <= count; i++) {
			if(array[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	//Helper methodHere's the helper method 'getIndex' that was missing from the previous response
	//Returns the index of the given value in the heap
	private int getIndex(int value) {
		for(int i = 1; i <= count; i++) {
			if(array[i] == value) {
				return i;
			}
		}
		return -1; //Value not found in the heap
	}
	
	//Returns the parent value of the given value in the heap
	public int parent(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		if(index == 1) {
			return -1; //Root Node, no parent
		}
		return array[index / 2];
	}
	
	//Returns the left child value of the given value in the heap
	public int leftChild(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		int leftChild = index * 2;
		if(leftChild > count) {
			return -1; //No left child exists
		}
		return array[leftChild];
	}
	
	//Returns the right child value of the given value in the heap
	public int rightChild(int value) {
		int index = getIndex(value);
		
		if(index == -1) {
			return -1; //Value not found in the heap
		}
		int rightChild = index * 2 + 1;
		if(rightChild > count) {
			return -1; //No right child exists
		}
		return array[rightChild];
	}
	
	//Prints the parents of the elements in the heap
	public String parents() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 2; i <= count; i+= 2) {
				int parent = array[i / 2];
				hold += parent + " ";
			}
		}
		return hold;
	}
	
	//Prints the left children of the elements in the heap
	public String leftChildren() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				int leftChild = array[i * 2];
				if(leftChild == 0) {
					break;
				}else if(leftChild != -1) {
					hold += leftChild + " ";
				}
			}
		}
		return hold;
	}
	
	//Prints the right childrent of the elements in the heap
	public String rightChildren() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				int rightChild = array[i * 2 + 1];
				if(rightChild == 0) {
					break;
				}else if(rightChild != -1) {
					hold += rightChild + " ";
				}
			}
		}
		return hold;
	}
	
	//Prints the leaf nodes of the heap
	public String leaves() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				if(array[i * 2] == -1 && array[i * 2 + 1] == -1) {
					hold += array[i] + " ";
				}
			}
		}
		return hold;
	}
	
	//Prints the elements in the heap
	public String displayHeap() {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Heap is empty!";
		}else {
			for(int i = 1; i <= count; i++) {
				hold += array[i] + " ";
			}
		}
		return hold;
	}
	
	//Resets the heap by clearing the elements
	public void reset() {
		count = 0;
	}
	
	//Print the root
	public int peek() {
		return (isEmpty()) ? -1 : array[1];
	}
}
