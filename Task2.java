//Написать программу, вычисляющую корни квадратного уравнения
//вида ax² + bx + c = 0, где a, b и c - вводимые пользователем из консоли данные.
//Учитывать только реальные корни (в случае отрицательного дискриминанта выводить сообщение пользователю).
//При решении создать и использовать следующие вынесенные функции:
//- функция isPositive, определяющая, является ли число положительным
//- функция isZero, определяющая, является ли число нулём
//- функция discriminant, вычисляющая дискриминант

package com.vl.homework1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        double a;
        double b;
        double c;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значения a, b, c квдратного уровнения ax² + bx + c = 0");

        System.out.print("Введите a:  ");
        a = scanner.nextDouble();
        System.out.print("Введите b:  ");
        b = scanner.nextDouble();
        System.out.print("Введите c:  ");
        c = scanner.nextDouble();

        System.out.println("Вы задали квадратное уровнение вида: " + a + "x² + " + b + "x + " + c + " = 0");

        if (isPositive(discriminant(a, b, c))) {
            double x1 = ((-b + Math.sqrt(discriminant(a, b, c))) / (2 * a));
            double x2 = ((-b - Math.sqrt(discriminant(a, b, c))) / (2 * a));
            System.out.println("Корни данного уравнения: х1 = " + x1 + " , x2 = " + x2);
        } else if (isZero(discriminant(a, b, c))) {
            int x = (int) ((-b / (2 * a)));
            System.out.println("Корень данного уравнения: х = " + x);
        } else {
            System.out.println("У данного уравнения нет действительных корней");
        }
    }

    public static double discriminant(double a, double b, double c) {
        double result = (b * b) - (4 * a * c);
        return result;
    }

    public static boolean isPositive(double discriminant) {
        return discriminant > 0;
    }

    public static boolean isZero(double discriminant) {
        return discriminant == 0;
    }
}