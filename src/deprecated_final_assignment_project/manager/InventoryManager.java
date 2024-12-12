package deprecated_final_assignment_project.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private Map<String, Integer> ingredients;

    public InventoryManager(){
        ingredients = new HashMap<>();
    }

    public void addIngredient(String ingredient, int amount){
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + amount);
    }

    public boolean useIngredients(List<String> requiredIngredients){
        for(String ingredient : requiredIngredients){
            if (ingredients.getOrDefault(ingredient, 0) < 1) {
                return false;
            }
        }

        for(String ingredient : requiredIngredients){
            ingredients.put(ingredient, ingredients.get(ingredient) - 1);
        }
        return true;
    }

    public int getIngredientCount(String ingredient){
        return ingredients.getOrDefault(ingredient, 0);
    }
}
