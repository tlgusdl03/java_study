package week_4;

class parent{
    private String name;
    private int age;

    public parent(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class child extends parent{
    private String address;
    public child(String name, int age, String address){
        super(name, age);
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String getName(){
        return super.getName() + "'s child";
    }

    public boolean getAddress(String input){
        return this.getAddress().equals(input);
    }
}

public class OverloadingTest {
    public static void main(String[] args) {
        parent myparent = new parent("abc", 50);
        child mychild = new child(myparent.getName(), myparent.getAge(), "Incheon");

        System.out.println(mychild.getAddress());
        System.out.println(mychild.getAddress("seoul"));

        System.out.println(myparent.getName());
        System.out.println(mychild.getName());
    }
}
