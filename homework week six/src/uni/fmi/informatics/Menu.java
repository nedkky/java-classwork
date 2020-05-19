package uni.fmi.informatics;

import java.util.Scanner;

public class Menu {
    public Menu() {

    }
    public void Menustart(){
        while (true) {
            printMainMenu();
            int option = getNumber(1, 3);
            switch (option) {
                case 1:
                    numbersMenu();
                    break;
                case 2:
                    wordsMenu();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static int getNumber(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        boolean isOptionIncorrect = true;
        int option = 0;
        while (isOptionIncorrect) {
            option = scanner.nextInt();
            if (min == max) isOptionIncorrect = option < min;
            else isOptionIncorrect = (option < min) || (option > max);
        }
        return option;
    }

    public static void printMainMenu() {
        System.out.println("1. Работа с числа" +
                "\n2. Работа с думи" +
                "\n3. Изход от програмата" +
                "\n");
    }

    public static void numbersMenu() {
        System.out.println("Въведи размер на масива");
        int size = getNumber(1, 1);
        ArrayInt array = new ArrayInt(size);
        array.setValues();
        while (true) {
            printNumbersMenu();
            int option = getNumber(1, 7);
            switch (option) {
                case 1: array.printPrimes();
                    break;
                case 2: array.getMostCommon();
                    break;
                case 3: array.printSubArrayAcs();
                    break;
                case 4: array.printSubArrayDesc();
                    break;
                case 5: array.printSubArrayEq();
                    break;
                case 6: System.out.println("Path not implemented");
                    break;
                case 7:
                    return;
            }
        }
    }
    public static void printNumbersMenu() {
        System.out.println("1. Извеждане само на простите числа от масива\n" +
                "2. Извеждане на най-често срещан елемент в масива\n" +
                "3. Извеждане на максимална редица от нарастваши елементи в масива\n" +
                "4. Извеждане на минимална редица от намаляващи елементи в масива\n" +
                "5. Извеждане на максимална редица от еднакви елементи в масива\n" +
                "6. Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип\n" +
                "7. Връщане назад към основно меню");
    }

    public static void wordsMenu() {
        System.out.println("Въведи размер на масива");
        int size = getNumber(1, 1);
        ArrayString array = new ArrayString(size);
        array.setValues();
        while (true) {
            printWordsMenu();
            int option = getNumber(1, 5);
            switch (option) {
                case 1: array.revertWords();
                    break;
                case 2: System.out.println("Path not implemented");
                    break;
                case 3: array.getWordLen();
                    break;
                case 4: array.printRepeatingWords();
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void printWordsMenu() {
        System.out.println("1. Обърнете буквите на думите от масива наобратно и ги изкарайте на конзолата \n" +
                           "2. Изкарайте броя на повтарящите се символи във всяка една от думите в масива\n" +
                           "3. Изкарайте броя на символите за всяка една дума в масива\n" +
                           "4. Изкарайте броя на повтарящите се думи в масива\n" +
                           "5. Връщане към главното меню");
    }

    public static String getString(){
        Scanner scanner = new Scanner(System.in);

        boolean isNotInLimit = true;
        String word=" ";
        while (isNotInLimit) {
            word = scanner.next();
            isNotInLimit = word.length()>20;
        }
        return word;
    }
}