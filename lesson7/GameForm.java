package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameForm extends SampleForm {

    private static char[][] field;
    private static JButton[][] field2;
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '*';
    private static final Random random = new Random();
    private static int fieldSize;;
    private static int toWin;


    GameForm(int size, int win) {
        fieldSize = size;
        toWin = win;
        setTitle("TicTacToe");
        setLayout(new GridLayout(fieldSize, fieldSize));
        initField();
        setVisible(true);
    }

    private void initField() {
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++)
                field[i][j] = '*';
        field2 = new JButton[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++)
            for (int j = 0; j < fieldSize; j++) {
                field2[i][j] = new JButton();
                field2[i][j].setBackground(Color.WHITE);
                final int X = i;
                final int Y = j;
                field2[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setXO(X, Y, HUMAN_DOT);
                        field2[X][Y].setEnabled(false);
                        printField();
                        if (checkWin(HUMAN_DOT)) {
                            JOptionPane.showMessageDialog(new JFrame(),"Поздравляем, Вы выиграли!");
                            System.out.println("Выиграл игрок!!!");
                            new NewGameForm();
                            dispose();
                            return;
                        }
                        if (isFieldFull()) {
                            System.out.println("Ничья!!!");
                            JOptionPane.showMessageDialog(new JFrame(),"Игра закончилась ничьей!");
                            new NewGameForm();
                            dispose();
                            return;
                        }
                        aiTurn();
                        printField();
                        if (checkWin(AI_DOT)) {
                            System.out.println("Выиграл компьютер!!!");
                            JOptionPane.showMessageDialog(new JFrame(),"К сожалению, Вы проиграли!");
                            new NewGameForm();
                            dispose();
                            return;
                        }
                        if (isFieldFull()) {
                            JOptionPane.showMessageDialog(new JFrame(),"Игра закончилась ничьей!");
                            System.out.println("Ничья!!!");
                            new NewGameForm();
                            dispose();
                            return;
                        }
                    }
                });
                add(field2[i][j]);
            }
    }

    private void setXO(int x, int y, char xo) {
        field[x][y] = xo;
        switch (xo) {
            case HUMAN_DOT:
                field2[x][y].setBackground(Color.GREEN);
                break;
            case AI_DOT:
                field2[x][y].setBackground(Color.RED);
                break;
            case EMPTY_DOT:
                field2[x][y].setBackground(Color.WHITE);
                break;
        }
    }

    private void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private void aiTurn() {
        if(turnAIWinCell()) return;
        if(turnHumanWinCell()) return;
        int x, y;
        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        } while (!isEmptyCell(x, y));
        setXO(x, y, AI_DOT);
        field2[x][y].setEnabled(false);
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isEmptyCell(i, j)) {
                    setXO(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) {
                        field2[i][j].setEnabled(false);
                        return true;
                    }
                    setXO(i, j, EMPTY_DOT);
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isEmptyCell(i, j)) {
                    setXO(i, j, HUMAN_DOT);
                    if (checkWin(HUMAN_DOT)) {
                        setXO(i, j, AI_DOT);
                        field2[i][j].setEnabled(false);
                        return true;
                    }
                    setXO(i, j, EMPTY_DOT);
                }
            }
        }
        return false;
    }

    private boolean checkWin(char c) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (checkLine(i, j, 1, 0, toWin, c)) return true;
                if (checkLine(i, j, 1, 1, toWin, c)) return true;
                if (checkLine(i, j, 0, 1, toWin, c)) return true;
                if (checkLine(i, j, 1, -1, toWin, c)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, char c) {
        final int far_x = x + (len - 1) * vx;
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;
        for (int i = 0; i < len; i++) {
            if (field[x + i * vx][y + i * vy] != c) return false;
        }
        return true;
    }

    private boolean isFieldFull() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[x][y] == EMPTY_DOT;
    }
}