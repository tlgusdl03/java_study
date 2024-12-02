package week_13;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserEx extends JFrame {
    private JLabel imageLabel = new JLabel();
    public FileChooserEx(){
        setTitle("FileChooser 활용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(imageLabel);
        createMenu();
        setSize(350, 200);
        setVisible(true);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");

        openItem.addActionListener(new OpenActionListener());
        fileMenu.add(openItem);
        mb.add(fileMenu);
        setJMenuBar(mb);
    }

    class OpenActionListener implements ActionListener{
        private JFileChooser chooser;
        public OpenActionListener(){
            chooser = new JFileChooser();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);

            int ret = chooser.showOpenDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
        }
    }

    public static void main(String[] args) {
        new FileChooserEx();
    }
}
