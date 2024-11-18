package week_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program_01 extends JFrame {
    public Program_01(){
        setTitle("Money changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program_01();
    }
}

class MyPanel extends JPanel{
    private String[] text = {"만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    private int[] unit = {10000, 1000, 500, 100, 50, 10, 1};
    JTextField[] tf = new JTextField[7];
    JCheckBox[] cb = new JCheckBox[6];

    public MyPanel(){
        setBackground(Color.white);
        setLayout(null);

        JLabel la1 = new JLabel("금액");
        la1.setSize(30, 20);
        la1.setLocation(60, 20);
        add(la1);

        JTextField source = new JTextField(30);
        source.setSize(100, 20);
        source.setLocation(100, 20);
        add(source);

        JButton calcBtn = new JButton("계산");
        calcBtn.setSize(70, 20);
        calcBtn.setLocation(210, 20);
        add(calcBtn);

        for(int i=0; i<tf.length; i++){
            JLabel la2 = new JLabel(text[i]);
            la2.setHorizontalAlignment(JLabel.RIGHT);
            la2.setSize(50, 20);
            la2.setLocation(50, 50 + i * 20);
            add(la2);

            tf[i] = new JTextField(30);
            tf[i].setHorizontalAlignment(JTextField.CENTER);
            tf[i].setLocation(120, 50 + i * 20);
            tf[i].setSize(70, 20);
            tf[i].setEditable(false);
            add(tf[i]);
        }

        for(int i=0; i<cb.length; i++){
            cb[i] = new JCheckBox("", true);
            cb[i].setOpaque(false);
            cb[i].setSize(30, 20);
            cb[i].setLocation(200, 50 + i * 20);
            add(cb[i]);
        }

        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = source.getText();
                if(str.isEmpty()) return;

                int money = Integer.parseInt(str);
                int res;

                for (int i = 0; i < unit.length; i++) {
                    if (i == unit.length - 1) {
                        tf[i].setText(Integer.toString(money));
                        break;
                    }
                    if (!cb[i].isSelected()) {
                        tf[i].setText("0");
                        continue;
                    }
                    res = money / unit[i];
                    tf[i].setText(Integer.toString(res));
                    if (res > 0) {
                        money = money %= unit[i];
                    }
                }
            }
        });
    }

}