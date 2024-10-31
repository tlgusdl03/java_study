package final_assignment_prefare;

import java.util.HashMap;

class Menu{
    private String name;
    private int price;
    private int beans;

    Menu(String name, int price, int beans){
        this.name = name;
        this.price = price;
        this.beans = beans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }
}

class CoffeeShop{
    private String name;
    private HashMap<Integer, Menu> menus = new HashMap<>();
    private int budget;
    private int beans;

    CoffeeShop(String name, Menu[] menus){
        this.name = name;
        this.budget = 500;
        this.beans = 500;
        for(int i=0; i<menus.length; i++){
            this.menus.put(i, menus[i]);
        }
    }

    boolean processingOrder(int i){
        if(!makingCoffee(i)){
            if(!buyBean()){
                return false;
            }
        }
        return true;
    }
    boolean buyBean(){
        if (this.budget >= 50) {
            this.budget -= 50;
            this.beans += 50;
            return true;
        }
        return false;
    }

    boolean makingCoffee(int i){
        Menu order = menus.get(i);
        if (this.beans >= order.getBeans()) {
            this.beans -= order.getBeans();
            this.budget += order.getPrice();
            return true;
        } else {
            return false;
        }
    }
}

class Customer{
    int makingOrder(){
        return (int) (Math.random() * 10);
    }
}

public class CoffeeShopGame {

    static Menu[] menu;
    static CoffeeShop coffeeShop;

    static Customer customer;

    static void init(){
        Menu coffee1 = new Menu("아메리카노", 2, 1000);
        Menu coffee2 = new Menu("아메리카노", 2, 1000);
        Menu coffee3 = new Menu("아메리카노", 2, 1000);
        Menu coffee4 = new Menu("아메리카노", 2, 1000);
        Menu coffee5 = new Menu("아메리카노", 2, 1000);
        Menu coffee6 = new Menu("아메리카노", 2, 1000);
        Menu coffee7 = new Menu("아메리카노", 2, 1000);
        Menu coffee8 = new Menu("아메리카노", 2, 1000);
        Menu coffee9 = new Menu("아메리카노", 2, 1000);
        Menu coffee10 = new Menu("아메리카노", 2, 1000);

        menu = new Menu[10];

        menu[0] = coffee1;
        menu[1] = coffee2;
        menu[2] = coffee3;
        menu[3] = coffee4;
        menu[4] = coffee5;
        menu[5] = coffee6;
        menu[6] = coffee7;
        menu[7] = coffee8;
        menu[8] = coffee9;
        menu[9] = coffee10;

        coffeeShop = new CoffeeShop("카페베네", menu);

        customer = new Customer();
    }

    public static void playGame() throws InterruptedException {
        int order;
        while(true){
            order = customer.makingOrder();
            String name = menu[order].getName();
            System.out.println("안녕하세요! 커피 가게에 어서오세요");
            System.out.println("주문하시겠어요?");
            Thread.sleep(5000);
            System.out.println(name + "으로 주세요");
            System.out.println("네 알겠습니다. 잠시 기다려주세요!");
            Thread.sleep(5000);
            if(!coffeeShop.processingOrder(order)){
                System.out.println("당신의 커피가게는 파산하였습니다.");
                return;
            }
            System.out.println("주문하신 "+ name + " 나왔습니다!");
        }
    }
    public static void main(String[] args) {
        init();
        try {
            playGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
