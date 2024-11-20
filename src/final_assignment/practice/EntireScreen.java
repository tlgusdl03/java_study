package final_assignment.practice;

import javax.swing.*;
import java.awt.*;

public class EntireScreen extends JFrame{
    private CrudProgram crudProgram;
    public EntireScreen(CrudProgram crudProgram){
        this.crudProgram = crudProgram;

        setTitle("Person Manager Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 1000);

        InputHeader inputHeader = new InputHeader(crudProgram);
        add(inputHeader, BorderLayout.NORTH);

        Body body = new Body(crudProgram);
        add(body, BorderLayout.CENTER);

        setVisible(true);
    }

    public void updateScreen(){

    }

}

