package week6.BogoSort;

import javax.swing.JOptionPane;

public class BogoSortv1 {
	// Check if the array is sorted
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Shuffle the elements of the array randomly
    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
        int[] array = new int[size];

        // Fill the array with user input
        for (int i = 0; i < size; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            array[i] = Integer.parseInt(input);
        }

        int pass = 1;

        System.out.print("Array at the beginning: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        while (!isSorted(array)) {
            shuffle(array);
            System.out.print("After Pass #" + pass + ": ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            pass++;
        }

        System.out.println("After Pass #" + pass + " (done): " + "\nMade by Clyde Allen Yu :D");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
