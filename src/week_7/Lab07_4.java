package week_7;

import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;;

class Student{
    private String name;
    private String birth;
    private int height;

    public Student(String name, String birth, int height) {
        this.name = name;
        this.birth = birth;
        this.height = height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth, height);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            return name.equals(s.name) && birth.equals(s.birth) && height == s.height;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + birth + " " + height;
    }
}
public class Lab07_4 {
    public static void main(String[] args) {
        HashMap<Student, Integer> h = new HashMap<>();
        h.put(new Student("dlwlrma", "930516", 162), 10000);
        h.put(new Student("pby", "900212", 158), 15000);
        h.put(new Student("pby", "000720", 158), 15000);
        h.put(new Student("dlwlrma", "930516", 162), 20000);

        for (Entry<Student, Integer> e : h.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
