package final_assignment.practice.gui;

import final_assignment.practice.admin.AdminManager;

import javax.swing.*;
import java.awt.*;

public class AdminLoginScreen extends JFrame {
    private JTextField idField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton loginButton = new JButton("Login");

    private AdminManager adminManager;

    public AdminLoginScreen(AdminManager adminManager) {
        this.adminManager = adminManager;

        setTitle("Admin Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Admin ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(e -> handleLogin());

        setVisible(true);
    }

    private void handleLogin() {
        String id = idField.getText();
        String password = new String(passwordField.getPassword());

        if (adminManager.login(id, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            new AdminDashboard(adminManager);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid ID or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
