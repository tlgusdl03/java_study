package week_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Program_04 extends JFrame{

    private JLabel jLabel = new JLabel("C");
    private Container c = getContentPane();
    public Program_04() {
        setTitle("Click \"C\"");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(null);

        jLabel.setSize(20, 20);
        jLabel.setLocation(100, 100);
        jLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (int) (Math.random() * (c.getWidth() - jLabel.getWidth()));
                int y = (int) (Math.random() * (c.getHeight() - jLabel.getHeight()));

                jLabel.setLocation(x, y);
            }
        });

        c.add(jLabel);

        c.setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program_04();
    }
}
