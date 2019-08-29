import java.util.Scanner;

public class CaesarCipher2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int key = 3;

        System.out.println("Provide the text to be encrypted:");
        String txtEncrypted = scanner.nextLine();
        char[] txtInput = txtEncrypted.toCharArray();
        char[] txtCHAR = new char[txtInput.length];

        //ENCRYPTING
        for (int i = 0; i < txtInput.length; i++) {
            int n = txtInput[i];
            int C = 0;
            if (n >= 65 && n <= 90) {
                if (n + key > 90){
                    n -= 26;
                }
                C = n + key % 26;
            } else if (n >= 97 && n <= 122) {
                if (n + key > 122){
                    n -= 26;
                }
                C = n + key % 26;
            } else if (n >= 48 && n <= 57) {
                if (n + key > 57) {
                    n -= 10;
                }
                C = n + key % 26;
            } else if (n < 47){
                C = n;
            }
            txtCHAR[i] = (char) C;
            System.out.print(txtCHAR[i]);
        }
        System.out.println();

        //DE-CRYPTION
        for (int i = 0; i < txtInput.length; i++) {
            int n = txtCHAR[i];
            int C = 0;
            if (n >= 65 && n <= 90) {
                if (n - key < 65) {
                    n += 26;
                }
                C = n - key % 26;
            } else if (n >= 97 && n <= 122) {
                if (n - key < 97) {
                    n += 26;
                }
                C = n - key % 26;
            } else if (n >= 48 && n <= 57) {
                if (n - key < 48) {
                    n += 10;
                }
                C = n - key % 26;
            } else if (n < 48){
                C = n;
            }
            txtCHAR[i] = (char) C;
            System.out.print(txtCHAR[i]);
        }
    }
}