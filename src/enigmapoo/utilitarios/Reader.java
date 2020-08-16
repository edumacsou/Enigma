package enigmapoo.utilitarios;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Reader {
    private static Scanner scan = new Scanner(System.in);

    public static int[] LerRotor(int n) {
        String nomeArquivo, linhaLida;
        BufferedReader arquivoRotor;
        int[] sequencia = new int[26];
        int i=0;

        System.out.printf("Qual o Rotor #%d usado?\n", n+1);
        nomeArquivo = scan.next();
        
        try {
            String caminho = new File("rotores/"+nomeArquivo).getCanonicalPath();
            arquivoRotor = new BufferedReader(new FileReader(caminho));
            linhaLida = arquivoRotor.readLine();
            Scanner leitor = new Scanner(linhaLida);
            while (leitor.hasNext()) {
                sequencia[i] = leitor.nextInt();
                i++;
            }
            leitor.close();
            arquivoRotor.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Documento de Rotor não encontrado!");
            System.out.println("Tente Novamente");
            LerRotor(n);
        }
        catch(IOException e) {
            System.out.println("Erro de entrada.");
            System.out.println("Tente Novamente");
            LerRotor(n);
        }

        return sequencia;
    }

    public static int LerPosicao(int n) {
        String letra;
        System.out.printf("Qual a letra da posição inicial do Rotor #%d?\n", n+1);
        letra = scan.next();
        letra.toUpperCase();
        return Conversor.LetraParaInt(letra.charAt(0));
    }

    public static String LerTexto(String PalavraChave) {
        StringBuilder texto = new StringBuilder();
        String palavra;
        System.out.println("Digite o texto: ");
        while(scan.hasNext()) {
            palavra = scan.next();
            if(palavra.toUpperCase().equals(PalavraChave)){
            break;
            } else {
                texto.append(palavra);
            }
        }
        return texto.toString();
    }
    
}