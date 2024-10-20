package week_4;

class Test{
    private int a;

    public Test(int input){
        this.a = input;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
public class ParameterTest {
    public static void makeDifference(int a){
        a++;
        System.out.println(a);
    }

    public static void makeDifference(Test a){
        a.setA(a.getA() + 1);
        System.out.println(a.getA());
    }

    public static void main(String[] args) {
        Test a = new Test(10);
        int b = 10;


        makeDifference(b);
        System.out.println(b);

        makeDifference(a);
        System.out.println(a.getA());
    }
}
