package M10_Z04;

import java.io.*;
import java.util.Scanner;

/*
Задача 4
У нас есть робот, который рандомно говорит числа, которые попадают в файл numbers.txt.
Давайте посчитаем, сколько чисел, выданных роботом, совпали со своим порядковым номером (у числа 1 порядковый номер 1, у числа 5 — 5).
Для этого предлагаем вам реализовать метод writeOrder(), этот метод должен анализировать файл numbers.txt и все числа,
которые совпали со своим номером, должен записать в файл output.txt (если таких чисел нет, то в файл нужно записать одно число — 0).
 */
public class Solution {

    private static String fileName = "src/M10_Z04/numbers.txt";

    public static void main(String[] args) {
        //String fileName = "src/M10_Z04/numbers.txt";
        if (fileExist(fileName)) {
            System.out.println("Файл " + fileName + " существует.");
        } else {
            fileCreate(fileName);
            System.out.println("Файл " + fileName + " создан.");
        }
        try {
            writeOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOrder() throws IOException {
        //создадим сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int index = 1;
        String numberOut = "";

        while (scanner.hasNextLine()) {
            //пока есть строчки
            String numbers = scanner.nextLine();
            //если номер совпадает с индексом
            if (Integer.parseInt(numbers) == index) {
                //складываем строку
                numberOut += numbers + " ";
            }
            index++;
        }
        //если строка все также "" то
        if (numberOut.equals("")) numberOut = "0";

        //пишем результат в файл
        FileWriter fileWriter = new FileWriter("src/M10_Z04/output.txt");
        //trim - убирает пробелы в начале и в конце строки
        fileWriter.write(numberOut.trim());
        //flush - если есть какие-то данные и они еще не записаны то они записываются
        fileWriter.close();
    }

    private static boolean fileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    private static void fileCreate(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}