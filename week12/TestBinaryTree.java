package week12;

import java.util.Arrays;

import adtbt.*;

public class TestBinaryTree {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		
		System.out.println("Level	Order\t:"+bt.printLevelOrder());
		System.out.println("Root	Node\t:"+ bt.getRootNode());
		System.out.println("Empty\t:"+ bt.isEmpty());
		System.out.println("Count\t:"+ bt.count());
		System.out.println("Level\t:"+ bt.level());
		System.out.println("Depth\t:"+ bt.depth());
		System.out.println("Height\t:"+ bt.height());
		
		Node node=new Node();
		
		//Adding node via iterative
		node.setData(14);
		bt.addNode(bt.getRoot(), node.getData());
		bt.addNode(bt.getRoot(), 100);
		
		//Adding node via recursive
		bt.add(12);
		bt.add(50);
		bt.add(10);
		bt.add(19);
		bt.add(5);
		bt.add(13);
		bt.add(80);
		
		System.out.println("Root Node\t: "+ bt.getRootNode());
		System.out.println("Count\t: "+ bt.count());
		System.out.println("Level\t: "+ bt.level());
		System.out.println("Depth\t: "+ bt.depth());
		System.out.println("Height\t: "+ bt.height());
		
		//(iterative)print level order - fully	abstracted
		System.out.println("Level Order\t: "+bt.printLevelOrder());
		
		//(recursive)print level order - via getting root node
		node=bt.getRoot();
		System.out.println("Level Order\t: "+bt.printLevelOrder(node));
		
		//(recursive)print	in-order - fully abstracted
		System.out.println("In Order\t: "+bt.printInOrder());
		
		//(recursive)print	in-order - via getting	root node
		System.out.println("In Order\t: "+bt.printInOrder(node));
		
		//(recursive)print	preorder - fully abstracted
		System.out.println("Pre Order\t: "+bt.printPreOrder());
		
		//(recursive)print	preorder - via	getting	root node
		System.out.println("Pre	Order\t: "+bt.printPreOrder(node));
		
		//(recursive)print	postorder - fully abstracted
		System.out.println("Post Order\t: "+bt.printPostOrder());
		
		//(recursive)print	postorder - via	getting	root node
		System.out.println("Post Order\t: "+bt.printPostOrder(node));
		System.out.println("Is 10 a Node? "+bt.search(10));
		System.out.print("Leaves\t:	");
		
		bt.printLeaves(node);
		
		System.out.println("\nLeaves\t:	"+bt.showLeaves(node));
		System.out.println("Leaves\t: "+bt.displayLeaves(node));
		System.out.println("Leaves\t: "+bt.printLeaf());
		System.out.println("Parents\t: "+bt.printParent());
		System.out.println("Is 50 a leaf?	\t:	"+bt.isLeaf(50));
		System.out.println("Is 50 a Parent?	\t:	"+bt.isParent(50));
		System.out.println(bt.remove()+" is	deleted	from a Tree");
		System.out.println("Level Order\t:"+bt.printLevelOrder());
		System.out.println("Complete\t:	"+bt.isCompleteBT());
		System.out.println("Full\t:	"+bt.isFullBT());
		System.out.println("Perfect\t:	"+bt.isPerfectBT());
		System.out.println("Balanced\t:	"+bt.isBalanceBT());
		System.out.println("Internal Nodes\t:	"+bt.internalNodes());
		System.out.println("Siblings 100\t:	"+bt.sibling(100));
		System.out.println("Children of	100\t:	"+ Arrays.toString(bt.getChildren(100)));
		System.out.println("What is	10?\t:	"+bt.isRightOrLeftChild(10));
		System.out.println("Degree of 50?\t:	"+bt.degree(50));
		System.out.println("Ancestors of	50\t:	"+bt.ancestors(50));
		System.out.println("Descendants	of 100\t:	"+bt.descendants(100));
		System.out.println("Level Order\t:"+bt.printLevelOrder());

		
	}
	
}
