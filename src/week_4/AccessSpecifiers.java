package week_4;

class MySuperClass{
    public int a;
    protected int b;
    private int c;
    int d;
    MySuperClass(){
        this.a = 10;
        this.b = 20;
        this.c = 30;
        this.d = 40;
    }
}

class MySubClass extends MySuperClass{
    public int a;
    protected int b;
    private int c;
    int d;

    MySubClass(){
        this.a = super.a;
        this.b = super.b;
//        this.c = super.c;
        this.d = super.d;
    }
}
public class AccessSpecifiers {
    public static void main(String[] args) {
        MySuperClass myClass = new MySuperClass();

        System.out.println(myClass.a + " " + myClass.b + " " + " " + myClass.d);
    }
}
