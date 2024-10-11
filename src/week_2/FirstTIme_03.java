package week_2;

import java.util.Scanner;

public class FirstTIme_03 {

    public static boolean isInside(int x, int y){
        return (100<=x && x<=200 && 100<=y && y<=200);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Coordinates of a point (x, y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (isInside(x, y)){
            System.out.println("(" + x +", " + y + "): inside the rectangle");
        }
        else {
            System.out.println("(" + x +", " + y + "): not in the rectangle");
        }

        scanner.close();
    }
}
