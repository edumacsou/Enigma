package enigmaoop.movel_discs;

public class UnilateralSwitcher {
	// Attributes //
	protected int[] sequence;

	// Constructors //
	public UnilateralSwitcher(int[] sequence) {
		this.sequence = sequence;
	}

	public UnilateralSwitcher() {
		sequence = new int[] {24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
	}

	// Methods //
	public int simpleSwitch (int input_position) {
		if(input_position < 0) {
			input_position += 26;
		}
		return sequence[input_position%26];
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

}