package week4;

import javax.swing.JOptionPane;

public class CaesarCipherv2 {

	public static void main(String[] args) {
		String plaintext = JOptionPane.showInputDialog("Enter the plaintext:");
        int shift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift value:"));

        String encryptedText = encrypt(plaintext, shift);
        String decryptedText = decrypt(encryptedText, shift);

        JOptionPane.showMessageDialog(null, "Encrypted: " + encryptedText + "\nDecrypted: " + decryptedText);
	}
	
	public static String encrypt(String plaintext, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedText.append((char) ((ch - base + shift) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, 26 - shift); // Decryption is shifting in the opposite direction
    }
}
