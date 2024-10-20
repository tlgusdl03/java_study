package midterm_practice.package_practice;

import java.util.Scanner;

interface defaultAction{
    boolean calculate(int menu);
    boolean consumeBean(int menu);

    boolean entireProcess(int menu);
}
class CoffeeShop implements defaultAction{

    Scanner scanner = new Scanner(System.in);
    // 카페 메뉴들
    private String[] menus;

    private int[] prices;

    private int[] costs;

    private int[] beanUses;

    // 초기 자금 0이되면 파산
    private int funds;

    // 커피콩의 양
    private int beans;

    CoffeeShop(String[] menus, int[] prices, int[] costs, int[] beanUses){
        this.menus = menus;
        this.prices = prices;
        this.costs = costs;
        this.beanUses = beanUses;

        this.funds = 1000000;
        this.beans = 1000;

    }
    @Override
    public boolean calculate(int menu) {
        this.funds -= costs[menu];
        if (this.funds >= 0) {
            this.funds += prices[menu];
            return true;
        } else {
            this.funds += costs[menu];
            return false;
        }
    }

    @Override
    public boolean consumeBean(int menu) {
        if (this.beans - this.beanUses[menu] >= 0) {
            this.beans -= this.beanUses[menu];
            return true;
        }
        else return false;
    }

    @Override
    public boolean entireProcess(int menu) {
        return this.calculate(menu) && this.consumeBean(menu);
    }

    public void printMenu(){
        System.out.println("저희 매장에 어서오세요 다음은 메뉴입니다 : ");
        for (String s : this.menus) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public void printFunds(){

    }
}
public class Main {
    String[] menus = {"아메리카노" , "에스프레소", "카페라떼", "카페모카", "캬라멜마끼아또"};
    int[] prices = {1500, 1500, 4000, 4000, 5000};
    int[] costs = {500, 500, 1500, 1500, 2000};

    int[] beanUses = {30, 30, 30, 40, 50};
    CoffeeShop myCoffeeShop = new CoffeeShop(menus, prices, costs, beanUses);

//    public static void
    public static void main(String[] args) {

    }
}
