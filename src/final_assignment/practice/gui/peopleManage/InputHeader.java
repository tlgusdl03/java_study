package final_assignment.practice.gui.peopleManage;

import final_assignment.practice.CrudProgram;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputHeader extends JPanel {
    private String[] choices = {"1. List up", "2. find", "3. Add", "4. Update", "5. Delete", "6. Exit"};
    private JRadioButton[] btn = new JRadioButton[6];
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

        for (int i = 0; i < choices.length; i++) {
            btn[i] = new JRadioButton(choices[i]);
            btn[i].setSize(80, 20);
            btn[i].setLocation(30 + 80 * i, 30);
            buttonGroup.add(btn[i]);
            if(i==0) btn[i].setSelected(true);
            add(btn[i]);
        }

        for (int i = 0; i < 3; i++) {
            jTextFields[i] = new JTextField(10);
            jTextFields[i].setColumns(30);
            jTextFields[i].setSize(100, 20);
            jTextFields[i].setLocation(550 + 110 * i, 30);
            if(i==2){
                jTextFields[i].setEditable(false);
                jTextFields[i].setText("Images Path...");
                jTextFields[i].addMouseListener(new ProfileImageListener());
            }
            add(jTextFields[i]);
        }

        submitBtn.setSize(80, 20);
        submitBtn.setLocation(900, 30);
        add(submitBtn);
    }

    public int getSelectedAction(){
        int result = -1;

        for(int i=0; i<btn.length; i++){
            if(btn[i].isSelected()){
                result = i;
                break;
            }
        }

        return result;
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

    class ProfileImageListener extends MouseAdapter {
        private JFileChooser chooser;

        public ProfileImageListener() {
            chooser = new JFileChooser();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
            chooser.setFileFilter(filter);

            int ret = chooser.showOpenDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String sourceFile = chooser.getSelectedFile().getPath();
            jTextFields[2].setText(sourceFile);
        }
    }
}
