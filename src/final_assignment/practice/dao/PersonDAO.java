package final_assignment.practice.dao;



import final_assignment.practice.dto.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private final String filePath;

    public PersonDAO(String filePath) {
        this.filePath = filePath;
    }
    public List<Person> getAll(){
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                people.add(Person.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }
    public List<Person> find(String name){
        List<Person> people = getAll();
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().contains(name)) {
                result.add(person);
            }
        }
        return result;
    }
    public void add(Person person){
        List<Person> people = getAll();
        people.add(person);
        saveAll(people);
    }

    public void update(String name, int newAge){
        List<Person> people = getAll();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                person.setAge(newAge);
                break;
            }
        }
        saveAll(people);
    }
    public void delete(String name){
        List<Person> people = getAll();
        people.removeIf(person -> person.getName().equals(name));
        saveAll(people);
    }

    private void saveAll(List<Person> people) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : people) {
                writer.write(person.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
