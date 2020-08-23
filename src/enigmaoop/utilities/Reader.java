package src.enigmaoop.utilities;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static int[] readRotor(int n) {
        String file_name;

        System.out.printf("What's the #%d rotor used?\n", n+1);
        file_name = scan.next();

        return loadRotor(file_name, n);
        
    }

    public static int[] loadRotor(String file_name, int n) {
        String  read_line;
        BufferedReader rotor_file;
        int[] sequence = new int[26];
        int i=0;

        try {
            String path = new File("src/rotors/"+file_name).getCanonicalPath();
            rotor_file = new BufferedReader(new FileReader(path));
            read_line = rotor_file.readLine();
            Scanner reader = new Scanner(read_line);
            while (reader.hasNext()) {
                sequence[i] = reader.nextInt();
                i++;
            }
            reader.close();
            rotor_file.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Rotor not found!");
            System.out.println("Try again");
            return readRotor(n);
        }
        catch(IOException e) {
            System.out.println("Input error");
            System.out.println("Try again");
            return readRotor(n);
        }

        return sequence;
    }

    public static int readPosition(int n) {
        String character;
        System.out.printf("What is the character of the #%d rotor's initial position?\n", n+1);
        character = scan.next();
        character = character.toUpperCase();
        if(character.charAt(0) < 65 || character.charAt(0) > 90) {
            System.out.println("Invalid character! Try again");
            return readPosition(n);
        }
        return Converter.charToInt(character.charAt(0));
    }

    public static String readText(String keyWord) {
        StringBuilder text = new StringBuilder();
        String word;
        System.out.println("Type the text: ");
        while(scan.hasNext()) {
            word = scan.next();
            if(word.toUpperCase().equals(keyWord)){
            break;
            } else {
                text.append(word);
            }
        }
        return text.toString();
    }
    
}