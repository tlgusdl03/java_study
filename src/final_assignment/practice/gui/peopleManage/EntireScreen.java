package final_assignment.practice.gui.peopleManage;

import final_assignment.practice.CrudProgram;
import final_assignment.practice.dto.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntireScreen extends JPanel{
    private CrudProgram crudProgram;
    private Body body;
    private InputHeader inputHeader;
    public EntireScreen(CrudProgram crudProgram){
        init(crudProgram);
    }

    private void init(CrudProgram crudProgram){
        this.crudProgram = crudProgram;
        this.body = new Body(crudProgram);
        this.inputHeader = new InputHeader(crudProgram);
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        inputHeader.setActionListener(new ActionSelectionListener(this ));
        body.setMouseListener(new ListSelectionListener());
        add(inputHeader, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }

    class ActionSelectionListener implements ActionListener{
        private Component parent;
        public ActionSelectionListener(Component parent){
            parent = parent;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action Occurred!");
            int action = inputHeader.getSelectedAction();
            String name = inputHeader.getName();
            int age = inputHeader.getAge();
            String imagePath = inputHeader.getImagePath();
            System.out.println(action);
            System.out.println(name + age);

            if (action == 0) {
                // List up logic
            } else if (action == 1) {
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.findPeople(name); // 특정 데이터 검색
            } else if (action == 2) {
                if (name.isEmpty() || age <= 0) {
                    JOptionPane.showMessageDialog(parent, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                crudProgram.addPerson(name, age, imagePath); // 데이터 추가
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
            JList<Person> jList = body.getMyPanelJList();
            Person myPanel = jList.getSelectedValue();
            int index = (int) jList.locationToIndex(e.getPoint());
            System.out.println("Clicked at : " + e.getPoint() + "index is : " + index);

            Rectangle cellBounds = jList.getCellBounds(index, index);
            if (cellBounds == null || !cellBounds.contains(e.getPoint())) {
                System.out.println("Clicked on empty background area");
                return; // 빈 영역 클릭 시 종료
            }
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
                UpdateDialog dialog = new UpdateDialog(myPanel.getName(), body);
                dialog.setVisible(true);
            } else if (result == 1) {
                crudProgram.delete(myPanel.getName());
                jList.repaint();
            }
        }
        class UpdateDialog extends JDialog{
            String name;
            private JTextField age = new JTextField(10);
            private JButton submitBtn = new JButton("Enter");

            public UpdateDialog(String name, Body body){
                setSize(new Dimension(300, 300));
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
                            body.updateList();

                            dispose();
                        }catch (NumberFormatException exception){
                            JOptionPane.showMessageDialog(UpdateDialog.this, "Input Age only Numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        }
    }
}

