package final_assignment.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputHeader extends JPanel {
    private String[] choices = {"1. List up", "2. Add", "3. Update", "4. Delete", "5. Exit"};
    private JRadioButton[] btn = new JRadioButton[5];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField[] jTextFields = new JTextField[2];
    private JButton submitBtn = new JButton("Enter");
    private CRUDPractice crudPractice;

    public InputHeader(CRUDPractice crudPractice) {
        this.crudPractice = crudPractice;
        setSize(500, 100);
        setLayout(new FlowLayout());

        JLabel jLabel = new JLabel("Enter the Choice, Name, Age");

        for (int i = 0; i < 5; i++) {
            btn[i] = new JRadioButton(choices[i]);
            buttonGroup.add(btn[i]);
            add(btn[i]);
        }

        for (int i = 0; i < 2; i++) {
            jTextFields[i] = new JTextField(10);
            add(jTextFields[i]);
        }

        submitBtn.addMouseListener(new MyMouseListener());
        add(submitBtn);
    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (btn[0].isSelected()) {
                crudPractice.getPeople();
                clear();
            } else if (btn[1].isSelected()) {
                crudPractice.createPerson(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()));
                clear();
            } else if (btn[2].isSelected()) {
                crudPractice.updatePerson(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()));
                clear();
            } else if (btn[3].isSelected()) {
                crudPractice.deletePerson(jTextFields[0].getText());
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
