package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    static char[][] field = new char[3][3];
    static final char playerDot = 'X';
    static final char aiDot = 'O';
    static final char emptyDot = '*';
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        byte point_ai = 0;
        byte point_player = 0;
        byte game = 1;
        initField();
        System.out.println("Начинается игра № " + game);
        System.out.println();
        printField();
        while (true) {
            System.out.println("Ваш ход!");
            playerTurn();
            printField();
            if(checkWin(playerDot)) {
                point_player++;
                System.out.println("В этом розыгрыше Вы победили.");
                System.out.println("Вы " + point_player + " : " + point_ai + " Компьютер");
                if (point_player == 4) {
                    System.out.println("Вы победили в серии игр");
                    return;
                }
                else {
                    game++;
                    System.out.println();
                    System.out.println("Начинается игра № " + game);
                    System.out.println();
                    initField();
                    printField();
                    continue;
                }
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                System.out.println();
                game++;
                System.out.println("Начинается игра № " + game);
                System.out.println();
                initField();
                printField();
                continue;
            }
            System.out.println("Ход компьютера");
            System.out.println();
            aiTurn();
            printField();
            if(checkWin(aiDot)) {
                point_ai++;
                System.out.println("В этом розыгрыше победил компьютер.");
                System.out.println("Вы " + point_player + " : " + point_ai + " Компьютер");
                if (point_ai == 4) {
                    System.out.println("В серии игр победил компьютер");
                    return;
                }
                else {
                    game++;
                    System.out.println();
                    System.out.println("Начинается игра № " + game);
                    System.out.println();
                    initField();
                    printField();
                    continue;
                }
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                game++;
                System.out.println("Начинается игра № " + game);
                initField();
                printField();
                continue;
            }
        }
    }

    public static boolean checkWin(char xo) {
        boolean win = false;
        for (int i = 0; i < field.length; i++) {
            // Проверка горизонталей
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == xo)
                    win = true;
                else {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
            // Проверка вертикалей
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == xo)
                    win = true;
                else {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }
        // Проверка 1-ой диагонали
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == xo)
                win = true;
            else {
                win = false;
                break;
            }
        }
        if (win)
            return true;
        // Проверка 1-ой диагонали
        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length - 1 - i] == xo)
                win = true;
            else {
                win = false;
                break;
            }
        }
        if (win)
            return true;
        return false;
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                if (field[i][j] == '*') return false;
        }
        return true;
    }

    public static void initField() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field.length; j++)
                field[i][j] = '*';
    }

    public static void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void setXO(int x, int y, char xo) {
        field[x][y] = xo;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > field.length || y > field.length)
            return false;
        if (field[x][y] == '*')
            return true;
        return false;
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y (1-3)");
            x = sc.nextInt();
            y = sc.nextInt();
        } while (!isCellEmpty(x - 1, y - 1));
        setXO(x - 1, y - 1, playerDot);
        System.out.println();
    }

    static Random rand = new Random();

    public static void aiTurn() {
        int x = -1, y = -1;
        for (int i = 0; i < field.length; i++) {
            int count = 0;
            // Проверка горизонталей
            for (int j = 0; j < field[i].length; j++)
                if (field[i][j] == playerDot)
                    count++;
                else if (field[i][j] == emptyDot) {
                        x = i;
                        y = j;
                    }
            if (count == field.length - 1 && x != -1 && y != -1) {
                setXO(x, y, aiDot);
                return;
            }
            // Проверка вертикалей
            count = 0;
            x = -1; y = -1;
            for (int j = 0; j < field[i].length; j++)
                if (field[j][i] == playerDot)
                    count++;
                else if (field[j][i] == emptyDot) {
                    x = j;
                    y = i;
                }
                if (count == field.length - 1 && x != -1 && y != -1) {
                    setXO(x, y, aiDot);
                    return;
                }
            }
        // Проверка диагоналей
        int count_i = 0, count_j = 0;
        int x_i = -1, x_j = -1, y_j = -1;
        for (int i = 0, j = field.length - 1; i < field.length; i++, j--) {
            if (field[i][i] == playerDot)
                count_i++;
            else if (field[i][i] == emptyDot)
                x_i = i;
            if (field[i][j] == playerDot)
                count_j++;
            else if (field[i][j] == emptyDot) {
                x_j = i;
                y_j = j;
            }
        }
        if (count_i == field.length - 1 && x_i != -1) {
            setXO(x_i, x_i, aiDot);
            return;
        }
        if (count_j == field.length - 1 && x_j != -1 && y_j != -1) {
            setXO(x_j, y_j, aiDot);
            return;
        }
        do {
            x = rand.nextInt(field.length);
            y = rand.nextInt(field.length);
        } while (!isCellEmpty(x, y));
        setXO(x, y, aiDot);
    }
}