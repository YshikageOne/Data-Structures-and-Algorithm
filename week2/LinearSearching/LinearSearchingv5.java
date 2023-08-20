package week2.LinearSearching;

//made by me Mr.Clyde Allen Yu :D

import java.util.Random;

public class LinearSearchingv5 {

	public static void main(String[] args) {
		
		int num[] = LinearSearchingv5.addElements();
		int positiveNum[] = removeOutliers(num);

        System.out.println("Positive values in the dataset:");
        
        for (int value : positiveNum) {	
        	System.out.println(value);
        }
        
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
	
	public static int[] removeOutliers(int[] num) {
        int positiveCount = 0;

        for (int value : num) {
            if (value >= 0) {
                positiveCount++;
            }
        }

        int[] positiveNum = new int[positiveCount];
        int index = 0;

        for (int value : num) {
            if (value >= 0) {
                positiveNum[index++] = value;
            }
        }

        return positiveNum;
    }
	
}
