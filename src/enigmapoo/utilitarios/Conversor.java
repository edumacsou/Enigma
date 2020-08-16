package enigmapoo.utilitarios;

import java.lang.StringBuilder;

public abstract class Conversor {

	public static int LetraParaInt(char letra) {
		return (int)letra-65;
	}

	public static char IntParaLetra(int numero) {
		return (char)(numero+65);
	}

	public static String IntParaString(int numero) {
		return ""+(char)(numero+65);
	}

	public static String limpaTexto (String texto) {
		StringBuilder textoLimpo = new StringBuilder();
		texto = texto.toUpperCase();
		for(int i=0; i<texto.length(); i++) {
			if (texto.charAt(i) < 'A' || texto.charAt(i) > 'Z') {
				textoLimpo.append(limpaChar(texto.charAt(i)));
			}
			else {
				textoLimpo.append(texto.charAt(i));
			}
		}
		return textoLimpo.toString();
	}

	private static String limpaChar (char algarismo) {

		int numAlgarismo = LetraParaInt(algarismo);
		
		if (numAlgarismo>=192 && numAlgarismo<=198) {
            return "A";
        }
        else if (numAlgarismo>=200 && numAlgarismo<=203) {
            return "E";
        }
        else if (numAlgarismo>=204 && numAlgarismo<=207) {
            return "I";
		}
        else if (numAlgarismo>=210 && numAlgarismo<=214) {
            return "O";
        }
        else if (numAlgarismo>=217 && numAlgarismo<=220) {
            return "U";
        }
        else if (numAlgarismo==199) {
            return "C";
        }
        else if (numAlgarismo==209) {
            return "N";
        }
		else {
			return "";
		}
	}
}