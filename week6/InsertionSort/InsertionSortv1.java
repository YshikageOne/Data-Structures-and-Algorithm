package week6.InsertionSort;

import javax.swing.JOptionPane;

public class InsertionSortv1 {

	public static void main(String[] args) {
		
		int num[] = {100, 75, 86, 80, 24, 10}; //input array
		int hold = 0; //temporary hold
		String all = "Array at the beginning: " + arrayToString(num) + "\n";; //String object
		
		int i = 0, j = 0, key;
		
		for(i = 1; i < num.length; i++) {
			key = num[i];
			for(j = (i-1); (j >=0 && num[j] > key); j--) {
				num[j+1] = num[j];
			}
			
			num[j+1] = key;
			
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
	
	private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
    }

}
