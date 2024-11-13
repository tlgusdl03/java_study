package predicated_final_assignment_prefare.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<String> order;
    private int patience;
    private int satisfaction;
    private boolean noMilk;
    private boolean noCaffeine;

    public Customer(String name, int patience, int satisfaction, boolean noCaffeine, boolean noMilk) {
        this.order = new ArrayList<>();
        this.name = name;
        this.patience = patience;
        this.satisfaction = satisfaction;
        this.noMilk = noMilk;
        this.noCaffeine = noCaffeine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public int getPatience() {
        return patience;
    }

    public void setPatience(int patience) {
        this.patience = patience;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public boolean isNoMilk() {
        return noMilk;
    }

    public void setNoMilk(boolean noMilk) {
        this.noMilk = noMilk;
    }

    public boolean isNoCaffeine() {
        return noCaffeine;
    }

    public void setNoCaffeine(boolean noCaffeine) {
        this.noCaffeine = noCaffeine;
    }
}
