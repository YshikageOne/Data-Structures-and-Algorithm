package week7.StackADTv2;

import java.util.Stack;

//Made by mr Clyde Allen T. Yu
public class TestStack {
	
	public static void main(String[] args) {
		Stack <Student> st = new Stack<>();
		
		//Pushing Student to the stack
		st.push(new Student("1001", "Kelly Bangon", "Male", 20, 1.8));
		st.push(new Student("1002", "Bolly Ngon", "Male", 21, 2.6));
		st.push(new Student("1003", "Lisa Puton", "Male", 19, 1.5));
		
		Student student = new Student();
		student.setStudent("1004", "Lee Tsu Nin", "Male", 15, 2.0);
		st.push(student);
		
		System.out.println("Size\t: " + st.size());
		
		while(!st.isEmpty()) {
			student = st.pop();
			System.out.print(student.getStudent());
		}
		
		System.out.println("Size\t: " + st.size());
	}
}
