package week6.InsertionSort;

import javax.swing.JOptionPane;

public class InsertionSortv2 {

	 public static void main(String[] args) {
	        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
	        int[] array = new int[size];

	        // Fill the array with user input
	        for (int i = 0; i < size; i++) {
	            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
	            array[i] = Integer.parseInt(input);
	        }

	        StringBuilder output = new StringBuilder();
	        output.append("Insertion Sort" + "\nArray at the beginning: " + arrayToString(array) + "\n");

	        for (int i = 1; i < array.length; i++) {
	            int key = array[i];
	            int j = i - 1;

	            while (j >= 0 && array[j] > key) {
	                array[j + 1] = array[j];
	                j--;
	            }

	            array[j + 1] = key;

	            output.append("After Pass #" + i + ": " + arrayToString(array) + "\n");
	        }

	        output.append("Sorted Array: " + arrayToString(array));

	        JOptionPane.showMessageDialog(null, output.toString(), "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public static String arrayToString(int[] array) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < array.length; i++) {
	            sb.append(array[i]);
	            if (i < array.length - 1) {
	                sb.append(" ");
	            }
	        }
	        return sb.toString();
	    }
}
