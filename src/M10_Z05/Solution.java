package M10_Z05;
/*
Задача 5
В файле strings.txt лежат строки, которые, возможно, являются палиндромами (зеркальное слово АННА).
Реализуйте метод arePalindromes(): этот метод должен вернуть true, если каждая строка в данном файле — палиндром,
или false, если это не так. Пробелы и большие буквы в строках не учитываются, также гарантируется, что знаков препинания не будет.
Пример
Файл strings.txt:
Коту тащат уток
шалаш
Метод arePalindromes(), должен вернуть true.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String fileName = "src/M10_Z05/strings.txt";
        try {
            System.out.println(arePalindromes(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean arePalindromes(String fileName) throws FileNotFoundException {
        //создать сканнер
        Scanner scanner = new Scanner(new FileInputStream(fileName));

        //создать чтение пока есть следующая строка
        while (scanner.hasNextLine()) {
            //переменная = строке считанной
            String str = scanner.nextLine();
            //toLowerCase - преобразует все символы в нижний регистр
            //replace - заменяем старый текст на новый
            str = str.toLowerCase().replace(" ", "");
            if (!str.equals(new StringBuilder(str.toLowerCase()).reverse().toString())) return false;
        }
        return true;
    }
}
