package week11.TreeTraversal;

public class Traversal {
	
	//Nodes
	public class NodeTraversal{
		
		int data;
		NodeTraversal left;
		NodeTraversal right;
		
		public NodeTraversal(int data) {
			this.data = data;
		}
	}
	
	//In-Order left -> root -> right
	private void inOrderTraversal(NodeTraversal root) {
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	//Post-Order left -> right -> root
	private void postOrderTraversal(NodeTraversal root) {
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}
	
	//Pre-Order root -> left -> right
	private void preOrderTraversal(NodeTraversal root) {
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
}
