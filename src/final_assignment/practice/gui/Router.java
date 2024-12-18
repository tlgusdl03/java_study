package final_assignment.practice.gui;

import final_assignment.practice.admin.AdminManager;
import final_assignment.practice.gui.admin.AdminDashboard;
import final_assignment.practice.gui.peopleManage.EntireScreen;
import final_assignment.practice.service.PersonManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// 로그인화면 - MainPage간 화면 전환을 담당함
// 로그인 성공시 MainPage를 볼 수 있도록 함
public class Router extends JFrame{
    private AdminManager adminManager = new AdminManager();
    private PersonManager personManager = new PersonManager("src/final_assignment/practice/text.txt");
    private LoginPage loginPage = new LoginPage(adminManager);
    private EntireScreen entireScreen = new EntireScreen(personManager);
    private AdminDashboard adminDashboard = new AdminDashboard(adminManager);

    public Router(){
        init();
    }
    private void init(){
        setTitle("Main Application");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMenu();
        loginPage.setModal(true);
        loginPage.setLoginButtonActionListener(new LoginBtnListener());
    }

    private void setMenu(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu1 = new JMenu("Admin");
        JMenu jMenu2 = new JMenu("Main");

        JMenuItem jMenuItem1 = new JMenuItem("Page");
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(adminDashboard);
                revalidate();
                repaint();
            }
        });
        JMenuItem jMenuItem2 = new JMenuItem("Page");
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(entireScreen);
                revalidate();
                repaint();
            }
        });

        jMenu1.add(jMenuItem1);
        jMenu2.add(jMenuItem2);

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);
    }

    class LoginBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(loginPage.handleLogin()){
                loginPage.dispose();
                setContentPane(entireScreen);
                setVisible(true);
                revalidate();
                repaint();
            }else{
                JOptionPane.showMessageDialog(getParent(), "Wrong ID or Password", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
