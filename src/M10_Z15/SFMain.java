package M10_Z15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SFMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/M10_Z15/trees"));
        String[] trees = scanner.nextLine().split(" ");

        //проверка того что мы имеем больше одного дерева
        if (trees.length != 1) {
            int x = 0, y = 0;
            int x1 = 0, y1 = 0;

            int tree = findTree(trees, 1, trees.length);
            int tree2 = findTree(trees, 0, trees.length - 1);
            System.out.println(Math.max(tree, tree2));
        }else {
            System.out.println(trees[trees.length - 1]);
        }
    }

    private static int findTree(String[] trees, int start, int end) {
        int x = 0, y = 0;
        int tree = 0;
        for (int i = start; i < end; i++) {
            int temp = x;
            x = y + Integer.parseInt(trees[i]);
            y = Math.max(temp, y);
            tree = Math.max(x, y);
        }
        return tree;
    }
}
