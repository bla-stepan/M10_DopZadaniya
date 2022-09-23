package M10_Z16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//предлагаемое решение задания 16
public class SFMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z16/files"));

        //создаем массивы для каждого типа файлов
        String[] tempTxt = new String[100];
        String[] tempZip = new String[100];
        String[] tempBmp = new String[100];

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

            //добавляем файла в массив
            if (type.equals("bmp")) {
                tempBmp[bmpCount] = name;
                bmpCount++;
                bmpB += size;
            } else if (type.equals("txt")) {
                tempTxt[txtCount] = name;
                txtCount++;
                txtB += size;
            } else if (type.equals("zip")) {
                tempZip[zipCount] = name;
                zipCount++;
                zipB = size;
            }
        }
        //создаем массивы для типов файлов
        String[] txt = new String[txtCount];
        String[] bmp = new String[bmpCount];
        String[] zip = new String[zipCount];

        //если значение count больше или равно 0 то копируем начиная с 0 элементы из массива темп и вставляем в 0 позицию массива txt.
        if (txtCount >= 0) System.arraycopy(tempTxt, 0, txt, 0, txtCount);
        if (bmpCount >= 0) System.arraycopy(tempBmp, 0, bmp, 0, bmpCount);
        if (zipCount >= 0) System.arraycopy(tempZip, 0, zip, 0, zipCount);

        //сортируем массивы
        Arrays.sort(txt);
        Arrays.sort(bmp);
        Arrays.sort(zip);

        //переделываем единицы измерения байтов
        String[] zipArr = convertToMaxUnits(zipB);
        String[] txtArr = convertToMaxUnits(txtB);
        String[] bmpArr = convertToMaxUnits(bmpB);

        String resultFinal = "";
        resultFinal += buildResultString(bmp, bmpArr);
        resultFinal += buildResultString(txt, txtArr);
        resultFinal += buildResultString(zip, zipArr);

        FileWriter fileWriter = new FileWriter(new File("src/M10_Z16/output.txt"), false);
        fileWriter.write(resultFinal.trim());
        fileWriter.flush();
    }

    //метод конвертации максимального размера файлов
    public static String[] convertToMaxUnits(int bytes) {
        //создаем массив дробных значений
        double[] bytesToUnits = {(double) bytes, (double) bytes / 1024, (double) bytes / (1024 * 1024)};
        String nowType = "B";
        if (bytesToUnits[2] >= 0.5) {
            nowType = "MB";
        } else if (bytesToUnits[1] >= 0.5) {
            nowType = "KB";
        }
        if (nowType.equals("B")) return new String[]{bytesToUnits[0] + "", nowType};
        else if (nowType.equals("KB")) return new String[]{Math.round(bytesToUnits[1]) + "", nowType};
        else return new String[]{Math.round(bytesToUnits[0]) + "", nowType};
    }

    //метод построение строки результата
    public static String buildResultString(String[] fileArr, String[] units) {
        String result = "";
        if (fileArr.length > 0) {
            for (String str : fileArr) {
                result += str + "\n";
            }
            result += "=============\n" + units[0] + " " + units[1] + " " + "\n\n";
        }
        return result;
    }
}
