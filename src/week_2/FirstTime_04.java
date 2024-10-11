package week_2;

import java.awt.*;
import java.util.Scanner;

public class FirstTime_04 {

    public static boolean isInside(int centerX, int centerY, int pointX, int pointY, double radius){
        int differentialX = centerX - pointX;
        int differentialY = centerY - pointY;

        double distance = Math.sqrt(Math.pow(differentialX,2)) + Math.sqrt(Math.pow(differentialY,2));

        return (distance < radius);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Center of circle: ");
        int centerX = scanner.nextInt();
        int centerY = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Radius: ");
        double radius = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Point: ");
        int pointX = scanner.nextInt();
        int pointY = scanner.nextInt();

        if (isInside(centerX, centerY, pointX, pointY, radius)){
            System.out.println("(" + pointX + ", " + pointY + "): inside the circle");
        }
        else {
            System.out.println("(" + pointX + ", " + pointY + "): not in the circle");
        }

        scanner.close();
    }
}
