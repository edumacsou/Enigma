package enigmapoo.perifericos;

import enigmapoo.componentes.*;
import enigmapoo.utilitarios.*;

public class SistemaEngrenagens {
	PermutadorBilateral[] rotores = new PermutadorBilateral[3];
	PermutadorUnilateral espelho;
	int[] posicaoRotor = new int[3];

	public SistemaEngrenagens() {	
		for(int i=0; i<3; i++) {
			int[] sequencia = Reader.LerRotor(i);
			rotores[i] = new PermutadorBilateral(sequencia);
			posicaoRotor[i] = Reader.LerPosicao(i);
		}
		espelho = new PermutadorUnilateral();
	}

	public String Codifica (char letra) {
		int numLetra = Conversor.LetraParaInt(letra);
		numLetra = rotores[0].PermutaSimples(numLetra+posicaoRotor[0]);
		numLetra = rotores[1].PermutaSimples(numLetra-posicaoRotor[0]+posicaoRotor[1]);
		numLetra = rotores[2].PermutaSimples(numLetra-posicaoRotor[1]+posicaoRotor[2]);
		numLetra = espelho.PermutaSimples(numLetra-posicaoRotor[2]);
		numLetra = rotores[2].PermutaRetorno(numLetra+posicaoRotor[2]);
		numLetra = rotores[1].PermutaRetorno(numLetra-posicaoRotor[2]+posicaoRotor[1]);
		numLetra = rotores[0].PermutaRetorno(numLetra-posicaoRotor[1]+posicaoRotor[0]);
		AtualizaPosRotores();
		return Conversor.IntParaString(numLetra);
	}

	private void AtualizaPosRotores() {
		posicaoRotor[2]++;
		if (posicaoRotor[2]>25)
		{
			posicaoRotor[2]-=26;
			posicaoRotor[1]++;
			if(posicaoRotor[1]>25)
			{
				posicaoRotor[1]-=26;
				posicaoRotor[0]++;
				if(posicaoRotor[0]>25)
				{
					posicaoRotor[0]-=26;
				}
			}
		}
	}
}
