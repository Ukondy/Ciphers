package ciphers.cezar;

public class CipherCaesar {
    private final static String ALPHABET =
                    "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
                    ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char aChar : message.toCharArray()) {
            int index = ALPHABET.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % ALPHABET.length();
                char charAt = newIndex < 0 ? ALPHABET.charAt(ALPHABET.length() + newIndex) : ALPHABET.charAt(newIndex);
                result.append(charAt);
            }
        }
        return result.toString();
    }

    public String decrypt(String message, int key) {
        return encrypt(message, key * (-1));
    }

    public int alphabetLength() {
        return ALPHABET.length();
    }
}