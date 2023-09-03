package week4;

import javax.swing.JOptionPane;

//made by ME CLYDEEEEE

public class VigenereCipherv2 {
    public static void main(String[] args) {
        String message = JOptionPane.showInputDialog("Enter the message to encrypt:");
        String keyword = JOptionPane.showInputDialog("Enter the keyword:");

        String encryptedMessage = encryptVigenere(message, keyword);

        JOptionPane.showMessageDialog(null, "Encrypted Message: " + encryptedMessage);
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
}
