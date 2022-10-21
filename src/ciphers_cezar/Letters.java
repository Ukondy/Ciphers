package ciphers_cezar;

import java.util.ArrayList;

public class Letters {
    public static ArrayList<Character> arrayLettEn = new ArrayList<>();
    public final static String ALPHOBET = "abcdefghijklmnopqrstuwxyz";
    public static ArrayList<Character> arrayLettRu = new ArrayList<>();
    public static ArrayList<Character> arraySymb = new ArrayList<>();

    public static char letters(char symb, String sign) {
        toAddArrayEn();
        toAddArrayRu();
        toAddArraySymb();


        if (sign.equals("en")) {
            for (Character character : arrayLettEn) {
                if (character.equals(symb)) {
                    return arrayLettEn.get(getIdxLett(character, arrayLettEn));
                }
            }
        } else {
            for (Character character : arrayLettRu) {
                if (character.equals(symb)) {
                    return arrayLettRu.get(getIdxLett(character, arrayLettRu));
                }
            }
        }

        for (Character character : arraySymb) {
            if (character.equals(symb)) {
                return arraySymb.get(getIdxSymb(character, arraySymb));
            }
        }
        return 'è';
    }

    public static char lettersReverse(char symb, String sign) {
        toAddArrayEn();
        toAddArrayRu();
        toAddArraySymb();
        if (sign.equals("en")) {
            for (Character character : arrayLettEn) {
                if (character.equals(symb)) {
                    return arrayLettEn.get(getIdxLettRe(character, arrayLettEn));
                }
            }
        } else {
            for (Character character : arrayLettRu) {
                if (character.equals(symb)) {
                    return arrayLettRu.get(getIdxLettRe(character, arrayLettRu));
                }
            }
        }
        for (Character character : arraySymb) {
            if (character.equals(symb)) {
                return arraySymb.get(getIdxSymbRe(character, arraySymb));
            }
        }
        return 'a';
    }

    public static int getIdxLettRe(char symb, ArrayList<Character> arrayLett) {
        if(arrayLett.indexOf(symb) - 3 < 0) {
            int temp1 = arrayLett.indexOf(symb) - 3;
            temp1 = (int)Math.pow(temp1, 2) + temp1;
            int temp2 = arrayLett.size();
            int temp3 = temp2 - temp1;
            return  temp3;
        }
        return arrayLett.indexOf(symb) - 3;
    }

    public static int getIdxSymbRe(char symb, ArrayList<Character> arrayLett) {
        if(arrayLett.indexOf(symb) - 3 < 0) {
            int temp1 = arrayLett.indexOf(symb) - 3;
            int temp2 = arrayLett.indexOf(symb);
            int temp3 = temp2 - temp1;
            return  temp3;
        }
        return arrayLett.indexOf(symb) - 3;
    }

    public static int getIdxLett(char symb, ArrayList<Character> arrayLett) {
        if(arrayLett.indexOf(symb) + 3 > arrayLett.size()) {
            int temp1 = arrayLett.indexOf(symb) + 3;
            int temp2 = arrayLett.indexOf(symb);
            int temp3 = temp1 - temp2 - 1;
            return  temp3;
        }
        return arrayLett.indexOf(symb) + 3;
    }

    public static int getIdxSymb(char symb, ArrayList<Character> arrayLett) {
        if(arrayLett.indexOf(symb) + 3 > arrayLett.size()) {
            int temp1 = arrayLett.indexOf(symb) + 3;
            int temp2 = arrayLett.indexOf(symb);
            int temp3 = temp1 - temp2 - 1;
            return  temp3;
        }
        return arrayLett.indexOf(symb) + 3;
    }

    public static void toAddArrayEn() {
        arrayLettEn.add('a');
        arrayLettEn.add('b');
        arrayLettEn.add('c');
        arrayLettEn.add('d');
        arrayLettEn.add('e');
        arrayLettEn.add('f');
        arrayLettEn.add('g');
        arrayLettEn.add('h');
        arrayLettEn.add('i');
        arrayLettEn.add('j');
        arrayLettEn.add('k');
        arrayLettEn.add('l');
        arrayLettEn.add('m');
        arrayLettEn.add('n');
        arrayLettEn.add('o');
        arrayLettEn.add('p');
        arrayLettEn.add('q');
        arrayLettEn.add('r');
        arrayLettEn.add('s');
        arrayLettEn.add('t');
        arrayLettEn.add('u');
        arrayLettEn.add('v');
        arrayLettEn.add('w');
        arrayLettEn.add('x');
        arrayLettEn.add('y');
        arrayLettEn.add('z');
    }

    public static void toAddArrayRu() {
        arrayLettRu.add('à');
        arrayLettRu.add('á');
        arrayLettRu.add('â');
        arrayLettRu.add('ã');
        arrayLettRu.add('ä');
        arrayLettRu.add('å');
        arrayLettRu.add('¸');
        arrayLettRu.add('æ');
        arrayLettRu.add('ç');
        arrayLettRu.add('è');
        arrayLettRu.add('é');
        arrayLettRu.add('ê');
        arrayLettRu.add('ë');
        arrayLettRu.add('ì');
        arrayLettRu.add('í');
        arrayLettRu.add('î');
        arrayLettRu.add('ï');
        arrayLettRu.add('ñ');
        arrayLettRu.add('ò');
        arrayLettRu.add('ó');
        arrayLettRu.add('ô');
        arrayLettRu.add('õ');
        arrayLettRu.add('ö');
        arrayLettRu.add('÷');
        arrayLettRu.add('ý');
        arrayLettRu.add('þ');
        arrayLettRu.add('ÿ');
    }

    public static void toAddArraySymb() {
        arraySymb.add(' ');
        arraySymb.add(',');
        arraySymb.add('.');
        arraySymb.add('?');
        arraySymb.add('!');
        arraySymb.add('-');
        arraySymb.add('"');
        arraySymb.add(':');
        arraySymb.add('(');
        arraySymb.add(')');
        arraySymb.add('%');
    }
}
