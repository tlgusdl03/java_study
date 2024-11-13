package final_assignment;

import jdk.jfr.Category;
import jdk.jfr.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CustomerApp {
    private JFrame frame;
    private JTextField id;
    private JPasswordField pw;
    private JTextField name;
    private JTextField publisher;
    private JTextField bookNumber;
    private JTextField author;
    private JTextField search;
    private JPanel currPanel;
    public JTextField studentName;
    public JTextField studentNumber;
    public JTextField grade;
    public JTextField phoneNumber;
    public JTextField email;
    public JTextField studentID;
    public JTextField studentPW;
    public JTextArea address;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    CustomerApp window = new CustomerApp();
                    window.frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomerApp(){
        initialize();
    }

    private void initialize(){
        Customer customer = new Customer();

        frame = new JFrame();
        frame.setSize(803, 538);
        frame.getContentPane().setLayout(null);
        String[][] data = customer.getCustomers();
        String[] headers = new String[]{"Name", "Author", "BookNumber", "Publisher", "Category", "Introduction"};

        ImagePanel listPanel = new ImagePanel(new ImageIcon("List.jpg 경로").getImage());
        listPanel.setBounds(0, 0, 787, 476);
        listPanel.setVisible(false);
        ImagePanel loginPanel = new ImagePanel(new ImageIcon("welcome.jpg 경로").getImage());
        ImagePanel mainPanel = new ImagePanel(new ImageIcon("Administrator.jpg 경로").getImage());

        JPanel joinPanel = new JPanel();
        joinPanel.setVisible(false);
        joinPanel.setBounds(0, 0, 787, 476);
        frame.getContentPane().add(joinPanel);
        joinPanel.setLayout(null);

        JLabel studentNameL = new JLabel("StudentName");
        studentNameL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        studentNameL.setBounds(12, 108, 180, 44);
        joinPanel.add(studentNameL);

        JLabel gradeL = new JLabel("StudentNumber");
        gradeL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        gradeL.setBounds(12, 186, 180, 44);
        joinPanel.add(gradeL);

        JLabel phoneNumberL = new JLabel("PhoneNumber");
        phoneNumberL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        phoneNumberL.setBounds(372, 27, 180, 44);
        joinPanel.add(phoneNumberL);

        JLabel emailL = new JLabel("Email");
        emailL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        emailL.setBounds(372, 108, 180, 44);
        joinPanel.add(emailL);

        JLabel addressL = new JLabel("Address");
        addressL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        addressL.setBounds(372, 186, 180, 44);
        joinPanel.add(addressL);

        studentName = new JTextField();
        studentName.setBounds(136, 31, 202, 44);
        joinPanel.add(studentName);
        studentName.setColumns(10);

        studentNumber = new JTextField();
        studentNumber.setColumns(10);
        studentNumber.setBounds(136, 112, 202, 44);
        joinPanel.add(studentNumber);

        grade = new JTextField();
        grade.setColumns(10);
        grade.setBounds(497, 31, 278, 44);
        joinPanel.add(grade);

        phoneNumber = new JTextField();
        phoneNumber.setColumns(10);
        phoneNumber.setBounds(497, 112, 278, 122);
        joinPanel.add(phoneNumber);

        studentNumber = new JTextField();
        studentNumber.setColumns(10);
        studentNumber.setBounds(136, 112, 202, 44);
        joinPanel.add(studentNumber);

        grade = new JTextField();
        grade.setColumns(10);
        grade.setBounds(136, 186, 202, 44);
        joinPanel.add(grade);

        phoneNumber = new JTextField();
        phoneNumber.setColumns(10);
        phoneNumber.setBounds(497, 31, 278, 44);
        joinPanel.add(phoneNumber);

        email = new JTextField();
        email.setColumns(10);
        email.setBounds(497, 112, 278, 122);
        joinPanel.add(email);

        JTextArea address_1 = new JTextArea();
        address_1.setBounds(497, 186, 278, 122);
        joinPanel.add(address_1);

        JButton signupBtn = new JButton("Sign up");
        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User();
                    user.studentName = studentName.getText();
                    user.studentNumber = studentNumber.getText();
                    user.grade = grade.getText();
                    user.studentID = studentID.getText();
                    user.studentPW = studentPW.getText();
                    user.phoneNumber = phoneNumber.getText();
                    user.email = email.getText();
                    user.address = address_1.getText();

                    UserManager.getInstance().createUser(user);
                    studentName.setText("");
                    studentNumber.setText("");
                    grade.setText("");
                    studentID.setText("");
                    studentPW.setText("");
                    phoneNumber.setText("");
                    email.setText("");
                    address_1.setText("");
                    JOptionPane.showMessageDialog(null, "Data Saved Successfully");

                    joinPanel.setVisible(false);
                    loginPanel.setVisible(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "There was an error while writing the data");
                }
            }
        });

        signupBtn.setFont(new Font("함초롬돋움", Font.BOLD, 30));
        signupBtn.setBounds(372, 357, 379, 87);
        joinPanel.add(signupBtn);

        studentID = new JTextField();
        studentID.setColumns(10);
        studentID.setBounds(136, 264, 202, 44);
        joinPanel.add(studentID);

        JLabel studentIDL = new JLabel("StudentID");
        studentIDL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        studentIDL.setBounds(12, 343,180,44);
        joinPanel.add(studentIDL);

        studentPW = new JTextField();
        studentPW.setColumns(10);
        studentPW.setBounds(136, 343, 202, 44);
        joinPanel.add(studentPW);

        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(0, 0, 787, 476);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setVisible(false);

        JLabel lblNewLabel_2 = new JLabel("PKNU librarian Page");
        lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 20));
        lblNewLabel_2.setBounds(222, 0, 301, 62);
        mainPanel.add(lblNewLabel_2);

        JLabel nameL = new JLabel("Name");
        nameL.setHorizontalAlignment(SwingConstants.CENTER);
        nameL.setBounds(244, 51, 95, 51);
        mainPanel.add(nameL);

        JLabel bookNumberL = new JLabel("BoolNumber");
        bookNumberL.setHorizontalAlignment(SwingConstants.CENTER);
        bookNumberL.setBounds(180, 112, 183, 51);
        mainPanel.add(bookNumberL);

        JLabel categroyL = new JLabel("Category");
        categroyL.setHorizontalAlignment(SwingConstants.CENTER);
        categroyL.setBounds(446, 164, 183, 51);
        mainPanel.add(categroyL);

        JLabel publisherL = new JLabel("Publisher");
        publisherL.setHorizontalAlignment(SwingConstants.CENTER);
        publisherL.setBounds(446, 51, 183, 51);
        mainPanel.add(publisherL);

        JLabel authorL = new JLabel("Author");
        authorL.setHorizontalAlignment(SwingConstants.CENTER);
        authorL.setBounds(456, 103, 183, 51);
        mainPanel.add(authorL);

        JLabel introductionL = new JLabel("Introduction");
        introductionL.setHorizontalAlignment(SwingConstants.CENTER);
        introductionL.setBounds(206, 164, 183, 51);
        mainPanel.add(introductionL);

        name = new JTextField();
        name.setBounds(335, 64, 138, 38);
        mainPanel.add(name);
        name.setColumns(10);

        publisher = new JTextField();
        publisher.setColumns(10);
        publisher.setBounds(592, 64, 183, 38);
        mainPanel.add(publisher);

        bookNumber = new JTextField();
        bookNumber.setColumns(10);
        bookNumber.setBounds(334, 116, 139, 38);
        mainPanel.add(bookNumber);

        author = new JTextField();
        author.setColumns(10);
        author.setBounds(592, 112, 183, 38);
        mainPanel.add(author);

        JComboBox category = new JComboBox(new String[]{"humanities", "Operation", "literature", "technology", "magazine"});
        category.setEditable(true);
        category.setBackground(Color.WHITE);
        category.setBounds(592, 170, 183, 45);
        mainPanel.add(category);

        JTextArea introduction = new JTextArea();
        introduction.setBounds(233, 220, 290, 214);
        introduction.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.add(introduction);

        JButton submitBtn = new JButton("\uC800\uC7A5");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameTxt = name.getText();
                String authorTxt = author.getText();
                String bookNumberTxt = bookNumber.getText();
                String publisherTxt = publisher.getText();
                String categoryTxt = category.getSelectedItem().toString();
                String introductionTxt = introduction.getText();

                Customer.createCustomer(nameTxt, authorTxt, bookNumberTxt, publisherTxt, categoryTxt, introductionTxt);
                JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
                mainPanel.setVisible(false);
                listPanel.setVisible(true);
            }
        });
        submitBtn.setBounds(572, 244, 164, 77);
        mainPanel.add(submitBtn);

        JButton listBtn = new JButton("");
        listBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        listBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPanel.setVisible(false);
                listPanel.setVisible(true);
                currPanel = listPanel;
            }
        });

        listBtn.setIcon(new ImageIcon("listBtn1.jpg path"));
        listBtn.setBounds(42, 31, 152, 62);
        mainPanel.add(listBtn);
        listPanel.setLayout(null);
        JTable table = new JTable(data, headers);
        table.setRowHeight(30);
        table.setAlignmentX(0);
        table.setSize(600, 400);
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(219, 24, 556, 305);
        listPanel.add(scrollPane);
        frame.getContentPane().add(listPanel);

        search = new JTextField();
        search.setHorizontalAlignment(SwingConstants.CENTER);
        search.setText("\uAC80\uC0C9");
        search.setBounds(219, 352, 392, 63);
        listPanel.add(search);
        search.setColumns(10);

        JButton addBtn = new JButton("");
        addBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currPanel.setVisible(false);
                mainPanel.setVisible(true);
                currPanel=mainPanel;
            }
        });

        addBtn.setIcon(new ImageIcon("AdministratorBtn1.jpg path"));
        addBtn.setBounds(35, 141, 172, 63);
        listPanel.add(addBtn);

        currPanel = loginPanel;

        loginPanel.setBounds(0, 0, 787, 476);
        frame.getContentPane().add(loginPanel);

        JLabel lblNewLabel = new JLabel("Log In");
        lblNewLabel.setBounds(52, 0, 227, 132);
        loginPanel.add(lblNewLabel);

        id = new JTextField();
        id.setHorizontalAlignment(SwingConstants.LEFT);
        id.setToolTipText("");
        id.setBounds(97, 121, 158, 32);
        loginPanel.add(id);
        id.setColumns(10);

        pw = new JPasswordField();
        pw.setBounds(97, 163, 158, 32);
        loginPanel.add(pw);

        JLabel lblNewLabel_1 = new JLabel("ID : ");
        lblNewLabel_1.setBounds(39, 117, 70, 37);
        loginPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("PW : ");
        lblNewLabel_1.setBounds(39, 158, 70, 37);
        loginPanel.add(lblNewLabel_1_1);

        JButton btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon("loginBtn4.jpg path"));
        btnLogin.setPressedIcon(new ImageIcon("loginBtn5.jpg path"));

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = UserManager.getInstance().getUser(id.getText());

                if (user == null) {
                    JOptionPane.showMessageDialog(null, "ID does not Exist");
                } else {
                    if(!String.valueOf(pw.getPassword()).equals(user.studentPW)){
                        JOptionPane.showMessageDialog(null, "Passwords do not match");
                    }else {
                        JOptionPane.showMessageDialog(null, "You success Log IN");
                        mainPanel.setVisible(false);
                        listPanel.setVisible(true);
                    }
                }
            }
        });

        btnLogin.setBounds(64, 205, 191, 42);
        loginPanel.add(btnLogin);

        JButton joinBtn = new JButton("Sign Up");
        joinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(false);
                joinPanel.setVisible(true);
            }
        });

        joinBtn.setBounds(64, 257, 191, 23);
        loginPanel.add(joinBtn);

        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String val = search.getText();
                TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
                table.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(val));
            }
        });
    }

    public JMenuBar menuBar(){
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu aboutMenu = new JMenu("About");

        bar.add(fileMenu);
        bar.add(aboutMenu);

        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(openFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return bar;
    }
}


































