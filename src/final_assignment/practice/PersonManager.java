package final_assignment.practice;

import final_assignment.practice.admin.AdminManager;
import final_assignment.practice.gui.AdminLoginScreen;
import final_assignment.practice.gui.EntireScreen;
import final_assignment.practice.gui.Router;
import final_assignment.practice.user.People;
import final_assignment.practice.user.Person;

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
//        getAll();
    }

    @Override
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

    @Override
    public People create(String name, int age, String profileImagePath){
        Person newPerson = new Person(name, age, profileImagePath);
        people.add(newPerson);
        saveToFile();
        return people;
    }

    @Override
    public People update(String name, int newAge){
        people.update(name, newAge);
        saveToFile();
        return people;
    }
    @Override
    public People delete(String name) {
        people.delete(name);
        saveToFile();
        return people;
    }
    @Override
    public People getSome(String name){
        people.clear();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.contains(name)){
                    Person person = Person.fromString(line);
                    people.add(person);
                    System.out.println("name: " + person.name + ", age: " + person.age);
                }
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
//        PersonManager personManager = new PersonManager();
//        new EntireScreen(personManager);
//        AdminManager adminManager = new AdminManager();
//        new AdminLoginScreen(adminManager);
        new Router();
    }
}
