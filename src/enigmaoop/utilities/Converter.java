package src.enigmaoop.utilities;

import java.lang.StringBuilder;

public abstract class Converter {

	public static int charToInt (char character) {
		return (int)character-65;
	}

	public static char intToChar (int number) {
		return (char)(number+65);
	}

	public static String intToString(int number) {
		return ""+(char)(number+65);
	}

	public static String clearText (String text) {
		StringBuilder text_clear = new StringBuilder();
		text = text.toUpperCase();
		for(int i=0; i<text.length(); i++) {
			if (text.charAt(i) < 'A' || text.charAt(i) > 'Z') {
				text_clear.append(clearChar(text.charAt(i)));
			}
			else {
				text_clear.append(text.charAt(i));
			}
		}
		return text_clear.toString();
	}

	private static String clearChar (char character) {

		int character_num = charToInt(character);
		
		if (character_num>=192 && character_num<=198) {
            return "A";
        }
        else if (character_num>=200 && character_num<=203) {
            return "E";
        }
        else if (character_num>=204 && character_num<=207) {
            return "I";
		}
        else if (character_num>=210 && character_num<=214) {
            return "O";
        }
        else if (character_num>=217 && character_num<=220) {
            return "U";
        }
        else if (character_num==199) {
            return "C";
        }
        else if (character_num==209) {
            return "N";
        }
		else {
			return "";
		}
	}
}