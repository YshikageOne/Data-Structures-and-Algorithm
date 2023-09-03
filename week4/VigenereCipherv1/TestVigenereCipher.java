package week4.VigenereCipherv1;

//made by mr. Clyde Allen T. Yu (YshikageJira)

public class TestVigenereCipher {
	
	public static void main(String[] args) {
		
		System.out.println("Encrypting...");
		VigenereCipherv1 vigenere1 = new VigenereCipherv1();
		vigenere1.setPlaintext("love moves in");
		vigenere1.setKeyword("java");
		vigenere1.encrypt();
		
		System.out.println("Plaintext\t:" + vigenere1.getPlaintext());
		System.out.println("Keyword\t:" + vigenere1.getKeyword());
		System.out.println("Ciphertext\t:" + vigenere1.getCiphertext());
		
		VigenereCipherv1 vigenere2 = new VigenereCipherv1("love moves in");
		vigenere2.setKeyword("java");
		vigenere2.encrypt();
		
		System.out.println("\nPlaintext\t:" + vigenere2.getPlaintext());
		System.out.println("Keyword\t:" + vigenere2.getKeyword());
		System.out.println("Ciphertext\t:" + vigenere2.getCiphertext());
		
		VigenereCipherv1 vigenere3 = new VigenereCipherv1("love moves in", "java");
		vigenere2.encrypt();
		
		System.out.println("\nPlaintext\t:" + vigenere3.getPlaintext());
		System.out.println("Keyword\t:" + vigenere3.getKeyword());
		System.out.println("Ciphertext\t:" + vigenere3.getCiphertext());
		
		VigenereCipherv1 vigenere4 = new VigenereCipherv1();
		vigenere4.setPlaintextAndKeyword("love moves in", "java");
		vigenere4.encrypt();
		
		System.out.println("\nPlaintext\t:" + vigenere4.getPlaintext());
		System.out.println("Keyword\t:" + vigenere4.getKeyword());
		System.out.println("Ciphertext\t:" + vigenere4.getCiphertext());
		
		VigenereCipherv1 vigenere5 = new VigenereCipherv1();
		vigenere5.encrypt("love	moves in","java");
		
		System.out.println("\nPlaintext\t:" + vigenere5.getPlaintext());
		System.out.println("Keyword\t:" + vigenere5.getKeyword());
		System.out.println("Ciphertext\t:" + vigenere5.getCiphertext());
		
		String cipher = vigenere1.getCiphertext();
		String keyword = vigenere1.getKeyword();
		
		System.out.println("\nDecrypting...");
		vigenere1.decrypt();
		System.out.println("Ciphertext\t:" + cipher);
		System.out.println("Decrypted\t: " + vigenere1.getDecrypted());
		
		cipher = vigenere2.getCiphertext();
		System.out.println("Ciphertext\t:" + cipher);
		System.out.println("Decrypted\t:" + vigenere2.decrypt(cipher, keyword));
		
		System.out.println("made by mr. Clyde Allen T. Yu (YshikageJira)");
	}

}
