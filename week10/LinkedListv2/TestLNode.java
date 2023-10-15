package week10.LinkedListv2;

public class TestLNode {

	public static void main(String[] args) {
		
		LNode<Object> node = new LNode<>();
		
		node.addAtFirst(12);
		node.addAtFirst(45);
		node.addAtFirst(3);
		node.addAtLast(2);
		node.addAtPosition(5, 1);
		node.addInMiddle(25);

		
		System.out.println(node.traverse());
		
		System.out.println("The first node is " + node.getFirst());
		System.out.println("The last node is " + node.getLast());
		System.out.println("The position/index of 12 is " + node.indexAt(12));
		

	}

}
