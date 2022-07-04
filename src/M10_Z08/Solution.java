package M10_Z08;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Задача 8
Каждый год вузы анализируют результаты сдачи ЕГЭ по разным предметам.
На основе этой статистики вузы устанавливают вступительные баллы. Ваша задача — написать программу-помощник для анализа.
Удобнее реализовывать работу с подобными файлами при помощи CSV-документов, но мы работаем с обычными файлами,
так что все будет немного иначе.
Вам дан файл EGE.txt, вот несколько первых строк этого файла:
Subject; Quantity; Passed in %;  Not passed in %
Math;    659973;   86.2;         13.8
History; 212526;   79.1;         20.9
…
Как вы поняли, это «таблица»: первая строка — заголовки, остальные — данные.
Задача: реализовать метод solution(double n), в этот метод передается число
n — не менее такого количества процентов должно быть в поле Passed in %.
Этот метод должен вывести в консоль те предметы, которые сдали не меньше данного числа.
Пример
Вызывается метод solution(80). В консоли должно появиться:
Math
 */
public class Solution {
    public static void main(String[] args) {
        int n = 80;
        try {
            solution(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(double n) throws IOException {
        //создаем сканнер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z08/EGE"));
        //создаем лист для загрузки данных
        //List<String> list = new ArrayList<>();
        //создаем массив и загружаем первую строчку
        String[] strings = scanner.nextLine().split(";");
        //создаем цикл пока есть следующая строчка
        while (scanner.hasNextLine()){
            //загружаем строки
            String[] element = scanner.nextLine().split(";");
            //загружаем данные для сравнения
            double percents = Double.parseDouble(element[2]);
            //проверяем условие
            if (n<=percents) System.out.println(element[0]);
        }
    }
}
