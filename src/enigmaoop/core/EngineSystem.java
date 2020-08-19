package src.enigmaoop.core;

import src.enigmaoop.movel_discs.*;
import src.enigmaoop.utilities.*;

public class EngineSystem {
	BilateralSwitcher[] rotors = new BilateralSwitcher[3];
	UnilateralSwitcher mirror;
	int[] rotor_position = new int[3];

	public EngineSystem() {	
		for(int i=0; i<3; i++) {
			int[] sequence = Reader.readRotor(i);
			rotors[i] = new BilateralSwitcher(sequence);
			rotor_position[i] = Reader.readPosition(i);
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
		// character_num = rotors[0].simpleSwitch(character_num+rotor_position[0]);
		// character_num = rotors[1].simpleSwitch(character_num-rotor_position[0]+rotor_position[1]);
		// character_num = rotors[2].simpleSwitch(character_num-rotor_position[1]+rotor_position[2]);
		// character_num = mirror.simpleSwitch(character_num-rotor_position[2]);
		// character_num = rotors[2].oppositeSwitch(character_num+rotor_position[2]);
		// character_num = rotors[1].oppositeSwitch(character_num-rotor_position[2]+rotor_position[1]);
		// character_num = rotors[0].oppositeSwitch(character_num-rotor_position[1]+rotor_position[0]);
		character_num = character_num-rotor_position[0];
		if (character_num < 0) {character_num += 26;}
		rotorPosUpdate();
		return Converter.intToString(character_num);
	}

	private void rotorPosUpdate() {
		rotor_position[2]++;
		if (rotor_position[2]>25)
		{
			rotor_position[2]-=26;
			rotor_position[1]++;
			if(rotor_position[1]>25)
			{
				rotor_position[1]-=26;
				rotor_position[0]++;
				if(rotor_position[0]>25)
				{
					rotor_position[0]-=26;
				}
			}
		}
	}
}
