package week12;

import java.util.ArrayList;

import adtbt.*;

/**
 * @author Clyde Allen Yu
 */

public class BinarySearchTree extends BinaryTree {

	//Contructor
	public BinarySearchTree() {
		super(); //super is a keyword to call a parent
	}
	
	//Method Wrapper for inserting a node
	public void add(int data) {
		setRoot(insert(getRoot(), data));
	}
	
	//Recursive method that inserts a node into the tree
	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		if(data < node.getData()) {
			node.setLeft(insert(node.getLeft(), data));
		}else if(data > node.getData()) {
			node.setRight(insert(node.getRight(),data));
		}
		return node;
	}

	//Method to search for a value in the BST
	public boolean search(int data) {
		return searchNode(getRoot(), data);
	}
	
	//Recursive method that searches for a value in the tree
	private boolean searchNode(Node node, int data) {
		if(node == null) {
			return false;
		}
		if(data == node.getData()) {
			return true;
		}else if(data < node.getData()) {
			return searchNode(node.getLeft(), data);
		}else {
			return searchNode(node.getRight(), data);
		}
	}
	
	//Method to delete a node from the BST
	public void delete(int data) {
		if(isEmpty()) {
			System.out.println("Tree is empty!");
		}else if(!search(data)) {
			System.out.println(data + " is NOT found");
		}else {
			setRoot(deleteNode(getRoot(), data));
		}
	}
	
	//Recursive method to delete a node from the BST
	private Node deleteNode(Node node, int data) {
		if(node == null) {
			return null;
		}
		if(data < node.getData()) {
			node.setLeft(deleteNode(node.getLeft(), data));
		}else if(data > node.getData()) {
			node.setRight(deleteNode(node.getRight(), data));
		}else {
			//Case 1 : No child or only one child
			if(node.getLeft() == null) {
				return node.getRight();
			}else if(node.getRight() == null) {
				return node.getLeft();
			}
			
			//Case 2 : Two children
			Node minNode = findMin(node.getRight());
			node.setData(minNode.getData());
			node.setRight(deleteNode(node.getRight(), minNode.getData()));
		}
		return node;
	}
	
	//Finds the minimum value in the BST
	public int min() {
		Node minNode = findMin(getRoot());
		return (minNode != null) ? minNode.getData() : -1;
	}
	
	//Recursive method that finds the minimum value in the BST
	private Node findMin(Node node) {
		if(node == null || node.getLeft() == null) {
			return node;
		}
		return findMin(node.getLeft());
	}
	
	//Finds the maximum value in the BST
	public int max() {
		Node maxNode = findMax(getRoot());
		return (maxNode != null) ? maxNode.getData() : -1;
	}
	
	//Recursive Method that finds the maximum value in the BST
	private Node findMax(Node node) {
		if(node == null || node.getRight() == null) {
			return node;
		}
		return findMax(node.getRight());
	}
	
	//Finds the successor value in the BST
	public int successor(int data) {
		
		int value = -1;
		
		Node node = findNode(getRoot(), data);
		
		if(isEmpty()) {
			System.out.println("Node is empty!");
		}else if(!search(data)) {
			System.out.println(data + " is NOT found!");
		}else if(node != null && node.getRight() != null) {
			value = findMin(node.getRight()).getData();
		}else {
			Node successor = findSuccessor(getRoot(), data);
			value = (successor != null) ? successor.getData() : -1;
		}
		return value;
	}
	
	//Method helper for successor
	private Node findSuccessor(Node root, int data) {
		Node current = findNode(root, data); // Find the node with the given key
		Node successor = null;
		Node ancestor = root;
		
		//Traverse the tree to find the successor
		while(ancestor != current) {
			//If the current node is greater than the key
			// update the successor and move to the left subtree
			if(current.getData() < ancestor.getData()) {
				successor = ancestor;
				ancestor = ancestor.getLeft();
			}
			// If the current node is less than the key, move to the right subtree
			else {
				ancestor = ancestor.getRight();
			}
		}
		return successor;
	}
	
	//Finds the predecessor of a given value in the BST
	public int predecessor(int data) {
		
		int value = -1;
		
		Node node  = findNode(getRoot(), data);
		
		if(isEmpty()) {
			System.out.println("Node is empty!");
		}else if(!search(data)) {
			System.out.println(data + " is NOT found!");
		}else if(node != null && node.getLeft() != null) {
			value = findMax(node.getLeft()).getData();
		}else {
			Node predecessor = findPredecessor(getRoot(), data);
			value = (predecessor != null) ? predecessor.getData() : -1;
		}
		return value;
	}
	
	//Method helper for predecessor
	private Node findPredecessor(Node root, int data) {
		Node current = findNode(root, data); // Find the node with the given key
		Node predecessor = null;
		Node ancestor = root;
		
		//Traverse the tree to find the predecessor
		while(ancestor != current) {
			//If the current node is less than the key
			// update the predecessor and move to the right subtree
			if(current.getData() > ancestor.getData()) {
				predecessor = ancestor;
				ancestor = ancestor.getRight();
			}
			// If the current node is less than the key, move to the right subtree
			else {
				ancestor = ancestor.getLeft();
			}
		}
		return predecessor;
	}
	
	//Method that creates a tree from a series of data and rejects duplicates
	/*
	 * @author Clyde Allen T. Yu
	 */
	public void makeTree(int[] values) {
		//Check for duplicates using an ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int value : values) {
			if(list.contains(value)) {
				System.out.println("Duplicate values found. TreeMaking.exe stopped");
				return;
			}
			list.add(value);
		}
		
		//Making the trees
		for(int value : values) {
			this.add(value);
		}
	}
	
	/*
	 * @author Clyde Allen T. Yu
	 */
	//Method to measure time taken for insertion
	public void measureInsertionTime(int data) {
	    long startTime = System.nanoTime();
	    this.add(data);
	    long endTime = System.nanoTime();
	    long timeTaken = endTime - startTime;
	    System.out.println("Time taken for insertion: " + timeTaken + " nanoseconds");
	}

	//Method to measure time taken for deletion
	public void measureDeletionTime(int data) {
	    long startTime = System.nanoTime();
	    this.delete(data);
	    long endTime = System.nanoTime();
	    long timeTaken = endTime - startTime;
	    System.out.println("Time taken for deletion: " + timeTaken + " nanoseconds");
	}

	//Method to measure time taken for searching
	public void measureSearchTime(int data) {
	    long startTime = System.nanoTime();
	    this.search(data);
	    long endTime = System.nanoTime();
	    long timeTaken = endTime - startTime;
	    System.out.println("Time taken for searching: " + timeTaken + " nanoseconds");
	}
	
}