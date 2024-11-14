package week_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program_04 extends JFrame {
    private ImageIcon[] gbbImage = {
            new ImageIcon("src/week_11/images/gawi.jpg"),
            new ImageIcon("src/week_11/images/bawi.jpg"),
            new ImageIcon("src/week_11/images/bo.jpg")
    };
    private MenuPanel menuPanel = new MenuPanel();
    private GamePanel gamePanel = new GamePanel();

    public Program_04(){
        super("GBB game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }
    class MenuPanel extends JPanel{
        private JButton[] gbbBtn = new JButton[3];
        public MenuPanel(){
            setBackground(Color.GRAY);
            for(int i=0; i<gbbBtn.length; i++){
                gbbBtn[i] = new JButton(gbbImage[i]);
                gbbBtn[i].addActionListener(new MyActionListener());
                add(gbbBtn[i]);
            }
        }
    }

    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButton = (JButton) e.getSource();
            int computerPart = (int) (Math.random() * 3);

            String winner = "Same!!!";

            if (jButton.getIcon() == gbbImage[0] && computerPart == 2 ||
                    jButton.getIcon() == gbbImage[1] && computerPart == 0 ||
                    jButton.getIcon() == gbbImage[2] && computerPart == 1) {
                winner = "Me!!!";
            } else if (jButton.getIcon() == gbbImage[0] && computerPart == 1 ||
                    jButton.getIcon() == gbbImage[1] && computerPart == 2 ||
                    jButton.getIcon() == gbbImage[2] && computerPart == 0) {
                winner = "Computer";
            }

            gamePanel.draw(jButton.getIcon(), gbbImage[computerPart], winner);
        }
    }

    class GamePanel extends JPanel{
        private JLabel me = new JLabel("me");
        private JLabel computer = new JLabel("com");
        private JLabel winner = new JLabel("Winner");

        public GamePanel(){
            setBackground(Color.YELLOW);
            add(me);
            add(computer);
            add(winner);
            winner.setForeground(Color.RED);
        }

        public void draw(Icon my, Icon com, String w){
            me.setIcon(my);
            computer.setIcon(com);
            winner.setText(w);
        }
    }

    public static void main(String[] args) {
        new Program_04();
    }
}
