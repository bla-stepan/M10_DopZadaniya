package M10_Z13;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*Задача 13
Научимся общаться с роботом. Робот умеет говорить только с помощью бинарного алфавита, то есть каждая буква кодируется 0 и 1.
Давайте напишем программу-перекодировщик, которая переведёт наше сообщение на язык робота.
Реализуйте метод translate() — этот метод должен считать текст из сообщения message.txt и перевести его в строку из 0 и 1.
После чего вернуть строку — переведенное сообщение, с сохранением всех символов (запятых, точек и так далее), табуляций
и новых строк (энтеров).
Таблица перевода
1000001 A 1000010 B 1000011 C 1000100 D 1000101 E
1000110 F 1000111 G 1001000 H 1001001 I 1001010 J
1001011 K 1001100 L 1001101 M 1001110 N 1001111 O
1010000 P 1010001 Q 1010010 R 1010011 S 1010100 T
1010101 U 1010110 V 1010111 W 1011000 X 1011001 Y 1011010 Z
Пример Файл message.txt:
PRIVET, KAK U TEBYA DELA?
Метод translate() должен вернуть строку:
101000010100101001001101011010001011010100, 100101110000011001011 1010101 10101001000101100001010110011000001 1000100100010110011001000001?
 */
public class Main {
    public static void main(String[] args) {
        try {
            translate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            translateSF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void translate() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z13/messege")));//создаем сканер для чтения сообщения для перевода
        StringBuilder transcoding = new StringBuilder();//создаем стринг билдер для формирования строчки для робота
        while (scanner.hasNextLine()) {
            String[] messege = scanner.nextLine().split("");
            String simvol = "";
            for (int i = 0; i < messege.length; i++) {
                char cr = messege[i].charAt(0);
                if (messege[i].equals(" ") || messege[i].equals("?") || messege[i].equals(",") || messege[i].equals("!")) {
                    simvol = messege[i];
                } else {
                    simvol = Integer.toString(Character.getNumericValue(cr) + 55, 2);
                }
                transcoding.append(simvol);
            }
        }
        System.out.println(transcoding);
    }

    public static void translateSF() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z13/messege")));
        String[] binLetters = ("1000001;1000010;1000011;1000100;1000101;1000110;1000111;1001000;1001001;" +
                "1001010;1001011;1001100;1001101;1001110;1001111;1010000;1010001;1010010;1010011;1010100;" +
                "1010101;1010110;1010111;1011000;1011001;1011010").split(";");
        String[] englishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        String maasege = "";
        while (scanner.hasNextLine()) {
            String stringMassege = scanner.nextLine();
            String[] arrey = stringMassege.split(";");
            for (String symbol : arrey) {
                int index = findSymbol(symbol, englishLetters);
                maasege += index != -1 ? binLetters[index] : symbol;
            }
            maasege += "\n";
        }
        System.out.println(maasege.trim());
    }

    private static int findSymbol(String symbol, String[] engLetters) {
        for (int i = 0; i < engLetters.length; i++) {
            if (engLetters[i].equals(symbol)) return i;
        }
        return -1;
    }
}
