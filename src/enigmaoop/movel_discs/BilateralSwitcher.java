package enigmaoop.movelparts;

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
		if(return_position < 0) {
			return_position += 26;
		}
		int input_position = 0;
		for(int i=0; i<26; i++) {
			if (sequence[i] == return_position) {
				input_position = i;
			}
		}
		return input_position;
	}
}