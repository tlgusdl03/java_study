package week_3;

import java.util.Scanner;

public class Program_05 {
    public static int[][] makeArray(){
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][];

        array[0] = new int[3];
        array[1] = new int[1];
        array[2] = new int[4];

        System.out.println("Enter 8 integers");

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println();

        return array;
    }
    public static void main(String[] args) {

        int[][] madeArray = makeArray();

        for(int i[] : madeArray){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
