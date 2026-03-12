package BitManipulation;

public class DESTest {
    public static void main(String[] args) {
        short key = 0b100100110;
        String s = "Worl is really hard today.";

        byte[] c = BitOperations.simpleDESEncrypt(s, key);
        String d = BitOperations.simpleDESDecrypt(c, key);

        System.out.println("Plain:");
        System.out.println(s);
        System.out.println("\nEncrypt/Decrypt text:");
        System.out.println(d);

        System.out.println("\n-------------\n");


        s = "Demonstrate your code by choosing a plain text value (e.g. \"This is the plain text message.\") and a 9-bit key (e.g. 0b01110011101). Pass the string and key to your encrypt function to get a cipher text byte[] array. Pass this byte[] array to your decrypt function to get a plain text string. Display your original plaintext and your encrypted/decrypted plain text.";

        c = BitOperations.simpleDESEncrypt(s, key);
        d = BitOperations.simpleDESDecrypt(c, key);

        System.out.println("Plain:");
        System.out.println(s);
        System.out.println("\nEncrypt/Decrypt text:");
        System.out.println(d);


        System.out.println("\n-------------\n");


        s = "Shmall";

        c = BitOperations.simpleDESEncrypt(s, key);
        d = BitOperations.simpleDESDecrypt(c, key);

        System.out.println("Plain:");
        System.out.println(s);
        System.out.println("\nEncrypt/Decrypt text:");
        System.out.println(d);
    }
}
