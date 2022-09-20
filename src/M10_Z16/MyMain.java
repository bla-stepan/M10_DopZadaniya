package M10_Z16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.Scanner;

/*
Задание 16
написать программу по анализу файлов. имеется файл files.txt  в которое есть информация о некоторых файлах, расширение которых
может быть ZIP, BMP, TXT. у каждого файла есть название, расширение и размер (байты, килобайты, мегабайты).
 задача: сгруппировать файлы в группы по расширению, выставить группы в алфавитном порядке,
 внутри группы файлы тоже должны быть отсортированы. после каждой группы должен быть выведен суммарны объем, сколько на компьютере
 файлы данной группы занимают места. и все это надо записать в файл output.txt
 пример output.txt
 input.txt
 output.txt
 ---------
 summary: 4 KB

 */
public class MyMain {
    private static final String files = "src/M10_Z16/files";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(files));

        //создаем массивы для всех типов файлов
//        String[] fileTxt =new String[10];
//        String[] fileBmp =new String[10];
//        String[] fileZip =new String[10];


        //while (scanner.hasNextLine()) {
        //загоняем в массив стоки про файлы
        String[] filesInfo = scanner.nextLine().split("\n");


        for (int i = 0; i < filesInfo.length; i++) {
            System.out.println("FI(" + filesInfo[i] + ") ");
        }
        int i = 0;
        fileBuilder(filesInfo, String.format("file%s", i));
        //}
        //String str = filesInfo[0];


    }

    private static Files fileBuilder(String[] fileOptions, String fileObjectName) {
        String[] fileOpt = fileOptions[0].split(" ");
        //StringBuilder sb = new StringBuilder(fileOpt[0]);
        for (String str: fileOpt) {
            System.out.println(str);
        }
        String fileName = fileOpt[0].trim().substring(0, fileOpt[0].length() - 4);
        System.out.println(fileName);
        String fileExpansion = fileOpt[0].trim().substring(fileOpt[0].length() - 3);
        System.out.println(fileExpansion);
//        System.out.println(fileOpt[1]);
        int volume = Integer.parseInt(fileOpt[1].trim());
        switch (fileOpt[2]) {
            case "KB":
                volume = volume * 1024;
                break;
            case "MB":
                volume = volume * 1024*1024;
                break;
            default:
                volume = volume;
                break;
        }
        System.out.println(volume);
        return new Files(fileName, fileExpansion, volume);
    }
}

