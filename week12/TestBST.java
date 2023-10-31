package week12;

public class TestBST {
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] values = {10, 5, 15, 20, 3, 7};
		tree.makeTree(values);
		
		tree.measureInsertionTime(8);
		tree.measureDeletionTime(5);
		tree.measureSearchTime(15);
	}
	
}
