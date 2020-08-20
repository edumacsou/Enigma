package src.enigmaoop.movel_discs;

import src.enigmaoop.utilities.Converter;

public class UnilateralSwitcher {
	// Attributes //
	protected int[] sequence;
	protected int rotate_position;

	// Constructors //
	public UnilateralSwitcher(int[] sequence) {
		this.sequence = sequence;
		this.rotate_position = 0;
	}

	public UnilateralSwitcher() {
		this.sequence = new int[] {24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
		this.rotate_position = 0;
	}

	// Methods //
	public int simpleSwitch (int input_position) {
		int input = Converter.normalize(input_position + this.rotate_position);

		int output = Converter.normalize(this.sequence[input]-this.rotate_position);

		return output;
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public void setRotatePosition(int position) {
		this.rotate_position = Converter.normalize(position);
	}

	public void rotate() {
		this.rotate_position = Converter.normalize(this.rotate_position+1);
	}

	public int getRotatePosition() {
		return this.rotate_position;
	}

}