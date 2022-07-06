package M10_Z10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача 10
Интегрирование — это вычисление площади фигуры, расположенной под графиком функции (конечно же, это не совсем так, но сейчас нам нужно лишь это).
Представьте, что вам нужно найти площадь под графиком линейной функции.
В этом нет ничего сложного, так как это просто площадь трапеции (произведению полусуммы оснований на высоту).
Хорошо, а что делать, если функция нелинейная?
Давайте будем пробовать разбивать функцию на много трапеций, считать площадь каждой, а после суммировать их.
Получим что-то приближенное к реальности.
Реализуйте метод findSquare(), он должен считать точки, записанные в файле points.txt
(каждая строка — это координаты точки (X, Y)), и возвращать вещественное число — площадь фигуры под графиком.
Гарантируется, что все точки — целые числа, лежат в первой четверти и отсортированы по оси X (то есть самая первая точка — самая левая).
Пример файла points.txt:
1 1
2 2
Метод findSquare() должен вернуть 1.5
 */
public class Main {
    public static void main(String[] args) {
        try {
            findSquare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findSquare() throws IOException {
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z10/points")));
        //создаем массив, считываем первые кординаты
        String[] value = scanner.nextLine().split(" ");
        //создаем переменную площади
        double square = 0;

        while (scanner.hasNextLine()) {
            //считываем следующие координаты
            String[] valueNext = scanner.nextLine().split(" ");

            int X1 = Integer.parseInt(value[0]);
            int Y1 = Integer.parseInt(value[1]);
            int Xn = Integer.parseInt(valueNext[0]);
            int Yn = Integer.parseInt(valueNext[1]);

            double a = Y1;
            double b = Yn;
            double h = Xn - X1;
            square += (a + b) / 2 * h;
            //заменяем value на valueNext и переходем на следующую итерацию
            value=valueNext;
        }
        System.out.println(square);
    }

}
