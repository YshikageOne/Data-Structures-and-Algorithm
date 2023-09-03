package week4;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Random;

//made by ME CLYDEEEEE
/*NOTE: im using BigInteger because it handles really big numbers
 * and the methods inside does most of the work for me
*/

public class RSACipher {
	
	private static BigInteger p, q, n, phi, e, d;

    public static void main(String[] args) {
        generateKeys();

        while (true) {
            String[] options = {"Encrypt", "Decrypt", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Simple RSA Encryption", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                String plaintext = JOptionPane.showInputDialog("Enter plaintext:");
                if (plaintext != null) {
                    String ciphertext = encrypt(plaintext);
                    displayKeys("Encryption", ciphertext);
                }
            } else if (choice == 1) {
                String ciphertext = JOptionPane.showInputDialog("Enter ciphertext:");
                if (ciphertext != null) {
                    String decryptedText = decrypt(ciphertext);
                    displayKeys("Decryption", decryptedText);
                }
            } else {
                System.exit(0);
            }
        }
    }

    private static void generateKeys() {
        Random rand = new Random();
        p = BigInteger.probablePrime(128, rand);
        q = BigInteger.probablePrime(128, rand);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537); // Common public exponent
        d = e.modInverse(phi);
    }

    private static String encrypt(String plaintext) {
        BigInteger message = new BigInteger(plaintext.getBytes());
        BigInteger ciphertext = message.modPow(e, n);
        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext) {
        BigInteger encryptedMessage = new BigInteger(ciphertext);
        BigInteger decryptedMessage = encryptedMessage.modPow(d, n);
        return new String(decryptedMessage.toByteArray());
    }

    private static void displayKeys(String operation, String result) {
        String keyInfo = "p: " + p + "\nq: " + q + "\nPublic Key (e, n): (" + e + ", " + n + ")\nPrivate Key (d, n): (" + d + ", " + n + ")";
        JOptionPane.showMessageDialog(null, operation + " Result:\n\n" + result + "\n\nKey Information:\n\n" + keyInfo);
    }
    
}
