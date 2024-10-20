package midterm_practice;

import java.sql.Wrapper;

public class WrapperClassTest {
    public static void main(String[] args) {
        Integer integer = Integer.valueOf(10);
        System.out.println(integer.intValue());
        System.out.println(Integer.parseInt("1001", 2));
    }
}
