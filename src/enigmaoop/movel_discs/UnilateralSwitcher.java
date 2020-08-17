package enigmapoo.componentes;

public class PermutadorUnilateral {
	// Atributo //
	protected int[] sequencia;

	// Construtores //
	public PermutadorUnilateral(int[] sequencia) {
		this.sequencia = sequencia;
	}

	public PermutadorUnilateral() {
		sequencia = new int[] {24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19};
	}

	// Metodos //
	public int PermutaSimples (int posEntrada) {
		if(posEntrada < 0) {
			posEntrada += 26;
		}
		return sequencia[posEntrada%26];
	}

	public void setSequencia(int[] sequencia) {
		this.sequencia = sequencia;
	}

}