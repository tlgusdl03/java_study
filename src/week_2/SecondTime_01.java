package week_2;

import java.util.Scanner;

public class SecondTime_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요:");
        int userInput = scanner.nextInt();

        int seconds = userInput % 60;
        int minutes = (userInput / 60) % 60;
        int hours = (userInput / 60) / 60;

        System.out.print(userInput + "초는 " + hours + "시간, " + minutes + "분, " + seconds + "초입니다.");
        scanner.close();
    }
}
