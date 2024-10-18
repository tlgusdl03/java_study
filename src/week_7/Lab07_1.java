package week_7;

import java.util.Iterator;
import java.util.Vector;

class Point{
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
public class Lab07_1 {

    static Vector<Point> myVector= new Vector<Point>();

    public static void main(String[] args) {
        myVector.add(new Point(5, 16));
        myVector.add(new Point(2, 12));
        myVector.add(new Point(1, 4));

        Iterator<Point> myIterator = myVector.iterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
