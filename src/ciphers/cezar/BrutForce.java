package ciphers.cezar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrutForce {

    private final Scanner scanner = new Scanner(System.in);
    private final CipherCaesar caesar = new CipherCaesar();

    public void brutForce() throws IOException {
        System.out.println("Enter first path to file");
        String firstPath = scanner.nextLine();

        System.out.println("Enter second path to file");
        String secondPath = scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(firstPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(secondPath))) {
            while (reader.ready()) {
                String string = reader.readLine();
                builder.append(string);
                list.add(string);
            }
            for (int i = 0; i < caesar.alphabetLength(); i++) {
                String decrypted = caesar.decrypt(builder.toString(), i);
                if (isValidateText(decrypted)) {
                    for (String string : list) {
                        String encrypted = caesar.decrypt(string, i);
                        writer.write(encrypted + System.lineSeparator());
                    }
                    System.out.println("���������� ����� ������������ ������� ��������. key: " + i);
                    break;
                }
            }
        }
    }

    private boolean isValidateText(String text) {
        String[] words = text.split(" ");
        boolean isValidate = false;
        for (String word : words) {
            if (word.length() > 25) {
                return false;
            }
        }
        if (text.contains(". ") || text.contains(", ") || text.contains(": ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            String txt = text.substring(0, 90);
            System.out.println(txt + "...\n ����� ����������? Y/N");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                isValidate = false;
            } else {
                System.out.println("������ ��� ������ ����");
            }
        }
        return false;
    }
}
