package M10_Z09;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача 9
Есть таблица crop_volumes.txt, она содержит в себе данные о сборе урожая в разных регионах России, выглядит так:
Part;            Federal District; 2016; 2017; 2018; 2019;  2020
Belgorod region; Central;          23.2; 24.4; 25.9; 28.34; 39.0
Bryansk region;  Central;          19.7; 20.0; 21.4; 23.6;  24.0
…
Реализуйте метод solution(String district, int fromYear, int toYear), принимающий строку —
название федерального округа и данные за 2 года.
Метод должен записать в файл data.txt те субъекты федерации, которые принадлежат указанному округу,
и уровень урожайности в которых конечный год вырос более чем на 4% по сравнению с начальным.
Конечный файл должен выглядеть примерно так:
Part;2018;2019
Komi Republic;2;2.7
…
P.S. Если не было найдено ни одного подходящего субъекта, то в файл data.txt следует записать только заголовки.
 */
public class Main {
    public static void main(String[] args) {
        try {
            solution("Central", 2018, 2019);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution(String district, int fromYear, int toYear) throws IOException {
        //String filePath = "src/M10_Z09/crop_volumes";
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z09/crop_volumes"));

        //грузим массив
        String[] columnName = scanner.nextLine().split(";");
        //создаем строчку результата
        String result = "Part;" + fromYear + ";" + toYear;
        //создаем цикл для обработки строк
        while (scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(";");
            if (elements[1].equals(district)) {
                //отбираем данные по заданным годам для расчета индекса прироста
                //  индекс      преобразуем в лист      индекс объекта соответсвующего значению фореар
                int index1 = Arrays.asList(columnName).indexOf(String.valueOf(fromYear));
                int index2 = Arrays.asList(columnName).indexOf(String.valueOf(toYear));
                //определяем значения по индексам
                double valueFromYear = Double.parseDouble(elements[index1]);
                double valueToYear = Double.parseDouble(elements[index2]);
                //проверяем условие
                if (valueFromYear * 1.04 < valueToYear) {
                    result += "\n" + elements[0] + ";" + valueFromYear + ";" + valueToYear;
                    System.out.println(result);
                }
            }
        }
        //создаем поток ввода для записи в файл
        FileWriter writer = new FileWriter(new File("src/M10_Z09/data.txt"), false);
        //пишем в файл
        writer.write(result);
        //закрываем поток
        writer.flush();
    }
}
