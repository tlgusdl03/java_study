package midterm_practice;

public class ExceptionTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c;
        try {
            c = a / b;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("t");
            return;
        }
        System.out.println(c);
    }
}
