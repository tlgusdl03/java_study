package final_assignment.practice.dto;

public class Person {
    private String name;
    private int age;
    private String profileImagePath;

    public Person(String name, int age, String profileImagePath) {
        this.name = name;
        this.age = age;
        this.profileImagePath = profileImagePath;
        System.out.println("new Person is created!");
        System.out.println("profileImagePath set to: " + (profileImagePath == null ? "null!" : profileImagePath));
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public String getProfileImagePath() {
        if(profileImagePath == null){
            System.out.println("image Path is Null!");
        }
        return profileImagePath;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + profileImagePath;
    }

    public static Person fromString(String data) {
        String[] parts = data.split(",");
        return new Person(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}
