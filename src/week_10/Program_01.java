package week_10;

import javax.swing.*;
import java.awt.*;

public class Program_01 extends JFrame {
    public Program_01(){
        setTitle("Ten Color Buttons Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(1, 10);

        Container c = getContentPane();
        c.setLayout(grid);

        for(int i=0; i<10; i++){
            JButton button = new JButton("" + i);

            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);

            button.setBackground(new Color(r, g, b));
            button.setOpaque(true);
            button.setBorderPainted(false);
            c.add(button);

            setSize(500, 150);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Program_01();
    }
}
