package FinalProject.ADT;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Clyde Allen Yu
 */

public class BinarySearchTree<T extends Comparable<T>>{

	  private Node<T> root;
	  
	  //Node class
	  public class Node<T>{
		  
		  T key;
		  Node<T> left, right;
		  
		  public Node(T item) {
			  key = item;
			  left = right = null;
		  }
	  }
	  
	  //Constructor
	  public BinarySearchTree() {
		  root = null;
	  }
	  
	  public void insert(T key) {
		  root = insertRec(root, key);
	  }
	  
	  private Node<T> insertRec(Node<T> root, T key) {
		  if(root == null) {
			  root = new Node<T>(key);
			  return root;
		  }
		  if(key.compareTo(root.key) < 0) {
			  root.left = insertRec(root.left, key);
		  }else if(key.compareTo(root.key) > 0) {
			  root.right = insertRec(root.right, key);
		  }
		  return root;
	  }
	  
	  public void deleteKey(T key) {
		  root = deleteRec(root, key);
	  }
	  
	  private Node<T> deleteRec(Node<T> root, T key){
		  if(root == null) {
			  return root;
		  }
		  if(key.compareTo(root.key) < 0) {
			  root.left = deleteRec(root.left, key);
		  } else if(key.compareTo(root.key) > 0) {
			  root.right = deleteRec(root.right, key);
		  }else {
			  if(root.left == null) {
				  return root.right;
			  }else if(root.right == null) {
				  return root.left;
			  }
			  
			  root.key = minValue(root.right);
			  root.right = deleteRec(root.right, root.key);
		  }
		  return root;
	  }
	  
	  public boolean isEmpty() {
		    return root == null;
		}

		public T maxValue() {
		    if (root == null) {
		        return null;
		    }
		    Node<T> current = root;
		    while (current.right != null) {
		        current = current.right;
		    }
		    return current.key;
		}
	  
	  public T minValue(Node<T> root) {
		  T minv = root.key;
		  
		  while(root.left != null) {
			  minv = root.left.key;
			  root = root.left;
		  }
		  
		  return minv;
	  }
	  
	  public void clear() {
		    root = null;
	  }
	  
	  public T search(T key) {
		    return searchRec(root, key);
		}

	  private T searchRec(Node<T> root, T key) {
		    if (root == null) {
		        return null;
		    }
		    if (key.compareTo(root.key) < 0) {
		        return searchRec(root.left, key);
		    } else if (key.compareTo(root.key) > 0) {
		        return searchRec(root.right, key);
		    } else {
		        return root.key;
		    }
		}
		
	  public int size() {
		    return sizeRec(root);
		}

		private int sizeRec(Node<T> root) {
		    if (root == null) {
		        return 0;
		    } else {
		        return(sizeRec(root.left) + 1 + sizeRec(root.right));
		    }
		}
		
		public List<T> inorder() {
		    List<T> keys = new ArrayList<>();
		    inorderRec(root, keys);
		    return keys;
		}

		private void inorderRec(Node<T> root, List<T> keys) {
		    if (root != null) {
		        inorderRec(root.left, keys);
		        keys.add(root.key);
		        inorderRec(root.right, keys);
		    }
		}


	  //Method that gets all of the nodes in the tree and writes it to a text document
	  public void inorderToFile(String filename) throws IOException {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		    inorderRecToFile(root, writer);
		    writer.close();
		}

	  private void inorderRecToFile(Node<T> root, BufferedWriter writer) throws IOException {
		    if (root != null) {
		        inorderRecToFile(root.left, writer);
		        writer.write(root.key.toString());
		        writer.newLine();
		        inorderRecToFile(root.right, writer);
		    }
		}
}