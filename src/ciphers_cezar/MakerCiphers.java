package ciphers_cezar;

import java.util.Collections;

public class MakerCiphers {
    public static String toCezar(String string, String sign) {
        char[] stringArr = string.toCharArray();
        for (char symbol : stringArr) {
            char symb = Letters.letters(symbol, sign);
            Main.cezarStr += symb;
        }
        return string;
    }
    public static String toCezarReverse(String string, String sign) {
        char[] stringArr = string.toCharArray();
        for (char symbol : stringArr) {
            char symb = Letters.lettersReverse(symbol, sign);
            Main.cezarStr += symb;
        }
        return string;
    }
}
