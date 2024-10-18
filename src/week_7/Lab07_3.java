package week_7;

import java.util.Iterator;
import java.util.Vector;

public class Lab07_3 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);

        System.out.println("size: " + v.size());
        System.out.println("capacity: " + v.capacity());

        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        int sum=0;
        it=v.iterator();
        while (it.hasNext()) {
            sum+=it.next();
            System.out.println("sum: " + sum);
        }
    }
}
