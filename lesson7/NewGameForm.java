package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewGameForm extends SampleForm {
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;
    private final int MIN_WIN_LENGTH = 3;

    NewGameForm() {
//      Вызываем конструктор родительского класса
        super();
//      Конфигурируем форму
        setTitle("Create New Game");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//      Создаем и конфигурируем элементы
        setLayout(new GridLayout(10,1));
//      Cоздаем и конфигурируем элементы формы
//      row1
        add(new JLabel("Choose gamimg mode:"));
//      row2-3
        JRadioButton radio1 = new JRadioButton("vsAI");
        JRadioButton radio2 = new JRadioButton("vsHuman");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(radio1);
        gameMode.add(radio2);
        radio1.setSelected(true);
        add(radio1);
        add(radio2);
//      row4
        add(new JLabel("Choose field size:"));
//      row5
        JLabel label2 = new JLabel("Field size is :" + MIN_FIELD_SIZE);
        add(label2);
//      row6
        JSlider slider2 = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        JSlider slider = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        JLabel label3 = new JLabel("Winning length is :" + MIN_WIN_LENGTH);
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slider.getValue();
                label3.setText("Winning length is " + currentValue);
                slider2.setMaximum(currentValue);
            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label2.setText("Field size is " + slider.getValue());
                if (slider.getValue() < slider2.getValue())
                    slider2.setValue(slider.getValue());
            }
        });
        add(slider);
//      row7
        add(new JLabel("Choose winning length:"));
//      row8
        add(label3);
//      row9
        add(slider2);
//      row10
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        JButton btnStart = new JButton("Start New Game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameForm(slider.getValue(), slider2.getValue());
                dispose();
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LaunchForm();
                dispose();
            }
        });
        panel.add(btnStart);
        panel.add(btnCancel);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }
}