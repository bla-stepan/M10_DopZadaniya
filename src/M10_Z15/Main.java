package M10_Z15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

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
public class Main {
    public static void main(String[] args) {

    }

    public int trees()throws FileNotFoundException {
        int treeSum=0;
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z15/trees")));
        String[] strings = scanner.nextLine().split(" ");
        //найти максимум в массиве
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i]=Integer.parseInt(strings[i]);
        }
        IntStream intStream = Arrays.stream(ints);
        OptionalInt optionalInt = intStream.max();
        int max = optionalInt.getAsInt();

        return treeSum;
    }
}

