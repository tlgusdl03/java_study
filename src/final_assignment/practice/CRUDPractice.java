package final_assignment.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

// Test implementation of CRUD of program Using File I/O Instead of Using DB
// After CLI test proceeded, Also will test on GUI
class Person{
    public String name;
    public int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name + ", " +age;
    }

    public static Person fromString(String line){
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        return new Person(name, age);
    }
}

public class CRUDPractice {
    private ArrayList<Person> people = new ArrayList<>();
    private final String filePath = "src/final_assignment/practice/text.txt";
    private Body body;

    public CRUDPractice(){
        initialize();
        new EntireScreen();
    }

    public void initialize(){
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Created new file " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getPeople(){
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            people.clear();
            while((line = bufferedReader.readLine()) != null){
                Person person = Person.fromString(line);
                people.add(person);
                System.out.println("name: " + person.name + ", age: " + person.age);
            }
            bufferedReader.close();
            fileReader.close();
            if(body != null){
                body.updateList();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createPerson(String name, int age){
        Person newPerson = new Person(name, age);
        people.add(newPerson);
        saveToFile();
        body.updateList();
    }

    public void updatePerson(String name, int newAge){
        boolean found = false;

        for(Person person : people){
            if(person.name.equals(name)){
                person.age = newAge;
                found=true;
                break;
            }
        }
        if(found){
            saveToFile();
            body.updateList();
        }else{
            System.out.println(name + "is not found");
        }
    }

    public void deletePerson(String name) {
        Iterator<Person> iterator = people.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.name.equals(name)) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            body.updateList();
        } else {
            System.out.println(name + "is not found");
        }
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : people) {
                bufferedWriter.write(person.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class EntireScreen extends JFrame{
        private Container c = getContentPane();
        public EntireScreen(){
            setTitle("GUI CRUD TEST");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            c.setLayout(new BorderLayout());

            InputHeader inputHeader = new InputHeader();
            body = new Body();

            c.add(inputHeader, BorderLayout.NORTH);
            c.add(body, BorderLayout.CENTER);

            setSize(1000, 1000);
            setVisible(true);
        }
    }

    class MyPanel extends JPanel{
        public MyPanel(String name, int age){
            setLayout(new GridLayout(1, 2));
            setSize(50, 30);

            add(new JLabel(name));
            add(new JLabel(Integer.toString(age)));
        }
    }
    class Body extends JPanel{
        private JPanel listPanel;
        public Body(){
            setLayout(new GridLayout(1, 1));
            listPanel = new JPanel();
            listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

            JScrollPane jScrollPane = new JScrollPane(listPanel);
            add(jScrollPane, BorderLayout.CENTER);

            updateList();
        }

        public void updateList(){
            listPanel.removeAll();
            for(Person p : people){
                listPanel.add(new MyPanel(p.name, p.age));
            }
            listPanel.revalidate();
            listPanel.repaint();
        }
    }
    class InputHeader extends JPanel{
        private String[] choices= {"1. List up", "2. Add", "3. Update", "4. Delete", "5. Exit"};
        private JRadioButton[] btn = new JRadioButton[5];
        private ButtonGroup buttonGroup = new ButtonGroup();
        private JTextField[] jTextFields = new JTextField[2];
        private JButton submitBtn = new JButton("Enter");
        public InputHeader(){
            setSize(500, 100);
            setLayout(new FlowLayout());

            JLabel jLabel = new JLabel("Enter the Choice, Name, Age");

            for(int i=0; i<5; i++){
                btn[i] = new JRadioButton(choices[i]);
                buttonGroup.add(btn[i]);
                add(btn[i]);
            }

            for(int i=0; i<2; i++){
                jTextFields[i] = new JTextField(10);
                add(jTextFields[i]);
            }

            submitBtn.addMouseListener(new MyMouseListener());
            add(submitBtn);
        }
        class MyMouseListener extends MouseAdapter{
            @Override
            public void mousePressed(MouseEvent e) {
                if(btn[0].isSelected()){
                    getPeople();
                    clear();
                }else if(btn[1].isSelected()){
                    createPerson(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()));
                    clear();
                }else if(btn[2].isSelected()){
                    updatePerson(jTextFields[0].getText(), Integer.parseInt(jTextFields[1].getText()));
                    clear();
                }else if(btn[3].isSelected()){
                    deletePerson(jTextFields[0].getText());
                    clear();
                }else if(btn[4].isSelected()){
                    System.exit(0);
                }
            }
        }

        private void clear(){
            jTextFields[0].setText("");
            jTextFields[1].setText("");
        }
    }

    public static void main(String[] args) {
        new CRUDPractice();
    }
}
