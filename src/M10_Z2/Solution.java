package M10_Z2;
/*Задача 2
Вам дан файл text.txt. Ваша задача — реализовать метод getCountWords(), возвращающий количество слов в тексте
(словом считается все, что отделено пробелами с двух сторон).
Пример
Файл text.txt:
Hello world,
It’s me!
Метод getCountWords() должен вернуть число 4. */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public int getCountWords() throws FileNotFoundException {
        //создаем сканер
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z2/text.txt"));//сканер считывает входной поток из файла "src/M10_Z2/text.txt"
        int countWords = 0;
        while (scanner.hasNextLine()){//пока поток имеет следующую строку
            //создаем массив и кладем туда слова
            //      массив   сканер   следу.строка
            String[] words = scanner.nextLine().split(" ");//кладем объекты выделенные пробелом
            //System.out.println();
            countWords = words.length;//суммируем слова
        }
        return countWords;
    }
}
