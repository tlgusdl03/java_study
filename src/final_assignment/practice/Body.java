//package final_assignment.practice;
//
//import javax.swing.*;
//import java.awt.*;
//import java.net.URL;
//
//public class Body extends JPanel implements DataChangeListener{
//    private JPanel listPanel;
//    private JScrollPane scrollPane;
//    private CRUDPractice crudPractice;
//    public Body(CRUDPractice crudPractice){
//        this.crudPractice = crudPractice;
//        crudPractice.setDataChangeListener(this);
//
//        setLayout(new BorderLayout());
//
//        listPanel = new JPanel();
//        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
//
//        scrollPane = new JScrollPane(listPanel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        add(scrollPane, BorderLayout.CENTER);
//
//        updateList();
//    }
//
//    public void onDataChanged(){
//        updateList();
//    }
//
//    public void updateList(){
//        listPanel.removeAll();
//
//        for(Person p : crudPractice.getPeopleList()){
//            MyPanel panel = new MyPanel(p.name, p.age, p.profileImagePath);
//            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
//            listPanel.add(panel);
//        }
//        listPanel.revalidate();
//        listPanel.repaint();
//    }
//    class MyPanel extends JPanel {
//        public MyPanel(String name, int age, String profileImagePath){
//            setLayout(new BorderLayout());
//            setPreferredSize(new Dimension(50, 50));
//
//            try{
//                ImageIcon imageIcon = new ImageIcon(new URL(profileImagePath));
//                Image img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
//                JLabel imageLabel = new JLabel(new ImageIcon(img));
//
//                JPanel textPanel = new JPanel(new GridLayout(2, 1));
//                textPanel.add(new JLabel("Name: " + name));
//                textPanel.add(new JLabel("Age: " + age));
//
//                add(imageLabel, BorderLayout.WEST);
//                add(textPanel, BorderLayout.CENTER);
//
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
