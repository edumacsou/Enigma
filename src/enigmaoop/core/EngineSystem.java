package enigmaoop.core;

import enigmaoop.movel_discs.*;
import enigmaoop.utilities.*;

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
		int character_num = Conversor.charToInt(character);
		character_num = rotors[0].simpleSwitch(character_num+rotor_position[0]);
		character_num = rotors[1].simpleSwitch(character_num-rotor_position[0]+rotor_position[1]);
		character_num = rotors[2].simpleSwitch(character_num-rotor_position[1]+rotor_position[2]);
		character_num = mirror.simpleSwitch(character_num-rotor_position[2]);
		character_num = rotors[2].oppositeSwitch(character_num+rotor_position[2]);
		character_num = rotors[1].oppositeSwitch(character_num-rotor_position[2]+rotor_position[1]);
		character_num = rotors[0].oppositeSwitch(character_num-rotor_position[1]+rotor_position[0]);
		rotorPosUpdate();
		return Conversor.IntToString(character_num);
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
