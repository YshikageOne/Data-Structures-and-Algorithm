package week3;

public class Keyboard {
	//Define a class named Keyboard
	private String layout;               //Holds the layout of the keyboard
	private String connectionType;       //Stores the type of connection (e.g., USB, Bluetooth)
	private boolean backlit;             //Indicates whether the keyboard is backlit
	private int numKeys;                 //Stores the total number of keys on the keyboard
	private boolean[] keyStates;         //Stores the states (pressed/released) of individual keys

	//Constructor to initialize the keyboard object with provided parameters
	public Keyboard(String layout, String connectionType, boolean backlit, int numKeys) {
	    this.layout = layout;
	    this.connectionType = connectionType;
	    this.backlit = backlit;
	    this.numKeys = numKeys;
	    keyStates = new boolean[numKeys];  //Initialize the array to store key states
	}

	//Method to simulate pressing a key on the keyboard
	public void pressKey(char key) {
	    int keyIndex = key - 'A';  //Convert the letter to an index (e.g., 'A' -> 0, 'B' -> 1, ...)
	    if (keyIndex >= 0 && keyIndex < numKeys) {
	        System.out.println("Pressed key: " + key);
	        keyStates[keyIndex] = true;  //Mark the key as pressed in the array
	    }
	}

	//Method to simulate releasing a key on the keyboard
	public void releaseKey(char key) {
	    int keyIndex = key - 'A';
	    if (keyIndex >= 0 && keyIndex < numKeys) {
	        System.out.println("Released key: " + key);
	        keyStates[keyIndex] = false;  //Mark the key as released in the array
	    }
	}

	//Method to simulate typing a text string on the keyboard
	public void typeText(String text) {
	    for (char c : text.toCharArray()) {
	        pressKey(c);     //Press the key corresponding to the character
	        releaseKey(c);   //Release the key after pressing
	    }
	}

	//Method to simulate connecting the keyboard
	public void connect() {
	    System.out.println("Keyboard connected via " + connectionType);
	}

	//Method to simulate disconnecting the keyboard
	public void disconnect() {
	    System.out.println("Keyboard disconnected");
	}

}
