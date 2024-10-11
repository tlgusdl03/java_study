package week_2;

import java.util.Scanner;

public class Switch {
    public static Scanner scanner = new Scanner(System.in);

    public static void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        int userInput = scanner.nextInt();

        switch(userInput){
            case 90:
                System.out.println("90점");
                break;
            case 80:
                System.out.println("80점");
                break;
            default:
                System.out.println("불합격");
        }

        closeScanner();
    }
}
