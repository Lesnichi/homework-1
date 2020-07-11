//Имеются три числа - день, месяц и год, вводимые пользователем с консоли.
//Вывести дату следующего дня в формате "День.Месяц.Год".
//Учесть переход на следующий месяц, а также следующий год.
//Форматирование строки "День.Месяц.Год" вынести в отдельную функцию.

package com.vl.homework1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        int currentDay;
        int currentMonth;
        int currentYear;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Введите день:  ");
            currentDay = scanner.nextInt();

            System.out.print("Введите месяц: ");
            currentMonth = scanner.nextInt();

            System.out.print("Введите год:   ");
            currentYear = scanner.nextInt();
        } while (!isDateCorrect(currentDay, currentMonth, currentYear));

        System.out.print("Текущая дата: ");
        printDate(currentDay, currentMonth, currentYear);

        printNextDay(currentDay, currentMonth, currentYear);
    }

    private static boolean isLeapYear(int currentYear) {
        return currentYear % 4 == 0;
    }

    private static boolean isDateCorrect(int currentDay, int currentMonth, int currentYear) {
        if (currentDay <= 0 || currentDay > 31 || currentYear < 0 || currentMonth <= 0 || currentMonth > 12) {
            System.out.println("Неправильно введена дата. Повторите попытку.");
            return false;
        } else if (currentMonth == 2 && isLeapYear(currentYear) && currentDay > 29) {
            System.out.println("Неправильно введена дата. Повторите попытку.");
            return false;
        } else if (currentMonth == 2 && !isLeapYear(currentYear) && currentDay > 28) {
            System.out.println("Неправильно введена дата. Повторите попытку.");
            return false;
        } else if ((currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11) && (currentDay > 30)) {
            System.out.println("Неправильно введена дата. Повторите попытку.");
            return false;
        } else return true;
    }

    public static void printDate(int day, int month, int year) {
        System.out.println(day + "." + month + "." + year);
    }

    public static void printNextDay(int currentDay, int currentMonth, int currentYear) {
        if ((currentMonth == 2) && (currentDay == 29) && isLeapYear(currentYear)) {
            currentMonth += 1;
            currentDay = 1;
        } else if ((currentMonth == 2) && (currentDay == 28) && !isLeapYear(currentYear)) {
            currentMonth += 1;
            currentDay = 1;
        } else if ((currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11) && (currentDay == 30)) {
            currentDay = 1;
            currentMonth += 1;
        } else if ((currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8) && (currentDay == 31)) {
            currentDay = 1;
            currentMonth += 1;
        } else if ((currentMonth == 12) && (currentDay == 31)) {
            currentDay = 1;
            currentMonth = 1;
            currentYear += 1;
        } else {
            currentDay += 1;
        }
        System.out.print("Дата следующего дня: ");
        printDate(currentDay, currentMonth, currentYear);
    }
}
