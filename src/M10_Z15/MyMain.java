package M10_Z15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Задача 15
Деревья, высаженные вокруг поселка, выросли неожиданно быстро. И теперь они загораживают слишком много солнца.
Совсем вырубать их жалко, а вот проредить надо. Жители поселка договорились пригласить лесорубов, и в качестве оплаты
отдать им срубленные деревья. Вот только рубить разрешили так, чтобы нигде не оказалось срубленным два соседних дерева.
Чем толще дерево, тем дороже оно стоит. Напишите программу, которая подскажет лесорубам, какую наибольшую выгоду
можно получить, но и условие жителей выполнить.
В файле trees.txt записаны целые числа через пробел — толщина каждого дерева.
Вывести необходимо одно число — максимальную сумму, которую можно получить при условии, что нельзя рубить два соседних дерева.
Деревья полностью окружают поселок, поэтому последнее число соседствует с первым.
Пример trees.txt: 2 3 2 Вывод: 3
trees.txt: 1 2 3 1 Вывод: 4
В первом примере нельзя взять числа 2 и 2, поскольку они соседствуют друг с другом.
Будем считать, что если дерево одно, то срубить можно только его, а если их два, то только одно из них. */

//МОЁ РЕШЕНИЕ

public class MyMain {
    private static final String fileName = "src/M10_Z15/trees";

    public static void main(String[] args) throws FileNotFoundException {
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        //создаем массив строк из файла
        String[] strings = scanner.nextLine().split(" ");
        //вызываем метод
        trees(strings);
    }

    public static int trees(String[] strings) throws FileNotFoundException {
//        int treeSum = 0;
        //создаем численный массив размером с массив строк
//        int[] ints = new int[strings.length];
//
//        //переводим каждую строку в чсило и помещаем в массив чисел
//        for (int i = 0; i < strings.length; i++) {
//            ints[i] = Integer.parseInt(strings[i]);
//            System.out.print(i + "{" + ints[i] + "} ");
//        }
//        int r = 0;
//        for (String j : strings) {
//            r++;
//            System.out.print(r + "{" + j + "} ");
//        }
//        System.out.println();
        //четность и нечетность числа элементов массива

        int treeSum1 = 0;
        int treeSum2 = 0;
        int treeSum3 = 0;
        if (strings.length % 2 == 0) {
            //если четное
            for (int i = 0; i < strings.length; i += 2) {
                treeSum1 += Integer.parseInt(strings[i]);
                treeSum2 += Integer.parseInt(strings[i + 1]);
            }
            System.out.println("(event) sum1:" + treeSum1 + " sum2:" + treeSum2);
        } else {
            //если не четное
            for (int i = 0; i < strings.length - 1; i += 2) {
                treeSum1 += Integer.parseInt(strings[i]);
                treeSum2 += Integer.parseInt(strings[i + 1]);
                treeSum3 += Integer.parseInt(strings[i + 2]);
            }
            System.out.println("sum1:" + treeSum1 + " sum2:" + treeSum2 + " sum3:" + treeSum3);
        }
        //ищем максимум
        int treeSum = Math.max(Math.max(treeSum1, treeSum3), treeSum2);

//        //помещаем результат а массив результатов
//        int[] treeSumArray = {treeSum1, treeSum2, treeSum3};
//        //пробегаемся циклом по массиву получаем максимум
//        for (int j : treeSumArray) {
//            if (j > treeSum)
//                treeSum = j;
//        }

        System.out.println(String.format("Вывод: %s", treeSum));
        return treeSum;
    }
}

