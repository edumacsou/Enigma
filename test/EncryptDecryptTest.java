import java.util.Scanner;
import src.enigmaoop.utilities.*;
import src.enigmaoop.core.EngineSystem;

public class EncryptDecryptTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        EngineSystem machine = new EngineSystem(new int{1, 3, 4}, new int{0, 15, 22});
        String text = "UM TEXTO QUALQUER PARA TESTAR";
        text = Converter.clearText(text);
        
        String encrypted = "";
        for(int i=0; i<text.length(); i++) {
            encrypted += machine.encrypt(text.charAt(i));
        }

        String decrypted = "";
        for(int i=0; i<encrypted.length(); i++) {
            decrypted += machine.encrypt(text.charAt(i));
        }
        System.out.println(encrypted);
        System.out.println(decrypted);
        
    }
}