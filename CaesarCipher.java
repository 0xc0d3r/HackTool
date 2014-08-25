public class CaesarCipher {
	
	public static void main (String [] args) {
		String s = "";
		try {
			s = decrypt(Integer.parseInt(args[0]), args[1]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("One or both arguments missing.");
			System.err.println("Usage: java CaesarCipher [encryption key] [text]");
			System.exit(1);
		}
		catch (NumberFormatException e) {
			System.err.println("The encryption key must be an integer.");
			System.err.println("Usage: java CaesarCipher [encryption key] [text]");
			System.exit(2);
		}
		System.out.println(s);
	}
	
	public static String decrypt (int key, String text) {
		key = ((key % 26) + 26) % 26;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			int c = (int)text.charAt(i);
			// Shift a capital letter
			if (c >= 'A' && c <= 'Z') {
				c -= 'A' + key;
				if (c < 0) c += 26;
				c += 'A';
			}
			// Shift a lower case letter
			else if (c >= 'a' && c <= 'z') {
				c -= 'a' + key;
				if (c < 0) c += 26;
				c += 'a';
			}
			sb.append((char)c);
		}
		return sb.toString();
	}
}
