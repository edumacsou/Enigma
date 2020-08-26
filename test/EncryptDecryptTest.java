package test;

import java.util.Scanner;
import java.util.Random;
import src.enigmaoop.utilities.*;
import src.enigmaoop.core.EngineSystem;

public class EncryptDecryptTest {

    public static void main(String[] args) {
        System.out.println("Testing 1000 random configurations");
        int counter = 0;
        for (int i=0; i<1000; i++) {
            if (makeRandomTest("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing")) {
                counter++;
            }
        }
        System.out.printf("%d Tests passed \n %d tests failed", counter, 1000-counter);

    }
    
    private static boolean makeRandomTest(String originalText) {
        
        int[] rotors = new int[3];
        int[] positions = new int[26];
    
        rotors = createThreeRandomNumbers(1, 6);
        positions = createThreeRandomNumbers(0, 26);
        
        String text = Converter.clearText(originalText);

        EngineSystem machine = new EngineSystem(rotors, positions);
        String encrypted = machine.encryptText(text);
        
        machine = new EngineSystem(rotors, positions);
        String decrypted = machine.encryptText(encrypted);
        
        if (text.equals(decrypted)){
            return true;
        } else {
            return false;
        }
    }
    
    private static int[] createThreeRandomNumbers(int init, int end) {
        Random generator = new Random();
        int range = end - init;
        
        int numbers[] = new int[3];
        for(int i = 0; i<3; i++) {
            numbers[i] = generator.nextInt(range) + init;
        }
        
        return numbers;
    }
    
    private static void showLog(String logName, int[] valors){

        System.out.println(logName + ":");
        for (int i=0; i<valors.length; i++){
            System.out.print(valors[i] + " | ");
        }
        System.out.println("");       
    }
}