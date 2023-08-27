package week3;

import javax.swing.JOptionPane;

//made by me Mr.Clyde Allen Yu :D

public class WaterTank {
	
	//1. Creator - create and initialize
	
	private String brand, color;
	private float capacity, level;
	
	//Default constructor
	public WaterTank() {
		capacity = 10000.0f;
		level = 0.0f;
	}
	
	//One Parameterized constructor
	public WaterTank(float capacity) {
		this.capacity = capacity;
		level = 0.00f;
	}
	
	//Two Parameterized constructor
	public WaterTank(String brand, float capacity) {
		this.brand = brand;
		this.capacity = capacity;
		level = 0.00f;
	}
	
	//Getters and setters

	public void setBrand(String brand) {	
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	//made by me Mr.Clyde Allen Yu :D
	public void setCapacity(float capacity) {
	    if (level > 0) {
	        JOptionPane.showMessageDialog(null, "Cannot change capacity while there is water in the tank.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    this.capacity = capacity;
	    JOptionPane.showMessageDialog(null, "Tank capacity has been updated.");
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	
	//2. Transformers - change the state of the object
	
	public void addWater(float amount) {
	    if (negativeInput(amount)) {
	        JOptionPane.showMessageDialog(null, "Please input a positive amount.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    float potentialExcess = (level + amount) - capacity;
	    
	    if (potentialExcess > 0) {
	        int confirmationResult = JOptionPane.showConfirmDialog(
	            null,
	            "The tank is about to reach full capacity.\nPlease confirm if you want to add " + amount + "L of water (it will exceed the tank capacity, and the excess water will be wasted).\nPotential Wastage: " + potentialExcess + "L",
	            "Confirmation",
	            JOptionPane.OK_CANCEL_OPTION
	        );
	        
	        if (confirmationResult != JOptionPane.OK_OPTION) {
	            return; // User cancelled the operation
	        }
	        
	        // User confirmed, adjust the water level to the tank's capacity
	        level = capacity;
	        JOptionPane.showMessageDialog(null, "Tank is now full. Excess water has been wasted.");
	    } else {
	        level += amount;
	        JOptionPane.showMessageDialog(null, amount + "L is added to the tank.");
	    }
	}
	
	public void removeWater(float amount) {
		if(negativeInput(amount) == false) {
			level -= amount;
			JOptionPane.showMessageDialog(null, amount + "L is removed to tank.");
		}else {
			JOptionPane.showMessageDialog(null, "Please Input a positive amount");
		}
	}
	
	//3. Observers - know the state of the object
	
	public float currentWater() {
		return level;
	}
	
	public boolean isEmpty() {
		return (level == 0);
	}
	
	public boolean isFull() {
		return (level >= capacity);
	}
	
	public float drain() {
		float wastage = level;
		level = 0.00f;
		return wastage;
	}
	
	public float remainingCapacity() {
		return capacity - level;
	}
	
	//Different ways to display the water tank's info
	public void showWTInfo() {
		System.out.println("Brand\t\t: " + brand);
		System.out.println("Color\t\t: " + color);
		System.out.println("Capacity\t: " + capacity + "L");
		System.out.println("Water Level\t: " + level + "L");
		System.out.println("isEmpty\t\t: " + isEmpty());
		System.out.println("isFull\t\t: " + isFull());
	}
	
	public String displayWTInfo() {
		String hold = "Brand\t\t: " + brand
				    + "\nColor\t\t: " + color
				    + "\nCapacity\t\t: " + capacity
				    + "\nWater Level\t: " + level + "L"
				    + "\nisEmpty\t\t: " + isEmpty()
				    + "\nisFull\t\t: " + isFull();
		return hold;
	}
	
	public String viewWTInfo() {
		String hold = "Brand\t: " + brand + "\tColor\t: " + color
				+ "\nCapacity\t: " + capacity + "L" + "\tWater Level\t: " + level + "L"
				+ "\nisEmpty\t: " + isEmpty() + "\tisFull\t: " + isFull()
				+ "\nRemaining Capacity : " + remainingCapacity() + "L"
				+ "\nmade by me Mr.Clyde Allen Yu :DDDDDD";
		return hold;
	}
	
	public boolean negativeInput(float value) {
		boolean isNegative = true;
		
		if(value >= 0) {
			isNegative = false;
			return isNegative;
		}else {
			return isNegative;
		}
	}
	
	
	//Simple Drawing of the Tank
	//made by me Mr.Clyde Allen Yu :D
	public String drawTank(String ch) {
		String display = "";
		int tankHeight = 0, liter = 0;
		
		//adjusting the tank height based on the capacity as needed
		if(capacity <= 100) {
			liter = 10;
			tankHeight = (int)capacity/liter;
		}else if(capacity <= 1000) {
			liter = 100;
			tankHeight = (int)capacity/liter;
		}else if(capacity <= 10000) {
			liter = 1000;
			tankHeight = (int)capacity/1000;
		}else {
			liter = 10000;
			tankHeight = (int)capacity/10000;
		}
		
		//Pointer to current water level
		String get = "<-" + (Math.min(level, capacity) + "L");
		
		//Draw the graphic
		for(int i = tankHeight; i > 0; i--) {
			
			//display in liter evenly as per desired height
			display += liter * i + "L|";
			
			//Draw the specified character as water
			if(i <= level/liter) { // checks if the current iteratio is within the range of the current water level
				//filled the tank with the character and repeats it 20 times, plus the indicator
				display += ch.repeat(22) + "|" + get;
				get = ""; //resets the get variable so it won't repeat the indicator
			}else {
				display += "\t\t   |"; //draw blank space
			}
			display += "\n"; //seperate the character in each line to draw a tank-like object
		}
		
		//creating a 0L indicator and a bottom part of the tank
		display += "     0L(______________________)";
		
		//draw a cover(top) portion of the tank
		return "           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" + display;
	}
	
}
