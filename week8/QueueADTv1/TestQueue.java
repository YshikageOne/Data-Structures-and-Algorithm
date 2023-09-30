package week8.QueueADTv1;

public class TestQueue {

	public static void main(String[] args) {
		
		QueueADTv1 q = new QueueADTv1();
		
		System.out.println(q.peek());
		System.out.println(q.getCurrentSize());
		System.out.println(q.last());
		
		q.enqueue(14);
		q.enqueue(24);
		q.enqueue(46);
		q.enqueue(290);
		
	}
}
