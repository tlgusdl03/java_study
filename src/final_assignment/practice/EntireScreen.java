package final_assignment.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntireScreen extends JFrame{
    private String[] choices = {"1. List up", "2. Add", "3. Update", "4. Delete", "5. Exit"};
    private CrudProgram crudProgram;
    private Body body;
    private InputHeader inputHeader;
    public EntireScreen(CrudProgram crudProgram){
        this.crudProgram = crudProgram;
        this.body = new Body(crudProgram);
        this.inputHeader = new InputHeader(crudProgram);

        setTitle("Person Manager Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 1000);

        inputHeader.setActionListener(new MyActionListener(this ));
        body.setMouseListener(new ListSelectionListener());
        add(inputHeader, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);

        setVisible(true);
    }

    class MyActionListener implements ActionListener{

        private Component parent;
        public MyActionListener(Component parent){
            parent = parent;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action Occurred!");
            int action = inputHeader.getSelectedAction();
            String name = inputHeader.getName();
            int age = inputHeader.getAge();
            System.out.println(action);
            System.out.println(name + age);

            if (action == 0) {
                // List up logic
            } else if (action == 1) {
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.getSome(name); // 데이터 추가
            } else if (action == 2) {
                if (name.isEmpty() || age <= 0) {
                    JOptionPane.showMessageDialog(parent, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.create(name, age, ""); // 데이터 추가
            } else if (action == 3) {
                if (name.isEmpty() || age <= 0) {
                    JOptionPane.showMessageDialog(parent, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.update(name, age); // 데이터 업데이트
            } else if (action == 4) {
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "Please enter a name to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.delete(name); // 데이터 삭제
            } else if (action == 5) {
                System.exit(0);
            }

            body.updateList();
            inputHeader.clear();
        }
    }

    class ListSelectionListener extends MouseAdapter {
        Object[]options = {"Update", "Delete"};
        @Override
        public void mouseClicked(MouseEvent e) {
            JList<Body.MyPanel> jList = (JList<Body.MyPanel>) e.getSource();
            Body.MyPanel myPanel = jList.getSelectedValue();
            int result = JOptionPane.showOptionDialog(
                    null,
                    "What would you like to do with this person",
                    "Choose an Action",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if(result == 0){
                UpdateDialog dialog = new UpdateDialog(myPanel.name);
                dialog.setVisible(true);
            } else if (result == 1) {
                crudProgram.delete(myPanel.name);
                jList.repaint();
            }
        }
        class UpdateDialog extends JDialog{
            String name;
            private JTextField age = new JTextField(10);
            private JButton submitBtn = new JButton("Enter");

            public UpdateDialog(String name){
                name = name;
                setLayout(new FlowLayout());
                add(new JLabel("Input age"));
                add(age);
                add(submitBtn);
                String finalName = name;
                submitBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            int num = Integer.parseInt(age.getText());
                            crudProgram.update(finalName, num);
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(UpdateDialog.this, "Input Age only Numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                });
            }
        }
    }
}

