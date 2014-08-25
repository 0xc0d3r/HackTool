public class MorseCode {
    public static void main(String []cla) {
        String input = cla[0];
        System.out.println(toPlain(input));
    }
    public static String toMorse(String text) {
        String morse="";
        String c;
        for(int i=0;i<text.length();i++) {
            c = text.charAt(i) + "";
            if(c.equalsIgnoreCase(" ")) morse += " ";
            if(c.equalsIgnoreCase("a")) morse += ".- ";
            if(c.equalsIgnoreCase("b")) morse += "-... ";
            if(c.equalsIgnoreCase("c")) morse += "-.-. ";
            if(c.equalsIgnoreCase("d")) morse += "-.. ";
            if(c.equalsIgnoreCase("e")) morse += ". ";
            if(c.equalsIgnoreCase("f")) morse += "..-. ";
            if(c.equalsIgnoreCase("g")) morse += "--. ";
            if(c.equalsIgnoreCase("h")) morse += ".... ";
            if(c.equalsIgnoreCase("i")) morse += ".. ";
            if(c.equalsIgnoreCase("j")) morse += ".--- ";
            if(c.equalsIgnoreCase("k")) morse += "-.- ";
            if(c.equalsIgnoreCase("l")) morse += ".-.. ";
            if(c.equalsIgnoreCase("m")) morse += "-- ";
            if(c.equalsIgnoreCase("n")) morse += "-. ";
            if(c.equalsIgnoreCase("o")) morse += "--- ";
            if(c.equalsIgnoreCase("p")) morse += ".--. ";
            if(c.equalsIgnoreCase("q")) morse += "--.- ";
            if(c.equalsIgnoreCase("r")) morse += ".-. ";
            if(c.equalsIgnoreCase("s")) morse += "... ";
            if(c.equalsIgnoreCase("t")) morse += "- ";
            if(c.equalsIgnoreCase("u")) morse += "..- ";
            if(c.equalsIgnoreCase("v")) morse += "...- ";
            if(c.equalsIgnoreCase("w")) morse += ".-- ";
            if(c.equalsIgnoreCase("x")) morse += "-..- ";
            if(c.equalsIgnoreCase("y")) morse += "-.-- ";
            if(c.equalsIgnoreCase("z")) morse += "--.. ";
            if(c.equalsIgnoreCase("1")) morse += ".---- ";
            if(c.equalsIgnoreCase("2")) morse += "..--- ";
            if(c.equalsIgnoreCase("3")) morse += "...-- ";
            if(c.equalsIgnoreCase("4")) morse += "....- ";
            if(c.equalsIgnoreCase("5")) morse += "..... ";
            if(c.equalsIgnoreCase("6")) morse += "-.... ";
            if(c.equalsIgnoreCase("7")) morse += "--... ";
            if(c.equalsIgnoreCase("8")) morse += "---.. ";
            if(c.equalsIgnoreCase("9")) morse += "----. ";
            if(c.equalsIgnoreCase("0")) morse += "----- ";
        }
        return morse;
    }
    public static String toPlain(String morse) {
        String plain="";
        String[] mwa = split(morse,'|');
        for(int i=0;i<mwa.length;i++) {
            String []mla = split(mwa[i],' ');
            for(int j=0;j<mla.length;j++) {
                if(mla[j].equalsIgnoreCase(".-")) plain += "a";
                if(mla[j].equalsIgnoreCase("-...")) plain += "b";
                if(mla[j].equalsIgnoreCase("-.-.")) plain += "c";
                if(mla[j].equalsIgnoreCase("-..")) plain += "d";
                if(mla[j].equalsIgnoreCase(".")) plain += "e";
                if(mla[j].equalsIgnoreCase("..-.")) plain += "f";
                if(mla[j].equalsIgnoreCase("--.")) plain += "g";
                if(mla[j].equalsIgnoreCase("....")) plain += "h";
                if(mla[j].equalsIgnoreCase("..")) plain += "i";
                if(mla[j].equalsIgnoreCase(".---")) plain += "j";
                if(mla[j].equalsIgnoreCase("-.-")) plain += "k";
                if(mla[j].equalsIgnoreCase(".-..")) plain += "l";
                if(mla[j].equalsIgnoreCase("--")) plain += "m";
                if(mla[j].equalsIgnoreCase("-.")) plain += "n";
                if(mla[j].equalsIgnoreCase("---")) plain += "o";
                if(mla[j].equalsIgnoreCase(".--.")) plain += "p";
                if(mla[j].equalsIgnoreCase("--.-")) plain += "q";
                if(mla[j].equalsIgnoreCase(".-.")) plain += "r";
                if(mla[j].equalsIgnoreCase("...")) plain += "s";
                if(mla[j].equalsIgnoreCase("-")) plain += "t";
                if(mla[j].equalsIgnoreCase("..-")) plain += "u";
                if(mla[j].equalsIgnoreCase("...-")) plain += "v";
                if(mla[j].equalsIgnoreCase(".--")) plain += "w";
                if(mla[j].equalsIgnoreCase("-..-")) plain += "x";
                if(mla[j].equalsIgnoreCase("-.--")) plain += "y";
                if(mla[j].equalsIgnoreCase("--..")) plain += "z";
                if(mla[j].equalsIgnoreCase(".----")) plain += "1";
                if(mla[j].equalsIgnoreCase("..---")) plain += "2";
                if(mla[j].equalsIgnoreCase("...--")) plain += "3";
                if(mla[j].equalsIgnoreCase("....-")) plain += "4";
                if(mla[j].equalsIgnoreCase(".....")) plain += "5";
                if(mla[j].equalsIgnoreCase("-....")) plain += "6";
                if(mla[j].equalsIgnoreCase("--...")) plain += "7";
                if(mla[j].equalsIgnoreCase("---..")) plain += "8";
                if(mla[j].equalsIgnoreCase("----.")) plain += "9";
                if(mla[j].equalsIgnoreCase("-----")) plain += "0";
            }
            plain +=" ";
        }
        return plain;
    }
    public static String[] split(String s,char d) {
		int size=1,index=0;
		char[] sarr = s.toCharArray();
		for(char ch : sarr) {
			if(ch == d) size++;
		}
		String words[] = new String[size];
		words[index] = "";
		for(char chr : sarr) {
			if(chr == d) words[++index]="";
			else words[index]+=chr;
		}
		return words;
	}
}
