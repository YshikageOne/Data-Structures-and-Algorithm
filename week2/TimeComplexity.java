package week2;

public class TimeComplexity {
	
	public static void main(String[] args) {
		int data[] = {5,6,7,3,10};
		
		System.out.println("The largest element in the array is " + max(data));
	}
	
	public static int max(int data[]) {
		long start = System.nanoTime();
		
		int highest = data[0];
		
		for (int i = 1; i < data.length; i++) {
			if (highest < data[i]) {
				highest = data[i];
			}
		}
		
		long end = System.nanoTime();
		
		System.out.println("Processing Time\t: " + (end - start) + " time units");

		return highest;
	}
	
	public static int reverse(int num) {
		int rev = 0;
		for (; num != 0;) {
			int lastDigit = num % 10;
			rev = rev * 10 + lastDigit;
			num /= 10;
		}
		
		return rev;
	}

}
