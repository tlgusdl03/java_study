package final_assignment_prefare.service;


import final_assignment_prefare.manager.InventoryManager;
import final_assignment_prefare.manager.MenuManager;
import final_assignment_prefare.model.MenuItem;

import java.util.List;

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

    public void buyNewMenu(MenuItem selectedMenu){
        if(this.budget > menuManager.unlockNewMenu(selectedMenu)){

        };
    }
}
