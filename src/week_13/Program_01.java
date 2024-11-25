package week_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program_01 extends JFrame {
    public Program_01(){
        setTitle("Only numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        toolBar.add(new JLabel("Student ID: "));
        JTextField jTextField = new JTextField();
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
                    String k = Character.toString(e.getKeyChar());
                    k = k.concat(" is not a number. \nInput only numbers.");
                    JOptionPane.showMessageDialog(getContentPane(), k, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        toolBar.add(jTextField);

        c.add(toolBar, BorderLayout.SOUTH);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program_01();
    }
}
