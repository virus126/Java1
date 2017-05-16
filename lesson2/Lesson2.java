package lesson2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;

public class Lesson2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void print_array(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void unit2(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
    }

    public static void unit3(int[] arr) {
        for (int i = 0, j = 1; i < arr.length; i++, j += 3)
            arr[i] = j;
    }

    public static void unit4(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6)
                arr[i] *= 2;
    }

    public static void unit5(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    // Методы пункта 6
    public static boolean check_matches (String result, String template) {
        Pattern pattern = Pattern.compile(template);
        Matcher matcher = pattern.matcher(result);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    public static void print_menu () {
        System.out.println("Выберите арифметическую операцию: ");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Выход");
        System.out.print("Введите число: ");
    }

    public static void calculateAndPrint (int choice) throws IOException {
            boolean allInteger = false;
            System.out.print("Введите первое число: ");
            String s1 = reader.readLine();
            System.out.print("Введите второе число: ");
            String s2 = reader.readLine();
            if (check_matches(s1, "-?\\d+") && check_matches(s2, "-?\\d+"))
                allInteger = true;
            float a = Float.parseFloat(s1);
            float b = Float.parseFloat(s2);
            float result = 0;
            switch (choice) {
                case 1:
                    result = a + b;
                    break;
                case 2:
                    result = a - b;
                    break;
                case 3:
                    result = a * b;
                    break;
                case 4:
                    if (b != 0.0f)
                        result = a / b;
                    else
                        throw new IOException();
                    break;
            }
            System.out.print("РЕЗУЛЬТАТ ОПЕРАЦИИ: ");
            if (check_matches(Float.toString(result), "-?\\d+\\.0") && allInteger)
                System.out.println(Math.round(result));
            else
                System.out.println(result);
            System.out.println();
    }

    public static void main(String[] args) {
        // Пункт 1
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        // Пункт 2
        System.out.println("Пункт 2");
        unit2(arr);
        print_array(arr);
        System.out.println();

        // Пункт 3
        System.out.println("Пункт 3");
        arr = new int[8];
        unit3(arr);
        print_array(arr);
        System.out.println();

        // Пункт 4
        System.out.println("Пункт 4");
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        unit4(mas);
        print_array(mas);
        System.out.println();

        // Пункт 5
        System.out.println("Пункт 5");
        System.out.print("Array: ");
        print_array(mas);
        unit5(mas);
        System.out.println();

        // Пункт 6
        System.out.println("Пункт 6");
        while (true) {
            try {
                print_menu();
                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4: calculateAndPrint(choice); break;
                    case 5: System.exit(0);
                    default: throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
                System.out.println("-------------------------------------------------------");
            }
        }
    }
}