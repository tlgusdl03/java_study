package week_4;

class Student{
    private String name;
    private int birth;

    Student(String name, int birth){
        this.name = name;
        this.birth = birth;
    }
    boolean isOlder(Student other){
        return this.birth < other.birth;
    }
    String getName(){
        return this.name;
    }
}
public class FirstTime_02 {

    public static void printInfor(Student s1, Student s2){
        String s1Name = s1.getName();
        String s2Name = s2.getName();

        if(s1.isOlder(s2)){
            System.out.println(s1Name + " > " + s2Name);
        }
        else{
            System.out.println(s1Name + " <= " + s2Name);
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("pby", 19900212);
        Student s2 = new Student("dlwlrma", 19930516);
        Student s3 = new Student("JianLee", 19981104);
        printInfor(s1, s2);
        printInfor(s3, s2);
    }
}
