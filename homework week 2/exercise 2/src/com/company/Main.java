package com.company;

public class Main {
    public static void main(String[] args) {
        String month = "Януари";
        if (month == "Януари" || month == "Март" || month == "Май" || month == "Юли" || month == "Август" || month == "Октомври" || month == "Декември") {
            System.out.println("Има 31 дни в " +month);
        } else if ( month == "Април" || month == "Юни" || month == "Септември" || month == "Ноември") {
            System.out.println("Има 30 дни в " + month);
        } else if ( month == "Февруари") {
            System.out.println("Има 29 дни в " + month);
        }
    }
}
