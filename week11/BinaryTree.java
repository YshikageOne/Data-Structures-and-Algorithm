package week11;

import java.util.*;

import javax.swing.JOptionPane;

public class BinaryTree {
	
	private Node root;
	
	//Constructor
	public BinaryTree() {
		root = null;
	}
	
	//Methods
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	//Adding Nodes
	public void addNode(int data) {
		root = add(root, data);
	}
	
	private Node add(Node node, int data) {
		if(isEmpty()) {
			root = new Node(data);
		}else {
			if(!duplicateChecker(data)) {
				Queue<Node> queue = new LinkedList<Node>();
				queue.add(node);
				
				while(!queue.isEmpty()) {
					node = queue.peek();
					queue.remove();
					
					if(node.getLeft() == null) {
						node.setLeft(new Node(data));
						break;
					}else {
						queue.add(node.getLeft());
					}
					
					if(node.getRight() == null) {
						node.setRight(new Node(data));
						break;
					}else {
						queue.add(node.getRight());
					}
			    }
			
			}else {
				JOptionPane.showMessageDialog(null, "Error: Duplicate data " + data + " cannot be added to the tree.");
			}
		}
		return root;
	}
	
	//Removing nodes
	public void remove(int data) {
	    root = remove(root, data);
	}

	private Node remove(Node root, int data) {
	    if (root == null) {
	        return root;
	    }
	    if (data < root.getData()) {
	        root.setLeft(remove(root.getLeft(), data));
	    } else if (data > root.getData()) {
	        root.setRight(remove(root.getRight(), data));
	    } else {
	        //node with no leaf nodes
	        if (root.getLeft() == null && root.getRight() == null) {
	            return null;
	        } else if (root.getLeft() == null) {
	            //node with one node (no left node)
	            return root.getRight();
	        } else if (root.getRight() == null) {
	            //node with one node (no right node)
	            return root.getLeft();
	        } else {
	            //nodes with two nodes
	            //search for min number in right sub tree
	            Node temp = findMinNode(root.getRight());
	            root.setData(temp.getData());
	            
	            // delete the value from right subtree.
	            root.setRight(remove(root.getRight(), temp.getData()));
	        }
	    }
	    return root;
	}

	private Node findMinNode(Node root) {
	    if (root.getLeft() != null) {
	        return findMinNode(root.getLeft());
	    }
	    return root;
	}

	
	
	//Level Order
	public String printLevelOrder() {
		return printLevelOrder(root);
	}
	
	public String printLevelOrder(Node node) {
		String hold = "";
		
		if(isEmpty()) {
			hold = "Tree is empty";
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(node);
			
			while(!queue.isEmpty()) {
				Node newNode = queue.poll();
				
				hold += newNode.getData() + " ";
				
				if(newNode.getLeft() != null) {
					queue.add(newNode.getLeft());
				}
				if(newNode.getRight() != null) {
					queue.add(newNode.getRight());
				}
			}
		}
		return hold;
	}
	
	//In-Order 
	public String printInOrder() {
		return printInOrder(root);
	}
	
	public String printInOrder(Node node) {
		if(node != null) {
			String result = printInOrder(node.getLeft()) + node.getData() + " " + printInOrder(node.getRight());
			return result;
		}else {
			return "";
		}
	}
	
	//Pre-Order
	public String printPreOrder() {
		return printPreOrder(root);
	}
	
	public String printPreOrder(Node node) {
		if(node != null) {
			String result = node.getData() + " " + printPreOrder(node.getLeft()) + printPreOrder(node.getRight());
			return result;
		}else {
			return "";
		}
	}
	
	//Post-Order
	public String printPostOrder() {
		return printPostOrder(root);
	}
	
	public String printPostOrder(Node node) {
		if(node != null) {
			String result = printPostOrder(node.getLeft()) + printPostOrder(node.getRight()) + node.getData() + " ";
			return result;
		}else {
			return "";
		}
	}
	
	//Count
	public int count() {
		return count(root);
	}
	
	private int count(Node node) {
		if(node == null) {
			return 0;
		}else {
			int counter = 1;
			counter += count(node.getLeft());
			counter += count(node.getRight());
			return counter;
		}
	}
	
