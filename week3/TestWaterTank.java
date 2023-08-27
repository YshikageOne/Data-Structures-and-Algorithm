package week3;

//made by me Mr.Clyde Allen Yu :D
import javax.swing.*;

public class TestWaterTank {

	public static void main(String[] args) {
		//Tester = Clyde Allen T. Yu
		
		String menu[] = {"Add Water", "Remove Water", "Clear Tank", "Setup Tank", "End"};
		
		String choice = "", color = "Dirty Black", brand ="", hold = "", display = "";
		float amount = 0.00f, capacity = 0.00f;
		
		JOptionPane j = new JOptionPane();
		WaterTank tank = new WaterTank("Sadie Sink", 1000);
		
		tank.setColor(color);
		
		do {
			display = tank.drawTank("~");
			
			hold = tank.viewWTInfo() + "\nSelect";
			
			choice=j.showInputDialog(null,new JTextArea(display+"\n\n"+hold), "Menu",1,null,menu,menu[0]).toString();
			
			switch (choice) {
			     case "Add Water":
			    	 amount = Float.parseFloat(j.showInputDialog("Amount (L: )"));
			    	 tank.addWater(amount);
			    	 break;
			     case "Remove Water":
			    	 if(tank.isEmpty()) {
			    		 j.showMessageDialog(null, "Tank is empty", "Error", JOptionPane.ERROR_MESSAGE);
			    	 }else {
			    		 amount = Float.parseFloat(j.showInputDialog("Amount (L: )"));
			    		 tank.removeWater(amount);
			    	 }
			    	 break;
			     case "Clear Tank":
			    	 j.showMessageDialog(null, "Tank is empty. Wastage\t:" + tank.drain());
			    	 break;
			     case "Setup Tank":
			    	 brand = j.showInputDialog("Brand: ");
			    	 color = j.showInputDialog("Color: ");	
			    	 capacity = Float.parseFloat(j.showInputDialog("Change Capacity:"));
			    	 
			    	 tank.setBrand(brand);
			    	 tank.setColor(color);
			    	 tank.setCapacity(capacity);
			    	 
			    	 j.showMessageDialog(null, "Tank has been updated.");
			    	 break;
			     case "End":
			}
		}while(!choice.equals("End"));
	}
}
