package final_assignment.practice.gui.admin;

import final_assignment.practice.admin.AdminManager;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JPanel {
    private AdminManager adminManager;
    public AdminDashboard(AdminManager adminManager) {
        this.adminManager = adminManager;

        setSize(400, 300);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome, Admin!", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        JButton addAdminButton = new JButton("Add Admin");
        JButton removeAdminButton = new JButton("Remove Admin");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addAdminButton);
        buttonPanel.add(removeAdminButton);
        add(buttonPanel, BorderLayout.CENTER);

        addAdminButton.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Enter new admin ID:");
            String password = JOptionPane.showInputDialog(this, "Enter new admin password:");
            if (id != null && password != null) {
                adminManager.addAdmin(id, password);
                JOptionPane.showMessageDialog(this, "Admin added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        removeAdminButton.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Enter admin ID to remove:");
            if (id != null) {
                adminManager.removeAdmin(id);
                JOptionPane.showMessageDialog(this, "Admin removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);

    }
}
