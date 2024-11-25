package week_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program_02 extends JFrame {
    JLabel result = new JLabel("Result");
    public Program_02(){
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton jButton = new JButton("calculate");
        jButton.addActionListener(new ActionListener() {
            private MyDialog dialog = new MyDialog(Program_02.this);
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
                if (dialog.isValid()) {
                    result.setText(Integer.toString(dialog.getResult()));
                }
            }
        });

        result.setSize(80, 30);
        result.setLocation(160, 0);
        result.setOpaque(true);
        result.setBackground(Color.GREEN);

        add(jButton);
        add(result);

        setSize(500, 500);
        setVisible(true);
    }

    public void setResult(String resultText){
        result.setText(resultText);
    }

    public static void main(String[] args) {
        new Program_02();
    }
}

class MyDialog extends JDialog{
    Program_02 parent;
    private int sum=0;
    private boolean bValid = false;
    JTextField num1 = new JTextField(10);
    JTextField num2 = new JTextField(10);
    JButton addBtn = new JButton("   Add   ");
    public MyDialog(JFrame jFrame){
        super(jFrame,"Calculation Dialog", true);
        setLayout(new FlowLayout());
        add(new JLabel("Input two integers"));
        add(num1);
        add(num2);
        add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(num1.getText());
                    int y = Integer.parseInt(num2.getText());
                    sum = x + y;
                    bValid = true;
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(MyDialog.this, "Input only Numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MyDialog.this.setVisible(false);
            }
        });


        setSize(200, 200);
    }

    public boolean isValid(){
        return bValid;
    }

    public int getResult(){
        return sum;
    }
}