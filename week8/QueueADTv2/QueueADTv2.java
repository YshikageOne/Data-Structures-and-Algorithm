package week8.QueueADTv2;

import javax.swing.JOptionPane;

/**Queue ADT that holds any element
 * 
 * @Author Clyde Allen T. Yu (YshikageOne)
 */


//Generic Queue that can hold any data type
public class QueueADTv2<T> {
	
	private Object[] queue;
	private int front;
	private int rear;
	private int capacity;
	private int size;
	
	
	//1. Constructor
	//Default Constructor
	public QueueADTv2() {
		capacity = 5;
		queue = new Object[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	//User-defined constructor
	public QueueADTv2(int initialCapacity) {
		capacity = initialCapacity;
		queue = new Object[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	//2. Transformers
	//Inserting element at the rear
	public void enqueue(T element) {
	    if (isFull()) {
	        JOptionPane.showMessageDialog(null, "Queue is full. Unable to enqueue.", "Error Message", JOptionPane.ERROR_MESSAGE);
	    } else {
	        rear = (rear + 1) % capacity;
	        	if(!((String) element).isEmpty()) {
	        		queue[rear] = element;
			        JOptionPane.showMessageDialog(null, "Element " + element + " enqueued successfully.");
			        size++;
	        	}else {
		        	JOptionPane.showMessageDialog(null, "Null elements are not allowed in the queue.", "Error Message", JOptionPane.ERROR_MESSAGE);
		            rear = (rear - 1 + capacity) % capacity;
		        }
	        }
	    }
	
	//Deletes elements at the front
	public Object dequeue() {
	    if (isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Queue is empty. Unable to dequeue.", "Error Message", JOptionPane.ERROR_MESSAGE);
	        return null;
	    } else {
	        Object element = queue[front];
	        front = (front + 1) % capacity;
	        JOptionPane.showMessageDialog(null, "Element " + element + " dequeued successfully.");
	        size--;
	        return element;
	    }
	}
	
	//Changes the max capacity of the queue
	public void setCapacity(int newCapacity) {
	    int confirmation = JOptionPane.showConfirmDialog(null, "Setting a new capacity will clear the queue. Are you sure?", "Confirmation", JOptionPane.YES_NO_OPTION);

	    if (confirmation == JOptionPane.YES_OPTION) {
	        clear(); 
	        capacity = newCapacity; 
	        queue = new Object[capacity]; 
	        front = 0;
	        rear = -1;
	        size = 0;
	        JOptionPane.showMessageDialog(null, "New capacity set to " + newCapacity + ". The queue has been cleared.");
	    } else {
	        JOptionPane.showMessageDialog(null, "New capacity change canceled. The queue remains unchanged.");
	    }
	}
	
	public void clear() {
	    size = 0;
	    front = 0;
	    rear = -1;
	    queue = new Object[capacity];
	}

	//3. Observers
	public String display() {
	    String result = "";
	    for (int i = 0; i < size; i++) {
	        int index = (front + i) % capacity;
	        result += queue[index] + " ";
	    }
	    return result.trim();
	}
	
	// Other observer methods
    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T frontValue() {
        return isEmpty() ? null : (T) queue[front];
    }

    public T rearValue() {
        return isEmpty() ? null : (T) queue[rear];
    }

    public T peek() {
        return frontValue();
    }

    public T last() {
        return rearValue();
    }

    public int count() {
        return size;
    }

    public int getCurrentSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

}
