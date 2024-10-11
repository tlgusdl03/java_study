package week_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] input;
        input = new int[2][3];

        System.out.println("Enter 6 integers one by one");

        for(int i=0; i<6; i++){
            int temp;
            System.out.print("> ");

            try{
                temp = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Not an integer!");
                scanner.next();
                i--;
                continue;
            }

            if(i < 3){
                input[0][i] = temp;
            }
            else{
                input[1][i-3] = temp;
            }
        }

        for(int i[] : input){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
