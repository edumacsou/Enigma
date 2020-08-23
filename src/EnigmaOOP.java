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
