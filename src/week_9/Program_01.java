package week_9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileWriter fout = null;
        FileReader fin = null;

        String userInput = null;

        try {
            fout = new FileWriter("c:/test/test2.txt");
            while(true){
                userInput = scanner.nextLine();
                if (userInput.length() == 0) {
                    break;
                }
                fout.write(userInput);
                fout.write("\r\n");
            }
            fout.close();
            scanner.close();

            fin = new FileReader("c:/test/test2.txt");
            int c;

            while((c=fin.read())!=-1){
                System.out.print((char) c);
            }
            fin.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
