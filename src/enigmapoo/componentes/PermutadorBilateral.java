package enigmapoo.componentes;

public class PermutadorBilateral extends PermutadorUnilateral {
	// Construtores //
	public PermutadorBilateral () {
		super();
	}

	public PermutadorBilateral (int[] sequencia) {
		super(sequencia);
	}

	// Metodos //
	public int PermutaRetorno (int posRetorno) {
		if(posRetorno < 0) {
			posRetorno += 26;
		}
		int posEntrada = 0;
		for(int i=0; i<26; i++) {
			if (sequencia[i] == posRetorno) {
				posEntrada = i;
			}
		}
		return posEntrada;
	}
}