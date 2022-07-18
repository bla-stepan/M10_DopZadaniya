package M10_Z14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Задача 14
Профессиональный грибник только что составил карту грибных мест в лесу. Лес представляет собой квадрат 10 на 10 километров,
поэтому грибник составил схему леса в виде квадрата 10 на 10 клеток. В каждую клетку грибник написал цифры, чем больше цифра,
тем больше там грибов. Но так как грибник уже стар, чтобы бегать по всему лесу за грибами, да и другие грибники могут
успеть вынести весь лес, вам нужно продумать самый выгодный маршрут и вывести в консоль количество грибов, которые сможет
собрать грибник, если начинает он в самой левой верхней клетке леса, а передвигаться он может только вправо и вниз.

Для решения данной задачи, вы должны реализовать метод findMaxQuantity(), который проанализирует файл forest.txt
и вернёт максимально возможное количество грибов, которые сможет собрать грибник.
Вот как он выглядит:
51;21;93;48;45;100;67;39;18;29//
57;43;97;51;92;10;93;32;19;58//
63;16;31;16;78;88;90;72;37;67//
10;57;64;25;96;50;81;65;91;69//
99;43;95;7;40;76;18;34;5;65//
35;19;71;77;64;38;62;56;10;2//
100;57;27;26;51;33;100;11;53;1//
11;79;49;46;37;69;80;31;25;39//
22;71;20;23;11;12;39;16;64;34
4;25;87;84;30;48;77;13;40;33
Для данного файла ответ будет: 1204
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(new Main().findMaxQuantity());
    }

    public int findMaxQuantity() throws FileNotFoundException {
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z14/forest")));
        //создаем двухуровневый массив
        int[][] forest = new int[10][10];
        int k = 0;
        //заполняем массив лес значениями
        while (scanner.hasNextLine()) {
            //создали массив строк
            String[] quantity = scanner.nextLine().split(";");
            //загружаем данные по к ряду.
            for (int i = 0; i < 10; i++) {
                forest[k][i] = Integer.parseInt(quantity[i]);
            }
            k++;
        }
        for (int i = 1; i < 10; i++) {
            forest[i][0] += forest[i - 1][0];
            forest[0][i] += forest[0][i - 1];
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(forest[i][j]+", ");
                forest[i][j] += Math.max(forest[i - 1][j], forest[i][j - 1]);
            }
            System.out.println("");
        }
        return forest[9][9];
    }
}
