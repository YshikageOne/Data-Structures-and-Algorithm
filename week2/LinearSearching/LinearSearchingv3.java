package week2.LinearSearching;

//made by me Mr.Clyde Allen Yu :D

import java.util.Random;
import java.util.Scanner;

public class LinearSearchingv3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//input for the length of the array
		System.out.print("Enter the length of the array: ");
		int length = scanner.nextInt();
		
		int num[] = LinearSearchingv3.addElements(length);
		int maxElement = MAX(num);
        System.out.println("The highest element is: " + maxElement);

	}
	
	public static int[] addElements(int length) {
		int num[] = new int[length];
		
		Random rng = new Random();
		
		int value = 0;
		
		for (int i = 0; i < num.length; i++) {
			value = rng.nextInt(Integer.MAX_VALUE) - num.length;
			System.out.println(value);
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
