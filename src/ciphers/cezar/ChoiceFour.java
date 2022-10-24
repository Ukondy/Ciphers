package ciphers.cezar;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ChoiceFour {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Character, Integer> map = new HashMap<>();

    public void choiceFour() throws IOException {

        System.out.println("Введите путь до зашифрованого файла");
        String pathDecrypt = scanner.nextLine();

        System.out.println("Введите путь до файла для набора статистики файла");
        String pathStatistic = scanner.nextLine();

        System.out.println("Введите путь до местя для сохранения файла");
        String pathEncrypt = "D:\\testJava\\target2.txt";

        Map<Character, Integer> fillMapStatistic = fillMapValues(map, pathStatistic); // один и тот же map используется
        Map<Character, Integer> fillMapDecrypt = fillMapValues(map, pathDecrypt); // один и тот же map используется

        List<Map.Entry<Character, Integer>> list;
        List<Map.Entry<Character, Integer>> list2;

        list = sortMap(fillMapStatistic);
        list2 = sortMap(fillMapDecrypt);

        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            System.out.print(characterIntegerEntry.getKey() + " ");
        }
        System.out.println();
        for (Map.Entry<Character, Integer> characterIntegerEntry : list2) {
            System.out.print(characterIntegerEntry.getKey() + " ");
        }
        System.out.println();
    }

    private Map<Character, Integer> fillMapValues(Map<Character, Integer> map, String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            for (char aChar : builder.toString().toCharArray()) {
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                } else {
                    map.put(aChar, map.get(aChar) + 1);
                }
            }
        }
        return map;
    }

    private List<Map.Entry<Character, Integer>> sortMap(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
//        Comparator<Map.Entry<Character, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);
        Comparator<Map.Entry<Character, Integer>> comparator1 = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        list.sort(comparator1);
        return list;
    }
}
