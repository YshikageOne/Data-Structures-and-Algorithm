package week4;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CaesarCipherv4 {

    public static void main(String[] args) {
    	String[] options = {"Encrypt", "Decrypt", "Store Encrypted Text", "Retrieve Encrypted Text", "Delete Encrypted Text"};
        JComboBox<String> operationDropdown = new JComboBox<>(options);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(operationDropdown);

        int result = JOptionPane.showConfirmDialog(null, panel, "Select Operation",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedOperation = (String) operationDropdown.getSelectedItem();

            switch (selectedOperation) {
                case "Encrypt":
                	int encryptShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift value:"));
                    String encryptMessage = JOptionPane.showInputDialog("Enter the message:");
                    String encryptedResult = encrypt(encryptMessage, encryptShift);
                    JOptionPane.showMessageDialog(null, "Encrypted Result: " + encryptedResult);
                    break;
                case "Decrypt":
                	int decryptShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift value:"));
                    String decryptMessage = JOptionPane.showInputDialog("Enter the message:");
                    String decryptedResult = decrypt(decryptMessage, decryptShift);
                    JOptionPane.showMessageDialog(null, "Decrypted Result: " + decryptedResult);
                    break;

                case "Store Encrypted Text":
                    int storeShift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift value:"));
                    String storeMessage = JOptionPane.showInputDialog("Enter the message:");
                    String filePath = "C:\\Users\\gayur\\Desktop\\Coding stuff\\Java\\SchoolWork\\Data Structures\\week4\\CaesarCipherv4TxT\\HiddenMessages.txt";
                    storeEncryptedText(storeMessage, storeShift, filePath);
                    break;

                case "Retrieve Encrypted Text":
                	String filePath1 = "C:\\Users\\gayur\\Desktop\\Coding stuff\\Java\\SchoolWork\\Data Structures\\week4\\CaesarCipherv4TxT\\HiddenMessages.txt";
                    String[] storedData = retrieveEncryptedText(filePath1);
                    if (storedData != null && storedData.length > 0 && storedData.length % 2 == 0) {
                        StringBuilder displayText = new StringBuilder("Retrieved Text and Keys:\n");
                        for (int i = 0; i < storedData.length; i += 2) {
                            String encryptedText = storedData[i];
                            String key = storedData[i + 1];
                            displayText.append("Encrypted Text: ").append(encryptedText).append("\nKey: ").append(key).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, displayText.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid or empty data retrieved.");
                    }
                    break;

                case "Delete Encrypted Text":
                    deleteEncryptedText();
                    JOptionPane.showMessageDialog(null, "All Encrypted Text and Keys Deleted");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid operation selected.");
            }
        }
    }

    public static String encrypt(String message, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char encryptedChar = (char) (base + (c - base + shift) % 26);
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift);
    }
    
    public static void storeEncryptedText(String message, int shift, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8, true)) {
        	String encryptedText = encrypt(message, shift);
            writer.write(encryptedText + "\n" + shift + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Encrypted Text and Key Stored");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error storing encrypted text.");
        }
    }

    
    public static String[] retrieveEncryptedText(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
        	 List<String> storedData = new ArrayList<>();
             String line;
             while ((line = bufferedReader.readLine()) != null) {
                 storedData.add(line);
             }
             return storedData.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void deleteEncryptedText() {
        File file = new File("HiddenMessages.txt");
        if (file.exists()) {
            if (file.delete()) {
                JOptionPane.showMessageDialog(null, "All Encrypted Text and Keys Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting encrypted text.");
            }
        }
    }
}
