package final_assignment.chat_client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame implements ActionListener{
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9999;
    private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private Receiver receiver = null;
    private JTextField sender = null;

    public ChatClient(){
        setTitle("클라이언트 채팅 창");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        receiver = new Receiver();
        receiver.setEditable(false);

        sender = new JTextField();
        sender.addActionListener(this);

        c.add(new JScrollPane(receiver), BorderLayout.CENTER);
        c.add(sender, BorderLayout.SOUTH);

        setSize(400, 200);
        setVisible(true);

        try {
            setupConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread th = new Thread(receiver);
        th.start();
    }

    private void setupConnection() throws IOException{
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        receiver.append("서버에 연결 완료");
        int pos = receiver.getText().length();
        receiver.setCaretPosition(pos);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    private class Receiver extends JTextArea implements Runnable {
        @Override
        public void run() {
            String msg = null;
            while (true) {
                try {
                    msg = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.append("\n 서버 : " + msg);
                int pos = this.getText().length();
                this.setCaretPosition(pos);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sender) {
            String msg = sender.getText();
            try {
                out.write(msg + "\n");
                out.flush();

                receiver.append("\n클라이언트 : " + msg);
                int pos = receiver.getText().length();
                receiver.setCaretPosition(pos);
                sender.setText(null);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
