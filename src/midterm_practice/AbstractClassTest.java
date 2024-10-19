package midterm_practice;

interface Sup3{
    int TIMEOUT = 0;

    default void printAny(){
        System.out.println("");
    }

    private static void sayHello() {
        System.out.println("Hello");
    }
    private void printAll(){
        System.out.println("");
    }
}
abstract class Sup1{
    public void print(){

    }
}
abstract class Sup2 extends Sup1{

    public static int TIMEOUT = 10000;
    public int a;
    abstract public void print();
}
public class AbstractClassTest {
    public static void main(String[] args) {
        Sup2 sup2 = new Sup2() {
            @Override
            public void print() {
                System.out.println(this.TIMEOUT);
            }
        };

        sup2.print();
    }
}
