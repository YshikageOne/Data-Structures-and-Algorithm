package week6.SortingADT;

import javax.swing.*;

//Made by mr. CLyde Allen T. Yu :))))))

public class TestSortingAlgorithm {

	public static void main(String[] args) {
		
		SortingAlgorithm sort = new SortingAlgorithm();
		
		int max = 0;
		
		String menu[] = {"Add Elements" , "Choose", "End"};
		String sortAlgo[] = {"Bubble", "Selection", "Exchange", "Insertion", "Back"};
		String choice = "", option = "", all = "", hold = "";
		
		JOptionPane jop = new JOptionPane();
		
		do {
			
			hold = "Tester: Clyde Allen T. Yu\nOriginal Elements:" + sort.getElements();
			choice = jop.showInputDialog(null, new JTextArea(hold + "\nChoose"), "Menu", 1, null, menu, menu[0]).toString();
			
			switch(choice) {
			
			case "Add Elements":
				max = Integer.parseInt(jop.showInputDialog("Enter max capacity: "));
				sort.setElements(max);
				break;
			case "Choose":
				do {
					option = jop.showInputDialog(null,"Choose","Option",1,null,sortAlgo, sortAlgo[0]).toString();
					
					switch(option) {
					case "Bubble":
						all += sort.bubbleSortv2();
						break;
					case "Exchange":
						all += sort.exchangeSort();
						break;
					case "Selection":
						all += sort.selectionSort();
						break;
					case "Insertion":
						all += sort.insertionSort();
						break;
					}
					
					jop.showMessageDialog(null,new JTextArea(hold + "\n" + all));
					
					all ="\nSorted Elements\t:" + sort.getSortedElements() + "\n";
					
				}while(!option.equals("Back"));
				
				break;
			}
			
		}while(!choice.equals("End"));
		
	}

}
