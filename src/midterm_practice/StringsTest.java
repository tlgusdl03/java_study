package midterm_practice;

import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;


public class StringsTest {


    public static void main(String[] args) {
        String string = new String("hello");

        StringBuffer stringBuffer = new StringBuffer("hello");

        StringBuilder stringBuilder = new StringBuilder("hello");

        stringBuffer.append(string);
        System.out.println(stringBuffer.capacity());
        stringBuffer.append(stringBuffer);
        System.out.println(stringBuffer.capacity());
        stringBuffer.setLength(10);
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());



    }
}
