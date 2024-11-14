package final_assignment.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CRUDPractice {
    private ArrayList<Person> people = new ArrayList<>();
    private final String filePath = "src/final_assignment/practice/text.txt";
    public Body body;

    public CRUDPractice(){
        initialize();
        new EntireScreen(this);
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
        getPeople();
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

    public ArrayList<Person> getPeopleList() {
        return people;
    }

    public static void main(String[] args) {
        new CRUDPractice();
    }
}
