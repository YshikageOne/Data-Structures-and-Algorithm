package week2;

import java.util.Scanner;

//made by me Mr.Clyde Allen Yu :D
public class Fibonacci {
	
	//Loops
	public int loopFibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		
		int previous = 0, current = 1;
		
		for(int i  = 2; i <= n; i++) {
			int next = previous + current;
			previous = current;
			current = next;
		}
		
		return current;
	}
	
	//Recursive
	public int recursiveFibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		int result = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fibonacci fibonacci = new Fibonacci();
		
		System.out.print("Enter your number: ");
		int n = scan.nextInt();
		
		System.out.println("Looped Fibonacci: " + fibonacci.loopFibonacci(n));
		System.out.println("Recursive Fibonacci: " + fibonacci.recursiveFibonacci(n));
		
		System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");

	}

}
