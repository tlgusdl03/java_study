package week_5;

import javax.xml.namespace.QName;

class People{
    private String name;
    private String ssn;

    public People(String name, String ssn){
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }
}

class Student extends People{
    private int id;

    public Student(String name, String ssn, int id){
        super(name, ssn);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
public class Lab05_1 {
    public static void main(String[] args) {
        Student s = new Student("dlwlrma", "930516-2xxxxxx", 12231234);
        System.out.println("name: " + s.getName());
        System.out.println("ssn: " + s.getSsn());
        System.out.println("name: " + s.getId());
    }
}
