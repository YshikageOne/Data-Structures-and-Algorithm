package FinalProject.ADT;

/*
 * Member Class
 * @author Clyde Allen T. Yu
 */

public class Member implements Comparable<Member>{

	private int studentID;
	private String name;
	private int age;
	private String course;
	private int year;
	
	public Member(int studentID, String name, int age, String course, int year) {
		  this.studentID = studentID;
	      this.name = name;
	      this.age = age;
	      this.course = course;
	      this.year = year;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Member other) {
        return Integer.compare(this.studentID, other.studentID);
    }

	@Override
    public String toString() {
        return studentID + "|" + name + "|" + age + "|" + course + "|" + year;
    }
}
