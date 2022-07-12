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
        String str = "PRIVET, KAK U TEBYA DELA?";

        String[] strings = str.split("");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
    }

    public static void translate() throws IOException {
        //создаем сканер для чтения сообщения для перевода
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z13/messege")));
        //создаем массив с чаровыми объектами
        while (scanner.hasNextLine()) {
            String[] messege = scanner.nextLine().split("");
            for (int i = 0; i < messege.length; i++) {
                String simvol="";
                switch (messege[i]){
                    case "A": simvol="1000001"; break;
                    case "B": simvol="1000010"; break;
                    case "C": simvol="1000011"; break;
                    case "D": simvol="1000100"; break;
                    case "E": simvol="1000101"; break;
                    case "F": simvol="1000110"; break;
                    case "G": simvol="1000111"; break;
                    case "H": simvol="1001000"; break;
                    case "I": simvol="1001001"; break;
                    case "J": simvol="1001010"; break;
                    case "K": simvol="1001011"; break;
                    case "L": simvol="1001100"; break;
                    case "M": simvol="1001101"; break;
                    case "N": simvol="1001110"; break;
                    case "O": simvol="1001111"; break;
                    case "P": simvol="1010000"; break;
                    case "Q": simvol="1010001"; break;
                    case "R": simvol="1010010"; break;
                    case "S": simvol="1010011"; break;
                    case "T": simvol="1010100"; break;
                    case "U": simvol="1010101"; break;
                    case "V": simvol="1010110"; break;
                    case "W": simvol="1010111"; break;
                    case "X": simvol="1011000"; break;
                    case "Y": simvol="1011001"; break;
                    case "Z": simvol="1011010"; break;
                }
            }
        }

    }
}
