package midterm_practice;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

        String name = "";
        int age = 0;
        Scanner scanner = new Scanner(System.in);

        age = scanner.nextInt();
        scanner.nextLine();
        name = scanner.nextLine();

        System.out.println(age);
        System.out.println(name);

        age = scanner.nextInt();
        name = scanner.next();

        System.out.println(age);
        System.out.println(name);

    }
}
