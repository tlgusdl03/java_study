package week_4;

import java.util.Scanner;

class Student2{
    private String name;
    private int birth;

    Student2(String name, int birth){
        this.name = name;
        this.birth = birth;
    }

    void printInfor(){
        System.out.print(this.name + " ");
        System.out.println(this.birth);
    }
}
public class FirstTime_03 {
    static Scanner scan = new Scanner(System.in);
    static void closeScanner(){
        scan.close();
    }

    static Student2[] makeArray(int num){
        Student2[] result;
        result = new Student2[num];
        String name;
        int birth;
        for(int i=0; i<num; i++){
            System.out.print("Enter your name and birth: ");
            name = scan.next();
            birth = scan.nextInt();
            result[i] = new Student2(name, birth);
        }

        return result;
    }

    static void printArray(Student2[] result){
        for(Student2 student : result){
            student.printInfor();
        }
    }
    public static void main(String[] args) {
        int number;
        System.out.print("Enter #students: ");
        number = scan.nextInt();
        Student2[] sArr = makeArray(number);
        System.out.println();
        printArray(sArr);
        FirstTime_03.closeScanner();
    }
}
