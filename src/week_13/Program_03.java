package week_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program_03 extends JFrame {
    private MyPanel p = new MyPanel();
    public Program_03(){
        setTitle("Menu & event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(p);
        createMenu();
        setSize(250, 220);
        setVisible(true);
    }

    class MenuActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "Load" : p.load(); break;
                case "Hide" : p.hide(); break;
                case "ReShow" : p.reShow(); break;
                case "Exit" :
                    int result = JOptionPane.showConfirmDialog(getContentPane(), "Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_NO_OPTION) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    class MyPanel extends JPanel{
        private Image img = null;
        private Image tmp = null;
        public void load(){
            img = new ImageIcon("src/week_13/images/dlwlrma1.jpg").getImage();
            setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
            pack();
            repaint();
        }
        public void hide(){
            tmp = img;
            img = null;
            repaint();
        }
        public void reShow(){
            img = tmp;
            repaint();
        }

        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            if (img == null) {
                return;
            }
            graphics.drawImage(img, 0, 0, this);
        }
    }
    private void createMenu(){
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem[] menuItems = new JMenuItem[4];
        String[] itemTitle = {"Load", "Hide", "Reshow", "Exit"};
        MenuActionListener listener = new MenuActionListener();

        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i] = new JMenuItem(itemTitle[i]);
            menuItems[i].addActionListener(listener);
            menu.add(menuItems[i]);
        }
        mb.add(menu);
        setJMenuBar(mb);
    }

    public static void main(String[] args) {
        new Program_03();
    }
}
