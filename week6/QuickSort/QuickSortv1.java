package week6.QuickSort;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class QuickSortv1 {
	
	public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
        int[] array = new int[size];

        // Fill the array with user input
        for (int i = 0; i < size; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            array[i] = Integer.parseInt(input);
        }

        StringBuilder output = new StringBuilder();
        output.append("Quick Sort" + "\nArray at the beginning: ").append(Arrays.toString(array)).append("\n");

        quickSort(array, 0, array.length - 1, output);

        JOptionPane.showMessageDialog(null, output.toString(), "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
    }

    // Quick Sort Algorithm
    public static void quickSort(int[] array, int low, int high, StringBuilder output) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, output);
            quickSort(array, low, pivotIndex - 1, output);
            quickSort(array, pivotIndex + 1, high, output);
        }
    }

    // Partition function
    public static int partition(int[] array, int low, int high, StringBuilder output) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        output.append("After Partition with pivot " + pivot + ": ").append(Arrays.toString(array)).append("\n");

        return i + 1;
    }
	
}
