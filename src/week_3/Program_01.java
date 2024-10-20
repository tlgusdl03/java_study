package week_3;

import java.util.Scanner;

public class Program_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArray;
        inputArray = new int[5];

        int maxNum=-1;

        System.out.println("Input 5 positive numbers.");

        for(int i=0;i<5;i++){
           inputArray[i] = scanner.nextInt();
           if(maxNum < inputArray[i]){
               maxNum = inputArray[i];
           }
        }

        System.out.println("Maximum number: " + maxNum);
    }
}
