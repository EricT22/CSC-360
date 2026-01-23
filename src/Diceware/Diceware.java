package Diceware;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diceware implements DicewareInterface{

    @Override
    public String genpassword(int minlength, char separator) throws FileNotFoundException {
        String pw = "";

        try {    
            File file = new File("src\\Diceware\\" + wordlist); 

            while (pw.length() < minlength){
                Scanner s = new Scanner(file);

                String num = "";
                for (int i = 0; i < 5; i++){
                    num += (rn.nextInt(6) + 1);
                }

                while (!s.next().equals(num)){}

                pw += s.next();
                pw += (pw.length() < minlength) ? Character.toString(separator) : "";

                s.close();
            }
            return pw;

        } catch (FileNotFoundException e) {
            throw e;
        }
    }
    
}
