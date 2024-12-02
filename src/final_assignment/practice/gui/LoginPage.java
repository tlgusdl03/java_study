package final_assignment.practice.gui;

import final_assignment.practice.admin.AdminManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPage extends JDialog {
    private JTextField idField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton loginButton = new JButton("Login");
    private AdminManager adminManager;
    public LoginPage(AdminManager adminManager) {
        this.adminManager = adminManager;

        setSize(300, 150);
        setLayout(new FlowLayout());

        add(new JLabel("Admin ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        setVisible(true);
    }

    public void setLoginButtonActionListener(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }

    public boolean handleLogin(){
        String id = idField.getText();
        String password = new String(passwordField.getPassword());
        return adminManager.login(id, password);
    }
}
