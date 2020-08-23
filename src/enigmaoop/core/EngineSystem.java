package src.enigmaoop.core;

import src.enigmaoop.movel_discs.*;
import src.enigmaoop.utilities.*;

public class EngineSystem {
	BilateralSwitcher[] rotors = new BilateralSwitcher[3];
	UnilateralSwitcher mirror;

	public EngineSystem() {	
		for(int i=0; i<3; i++) {
			int[] sequence = Reader.readRotor(i);
			rotors[i] = new BilateralSwitcher(sequence);
			rotors[i].setRotatePosition(Reader.readPosition(i));
		}
		mirror = new UnilateralSwitcher();
	}

	public EngineSystem(int[] rotorsNumbers, int[] positions) {	
		for(int i=0; i<3; i++) {
			int[] sequence = Reader.loadRotor(Integer.toString(rotorsNumbers[i]), 0);
			rotors[i] = new BilateralSwitcher(sequence);
			rotors[i].setRotatePosition(positions[i]);
		}
		mirror = new UnilateralSwitcher();
	}

	public String encryptText (String originalText) {
		String text = Converter.clearText(originalText);
        
		String encrypted = "";
		for(int i=0; i<text.length(); i++) {
			encrypted += this.encryptChar(text.charAt(i));
		}

		return encrypted;
	}

	public String encryptChar (char character) {
		int character_num = Converter.charToInt(character);

		character_num = rotors[0].simpleSwitch(character_num);
		character_num = rotors[1].simpleSwitch(character_num);
		character_num = rotors[2].simpleSwitch(character_num);
		character_num = mirror.simpleSwitch(character_num);
		character_num = rotors[2].oppositeSwitch(character_num);
		character_num = rotors[1].oppositeSwitch(character_num);
		character_num = rotors[0].oppositeSwitch(character_num);
		rotorPosUpdate();
		return Converter.intToString(character_num);
	}

	private void rotorPosUpdate() {
		rotors[2].rotate();
		if (rotors[2].getRotatePosition() == 0) {
			rotors[1].rotate();
			if(rotors[1].getRotatePosition() == 0) {
				rotors[0].rotate();
			}
		}
	}

	public void show() {
		for (int i=0; i<rotors.length; i++) {
			System.out.printf("The rotor %d is in position %d\n", i+1, rotors[i].getRotatePosition());
			System.out.println("This rotor is:");
			int[] sequence = rotors[i].getSequence();
			for (int j=0; j<sequence.length; j++) {
				System.out.print(sequence[j] + " | ");
			}
			System.out.println("");
		}
		System.out.println("The mirror rotor is:");
		int[] sequence = mirror.getSequence();
		for(int i=0; i<sequence.length; i++) {
			System.out.print(sequence[i] + " | ");
		}
		System.out.println("");
	}
}
