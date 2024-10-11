package week_2;
import java.util.Scanner;

public class FirstTime_01 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("age: ");
        int userAge = userInput.nextInt();

        userInput.nextLine();

        System.out.print("name: ");
        String userName = userInput.nextLine();
//        String userFirstName = userInput.next();
//        String userLastName = userInput.next();

        System.out.println(userAge + " " + userName);
//        System.out.println(userAge + " " + userFirstName + " " + userLastName);

        userInput.close();
    }
}
