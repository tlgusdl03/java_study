package final_assignment_prefare.model;

import java.util.List;
import java.util.Map;

// 플레이어가 제작할 수 있는 메뉴
// 첫날부터 해금할 수 있음
// 예시 : 아메리카노, 100, 20, 0, false, true, {{beans : 30}}, {컵에 얼음을 넣는다, 커피를 추출한다, 추출한 커피를 얼음컵에 붓는다, 물을 붓는다}

public class MenuItem {
    private String name;
    private double unlockPrice;
    private double price;
    private double sugar;
    private boolean containsMilk;
    private boolean containsCaffeine;
    Map<String, Integer> ingredients;
    private List<String> recipe;
    private boolean isUnlock;

    public MenuItem(String name, double unlockPrice,
                    double price, double sugar,
                    boolean containsMilk, boolean containsCaffeine,
                    List<String> recipe)
    {
        this.name = name;
        this.unlockPrice = unlockPrice;
        this.price = price;
        this.sugar = sugar;
        this.containsMilk = containsMilk;
        this.containsCaffeine = containsCaffeine;
        this.recipe = recipe;
        this.isUnlock = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnlockPrice() {
        return unlockPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public boolean isContainsMilk() {
        return containsMilk;
    }


    public boolean isContainsCaffeine() {
        return containsCaffeine;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setUnlock(){
        this.isUnlock = true;
    }

    public boolean isUnlock() {
        return isUnlock;
    }

    @Override
    public String toString() {
        return "Menu{name='" + name + "', price=" + price + ", containsMilk=" + containsMilk +
                ", containsCaffeine=" + containsCaffeine + ", sugar=" + sugar + "}";
    }
}
