package week_10;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumPad extends JPanel{
    final List<String> content = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "CE", "RUN", "+", "-", "X", "/"));
    public NumPad(){
        GridLayout gridLayout = new GridLayout(4, 4);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);


        setLayout(gridLayout);

        for(int i =0; i<16; i++){
            JButton jButton = new JButton(content.get(i));
            if(i>=12){
                jButton.setBackground(Color.cyan);
            }
            add(jButton);
        }

        setSize(300, 150);
        setVisible(true);

    }
}

class Header extends JPanel{
    public Header(){
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 2,5);
        setLayout(flowLayout);

        add(new JLabel("Enter formula"));
        add(new JTextField(15));

        setBackground(Color.gray);
        setSize(300, 50);
        setVisible(true);
    }
}

class Footer extends JPanel{
    public Footer(){
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 2,5);
        setLayout(flowLayout);

        add(new JLabel("Result"));
        add(new JTextField(15));

        setBackground(Color.yellow);
        setSize(300, 50);
        setVisible(true);
    }
}
public class Program_02 extends JFrame {
    public Program_02(){
        setTitle("Calculator Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();
        Container c = getContentPane();
        c.setLayout(borderLayout);

        c.add(new NumPad(), BorderLayout.CENTER);
        c.add(new Header(), BorderLayout.NORTH);
        c.add(new Footer(), BorderLayout.SOUTH);

        setSize(500, 500);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Program_02();
    }
}
