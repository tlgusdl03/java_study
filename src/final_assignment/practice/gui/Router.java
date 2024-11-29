package final_assignment.practice.gui;

import javax.swing.*;
import java.awt.*;

public class Router extends JFrame{
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu[] menus = new JMenu[3];
    private String[] menuStrings = {"Screen", "Edit", "Source"};
    private String[][] subMenuStrings = {
            {"add", "delete", "update"},
            {"add", "delete", "update"},
            {"add", "delete", "update"},
    };
    public Router(){
        setMenu();
        setJMenuBar(jMenuBar);
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    void setMenu(){
        for(int i=0; i< menus.length; i++){
            menus[i] = new JMenu(menuStrings[i]);
            for(int j=0; j< subMenuStrings.length; j++){
                menus[i].add(new JMenuItem(subMenuStrings[i][j]));
            }
            jMenuBar.add(menus[i]);
        }
    }
}
