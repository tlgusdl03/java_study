package week_9;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte[] bytes = {7, 51, 3, 4, -1, 24};
        try {
            FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
            for (int i = 0; i < bytes.length; i++) {
                fout.write(bytes[i]);
            }
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("c:/Temp/test.out을 저장하였습니다.");
    }
}
