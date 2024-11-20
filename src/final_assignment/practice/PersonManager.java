package final_assignment.practice;

import java.io.*;
import java.util.ArrayList;
public class PersonManager implements CrudProgram{
    private People people = new People();
    private final String filePath = "src/final_assignment/practice/text.txt";

    public PersonManager(){
        initialize();
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
        getAll();
    }

    public People getAll(){
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
        }catch (IOException e){
            e.printStackTrace();
        }
        return people;
    }

    public People create(String name, int age, String profileImagePath){
        Person newPerson = new Person(name, age, profileImagePath);
        people.add(newPerson);
        saveToFile();
        return people;
    }

    public People update(String name, int newAge){
        people.update(name, newAge);
        saveToFile();
        return people;
    }

    public People delete(String name) {
        people.delete(name);
        saveToFile();
        return people;
    }

    private void saveToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            ArrayList<Person> data = people.getPeople();
            for (Person person : data) {
                bufferedWriter.write(person.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
         new EntireScreen(new PersonManager());
    }
}
