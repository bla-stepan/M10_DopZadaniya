package M10_Z16;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;
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
        //создаем сканер
        Scanner scanner = new Scanner(new FileInputStream(files));
        //создаем массив для типов файлов
        String[] fileTXT = new String[100];
        String[] fileZIP = new String[100];
        String[] fileBMP = new String[100];
        //создаем переменные для подсчета занимаемого мета
        int sizeTXT = 0;
        int sizeBMP = 0;
        int sizeZIP = 0;
        //создаем счетчики для помещения файлов в массив
        int countTXT = 0;
        int countBMP = 0;
        int countZIP = 0;
        //пока есть следующая строка
        while (scanner.hasNextLine()) {
            //загоняем в массив стоки про файлы
            String[] filesInfo = scanner.nextLine().split(" ");
            //получаем параметры файла
            //имя файлв
            String fileName = filesInfo[0];
            System.out.println(fileName);
            //тип файла
            String fileType = fileName.substring(1+fileName.indexOf('.')).toLowerCase();
            System.out.println(fileType);
            //размер файла
            int size = fileSize(Integer.parseInt(filesInfo[1]), filesInfo[2]);
            //загоняем данные в массив
            switch (fileType) {
                case "txt":
                    fileTXT[countTXT] = fileName;//загоняем название файла в массив для создания группы
                    countTXT++;//счетчик элемента в массиве
                    sizeTXT += size;
                    break;
                case "zip":
                    fileZIP[countZIP] = fileName;
                    countZIP++;
                    sizeZIP += size;
                    break;
                case "bmp":
                    fileBMP[countBMP] = fileName;
                    countBMP++;
                    sizeBMP += size;
                    break;
            }
        }
        //проверка
        for (String str : fileTXT) {
            if (str != null) {
                System.out.print(str);
            }
        }

        resultStringToOutput(fileTXT, "txt", sizeTXT, countTXT);
    }

    private static void filesListPrint(String[] fileArray){
        //создаем файл
        File file = new File("src/M10_Z16/output.txt");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
//            Writer writer = new FileWriter(file, fileArray)
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
    //метод построения строки результата
    private static  String resultStringToOutput(String[] files, String type, int size, int count){
        String[] fileArr = new String[count];//создаем новый массив
        System.arraycopy(files, 0, fileArr, 0, count);//перекопируем из старого
        Arrays.sort(fileArr);//сортируем
        System.out.println(String.valueOf(fileArr));
        return "";
    }

    //метод приведения к нужным единицам
    private static String sizeUnit(int sizeFiles){
        String unit = sizeFiles+" B";
        if (sizeFiles/(1024+1024)>=0.5){
            unit=Math.round(sizeFiles/(1024+1024))+" MB";
        }else if(sizeFiles/1024>=0.5){
            unit=Math.round(sizeFiles/1024)+" KB";
        }
        return unit;
    }
    //метод приведения к байтам
    private static int fileSize(int size, String fileUnit) {
        if (fileUnit.equals("KB")) {
            size *= 1024;
        } else if (fileUnit.equals("MB")) {
            size *= 1024 * 1024;
        }
        System.out.println(size);
        return size;
    }
}

//    private static Files fileBuilder(String[] fileOptions, String fileObjectName) {
//        String[] fileOpt = fileOptions[0].split(" ");
//        //StringBuilder sb = new StringBuilder(fileOpt[0]);
//        for (String str: fileOpt) {
//            System.out.println(str);
//        }
//        String fileName = fileOpt[0].trim().substring(0, fileOpt[0].length() - 4);
//        System.out.println(fileName);
//        String fileExpansion = fileOpt[0].trim().substring(fileOpt[0].length() - 3);
//        System.out.println(fileExpansion);
////        System.out.println(fileOpt[1]);
//        int volume = Integer.parseInt(fileOpt[1].trim());
//        switch (fileOpt[2]) {
//            case "KB":
//                volume = volume * 1024;
//                break;
//            case "MB":
//                volume = volume * 1024*1024;
//                break;
//            default:
//                volume = volume;
//                break;
//        }
//        System.out.println(volume);
//        return new Files(fileName, fileExpansion, volume);
//    }


