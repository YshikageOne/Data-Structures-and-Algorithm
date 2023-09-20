package week6.MergeSort;

import java.util.Arrays;
import javax.swing.*;

public class MergeSortv1 {
	public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
        int[] array = new int[size];

        // Fill the array with user input
        for (int i = 0; i < size; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            array[i] = Integer.parseInt(input);
        }

        StringBuilder output = new StringBuilder();
        output.append("Merge Sort" + "\nArray at the beginning: ").append(Arrays.toString(array)).append("\n");

        mergeSort(array, 0, array.length - 1, output);

        JOptionPane.showMessageDialog(null, output.toString(), "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
    }

    // Merge Sort Algorithm
    public static void mergeSort(int[] array, int left, int right, StringBuilder output) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle, output);
            mergeSort(array, middle + 1, right, output);
            merge(array, left, middle, right, output);
        }
    }

 // Merge function
    public static void merge(int[] array, int left, int middle, int right, StringBuilder output) {
        int[] tempArray = new int[array.length];
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }

        // Maintain a counter for pass number
        passNumber++;
        output.append("After Pass #").append(passNumber).append(": ").append(Arrays.toString(array)).append("\n");
    }

    // Add a static variable to keep track of the pass number
    private static int passNumber = 0;
}
