package week_3;

import java.util.Scanner;

public class Program_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your message.");
        System.out.println("q: quit the program.");

        String input = "";

        while(!input.equals("q")){

            System.out.print("> ");
            input = scanner.nextLine();
            System.out.println(input);

        }


        System.out.println("\nBye!");
    }
}
