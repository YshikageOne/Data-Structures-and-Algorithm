package week7.StackADTv1;

import java.util.Stack;

public class TestStack {
	
	//Made by mr. Clyde Allen T. Yu
	public static void main(String[] args) {
		Stack st = new Stack();
		
		st.push(45);
		st.push(15);
		st.push(5);
		st.pop();
		st.push(58);
		st.push(100);
		st.pop();
		
		System.out.println(st.peek());
		System.out.println(st.search(15));
		System.out.println(st.search(69));
		System.out.println(st.contains(100));
		System.out.println(st.empty());
		st.push(12);
		st.push(21);
		st.pop();
		System.out.println(st);
		
	}
}
