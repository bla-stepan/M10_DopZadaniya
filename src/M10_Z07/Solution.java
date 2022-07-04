package M10_Z07;

import java.io.*;
import java.util.Scanner;

/*
Задача 7
Напишите программу, которая будет метрономом считать ритм для танцев.
В файле dance.txt находятся целые числа, каждое с новой строки.
Первое число — ритм, который надо отсчитывать (то есть количество шагов в танце).
Затем перечислены длительности танцев (в шагах).
Для каждого числа после первого в файл rhythm.txt нужно записать два числа:
столько раз повторился ритм (сколько полных «элементов» танца было пройдено) и сколько осталось.
Для этого реализуйте метод dance().
Пример
Файл dance.txt:
4 24 15 9 98
Файл rhythm.txt после вызова метода dance():
6 0 3 3 2 1 24 2
 */
public class Solution {
    public static void main(String[] args) {

    }
    public void dance() throws IOException {
        //StringBuilder stringBuilder;
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z07/dance"));
        StringBuilder stringBuilder = new StringBuilder();
            //серез класс интегер переводим в интовый тип значение сканера (первая строка)
            int ritm = Integer.parseInt(scanner.nextLine());
            while (scanner.hasNextLine()) {
                int step = Integer.parseInt(scanner.nextLine());
                int result;
                stringBuilder.append(step / ritm).append(" ").append(step % ritm).append("\n");
            }
        //пишем результат в файл
        FileWriter writer = new FileWriter(new File("src/M10_Z07/rhythm.txt"));
        writer.write(stringBuilder.toString().trim());
        writer.flush();
    }
}
