package week_9;

import java.io.*;
import java.util.Scanner;

public class Program_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileOutputStream fout = null;
        OutputStreamWriter out = null;
        FileInputStream fin = null;
        InputStreamReader in = null;

        String userInput = null;

        try {
            fout = new FileOutputStream("c:/test/test3.txt");
            out = new OutputStreamWriter(fout, "UTF-8");
            while(true){
                userInput = scanner.nextLine();
                if(userInput.length()==0) break;
                out.write(userInput + "\r\n");
            }
            out.close();
            fout.close();
            scanner.close();

            int num;
            char[] c = new char[10];
            fin = new FileInputStream("c:/test/test3.txt");
            in = new InputStreamReader(fin, "UTF-8");

            if ((num=in.read(c))!=-1) {
                for(int i=0; i<num; i++){
                    System.out.println(c[i]);
                }
            }
            fin.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
