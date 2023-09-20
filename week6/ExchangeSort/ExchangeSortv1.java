package week6.ExchangeSort;

import javax.swing.*;

public class ExchangeSortv1 {

	public static void main(String[] args) {
		
		int num[] = {100, 75, 86, 80, 24, 10}; //input array
		int hold = 0; //temporary hold
		String all = "Array at the beginning: " + arrayToString(num) + "\n"; //String object
		
		for(int i = 0; i < num.length - 1; i++) {
			for(int j = (i+1); j < num.length; j++) {
				if(num[i] > num[j]) {
					hold = num[j];
					num[j] = num[i];
					num[i] = hold;
				}
			}
			
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
