package final_assignment.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputHeader extends JPanel {
    private String[] choices = {"1. List up", "2. Add", "3. Update", "4. Delete", "5. Exit"};
    private JRadioButton[] btn = new JRadioButton[5];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField[] jTextFields = new JTextField[3];
    private JButton submitBtn = new JButton("Enter");
    private CrudProgram crudProgram;

    public InputHeader(CrudProgram crudProgram) {
        this.crudProgram = crudProgram;

        setPreferredSize(new Dimension(1000, 100));
        setLayout(null);

        JLabel jLabel = new JLabel("Enter the Choice, Name, Age, ProfileImagePath");
        jLabel.setSize(300, 30);
        jLabel.setLocation(130, 0);
        add(jLabel);

        for (int i = 0; i < 5; i++) {
            btn[i] = new JRadioButton(choices[i]);
            btn[i].setSize(100, 20);
            btn[i].setLocation(30 + 100 * i, 30);
            buttonGroup.add(btn[i]);
            add(btn[i]);
        }

        for (int i = 0; i < 3; i++) {
            jTextFields[i] = new JTextField(10);
            jTextFields[i].setColumns(30);
            jTextFields[i].setSize(100, 20);
            jTextFields[i].setLocation(550 + 110 * i, 30);
            add(jTextFields[i]);
        }

        submitBtn.addMouseListener(new MyMouseListener());
        submitBtn.setSize(80, 20);
        submitBtn.setLocation(900, 30);
        add(submitBtn);
    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (btn[0].isSelected()) {
                crudProgram.getAll();
                clear();
            } else if (btn[1].isSelected()) {
                crudProgram.create(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()), jTextFields[2].getText());
                clear();
            } else if (btn[2].isSelected()) {
                crudProgram.update(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()));
                clear();
            } else if (btn[3].isSelected()) {
                crudProgram.delete(jTextFields[0].getText());
                clear();
            } else if (btn[4].isSelected()) {
                System.exit(0);
            }
        }
    }

    private void clear() {
        jTextFields[0].setText("");
        jTextFields[1].setText("");
    }
}
