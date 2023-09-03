package week4.CaesarCipherv1;

public class CaesarCipherv1 {
	
	private String plaintext = "", ciphertext = "";
	private int key, letter;

	//Constructor
	public CaesarCipherv1() {
		key = letter = 0;
		plaintext = ciphertext = "";
	}
	
	//Parameterized Constructor
	public CaesarCipherv1(String plaintext) {
		setPlaintext(plaintext);
	}
	
	public CaesarCipherv1(int key) {
		setKey(key);
	}
	
	//2 Parameterized Constructor
	public CaesarCipherv1(String plaintext, int key) {	
		setPlaintext(plaintext);
		setKey(key);
	}
	
	
	//setters (transformers)
	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext.toLowerCase();
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setCaesarCipher(String plaintext, int key) {
		setPlaintext(plaintext);
		setKey(key);
	}
	
	//getters (observers)
	public String getCiphertext() {
		return ciphertext;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getPlaintext() {
		return plaintext;
	}
	
	public void encrypt() {
		for (int i = 0; i < plaintext.length(); i++) {
	        char currentChar = plaintext.charAt(i);

	        if (Character.isLetter(currentChar)) {
	            letter = currentChar + (key % 26);

	            if (Character.isLowerCase(currentChar)) {
	                if (letter > 'z') {
	                    letter -= 26;
	                }
	            } else if (Character.isUpperCase(currentChar)) {
	                if (letter > 'Z') {
	                    letter -= 26;
	                }
	            }

	            ciphertext += (char) letter;
	        } else {
	            ciphertext += currentChar;
	        }
	    }
	}
	
	
	//Algo1 : Overloaded method
	public void encrypt(String plaintext) {
		ciphertext = "";
		setPlaintext(plaintext);
		encrypt();
	}
	
	//Algo2 : Overloaded method
	public void encrypt(String plaintext, int key) {
		ciphertext ="";
		setCaesarCipher(plaintext,key);
		encrypt();
	}
	
	//Algo3 : (Value returning)
	public String encryptS(String plaintext, int key) {
		ciphertext = "";
		setCaesarCipher(plaintext, key);
		encrypt();
		return ciphertext;
	}
	
	//Decryption
	public String decrypt(String ciphertext) {
		String hold = "";
		for(int i = 0; i < ciphertext.length(); i++) {
			letter = ciphertext.charAt(i) - (key % 26);
			if(letter < 'a') {
				letter += 26;
			}
			hold += (char)(letter);
		}
		return hold;
	}

}
