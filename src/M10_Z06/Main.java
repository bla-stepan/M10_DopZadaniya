package M10_Z06;

import jdk.swing.interop.DispatcherWrapper;

import java.io.*;
import java.util.Scanner;

/*
Задача 6
В файле data.txt записано число, а затем строки. Число — это то, на сколько символов может отличаться длина строки от
средней длины строк (то есть это длина всех строк, нацело деленная на количество строк).
Ваша задача — реализовать метод solution(), который должен записать в файл output.txt
среднюю длину строк,
а затем все строки, которые отличаются от средней длины не более чем на данное число в файле data.txt.
P.S. Если таких строк нет, то в файл output.txt следует записать только среднюю длину строк.
Пример
Файл data.txt:
1
Hello world,
It’s me,
Mario!
Файл output.txt после вызова метода solution():
13
Hello world,
 */
public class Main {
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод согласно задания
    public static void solution() throws IOException {//правильно
        //создаем сканнер
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z06/data"));//правильно
        int i = 0, length = 0;
        StringBuilder ollStrings = new StringBuilder();
        //считываем строки
        int limit = Integer.parseInt(scanner.nextLine());//правильно
        while (scanner.hasNextLine()) {//правильно
            String string = scanner.nextLine();//считываем новую строчку.length();
            ollStrings.append(string).append("\n");//преобразовываем переданный объект в строку и добавляет к текущей строке.
            length += string.length();//устанавливаем значение длинны строки
            //strS = string /
            i++;
        }
        //среднее значение длинны строки
        StringBuilder result = new StringBuilder(length / i + "\n");
        System.out.println(result);
        //создаем массив со всеми строками
        //                   (1)         (2)      (3)     (4)        (5)
        String[] strings = ollStrings.toString().trim().split("\n");
        // 1 - строка, 2 - переводим в тип стринг, 3 - убираем пробелы в начале и конце строки 4 - разделяем строку на массив по используя разделитель 5
        //для каждого объекта массива стрингс выполниить следующее
        for (String string : strings){
            //проверяем на соответствие условию
            if (Math.abs(string.length()-length/i)<=limit) result.append(string).append("\n");
        }
        //создаем объект райтера
        FileWriter fileWriter = new FileWriter("src/M10_Z06/output.txt", false);
        //записываем в фойл
        fileWriter.write(result.toString());//.trim());
        //закрываем поток
        fileWriter.flush();
        //Вебинар п собеседованию
        String s = "Степан ";
        System.out.println(s.repeat(5));
        //StringBuilder stringBuilder = new StringBuilder(s).reverse();
        System.out.println(new StringBuilder(s).reverse());

        for (Character synbol : s.toCharArray()){
            if (!Character.isDigit(synbol)){
                System.out.println("нет");
            } else {
                System.out.println("да");
            }
        }
    }
}
