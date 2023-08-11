package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//made by me Mr.Clyde Allen Yu :D hehe

public class Algorithm {

	public static void main(String[] args) {
		
		
		Integer[] num = {23, 56, -10, 100, 45, -78, 90, 45, 69, -7};
		
		List data = new ArrayList(Arrays.asList(num));
		
		System.out.println(Algorithm.delete_algo1(num, 101));
		System.out.println(Algorithm.delete_algo2(data, 101));
		
		System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");
	}
	
	//First Algorithm
	public static String delete_algo1(Integer[] num, int del) {
		String hold = del + " is NOT found.";
		
		for (int i = 0; i < num.length; i++) {
			if(num[i] == del) {
				hold = del + " is deleted successfully.";
				for(int j = i; j < num.length - 1; j++) {
					num[j] = num[j+1];
				}
			}
		}
		
		return hold;
	}
	
	//Second Algoritm
	public static String delete_algo2(List data, int del) {
		if(data.contains(del)) {
			return del + " is deleted successfully.";
		}
		else {
			return del + " is NOT found.";
		}
	}
	

}
