package M10_Z03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
Задача 3
Возьмём первые 10 натуральных чисел. Если из них взять только те, что делятся на 4 или на 5, то это будут 4, 5, 8, 10.
Их произведение будет равно 1600. Ваша задача реализовать метод getMul(), который будет считывать файл data.txt,
в первой строке которого записано число N, до которого (включая его) нужно считать произведение.
В следующей строке файла через пробел записаны числа, на которые должны делиться перебираемые числа.
Метод должен вернуть произведение таких чисел.

Пример
Файл data.txt:
10
4 5
Метод getMul() должен вернуть число 1600.
 */
public class Zadanie_3 {
    public static void main(String[] args) {

    }

    public int getMul() throws FileNotFoundException {
        //переменная с именем файла
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z03/data"));
        //считываем значение чисел
        //преобразовываем строку в число используя класс Integer и его метод parseInt
        int limit = Integer.parseInt(scanner.nextLine());
        //читаем следующую строку и разделяем строку на подстроки ориентируясь на пробел
        String[] divisorsStr = scanner.nextLine().split(" ");
        //создаем массив для хранения прочитанных делителей длинной в стринговы массив
        int[] divisorsInt = new int[divisorsStr.length];
        //создаем цикл и перекидываем значения стрингового массивав с интовый массив
        for (int i = 0; i < divisorsStr.length; i++) {
            //помещаем в интеговый массив значения стрингового массива с преобразованием типа сос тринга в инт
            divisorsInt[i] = Integer.parseInt(divisorsStr[i]);
        }
        int mul=1;
        for (int i = 1; i <= limit; i++) {
            for (int divisor : divisorsInt) {
                if (i % divisor == 0) {
                    mul *= i;
                    break;
                }
            }
        }
        return mul;
    }
}
