package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LaunchForm extends SampleForm {

    LaunchForm() {
//      Вызываем конструктор родительского класса
        super();
//      Конфигурируем форму
        setTitle("Tic Tac toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGameForm();
                dispose();
            }
        });
        JButton btnExitGame = new JButton("Exit Game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//      Добавляем компоненты
        panel.add(btnNewGame);
        panel.add(btnExitGame);
        add(panel);
//      Отображаем форму
        setVisible(true);
    }


}
