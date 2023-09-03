package week4;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CaesarCipherv3 {
	public static void main(String[] args) {
        int shift = Integer.parseInt(JOptionPane.showInputDialog("Enter the shift value:"));
        String message = JOptionPane.showInputDialog("Enter the message:");
        
        String[] options = {"Encrypt", "Decrypt"};
        JComboBox<String> operationDropdown = new JComboBox<>(options);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(operationDropdown);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Select Operation",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String selectedOperation = (String) operationDropdown.getSelectedItem();
            String resultMessage = "";
            
            if ("Encrypt".equals(selectedOperation)) {
                resultMessage = encrypt(message, shift);
            } else if ("Decrypt".equals(selectedOperation)) {
                resultMessage = decrypt(message, shift);
            }
            
            JOptionPane.showMessageDialog(null, "Result: " + resultMessage);
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
}
