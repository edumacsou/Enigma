package src.enigmaoop.movel_discs;

import src.enigmaoop.utilities.Converter;

public class BilateralSwitcher extends UnilateralSwitcher {
	// Constructors //
	public BilateralSwitcher () {
		super();
	}

	public BilateralSwitcher (int[] sequence) {
		super(sequence);
	}

	// Methods //
	public int oppositeSwitch (int return_position) {
		return_position = Converter.normalize(return_position + this.rotate_position);

		int input_position = 0;
		
		for(int i=0; i<26; i++) {
			if (this.sequence[i] == return_position) {
				input_position = i;
			}
		}
		input_position = Converter.normalize(input_position - this.rotate_position);
		
		return input_position;
	}
}