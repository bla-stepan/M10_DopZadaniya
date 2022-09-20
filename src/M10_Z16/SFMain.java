package M10_Z16;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//предлагаемое решение задания 16
public class SFMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z16/files"));

        //создаем массивы для каждого типа файлов
        String[] fileTxt = new String[100];
        String[] fileZip = new String[100];
        String[] fileBmp = new String[100];

        //создаем счетчики байт для всех типов файлов
        int zipB = 0;
        int txtB = 0;
        int bmpB = 0;

        //создаем счетчик файлов для всех типоы файлов
        int zipCount = 0;
        int txtCount = 0;
        int bmpCount = 0;

        while (scanner.hasNextLine()) {
            //создаем массив со сканера
            String[] fileInfo = scanner.nextLine().split(" ");

            String name = fileInfo[0];//можно разделить название и расширение
            int size = Integer.parseInt(fileInfo[1]);
            String unit = fileInfo[2];
            String type = name.split("\\.")[1];//возвращает последние символы расширения

            //конвертируем байты
            if (unit.equals("KB")) {
                size *= 1024;
            } else if (unit.equals("MB")) {
                size *= 1024 * 1024;
            }

        }

    }
}
