package week_9;

import java.io.*;

public class Program_03 {
    public static void main(String[] args) {
        try {
            File file = new File("c:/tmp");
            File[] subfiles = file.listFiles();

            for(int i=0; i<subfiles.length; i++){
                if(subfiles[i].isFile()){
                    System.out.println("<" + subfiles[i].getName() + ">");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(subfiles[i]));
                    int c;
                    while((c= bufferedReader.read())!=-1){
                        System.out.print((char) c);
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
