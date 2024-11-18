//package final_assignment.practice;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class EntireScreen extends JFrame {
//    private Container c = getContentPane();
//    public EntireScreen(CRUDPractice crudPractice){
//        setTitle("GUI CRUD TEST");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        c.setLayout(new BorderLayout());
//
//        InputHeader inputHeader = new InputHeader(crudPractice);
//        crudPractice.body = new Body(crudPractice);
//
//        c.add(inputHeader, BorderLayout.NORTH);
//        c.add(crudPractice.body, BorderLayout.CENTER);
//
//        setSize(1000, 1000);
//        setVisible(true);
//    }
//}
//
