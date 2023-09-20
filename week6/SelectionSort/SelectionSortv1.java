package week6.SelectionSort;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SelectionSortv1 {
	
	public static void main(String[] args) {
		int num[] = {16, 30, 24, 7, 62, 45, 5, 55}; //input array
		int hold = 0; //temporary hold
		String all = "Array at the beginning: " + arrayToString(num) + "\n";; //String object
		
		int lowest = 0, i = 0, j = 0;
		for(i = 0; i < num.length; i++) {	
			lowest = i;
			for(j = (i+1); j < num.length; j++) {
				if(num[lowest] < num[j]) {
					lowest = j;
				}
			}
			
			hold = num[lowest];
			num[lowest] = num[i];
			num[i] = hold;
			
			all += "After Pass #" + (i + 1) + ": " + arrayToString(num);
            if (i < num.length - 1) {
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
