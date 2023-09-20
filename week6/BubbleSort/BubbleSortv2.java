package week6.BubbleSort;

import javax.swing.*;

public class BubbleSortv2 {
	
	public static void main(String[] args) {
		//Taking the array size
		 int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
		 
		 int[] array = new int[size];
		 
		//Fill the array with user input
		 for(int i = 0; i < size; i++) {
			 String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
			 array[i] = Integer.parseInt(input);
		 }
		 
		 JOptionPane.showMessageDialog(null, bubbleSort(array), "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static String bubbleSort(int[] array) {
		int length = array.length;
		boolean swapped;
		String all = "Bubble Sort" + "\nArray at the beginning: " + arrayToString(array) + "\n";
		
		for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //Swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            all += "After Pass #" + (i + 1) + ": " + arrayToString(array);
            if (i < array.length - 1) {
                all += "\n";
            } else {
                all += " (done): " + arrayToString(array);
            }
            all += "\n";
            
         //If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
	    }
		return all;

    }
	
	private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
    }
}