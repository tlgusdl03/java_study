package final_assignment.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHeader extends JPanel {
    private String[] choices = {"1. List up", "2. Add", "3. Update", "4. Delete", "5. Exit"};
    private JRadioButton[] btn = new JRadioButton[5];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField[] jTextFields = new JTextField[3];
    private JButton submitBtn = new JButton("Enter");
    private CrudProgram crudProgram;
    private int selection=0;

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
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JRadioButton jRadioButton = (JRadioButton)e.getSource();
                    for(int i=0; i< btn.length; i++){
                        if(btn[i].isSelected()){
                            selection = i;
                            System.out.println("selection is set" + i);
                            break;
                        }
                    }
                }
            });
            buttonGroup.add(btn[i]);
            if(i==0) btn[i].setSelected(true);
            add(btn[i]);
        }

        for (int i = 0; i < 3; i++) {
            jTextFields[i] = new JTextField(10);
            jTextFields[i].setColumns(30);
            jTextFields[i].setSize(100, 20);
            jTextFields[i].setLocation(550 + 110 * i, 30);
            add(jTextFields[i]);
        }

        submitBtn.setSize(80, 20);
        submitBtn.setLocation(900, 30);
        add(submitBtn);
    }

    public int getSelectedAction(){
        return selection;
    }

    public void setActionListener(ActionListener actionListener) {
        submitBtn.addActionListener(actionListener);
    }

    public String getName(){
        return jTextFields[0].getText();
    }

    public int getAge(){
        String ageText = jTextFields[1].getText().trim();
        if (ageText.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age input! Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void clear() {
        jTextFields[0].setText("");
        jTextFields[1].setText("");
    }
}
