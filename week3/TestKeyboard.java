package week3;

public class TestKeyboard {

	public static void main(String[] args) {
		Keyboard keyboard = new Keyboard("QWERTY", "USB", true, 104);
        keyboard.connect();
        keyboard.typeText("Clyde Love Jerra");
        keyboard.disconnect();

	}

}
