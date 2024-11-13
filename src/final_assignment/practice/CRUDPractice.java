package final_assignment.practice;

import javax.script.ScriptEngine;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
        String name = parts[0];
        int age = Integer.parseInt(parts[1].trim());
        return new Person(name, age);
    }
}

public class CRUDPractice {
    private ArrayList<Person> people = new ArrayList<>();
    private final String filePath = "src/final_assignment/practice/text.txt";

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
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createPerson(String name, int age){
        Person newPerson = new Person(name, age);
        try{
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(newPerson.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
            System.out.println(name +"`s age is updated to " + newAge  );
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
            System.out.println(name + "is deleted");
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

    public static void main(String[] args) {
        CRUDPractice crud = new CRUDPractice();
        Scanner scanner = new Scanner(System.in);

        crud.initialize();

        while(true){
            System.out.println("\n1. See all people");
            System.out.println("2. Add new person");
            System.out.println("3. Exit");
            System.out.println("Enter : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\nPerson List:");
                crud.getPeople();
            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                crud.createPerson(name, age);
                System.out.println("New person added.");
            } else if (choice == 3) {
                System.out.println("Terminated...");
                break;
            } else {
                System.out.println("Incorrect Input.");
            }
        }
        scanner.close();
    }
}
