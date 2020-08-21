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

	public String encrypt (char character) {
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
}
