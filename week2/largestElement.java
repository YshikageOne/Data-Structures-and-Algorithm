package week2;

public class largestElement {

	public static void main(String[] args) {
		int[] array = {9,5,1,4,6,72,21,56,21};
		
		largestElement big = new largestElement();
		
		//made by me Mr.Clyde Allen Yu :D 
		System.out.println("The Largest Element through Linear Searching: " + big.linear(array));
		System.out.println("The Largest Element through Divide and Conquer: " + big.divisionComparison(array, 0, array.length - 1)); 
		System.out.println("made by me Mr.Clyde Allen Yu :D");

	}
	
	public int linear(int[] array) {
	   int biggestNum = array[0];
	   
	   for (int i = 1; i < array.length; i++) {
		   if(array[i] > biggestNum) {
			   biggestNum = array[i];
		   }
	   }
	   
	   return biggestNum;
	}
	
	public int divisionComparison(int[] array, int leftSide, int rightSide) {
		if (leftSide == rightSide) {
			return array[leftSide];
		}
		
		int middle = leftSide + (rightSide - leftSide) /2;
		int maxLeft = divisionComparison(array, leftSide, middle);
		int maxRight = divisionComparison(array, middle + 1, rightSide);
		
		return Math.max(maxLeft, maxRight);
	}

}
