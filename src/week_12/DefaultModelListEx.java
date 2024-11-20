package week_12;

import week_4.Ex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

class Person{
    String name;
    int age;
    String imagePath;

    public Person(String name, int age, String imagePath) {
        this.name = name;
        this.age = age;
        this.imagePath = imagePath;
    }
}

public class DefaultModelListEx extends JFrame {

    DefaultListModel<Person> personDefaultListModel = new DefaultListModel<>();
    JList<Person> jList = new JList<>(personDefaultListModel);

    public DefaultModelListEx() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        jList.setCellRenderer(new MyRenderer());
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        addSampleData();

        add(jScrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addSampleData() {
        // 샘플 데이터 추가
        personDefaultListModel.addElement(new Person("Alice", 25, "src/final_assignment/practice/images/default_profile_image.jpg"));
        personDefaultListModel.addElement(new Person("Bob", 30, "src/final_assignment/practice/images/default_profile_image.jpg"));
        personDefaultListModel.addElement(new Person("Charlie", 22, "src/final_assignment/practice/images/default_profile_image.jpg"));
        personDefaultListModel.addElement(new Person("Diana", 28, "src/final_assignment/practice/images/default_profile_image.jpg"));
    }

    static class MyRenderer extends JPanel implements ListCellRenderer<Person>{
        private JLabel nameLabel = new JLabel();
        private JLabel ageLabel = new JLabel();
        private JLabel imageLabel = new JLabel();
        MyRenderer(){
            setLayout(new BorderLayout());
            JPanel textPanel = new JPanel(new GridLayout(1, 2));
            textPanel.add(nameLabel);
            textPanel.add(ageLabel);

            textPanel.setPreferredSize(new Dimension(450, 50));
            imageLabel.setPreferredSize(new Dimension(50, 50));
            add(textPanel, BorderLayout.CENTER);
            add(imageLabel, BorderLayout.WEST);
        }
        @Override
        public Component getListCellRendererComponent(JList<? extends Person> list,
                                                      Person value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus)
        {
            nameLabel.setText("Name: " + value.name);
            ageLabel.setText("Age: " + value.age);
            try{
                Image origin = ImageIO.read(new File(value.imagePath));
                Image resized = origin.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resized));
            }catch (Exception e){
                imageLabel.setIcon(null);
                e.printStackTrace();
            }

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                nameLabel.setForeground(list.getSelectionForeground());
                ageLabel.setForeground(list.getSelectionForeground());
                imageLabel.setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                nameLabel.setForeground(list.getForeground());
                ageLabel.setForeground(list.getForeground());
                imageLabel.setForeground(list.getForeground());
            }

            setOpaque(true);
            return this;
        }
    }

    public static void main(String[] args) {
        new DefaultModelListEx();
    }
}
