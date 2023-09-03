package week4.CaesarCipherv1;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.swing.*;

public class TestCaesarCipherv1 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        CaesarCipherv1 cipher1 = new CaesarCipherv1();

        String menu[] = {"Encrypt", "Decrypt", "View", "End"};
        String hold = "", choice = "", plaintext = "";
        int key = 0, option = 0;
        JOptionPane j = new JOptionPane();

        String jarPath = TestCaesarCipherv1.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        String url = new File(jarPath).getParent();
        File jarDirectory = new File(url, "HiddenMessages.txt");
        FileWriter fWrite = null;
        FileReader fReader = null;
        Scanner read = null;

        do {

            choice = j.showInputDialog(null, new JTextArea("Choose"), "Menu", 1, null, menu, menu[0]).toString();
            switch (choice) {
                case "Encrypt":
                    JTextField txtPlaintext = new JTextField();
                    JTextField txtKey = new JTextField();
                    Object[] message = {
                            "Plaintext:", txtPlaintext,
                            "Key:", txtKey
                    };

                    option = j.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        plaintext = txtPlaintext.getText();
                        try {
                            key = Integer.parseInt(txtKey.getText());
                        } catch (NumberFormatException e) {
                            j.showMessageDialog(null, "Key must be a valid positive integer.", "Error", j.ERROR_MESSAGE);
                            continue;
                        }

                        if (key <= 0) {
                            j.showMessageDialog(null, "Key must be a valid positive integer.", "Error", j.ERROR_MESSAGE);
                            continue;
                        }

                        cipher1.setPlaintext(plaintext);
                        cipher1.setKey(key);

                        String encryptedMessage = cipher1.encryptS(plaintext, key);
                        j.showMessageDialog(null, "Plaintext: " + plaintext + "\nKey: " + key + "\nEncrypted Message: " + encryptedMessage);
                        try {
                            fWrite = new FileWriter(jarDirectory, true);
                            fWrite.write("Plaintext: " + plaintext + "\n");
                            fWrite.write("Key: " + key + "\n");
                            fWrite.write("Encrypted Message: " + encryptedMessage + "\n\n");
                            fWrite.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        j.showMessageDialog(null, "Login canceled", "Error", j.ERROR_MESSAGE);
                    }
                    break;
                case "Decrypt":
                    JTextField txtCiphertext = new JTextField();
                JTextField txtKeyDecrypt = new JTextField();
                Object[] decryptMessage = {
                    "Ciphertext:", txtCiphertext,
                    "Key:", txtKeyDecrypt
                };

                option = j.showConfirmDialog(null, decryptMessage, "Decrypt", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String ciphertext = txtCiphertext.getText();
                    try {
                        key = Integer.parseInt(txtKeyDecrypt.getText());
                    } catch (NumberFormatException e) {
                        j.showMessageDialog(null, "Key must be a valid positive integer.", "Error", j.ERROR_MESSAGE);
                        continue;
                    }

                    if (key <= 0) {
                        j.showMessageDialog(null, "Key must be a valid positive integer.", "Error", j.ERROR_MESSAGE);
                        continue;
                    }

                    cipher1.setKey(key);

                    String decryptedMessage = cipher1.decrypt(ciphertext);
                    j.showMessageDialog(null, "Ciphertext: " + ciphertext + "\nKey: " + key + "\nDecrypted Message: " + decryptedMessage);
                } else {
                    j.showMessageDialog(null, "Decryption canceled", "Error", j.ERROR_MESSAGE);
                }
                break;
                case "View":
                    try {
                        fReader = new FileReader(jarDirectory);
                        read = new Scanner(fReader);
                        StringBuilder messages = new StringBuilder();
                        while (read.hasNextLine()) {
                            messages.append(read.nextLine()).append("\n");
                        }
                        j.showMessageDialog(null, new JTextArea(messages.toString()));
                        read.close();
                    } catch (IOException e) {
                        j.showMessageDialog(null, "Error reading HiddenMessages.txt", "Error", j.ERROR_MESSAGE);
                    }
                    break;
            }

        } while (!choice.equals("End"));
    }
}
