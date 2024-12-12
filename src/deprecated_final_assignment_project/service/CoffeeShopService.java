package deprecated_final_assignment_project.service;


import deprecated_final_assignment_project.manager.InventoryManager;
import deprecated_final_assignment_project.manager.MenuManager;
import deprecated_final_assignment_project.model.MenuItem;
import deprecated_final_assignment_project.model.Order;

import java.util.*;


public class CoffeeShopService {
    private MenuManager menuManager;
    private InventoryManager inventoryManager;
    private OrderService orderService;
    private int budget;

    public CoffeeShopService() {
        this.menuManager = new MenuManager();
        this.inventoryManager = new InventoryManager();
        this.orderService = new OrderService();
        this.budget=500;
    }

    public Map<MenuItem, List<String>> makingCoffee (Order order){
        List<MenuItem> menuItemList = order.getOrderedItems();

        Scanner scanner = new Scanner(System.in);

        Map<MenuItem, List<String>> result = new HashMap<>();

        for(MenuItem menuItem : menuItemList){

            Map<String, Integer> ingredients =  menuItem.getIngredients();
            List<String> recipe = new ArrayList<>();
            while(scanner.hasNextLine()){
                recipe.add(scanner.nextLine());
            }
            result.put(menuItem, recipe);
        }

        return result;
    }


    public boolean buyNewMenu(MenuItem selectedMenu){
        double result = menuManager.unlockNewMenu(selectedMenu, budget);

        if(result != budget){
            return true;
        }else{
            return false;
        }
    }
}
