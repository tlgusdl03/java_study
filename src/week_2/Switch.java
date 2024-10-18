package week_2;

import java.util.Scanner;

public class Switch {
    public static Scanner scanner = new Scanner(System.in);

    public static void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        int userInput = scanner.nextInt();

        userInput /= 10;
        switch(userInput){
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            default:
                System.out.println("불합격");
                break;
        }

        closeScanner();
    }
}
