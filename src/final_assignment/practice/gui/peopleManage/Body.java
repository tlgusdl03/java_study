package final_assignment.practice.gui.peopleManage;

import final_assignment.practice.CrudProgram;
import final_assignment.practice.user.Person;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
import java.util.List;

public class Body extends JPanel {
    private CrudProgram crudProgram;
    private DefaultListModel<MyPanel> listModel = new DefaultListModel<>();
    private JList<MyPanel> myPanelJList = new JList<>(listModel);

    private static final String defaultProfileImage = "src/final_assignment/practice/images/default_profile_image.jpg";

    public Body(CrudProgram crudProgram) {
        this.crudProgram = crudProgram;

        myPanelJList.setCellRenderer(new MyPanelRenderer());
        myPanelJList.setFixedCellWidth(200);
        myPanelJList.setFixedCellHeight(50);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 1000));

        JScrollPane jScrollPane = new JScrollPane(myPanelJList);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(jScrollPane, BorderLayout.CENTER);
        updateList();
    }

    public void setMouseListener(MouseListener mouseListener){
        myPanelJList.addMouseListener(mouseListener);
    }

    public void updateList() {
        listModel.clear();

        List<Person> people = crudProgram.getAll().getPeople();
        if (people.isEmpty()) {
            listModel.addElement(new MyPanel("No Data", 0, defaultProfileImage));
        } else {
            for (Person p : people) {
                listModel.addElement(new MyPanel(p.name, p.age, p.profileImagePath));
            }
        }
    }

    class MyPanel extends JPanel {
        String name;
        int age;
        String profileImagePath;
        public MyPanel(String name, int age, String profileImagePath) {
            this.name = name;
            this.age = age;
            this.profileImagePath = profileImagePath;
        }
    }

    static class MyPanelRenderer extends JPanel implements ListCellRenderer<MyPanel> {
        private JLabel nameLabel = new JLabel();
        private JLabel ageLabel = new JLabel();
        private JLabel imageLabel = new JLabel();
        private JButton updateBtn = new JButton("Update");
        private JButton deleteBtn = new JButton("Delete");

        public MyPanelRenderer(){
            setLayout(new BorderLayout());
            JPanel textPanel = new JPanel(new GridLayout(1, 2));
            textPanel.add(nameLabel);
            textPanel.add(ageLabel);

            textPanel.setPreferredSize(new Dimension(850, 50));
            imageLabel.setPreferredSize(new Dimension(50, 50));

            add(imageLabel, BorderLayout.WEST);
            add(textPanel, BorderLayout.CENTER);


        }
        @Override
        public Component getListCellRendererComponent(JList<? extends MyPanel> list, MyPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText("Name: " + value.name);
            ageLabel.setText("Age: " + value.age);

            try {
                Image image;
                if (value.profileImagePath.startsWith("http")) {
                    URL url = new URL(value.profileImagePath);
                    image = ImageIO.read(url);
                } else if (value.profileImagePath.isEmpty()){
                    image = ImageIO.read(new File(defaultProfileImage));
                }else{
                    image = ImageIO.read(new File(value.profileImagePath));
                }
                imageLabel.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                imageLabel.setIcon(new ImageIcon(defaultProfileImage));
            }

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setOpaque(true);
            return this;
        }
    }
}
