package midterm_practice.accessControl_practice.package1;

import midterm_practice.accessControl_practice.package2.Base1;

public class Base2 extends Base1{

    void printAll(){
        System.out.println(publicString);
        System.out.println(protectedString);
    }
    public static void main(String[] args) {
        Base2 base2 = new Base2();
        base2.printAll();
    }
}
