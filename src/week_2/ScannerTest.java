package week_2;

import java.util.Scanner;

public class ScannerTest {
    public static Scanner scanner = new Scanner(System.in);

    public static void closeScanner(){
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Enter your name : ");
        String name = scanner.nextLine();

        System.out.println("Enter your age : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your address : ");
        String address = scanner.nextLine();

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);

        closeScanner();
    }
}
