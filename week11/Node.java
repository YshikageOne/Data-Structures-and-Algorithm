package week11;

public class Node{
	
	//data attributes
	public Node left, right;
	public int data;
	
	//Creators
	
	//Default constructor
	public Node() {
		left = right = null;
		data = 0;
	}
	
	//Parameterized constructor
	public Node(int data) {
		left = right = null;
		this.data = data;
	}

	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}