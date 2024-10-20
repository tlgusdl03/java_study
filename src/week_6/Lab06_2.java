package week_6;

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + this.x + ", " + this.y + ")";
    }
}

class Circle extends Point{
    private int radius;


    Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
    }

    public boolean isSameCircle(Circle other){
        if(this == other){
            return true;
        }
        else{
            return this.getClass() == other.getClass() && this.radius == other.radius;
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", r = " + this.radius;
    }
}
public class Lab06_2 {
    public static void main(String[] args) {
        Circle c1 = new Circle(3, 4, 5);
        Circle c2 = new Circle(3, 4, 5);
        Circle c3 = new Circle(3, 4, 6);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("c1 " + (c1.isSameCircle(c2) ? "==" : "!=") + " c2");
        System.out.println("c2 " + (c2.isSameCircle(c3) ? "==" : "!=") + " c3");
    }
}
