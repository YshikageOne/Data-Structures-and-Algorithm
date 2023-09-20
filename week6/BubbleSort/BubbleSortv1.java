package week6.BubbleSort;

import javax.swing.*;

public class BubbleSortv1 {
	public static void main(String[] args) {
		int num[] = {100,75,86,80,24,10}; //Input array
		int hold = 0; //Temperorary Hold
		String all = ""; //String object
		
		for(int x = 0; x < num.length; x++) {
			for(int y = 0; y < num.length-1; y++) {
				if(num[y] > num[y+1]) {
					hold = num[y+1];
					num[y+1] = num[y];
					num[y] = hold;
				}
			}
			
			for(int val: num) {
				all += val +"\t";
			}
			
			all += "\n";
		}
		
		
		JOptionPane.showMessageDialog(null, all);
	}
}
