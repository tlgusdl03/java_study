package deprecated_final_assignment_project.manager;

import deprecated_final_assignment_project.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItemList;

    public MenuManager() {
        this.menuItemList = new ArrayList<>();
    }

    public void addMenu(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public void remove(String name){
        menuItemList.removeIf(menuItem -> menuItem.getName().equals(name));
    }

    public void updateMenu(String name, double price){
        for(MenuItem menuItem : menuItemList){
            if(menuItem.getName().equals(name)){
                menuItem.setPrice(price);
            }
        }
    }

    public List<MenuItem>getMenuList(){
        return menuItemList;
    }

    public List<MenuItem> findMenusByCondition(boolean containsMilk, boolean containsCaffeine, double sugar) {
        List<MenuItem> filteredMenuItems = new ArrayList<>();
        for (MenuItem menuItem : menuItemList) {
            if (menuItem.isContainsMilk() == containsMilk &&
                    menuItem.isContainsCaffeine() == containsCaffeine &&
                    sugar <= menuItem.getSugar()) {
                filteredMenuItems.add(menuItem);
            }
        }
        return filteredMenuItems;
    }

    public double unlockNewMenu(MenuItem selectedMenu, double budget){
        for(MenuItem menuItem : menuItemList){
            if(menuItem.equals(selectedMenu)){
                if(menuItem.isUnlock()){
                    return budget;
                }
                if(menuItem.getUnlockPrice() > budget){
                    return budget;
                }

                menuItem.setUnlock();
                return budget-menuItem.getUnlockPrice();
            }
        }
        return budget;
    }
}
