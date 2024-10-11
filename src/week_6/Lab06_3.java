package week_6;

import java.util.Objects.*;

import static java.util.Objects.hash;

class Student{
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode(){
        return hash(this.id, this.name);
    }


    @Override
    public boolean equals(Object obj){
        Student A = (Student) obj;
        return this.id == A.id && this.name == A.name;
    }
}

public class Lab06_3 {
    public static void main(String[] args) {
        Student s1 = new Student(16, "dlwlrma");
        Student s2 = new Student(16, "dlwlrma");

        int s1Hash = hash(s1);
        int s2Hash = hash(s2);

        if(s1Hash==s2Hash){
            if (s1.equals(s2)) {
                System.out.println("s1 == s2");
                return;
            }
        }
        System.out.println("s1 != s2");
    }
}
