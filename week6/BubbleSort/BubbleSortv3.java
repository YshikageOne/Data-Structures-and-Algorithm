package week6.BubbleSort;

import javax.swing.*;

public class BubbleSortv3 {
    public static void main(String[] args) {
        int num[] = {2, 56, 34, 25, 73, 46, 89, 10, 5, 16}; // Input array
        int hold = 0; // Temporary Hold
        String all = "Array at the beginning: " + arrayToString(num) + "\n";

        for (int x = 0; x < num.length; x++) {
            for (int y = 0; y < num.length - 1; y++) {
                if (num[y] > num[y + 1]) {
                    hold = num[y + 1];
                    num[y + 1] = num[y];
                    num[y] = hold;
                }
            }

            all += "After Pass #" + (x + 1) + ": " + arrayToString(num);
            if (x < num.length - 1) {
                all += "\n";
            } else {
                all += " (done): " + arrayToString(num);
            }
            all += "\n";
        }

        JOptionPane.showMessageDialog(null, all);
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

