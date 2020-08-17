import enigmapoo.utilitarios.*;
import enigmapoo.perifericos.SistemaEngrenagens;

public class EnigmaPOO {

    public static void main(String[] args) {
        
    SistemaEngrenagens maquina = new SistemaEngrenagens();
	String texto = Reader.LerTexto("CAMBIO");
	texto = Conversor.limpaTexto(texto);
        
	String codificado = "";
	for(int i=0; i<texto.length(); i++) {
		codificado += maquina.Codifica(texto.charAt(i));
	}
	System.out.println(codificado);
        
    }
    
}
