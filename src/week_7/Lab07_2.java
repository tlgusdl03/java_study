package week_7;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab07_2 {
    static ArrayList<String> myArrayList = new ArrayList<String>();

    static Scanner scanner = new Scanner(System.in);

    static int longestIndex = 0;
    public static void main(String[] args) {

        while (true) {
            System.out.print("? ");
            String temp;
            temp = scanner.next();
            if(temp.equals("exit")){
                break;
            }
            else{
                myArrayList.add(temp);
            }
        }


        for(String i : myArrayList){
            System.out.print(i + " ");
        }

        for(int i=1; i< myArrayList.size(); i++){
            if (myArrayList.get(longestIndex).length() < myArrayList.get(i).length()) {
                longestIndex = i;
            }
        }

        System.out.println("\nthe longest name: " + myArrayList.get(longestIndex));

        scanner.close();
    }
}
