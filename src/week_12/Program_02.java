package week_12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program_02 extends JFrame {
    public Program_02(){
        setTitle("TextArea with JSlider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setContentPane(new MyPanel2());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program_02();
    }
}

class MyPanel2 extends JPanel{
    private JTextArea ja = new JTextArea(5, 10);
    private JSlider js = new JSlider(0, 200, 0);

    public MyPanel2(){
        setLayout(new BorderLayout());

        ja.setSize(200, 50);
        add(new JScrollPane(ja), BorderLayout.NORTH);

        js.setMajorTickSpacing(50);
        js.setMinorTickSpacing(10);
        js.setPaintLabels(true);
        js.setPaintTicks(true);
        add(js, BorderLayout.CENTER);

        ja.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextArea t = (JTextArea) e.getSource();
                int length = t.getText().length();
                try {
                    if(length>=200){
                        t.setText(t.getText(0, 200));
                    }
                }catch (BadLocationException ex){}
                js.setValue(length);
            }
        });

        js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider) e.getSource();
                if (ja.getText().length() <= s.getValue()) {
                    s.setValue(ja.getText().length());
                } else {
                    try{
                        ja.setText(ja.getText(0, js.getValue()));
                    }catch (BadLocationException e1){

                    }
                }
            }
        });
    }
}