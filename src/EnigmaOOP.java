/*
 * Created with Java SE 8u261
 * Under licence MIT
 * Author : Eduardo Maciel de Souza
 */


package src;

import src.enigmaoop.utilities.*;
import src.enigmaoop.core.EngineSystem;

public class EnigmaOOP {

    public static void main(String[] args) {
        
    EngineSystem machine = new EngineSystem();
	String text = Reader.readText("CAMBIO");
	
	System.out.println(machine.encryptText(text));
    }
    
}
