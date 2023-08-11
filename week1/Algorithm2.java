package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//made by me Mr.Clyde Allen Yu :D hehe

public class Algorithm2 {

	public static void main(String[] args) {
		
		
		Integer[] num = {23, 56, -10, 100, 45, -78, 90, 45, 69, -7};
		
		List data = new ArrayList(Arrays.asList(num));
		
		String arrayResult = "Array: " + del_algo1(num);
		String listResult = "List: " + del_algo2(data);
		
		System.out.println("With Negative numbers");
		System.out.println("Array: " + display_array(num) +
				           "\nList: " + data);
		
		System.out.println("\n\nWithout Negative numbers");
		System.out.println(arrayResult + "\n" + listResult);
		
		System.out.println("made by me Mr.Clyde Allen Yu :DDDDDD");
	}
	
	//Display the array
	public static String display_array(Integer[] num) {
		String hold = "";
		
		for (int i = 0; i < num.length; i++) {
			 hold += num[i] + ", ";
		}
		
		return hold;
	}
	
	//First Algorithm
	public static String del_algo1(Integer[] num) {
		String hold = "";
		
		for (int i = 0; i < num.length; i++) {
	        if (num[i] >= 0) {
	            hold += num[i] + " ";
	        }
	    }
		
		return hold;
	}
	
	//Second Algoritm
	public static String del_algo2(List data) {
        String hold = "";
		
        for (int i = 0; i < data.size(); i++) {
            Integer num = (Integer) data.get(i);
            if (num >= 0) {
                hold += num + " ";
            }
        }	
		return hold;
	}
	

}
