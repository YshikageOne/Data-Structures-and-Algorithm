package week6.ExchangeSort;

import javax.swing.*;

public class ExchangeSortv2 {

    public static void main(String[] args) {

        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));

        int[] array = new int[size];

        // Fill the array with user input
        for (int i = 0; i < size; i++) {
            String input = JOptionPane.showInputDialog("Enter element at index " + i + ":");
            array[i] = Integer.parseInt(input);
        }

        int hold = 0;
        String all = "Exchange Sort" + "\nArray at the beginning: " + arrayToString(array) + "\n";

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = (i + 1); j < array.length; j++) {
                if (array[i] > array[j]) {
                    hold = array[j];
                    array[j] = array[i];
                    array[i] = hold;
                }
            }

            all += "After Pass #" + (i + 1) + ": " + arrayToString(array);
            if (i < array.length - 1) {
                all += "\n";
            } else {
                all += " (done): " + arrayToString(array);
            }
            all += "\n";
        }

        JOptionPane.showMessageDialog(null, all, "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
    }

    // Helper function to convert an array to a string
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
    }
}
