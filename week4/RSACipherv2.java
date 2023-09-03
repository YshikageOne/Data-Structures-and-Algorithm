package week4;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Random;

//made by ME CLYDEEEEE
/*NOTE: im using BigInteger because it handles really big numbers
 * and the methods inside does most of the work for me
*/

public class RSACipherv2 {
	
	public static void main(String[] args) {
        while (true) {
            String[] options = {"Encrypt", "Decrypt", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Simple RSA Encryption", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                encrypt();
            } else if (choice == 1) {
                decrypt();
            } else {
                System.exit(0);
            }
        }
    }

    private static void encrypt() {
        Random rand = new Random();
        BigInteger p, q, n, phi, e, d;

        do {
            p = BigInteger.probablePrime(rand.nextInt(3) + 3, rand); // 3-5 digits for p
            q = BigInteger.probablePrime(rand.nextInt(3) + 3, rand); // 3-5 digits for q
            n = p.multiply(q);
            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

            e = new BigInteger(phi.bitLength(), rand);
        } while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));

        d = e.modInverse(phi);

        String plaintext = JOptionPane.showInputDialog("Enter plaintext:");
        if (plaintext != null) {
            String ciphertext = encrypt(plaintext, n, e);
            displayKeys("Encryption", "Public Key", "(n, e)", n, e, "Private Key", "(n, d)", n, d, ciphertext);
        }
    }

    private static void decrypt() {
        String ciphertext = JOptionPane.showInputDialog("Enter ciphertext:");
        if (ciphertext != null) {
            String nValue = JOptionPane.showInputDialog("Enter n:");
            String publicKeyValue = JOptionPane.showInputDialog("Enter public key (e):");
            String privateKeyValue = JOptionPane.showInputDialog("Enter private key (d):");
            
            if (nValue != null && publicKeyValue != null && privateKeyValue != null) {
                BigInteger userN = new BigInteger(nValue);
                BigInteger userPublicKey = new BigInteger(publicKeyValue);
                BigInteger userPrivateKey = new BigInteger(privateKeyValue);
                
                String decryptedText = decrypt(ciphertext, userN, userPrivateKey);
                displayKeys("Decryption", "Public Key", "(n, e)", userN, userPublicKey, "Private Key", "(n, d)", userN, userPrivateKey, decryptedText);
            }
        }
    }

    private static String encrypt(String plaintext, BigInteger n, BigInteger e) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            int asciiValue = (int) c;
            BigInteger message = BigInteger.valueOf(asciiValue);
            BigInteger ciphertext = message.modPow(e, n);
            encryptedText.append(ciphertext).append(" ");
        }

        return encryptedText.toString();
    }

    private static String decrypt(String ciphertext, BigInteger userN, BigInteger userPrivateKey) {
        StringBuilder decryptedText = new StringBuilder();

        String[] ciphertextArray = ciphertext.trim().split(" ");
        for (String c : ciphertextArray) {
            BigInteger encryptedMessage = new BigInteger(c);
            BigInteger decryptedMessage = encryptedMessage.modPow(userPrivateKey, userN);
            int asciiValue = decryptedMessage.intValue();
            decryptedText.append((char) asciiValue);
        }

        return decryptedText.toString();
    }

    private static void displayKeys(String operation, String label1, String keyType1, BigInteger key1, BigInteger key2, String label2, String keyType2, BigInteger key3, BigInteger key4, String result) {
        String keyInfo1 = label1 + ": " + keyType1 + ": (" + key1 + ", " + key2 + ")";
        String keyInfo2 = label2 + ": " + keyType2 + ": (" + key3 + ", " + key4 + ")";
        JOptionPane.showMessageDialog(null, operation + " Result:\n\n" + result + "\n\nKey Information:\n\n" + keyInfo1 + "\n" + keyInfo2);
    }
    
}
