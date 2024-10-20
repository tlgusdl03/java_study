package week_6;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.random.RandomGenerator;

public class Lab06_5 {
    public static Scanner scanner = new Scanner(System.in);
    public static void closeScanner(){
        scanner.close();
    }

    public static int makingStartIndex(int length){
        RandomGenerator g = RandomGenerator.of("L64X128MixRandom");
        int startIndex = g.nextInt(length);
        return startIndex;
    }

    public static String makingSubString(int index, String input) {
        return input.substring(index);
    }

    public static StringTokenizer makingSubStringTokens(String input){
        StringTokenizer st = new StringTokenizer(input);
        return st;
    }

    public static void main(String[] args) {
        System.out.print("Input a string: ");
        String userInput = scanner.nextLine();

        int length = userInput.length();
        int startIndex = makingStartIndex(length);

        String subString = makingSubString(startIndex, userInput);
        StringTokenizer st = makingSubStringTokens(subString);

        int numOfWords = st.countTokens();

        System.out.println("startIndex = " + startIndex + ", #Words = " + numOfWords);
        while (st.hasMoreTokens()) {
            System.out.print(st.nextToken() + " ");
        }

        closeScanner();
    }
}
