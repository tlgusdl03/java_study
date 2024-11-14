package final_assignment.practice;

import javax.swing.*;
import java.awt.*;

public class Body extends JPanel{
    private JPanel listPanel;
    private JScrollPane scrollPane;
    private CRUDPractice crudPractice;
    public Body(CRUDPractice crudPractice){
        this.crudPractice = crudPractice;
        setLayout(new BorderLayout());

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        updateList();
    }

    public void updateList(){
        listPanel.removeAll();

        for(Person p : crudPractice.getPeopleList()){
            MyPanel panel = new MyPanel(p.name, p.age);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            listPanel.add(panel);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }
    class MyPanel extends JPanel {
        public MyPanel(String name, int age){
            setLayout(new GridLayout(1, 2));

            setPreferredSize(new Dimension(50, 30));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            add(new JLabel(name));
            add(new JLabel(Integer.toString(age)));
        }
    }
}
