package src;

import src.enigmaoop.utilities.*;
import src.enigmaoop.core.EngineSystem;

public class EnigmaOOP {

    public static void main(String[] args) {
        
    EngineSystem machine = new EngineSystem();
	String text = Reader.readText("CAMBIO");
	text = Converter.clearText(text);
        
	String encrypted = "";
	for(int i=0; i<text.length(); i++) {
		encrypted += machine.encrypt(text.charAt(i));
	}
	System.out.println(encrypted);
        
    }
    
}
