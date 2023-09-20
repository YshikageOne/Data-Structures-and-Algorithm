package week6.SelectionSort;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class SelectionSortv2 {
	
    public static void main(String[] args) {
        //Input the size of the array from the user
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the array:"));
        
        //Create an array of the specified size
        int[] array = new int[size];
        
        //Input the array elements from the user
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter element #" + (i + 1) + ":"));
        }
        
        //Display the array at the beginning
        String output = "Selection Sort" + "\nArray at the beginning: " + Arrays.toString(array) + "\n\n";
        
        // Perform selection sort
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            //Swap the elements
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            
            //Add the array state after each pass to the output string
            output += "After Pass #" + (i + 1) + ": " + Arrays.toString(array) + "\n\n";
        }
        
        //Add the final sorted array to the output string
        output += "After Pass #" + n + " (done): " + Arrays.toString(array);
        
        //aDisplay the output all at once
        JOptionPane.showMessageDialog(null, output , "Made by Clyde Allen Yu :D", JOptionPane.INFORMATION_MESSAGE);
    }
}
