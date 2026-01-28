package Inclass;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputValidation {

    public static String int2binary(int b)
    {
        int q = b; // -- note that variables are initialized
        int r = 0;
        String result = "";
        
        for (int i = 0; i < 32; ++i) {
            r = q & 0x01; // -- isolate least significant bit
            result = r + result; // -- string concatenation
            q = q >>> 1; // -- shift for next least significant bit (unsigned shift)
        }

        return result;
    }


    public static void main(String[] args) {
        
        Scanner s = null;

        try{
            s = new Scanner(System.in);

            System.out.println("Please enter the value for int 1: ");
            int a = s.nextInt();
            System.out.println("Please enter the value for int 2: "); 
            int b= s.nextInt();

            System.out.println("Enter your operation symbol: "); 
            String operator = s.next();
            
            switch (operator) {
                case "+": 
                    System.out.println(a+b);
                    break;
                case "-": 
                    System.out.println(a-b);
                    break;
                case "*": 
                    System.out.println(a*b);
                    break; 
                case "/": 
                System.out.println(a/b);
                break; 
                default: 
                    throw new IllegalArgumentException("invalid operation");
            }
        }
        catch (InputMismatchException e){
                System.out.println(e);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
        catch (Exception e){ //has to be last one 
            System.out.println(e);
        }
        finally{
            s.close();
        }

        System.out.println("done");
    }
}
