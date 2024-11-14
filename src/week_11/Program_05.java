package week_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

public class Program_05 extends JFrame{
    private RadioPanel radioPanel = new RadioPanel();
    private JLabel imageLabel = new JLabel();
    private Vector<ImageIcon> imageVector = new Vector<>();

    public Program_05(){
        super("Image gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        loadImages("src/week_11/images2");
        c.add(radioPanel, BorderLayout.NORTH);
        c.add(imageLabel, BorderLayout.CENTER);
        imageLabel.setIcon(imageVector.getFirst());
        imageLabel.addMouseListener(new MyMouseListener());

        setSize(400, 300);
        setVisible(true);
    }
    public void loadImages(String src){
        File file = new File(src);
        File[] files = file.listFiles();
        for(File f : files){
            if (f.isFile()) {
                ImageIcon icon = new ImageIcon(f.getPath());
                imageVector.add(icon);
            }
        }
    }

    class RadioPanel extends JPanel {
        private JRadioButton leftRadio = new JRadioButton("left");
        private JRadioButton rightRadio = new JRadioButton("right");

        public RadioPanel(){
            ButtonGroup g = new ButtonGroup();
            g.add(leftRadio);
            g.add(rightRadio);

            add(leftRadio);
            add(rightRadio);

            leftRadio.setSelected(true);
        }

        public boolean isLeft(){
            return leftRadio.isSelected();
        }
    }
    class MyMouseListener extends MouseAdapter{
        private int index = 0;
        @Override
        public void mouseReleased(MouseEvent e) {
            if(radioPanel.isLeft()){
                index++;
                index %= imageVector.size();
                imageLabel.setIcon(imageVector.get(index));
            }else{
                index--;
                if (index == -1) {
                    index  = imageVector.size()-1;
                }
                imageLabel.setIcon(imageVector.get(index));
            }
        }
    }

    public static void main(String[] args) {
        new Program_05();
    }
}
