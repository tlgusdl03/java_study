package final_assignment.practice;

public class Person {
    public String name;
    public int age;
    public String profileImagePath;

    Person(String name, int age, String profileImagePath){
        this.name = name;
        this.age = age;
        this.profileImagePath=profileImagePath;
    }

    @Override
    public String toString(){
        return name + ", " + age + ", " + profileImagePath;
    }

    public static Person fromString(String line){
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        String profileImagePath = parts[2].trim();
        return new Person(name, age, profileImagePath);
    }
}
