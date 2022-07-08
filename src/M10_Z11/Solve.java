package M10_Z11;

import java.io.*;
import java.util.Scanner;

/* Задача 11
Итак, время представить, что вы очень умный, но очень ленивый школьник, которому задают решать очень много легких примеров.
Вы умеете только +, - и *. Чтобы не делать уроки весь день, нам нужно написать программу, которая будет делать это за нас.
в файле arithmetic.txt лежат примеры, которые нам надо решить. Выглядят они так:
5 + 3
2 * 8
13 - 7
…
Наша задача — написать метод solve(), который должен считать этот файл и решить данные примеры.
Ответы записать в файл answers.txt, который должен выглядеть так:
5 + 3 = 8
2 * 8 = 16
13 - 7 = 6
...
 */
public class Solve {
    public static void main(String[] args) {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solve() throws IOException {
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z11/arithetic")));

        //объявляем и задаем переменные для расчетов
        int value1 = 0, value2 = 0, result = 0;
        String operator = "";
        String stringResult = "";
        //создаем цикл до тех пор пока есть следующая строка
        while (scanner.hasNextLine()) {
            stringResult = scanner.nextLine();
            //считываем в массив строку
            String[] strings = scanner.nextLine().split(" ");
            //переводим в тип инт первый элемент массива
            value1 = Integer.parseInt(strings[0]);
            //переводим в тип инт второй элемент массива
            value2 = Integer.parseInt(strings[2]);
            //оператор
            operator = strings[1];
            //делаем решение
            switch (operator) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
            }
            stringResult = String.format("%s = %d", stringResult, result);
        }
        FileWriter writer = null;
        writer = new FileWriter(new File("src/M10_Z11/answers.txt"));
        writer.write(stringResult);
        writer.flush();

    }
}
