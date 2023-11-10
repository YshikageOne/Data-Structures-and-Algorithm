package FinalProject.ADT;


/*
 * Issue class
 * @author Clyde Allen T. Yu
 */

public class Issue implements Comparable<Issue>{

	private int issueId;
	private int memberId;
	private String memberName;
	private int bookId;
	private String bookName;
	private String issueDate;
	private String returnDate;
	
	public Issue(int issueId, int memberId, String memberName, int bookId, String bookName, String issueDate, String returnDate) {
        this.issueId = issueId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
	
	@Override
	public int compareTo(Issue other) {
        return Integer.compare(this.issueId, other.issueId);
    }
	
	@Override
    public String toString() {
        return issueId + "|" + memberId + "|" + memberName + "|" + bookId + "|" + bookName + "|" + issueDate + "|" + returnDate;
    }
	
	public int getBookId() {
		return bookId;
	}

	public int getIssueId() {
		return issueId;
	}
}
