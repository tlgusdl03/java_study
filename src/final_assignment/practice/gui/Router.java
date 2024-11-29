package final_assignment.practice.gui;

import final_assignment.practice.PersonManager;
import final_assignment.practice.admin.AdminManager;
import final_assignment.practice.gui.admin.AdminDashboard;
import final_assignment.practice.gui.admin.AdminLoginScreen;
import final_assignment.practice.gui.peopleManage.EntireScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Router extends JFrame{

    private String[] menuStrings = {"Admin", "Main"};
    private String[][] subMenuStrings = {
            {"page"},
            {"page"},
    };

    private AdminManager adminManager = new AdminManager();
    private PersonManager personManager = new PersonManager();
    private AdminLoginScreen adminLoginScreen = new AdminLoginScreen(adminManager);
    private AdminDashboard adminDashboard = new AdminDashboard(adminManager);
    private EntireScreen entireScreen = new EntireScreen(personManager);
    private Object[] object = {adminDashboard, entireScreen};
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu[] menus = new JMenu[2];

    public Router(){
        setMenu();
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(adminLoginScreen);
        setVisible(true);
    }

    void setMenu(){
        for(int i=0; i< menus.length; i++){
            menus[i] = new JMenu(menuStrings[i]);
            for(int j=0; j< subMenuStrings[i].length; j++){
                JMenuItem jMenuItem = new JMenuItem(subMenuStrings[i][j]);
                int finali = i;
                jMenuItem.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Page Changed!" + finali);
                            setContentPane((Container) object[finali]);
                            revalidate();
                            repaint();
                        }
                    }
                );
                menus[i].add(jMenuItem);
            }
            jMenuBar.add(menus[i]);
        }
        setJMenuBar(jMenuBar);
        adminLoginScreen.setLoginButtonActionListener(new LoginActionListener());
    }

    class LoginActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("login button clicked!");
            if (adminLoginScreen.handleLogin()) {
                JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                setContentPane(adminDashboard);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid ID or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
