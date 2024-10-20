package week_4;

class Car{
    private String model;
    private String color;
    private int year;
    Car(){}
    Car(String model){
        this();
        this.model = model;
    }
    Car(String model, String color){
        this(model);
        this.color = color;
    }
    Car(String model, String color, int year){
        this(model,color);
        this.year = year;
    }

    void printInfor(){
        System.out.print(this.model + " ");
        System.out.print(this.color + " ");
        System.out.print(this.year + " ");
        System.out.println();
    }
}

public class FirstTime_01 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("MC20");
        Car car3 = new Car("MC20", "white");
        Car car4 = new Car("MC20", "white", 2021);

        car1.printInfor();
        car2.printInfor();
        car3.printInfor();
        car4.printInfor();
    }
}
