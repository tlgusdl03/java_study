package week_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Program_03 extends JFrame {
    private JLabel jLabel = new JLabel("C");
    private Container c = getContentPane();
    public Program_03(){
        setTitle("Click \"C\"");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(null);

        jLabel.setSize(20,20);
        jLabel.setLocation(100,100);
        jLabel.addMouseListener(new MyMouseListener());
        c.add(jLabel);

        c.setSize(500,500);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = (int) (Math.random() * (c.getWidth()-jLabel.getWidth()+1));
            int y = (int) (Math.random() * (c.getHeight()-jLabel.getHeight()+1));

            jLabel.setLocation(x, y);
            c.validate();
            c.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public static void main(String[] args) {
        new Program_03();
    }
}
