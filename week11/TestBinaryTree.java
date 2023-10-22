package week11;

public class TestBinaryTree {
	
	public static void main(String[] args) {
		System.out.println("Made by Clyde Allen Yu :DDDDDDDDDD");
		
		BinaryTree tree = new BinaryTree();
		
		//Display Before
		System.out.println("--- Before Adding Nodes ---");
		System.out.println("Empty\t\t: " + tree.isEmpty());
		System.out.println("Number of Nodes\t: " + tree.count());
		System.out.println("Level Order\t: " + tree.printLevelOrder());
		
		//add 1
		tree.addNode(12);
		
		
		System.out.println("\nEmpty\t\t: " + tree.isEmpty());
		System.out.println("Number of Nodes\t: " + tree.count());
		System.out.println("Level Order\t: " + tree.printLevelOrder(tree.getRoot()));
		System.out.println("Level Order\t: " + tree.printLevelOrder());
		
		Node root = new Node();
		root = tree.getRoot();
		
		System.out.println("\nIn-order\t: " + tree.printInOrder(root));
		System.out.println("\nPre-order\t: " + tree.printPreOrder(root));
		System.out.println("\nPost-order\t: " + tree.printPostOrder(root));
		
		System.out.println("\nFound 100\t: " + tree.search(100));
		System.out.println("Found 25\t: " + tree.search(25));
	}
}
