package week_3;

import java.util.Scanner;

public class Program_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray;
        intArray = new int[5];
        int sum=0;

        System.out.print("Input 5 positive numbers: ");

        for(int i : intArray){
            intArray[i] = scanner.nextInt();
            sum += intArray[i];
        }

        System.out.println("Average: " + (sum / (double)intArray.length));
    }
}
