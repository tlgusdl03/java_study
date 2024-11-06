package week_9;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Program_04 {
    public static void main(String[] args) {
        long start, end;
        try {
            FileInputStream fis = new FileInputStream("c:/dlwlrma.jpg");
            start = System.currentTimeMillis();
            while (fis.read() != -1) {}
            end = System.currentTimeMillis();
            System.out.printf("FileInputStream: %dms\n", end-start);
            fis.close();

            fis = new FileInputStream("c:/dlwlrma.jpg");
            BufferedInputStream bis = new BufferedInputStream(fis);
            start = System.currentTimeMillis();
            while (bis.read() != -1) {
            }
            end = System.currentTimeMillis();
            System.out.printf("BufferedInputStream: %dms\n", end - start);
            bis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
