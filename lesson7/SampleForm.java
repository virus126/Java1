package lesson7;

import javax.swing.*;
import java.awt.*;

class SampleForm extends JFrame {
//  Шаблон для саздания форм
    SampleForm() {
        setSize(300,300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)((dim.getWidth() - getWidth()) / 2);
        int y = (int)((dim.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setResizable(false);
    }

}
