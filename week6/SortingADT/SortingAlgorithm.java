package week6.SortingADT;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class SortingAlgorithm {
	private int num[], sorted[];
	private int hold; //temporary holder
	private String all;
	
	//Time complexity
	private long startTime, stopTime, elapsedTime;
	
	//Default Constructor
	public SortingAlgorithm() {
		num = new int[0];
	}
	
	//Parameterized constructor that accepts an integer
	public SortingAlgorithm(int num[]) {
		this.num = num;
	}
	
	public boolean isEmpty() {
		return (num.length < 0);
	}
	
	public void setElements(int num[]) {
		this.num = num;
	}
	
	public void setElements(int max) {
		
		if(max > 0) {
			Random rng = new Random();
			num = new int[max];
			
			for(int i = 0; i < max; i++) {
				num[i] = rng.nextInt(-max, max);
			}
		}else {
			System.err.println(max + " is invalid! Array cannot be empty!");
		}
	}
	
	public void setElements(String elements) {
		String data[] = elements.split(",\\s*");
		
		if(data.length < 2 || data[data.length-1].isEmpty()) {
			System.out.println("Format invalid! Elements must be atleast 2.");
		}else {
			for(String val:data) {
				if(!val.matches("-?\\d+")) {
					System.out.println("Format invalid! Only numbers are allowed.");
					return;
				}
			}
			
			num = new int[data.length];
			
			for(int i = 0; i<num.length; i++) {
				num[i] = Integer.parseInt(data[i]);
			}
		}
	}
	
	/*
	 * The	 regular	expression	pattern	 ",\\s*" is	used	 for	 splitting	 the	 string.	 It	matches	a	
comma	followed	by	zero	or	more	whitespace	characters.	This	allows	for	flexibility	in	
accepting	spaces	after	the	comma.
If	the	length	of	the	data	array	is	less	than	2	or	if	the	last	element	is	empty,	it	prints	
an	error	message	indicating	 that	 the	 format	is	invalid	and	 there	must	be	at	least	2	
elements.
Otherwise,	it	iterates	over	each	element	in	 the	data	array.	 If	any	element	does	not	
match	 the	 pattern	 "-?\\d+" (which	 represents	 a	 sequence	 of	 positive/negative	
digits),	it	prints	an	error	message	indicating	 that	only	numbers	are	allowed. The	-?
part	allows	for	an	optional	negative	sign,	and	\\d+ matches	one	or	more	digits.
If	all	elements	are	valid,	it	creates	a	new	num	array	of	the	same	length as	data	and	
populates	it	with	the	parsed	integer	values	of	the	elements.
If	 any	 element	 does	 not	 match	 the	 pattern,	 an	 error	 message	 is	 printed,	 and	 the	
method	exits	without	populating	the	num	array.
Note: I've	added	a	return	statement	to	exit	the	method	if	any	invalid	element	is	found,	
preventing	the	array	from	being	populated	if	there	are	any	non-numeric	elements.

	 */
	
	
	public String getElements() {
		all = "";
		
		if(!isEmpty()) {
			for(int val:num) {
				all += val + " ";
			}
		}else {
			all = "Array is empty!";
		}
		
		return all;
	}
	
	public int size() {
		return num.length;
	}
	
	public String getAll() {
		return all;
	}
	
	public void setData(int max) {
		if(max > 0) {
			num = new int[max];
			
			for(int i = 0; i < max; i++) {
				num[i] = Integer.parseInt(JOptionPane.showInputDialog("Num: "));
			}
		}else {
			System.err.println(max + " is invalid! Array cannot be empty!");
		}
	}
	
	public String getSortedElements() {	
		all = "";
		if(!isEmpty()) {
			for(int val:sorted) {
				all += val + " ";
			}
		}else {
			all = "Array is empty!";
		}
		return all;
	}
	
	public long getStartTime() {
		startTime = System.nanoTime();
		return startTime;
	}
	
	public long getStopTime() {
		stopTime = System.nanoTime();	
		return stopTime;
	}
	
	public long getElapsedTime() {
		elapsedTime = stopTime - startTime;
		return elapsedTime;
	}
	
	
	//Bubble sort
	
	public void bubbleSortv1() {
		all = "";
		startTime = System.nanoTime();
		
		for(int x = 0; x < num.length; x++) {
			for(int y = 0; y < num.length-1; y++) {
				if(num[y] > num[y+1]) {
					hold = num[y+1];
					num[y+1] = num[y];
					num[y] = hold;
				}
			}
			for(int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t:" + elapsedTime + " units";
		System.out.println(all);
	}
	
	//Made by Clyde Allen Yu :D
	public String bubbleSortv2() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();
		
		for(int x = 0; x < sorted.length; x++) {
			for(int y = 0; y < sorted.length-1; y++) {
				if(sorted[y] > sorted[y+1]) {
					hold = sorted[y+1];
					sorted[y+1] = sorted[y];
					sorted[y] = hold;
				}
			}
			for(int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t:" + elapsedTime + " units";
		return all;
	}
	
	public String bubbleSortv3() {
		all = "";
		bubbleSortv1();
		return all;
	}
	
	public int[] bubbleSortv4() {
		all = "";
		startTime = System.nanoTime();
		
		for(int x = 0; x < num.length; x++) {
			for(int y = 0; y < num.length-1; y++) {
				if(num[y] > num[y+1]) {
					hold = num[y+1];
					num[y+1] = num[y];
					num[y] = hold;
				}
			}
			for(int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t:" + elapsedTime + " units";
		return num;
	} 
	
	public String bubbleSortv5(int num[]) {
		all = "";
		startTime = System.nanoTime();
		
		for(int x = 0; x < num.length; x++) {
			for(int y = 0; y < num.length-1; y++) {
				if(num[y] > num[y+1]) {
					hold = num[y+1];
					num[y+1] = num[y];
					num[y] = hold;
				}
			}
			for(int val : num) {
				all += val + "\t";
			}
			all += "\n";
		}
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t:" + elapsedTime + " units";
		return all;
	}
	
	//Exchange sort
	//Made by Clyde Allen Yu :D
	public String exchangeSort() {
		sorted = Arrays.copyOf(num, num.length);
		all = "";
		startTime = System.nanoTime();
		
		for(int i = 0; i < sorted.length - 1; i++) {
			for(int j = (i+1); j < sorted.length; j++) {
				if(sorted[i] > sorted[j]) {
					hold = sorted[j];
					sorted[j] = sorted[i];
					sorted[i] = hold;
				}
			}
			for(int val : sorted) {
				all += val + "\t";
			}
			all += "\n";
		}
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		all += "Time efficiency\t:" + elapsedTime + " units";
		return all;
	}
	
	//Made by Clyde Allen Yu :D
	public String selectionSort() {
		sorted = Arrays.copyOf(num, num.length);
		int hold = 0; //temporary hold
		String all = "";; //String object
		
		int lowest = 0, i = 0, j = 0;
		for(i = 0; i < sorted.length; i++) {	
			lowest = i;
			for(j = (i+1); j < num.length; j++) {
				if(sorted[lowest] < sorted[j]) {
					lowest = j;
				}
			}
			
			hold = sorted[lowest];
			sorted[lowest] = sorted[i];
			sorted[i] = hold;
			
			all += "After Pass #" + (i + 1) + ": " + arrayToString(sorted);
            if (i < sorted.length - 1) {
                all += "\n";
            } else {
                all += " (done): " + arrayToString(sorted);
            }
            all += "\n";
		}
		
		return all;
   }
	//Made by Clyde Allen Yu :D
	public String insertionSort() {
		
		sorted = Arrays.copyOf(num, num.length);
		int hold = 0; //temporary hold
		String all = "";; //String object
		
		int i = 0, j = 0, key;
		
		for(i = 1; i < sorted.length; i++) {
			key = sorted[i];
			for(j = (i-1); (j >=0 && sorted[j] > key); j--) {
				sorted[j+1] = sorted[j];
			}
			
			sorted[j+1] = key;
			
			all += "After Pass #" + (i + 1) + ": " + arrayToString(sorted);
            if (i < sorted.length - 1) {
                all += "\n";
            } else {
                all += " (done): " + arrayToString(sorted);
            }
            all += "\n";
		}
		
		return all;
	}
	
	//Made by Clyde Allen Yu :D
	private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        return sb.toString().trim();
    }
}
