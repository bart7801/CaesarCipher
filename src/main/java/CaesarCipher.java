import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * A program that encrypts a file using a Caesar cipher;
 * Then decrypts the files;
*/

public class CaesarCipher {

    public static String cezar(String str){        //encryption method;
        char x[] = str.toCharArray();

        for(int i=0; i != x.length; i++){
            int n = x[i];
            n += 5;
            x[i] = (char)n;
        }
        return new String(x);
    }

    public static String caesarback(String str){     //decryption method;
        char x[] = str.toCharArray();

        for(int i=0; i != x.length; i++) {
            int n = x[i];
            n -= 5;
            x[i] = (char)n;
        }
        return new String(x);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File entry = new File("src/main/java/data.txt");
        Scanner in = new Scanner(entry);
        PrintWriter exit = new PrintWriter("src/main/java/encrypteddata.txt");
        File entry2 = new File("src/main/java/encrypteddata.txt");
        Scanner in2 = new Scanner(entry2);

        int i = 0;
        int j = 0;

        String word;
        String cipher;
        String[] data = new String[100];           //array declaration, data with size 100;

        while (in.hasNextLine()){                  //reading the contents of the file into the data table;
            String sentence = in.nextLine();
            data[i] = sentence;
            i++;
        }

        while (j != i){                            //loop sending elements arrays as parameters of the caesar method;
            word = data[j];
            cipher = CaesarCipher.caesarback(word);     //we assign encrypted words to the cipher variable;
            exit.println(cipher);                //write to file;
            j++;
        }

        exit.close();                            //closing output.txt file;

        while (in2.hasNextLine()) {                 //file decryption;
            String encryption = in2.nextLine();
            String decryption = CaesarCipher.caesarback(encryption);
            System.out.println(decryption);       //printing encrypted file contents on the screen;
        }
    }
}