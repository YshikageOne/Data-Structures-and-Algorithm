package FinalProject.ADT;

/*
 * Book class
 * @author Clyde Allen T. Yu
 */

public class Book implements Comparable<Book> {
	
	//Data attributes
	private int bookId;
	private String name;
	private String publisher;
	
	//Constructor
	public Book(int bookId, String name, String publisher) {
		this.bookId = bookId;
		this.name = name;
		this.publisher = publisher;
	}
	
	// Getters and setters
    public int getId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }
    
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.bookId, other.bookId);
    }
    
    @Override
    public String toString() {
        return bookId + "|" + name + "|" + publisher;
    }
}