	//Search for duplicate
	public boolean duplicateChecker(int val) {
		if(isEmpty()) {
			return false;
		}else {
			return duplicateChecker(root, val);
		}
	}
	
	private boolean duplicateChecker(Node node, int val) {
		if(node.getData()==val)
			return true;
		if(node.getLeft() != null)
			if(duplicateChecker(node.getLeft(), val))
				return true;
		if(node.getRight() != null)
			if(duplicateChecker(node.getRight(), val))
				return true;
		return false;
	}
	
	//Search
	public int search(int val) {
	    if(isEmpty()) {
	        return -1;
	    } else {
	        return search(root, val, 1);
	    }
	}

	private int search(Node node, int val, int level) {
	    if(node == null) {
	        return -1;
	    }
	    if(node.getData() == val) {
	        return level; 
	    }
	    int left = search(node.getLeft(), val, level + 1); 
	    if(left != -1) { 
	        return left;
	    }
	    return search(node.getRight(), val, level + 1); 
	}
	
	public void searchAndDisplay(int val) {
	    int result = search(val);
	    if(result != -1) {
	        JOptionPane.showMessageDialog(null, "Value " + val + " is at level " + result);
	    } else {
	        JOptionPane.showMessageDialog(null, "Value " + val + " isn't in the tree");
	    }
	}

	
	
	//Deforestation
	public void cutTheTree() {
		root = null;
	}
	
	//print internal nodes
	public String printParents() {
	    return printParents(root);
	}

	private String printParents(Node node) {
	    if (node == null) {
	        return "";
	    } else {
	        String result = "";
	        if (node.getLeft() != null || node.getRight() != null) {
	            result += node.getData() + " ";
	        }
	        result += printParents(node.getLeft());
	        result += printParents(node.getRight());
	        return result;
	    }
	}

	public String printLeaves() {
	    return printLeaves(root);
	}

	private String printLeaves(Node node) {
	    if (node == null) {
	        return "";
	    } else {
	        String result = "";
	        if (node.getLeft() == null && node.getRight() == null) {
	            result += node.getData() + " ";
	        }
	        result += printLeaves(node.getLeft());
	        result += printLeaves(node.getRight());
	        return result;
	    }
	}
	
	
	public int depth() {
	    return depth(root);
	}

	private int depth(Node node) {
	    if (node == null) {
	        return 0;
	    } else {
	        int leftDepth = depth(node.getLeft());
	        int rightDepth = depth(node.getRight());

	        // Use the larger + 1
	        return Math.max(leftDepth, rightDepth) + 1;
	    }
	}

	
	public int height() {
	    return depth();
	}

	
	public int level() {
	    return level(root);
	}

	private int level(Node node) {
	    if (node == null) {
	        return 0;
	    } else {
	        int leftDepth = level(node.getLeft());
	        int rightDepth = level(node.getRight());

	        return Math.max(leftDepth, rightDepth) + 1;
	    }
	}


	
	public String treeType() {
	    if (isFull(root)) {
	        return "Full";
	    } else if (isComplete(root, 0, count())) {
	        return "Complete";
	    } else {
	        return "Neither full nor complete";
	    }
	}

	private boolean isFull(Node node) {
	    if (node == null) {
	        return true;
	    }

	    //if leaf node
	    if (node.getLeft() == null && node.getRight() == null) {
	        return true;
	    }

	    //if internal node
	    if ((node.getLeft() != null) && (node.getRight() != null)) {
	        return (isFull(node.getLeft()) && isFull(node.getRight()));
	    }

	    //neither full internal node nor a leaf node
	    return false;
	}

	private boolean isComplete(Node node, int index, int numberNodes) {
	    //an empty tree is complete
	    if (node == null) {
	        return true;
	    }

	    //if index assigned to current node is more than number of nodes in a tree,
	    //then the tree is not complete
	    if (index >= numberNodes) {
	        return false;
	    }

	    //recur for left and right subtrees
	    return (isComplete(node.getLeft(), 2 * index + 1, numberNodes)
	            && isComplete(node.getRight(), 2 * index + 2, numberNodes));
	}

}
