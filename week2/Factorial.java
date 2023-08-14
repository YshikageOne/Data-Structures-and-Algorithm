package week2;
import java.util.Scanner;

//made by me Mr.Clyde Allen Yu :D
public class Factorial {
	
	//Loops
	public int loopFactorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	//Recursive
	public int recursiveFactorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		int result = n * recursiveFactorial(n-1);
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Factorial factorial = new Factorial();
		
		System.out.print("Enter your number: ");
		int n = scan.nextInt();
		
		System.out.println("Looped Factorial: " + factorial.loopFactorial(n));
		System.out.println("Recursive Factorial: " + factorial.recursiveFactorial(n));
		
		System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");
	}

}
