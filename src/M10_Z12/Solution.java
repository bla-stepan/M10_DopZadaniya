package M10_Z12;

import java.io.*;
import java.util.Scanner;

/*
Задача 12
Ярмарки — это весело, а главное прибыльно. Власти одного королевства хотят иметь с этого свой доход, поэтому они вводят налоги.
Налог зависит от дохода конкретного торговца, а значит, его нужно уметь быстро узнавать.
В метод findMerchant() поступает строка — имя торговца.
Вам будет доступен файл outcome.txt, в котором записаны торговые операции прошедшего дня. Вот заголовки файла и несколько его первых строк:

id; merchant; product; quantity; price
1;  Cherevik; hemp;    20;       5
2;  Gresto;   straw;   12;       6
Ваша задача — посчитать доход данного торговца по каждому товару (количество, умноженное на цену)
и налог, который должен заплатить торговец (15% от заработанного). И вывести это в консоль.
Пример
В метод findMerchant() поступает имя Cherevik.
Файл outcome.txt:
id;merchant;product;quantity;price
1;Cherevik;hemp;20;5
2;Cherevik;straw;12;6
3;Gritsko;harness;3;15
Вывод:
hemp,20,5,100
straw,12,6,72
tax: 25.8
 */
public class Solution {
    public static void main(String[] args) {
        try {
            findMerchant("Cherevik");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findMerchant(String name) throws IOException {
        //создаем сканер для ввода имени в метод
        //Scanner nameEnter = new Scanner(new InputStreamReader(System.in));

        //создаем переменные для расчета
        int quantity=0, price=0;
        double tax = 0;
        //String traderName = name.nextLine();
        String product = "", merchant = "";
        StringBuilder result = new StringBuilder();
        //создаем сканер для чтения файла
        Scanner scanner = new Scanner(new FileInputStream(new File("src/M10_Z12/outcome")));

        //создаем массив строк
        String[] str = scanner.nextLine().split(";");
        while (scanner.hasNextLine()) {
            str = scanner.nextLine().split(";");
            merchant = str[1];
            product = str[2];
            //System.out.println(str[3]);
            quantity = Integer.parseInt(str[3]);
            price = Integer.parseInt(str[4]);
            if (merchant.equals(name)) {
                System.out.print(result.append(product).append(",").append(quantity).append(",").append(price).append(",").append(quantity*price).append("\n"));
                tax += quantity * price * 0.15;
            }// else System.out.println(result);
        }
        System.out.println(String.format("tax: %.2f", tax));//подумать как сделать через округление (нужна точка)
    }
}
