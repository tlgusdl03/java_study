package final_assignment.practice;

public class Person {
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
