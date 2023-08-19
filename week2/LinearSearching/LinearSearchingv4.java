package week2.LinearSearching;

//made by me Mr.Clyde Allen Yu :D

import java.util.Random;

public class LinearSearchingv4 {

	public static void main(String[] args) {
		
		int num[] = LinearSearchingv4.addElements();
		int maxElement = MAX(num);
        System.out.println("The highest element is: " + maxElement);
        System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");

	}
	
	public static int[] addElements() {
		int num[] = new int[Integer.MAX_VALUE/5];
		
		Random rng = new Random();
		
		int value = 0;
		
		for (int i = 0; i < num.length; i++) {
			value = rng.nextInt(Integer.MAX_VALUE) - num.length;
			num[i] = value;
		}
		
		return num;
	}
	
	
	public static int MAX(int num[]) {
		long start = System.nanoTime();
		int maxNum = Integer.MIN_VALUE;
		
		for (int i = 0; i < num.length; i++) {
			if(num[i] > maxNum) {
				maxNum = num[i];
			}
		}
		
		long end = System.nanoTime();
		
		System.out.println("Processing Time\t: " + (end - start) + " time units");
		
		return maxNum;
		
	}

}
