package com.company;
kur
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int pixels;
        boolean mouse = false;
        int battery = 4;
        int number = 0;
        String mebeli = "";

        Scanner scanner = new Scanner(System.in);

        Random chislo = new Random();

        while (true) {

            System.out.println("Какво има пред робота? : ");
            mebeli = scanner.nextLine();
            boolean sideway = false;
            boolean jump = false;
            boolean forward = false;

            switch (mebeli) {
                case "Стена": {
                    System.out.println("Заобикаляме ..");
                    sideway = true;
                }
                break;
                case "Стол": {
                    System.out.println("Прескачаме ..");
                    jump = true;
                }
                break;
                case "Нищо": {
                    System.out.println("Продължаваме напред ..");
                    forward = true;
                }
                break;
                case "STOP": {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(10 - i);
                        if ((10 - i) % 2 == 0) {
                            System.out.println("I am a Robottttt");
                        }
                    }

                } return;
            }

            System.out.println("Пиксели: ");
            pixels = scanner.nextInt();
            if (pixels % 2 == 0) {
                System.out.println("Мишката намерена!");
                mouse = true;
            }

            if (mouse == true && battery > 0) {
                number = chislo.nextInt(10);
                if (number == 5) {
                    System.out.println("Удряме мебелите...");
                } else {
                    battery--;
                    System.out.println("Мишката беше унищожена..");
                }
            }

            if (battery == 0) {
                System.out.println("Робота няма батерия!");
                int chislo1 = chislo.nextInt();
                int chislo2 = chislo.nextInt();
                boolean tok = false;
                while (!tok) {
                    if (chislo1 > chislo2) {
                        tok = true;
                        System.out.println("Има ток в контакта, робота се зарежда.");
                    } else if (chislo1 <= chislo2) {
                        System.out.println("Няма ток в контакта.");
                        continue;
                    }
                }
            }
            mebeli = scanner.nextLine();
            mouse = false;
        }
    }
}