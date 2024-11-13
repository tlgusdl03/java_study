package week_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyMouseListener extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);

        JLabel newJLabel = new JLabel();
        newJLabel.setSize(5,5);
        newJLabel.setLocation(x,y);
        newJLabel.setBackground(new Color(r, g, b));
        newJLabel.setOpaque(true);

        Container c =  (Container) e.getSource();
        c.add(newJLabel);

        c.revalidate();
        c.repaint();
    }
}
public class Program_05 extends JFrame {
    public Program_05(){
        setTitle("Click \"C\"");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.addMouseListener(new MyMouseListener());

        c.setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program_05();
    }
}
