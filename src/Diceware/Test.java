package Diceware;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        Diceware d = new Diceware();

        for (int i = 1; i <= 25; i++){
            try {
                System.out.println(d.genpassword(i, '@'));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // for (int i = 1; i <= 25; i++){
        //     try {
        //         String word = d.genpassword(i, '@');
        //         System.out.println(i + "\t" +  word.length() + "\t" + word);
        //     } catch (FileNotFoundException e) {
        //         e.printStackTrace();
        //     }
        // }
    }
}
