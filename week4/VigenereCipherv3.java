package week4;

import javax.swing.JOptionPane;

//made by ME CLYDEEEEE

public class VigenereCipherv3 {
	
    public static void main(String[] args) {
    	
        while (true) {
            String[] options = {"Encrypt", "Decrypt", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Vigenere Cipher", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Encrypt
                String message = JOptionPane.showInputDialog("Enter the message to encrypt:");
                String keyword = JOptionPane.showInputDialog("Enter the keyword:");
                String encryptedMessage = encryptVigenere(message, keyword);
                JOptionPane.showMessageDialog(null, "Encrypted Message: " + encryptedMessage);
            } else if (choice == 1) { // Decrypt
                String encryptedMessage = JOptionPane.showInputDialog("Enter the encrypted message:");
                String keyword = JOptionPane.showInputDialog("Enter the keyword:");
                String decryptedMessage = decryptVigenere(encryptedMessage, keyword);
                JOptionPane.showMessageDialog(null, "Decrypted Message: " + decryptedMessage);
            } else if (choice == 2) { // Exit
                break;
            }
        }
    }

    public static String encryptVigenere(String message, String keyword) {
    	 StringBuilder encryptedMessage = new StringBuilder();
         int messageLength = message.length();

         for (int i = 0, j = 0; i < messageLength; i++) {
             char currentChar = message.charAt(i);

             if (Character.isLetter(currentChar)) {
                 char keyChar = keyword.charAt(j % keyword.length());
                 int shift = Character.toUpperCase(keyChar) - 'A';

                 if (Character.isUpperCase(currentChar)) {
                     char encryptedChar = (char) ((currentChar + shift - 'A') % 26 + 'A');
                     encryptedMessage.append(encryptedChar);
                 } else if (Character.isLowerCase(currentChar)) {
                     char encryptedChar = (char) ((currentChar + shift - 'a') % 26 + 'a');
                     encryptedMessage.append(encryptedChar);
                 }
                 j++;
             } else {
                 encryptedMessage.append(currentChar);
             }
         }

         return encryptedMessage.toString();
    }

    public static String decryptVigenere(String encryptedMessage, String keyword) {
        StringBuilder decryptedMessage = new StringBuilder();
        int messageLength = encryptedMessage.length();

        for (int i = 0, j = 0; i < messageLength; i++) {
            char currentChar = encryptedMessage.charAt(i);

            if (Character.isLetter(currentChar)) {
                char keyChar = keyword.charAt(j % keyword.length());
                int shift = Character.toUpperCase(keyChar) - 'A';

                if (Character.isUpperCase(currentChar)) {
                    char decryptedChar = (char) ((currentChar - shift - 'A' + 26) % 26 + 'A');
                    decryptedMessage.append(decryptedChar);
                } else if (Character.isLowerCase(currentChar)) {
                    char decryptedChar = (char) ((currentChar - shift - 'a' + 26) % 26 + 'a');
                    decryptedMessage.append(decryptedChar);
                }
                j++;
            } else {
                decryptedMessage.append(currentChar);
            }
        }

        return decryptedMessage.toString();
    }
}
