package ciphers.cezar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ChoiceOne {

    private final Scanner scanner = new Scanner(System.in);
    private final CipherCaesar caesar = new CipherCaesar();

    public void choiceOne() throws IOException {

        System.out.println("Enter path to file");
        String path = scanner.nextLine();

        System.out.println("Enter key for cipher");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter path to cipher's file");
        String targetPath = scanner.nextLine();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(targetPath))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = caesar.encrypt(string, key);
                writer.write(encrypt + System.lineSeparator());
            }
            System.out.println("Содержимое файла зашифрованно." + System.lineSeparator() );
        }
    }
}
