package ciphers.cezar;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("""
                    Выберите что вы хотите сделать:
                    1 - зашифровать,\s
                    2 - расшифровать,\s
                    3 - выполнить брут форс,\s
                    4 - синтаксический анализ,\s
                    5 - что бы выйти из программы\s
                    """);
            String answer = scanner.nextLine();
            switch(answer) {
                case "1" -> new ChoiceOne().choiceOne();
                case "2" -> new ChoiceTwo().choiceTwo();
                case "3" -> new BrutForce().brutForce();
                case "4" -> new ChoiceFour().choiceFour();
                case "5" -> {return;}
            }
        }
    }
}
//D:\testJava\source.txt
//D:\testJava\target.txt
// запросить зашифрованный текст запросить текст для набора статисткики собрать статистику
// для первого и для второго файла остортировать их от большему к меньшему по колличеству
// найденных символов объеденить эти две структуры данных и с помошью структуры выполнить расшифровку текста