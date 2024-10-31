package final_assignment_prefare.model;

import java.util.List;

public class Order {
    private Customer customer;
    private List<MenuItem> orderedItems;
    private OrderStatus status;

    public enum OrderStatus{
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    public Order(Customer customer, List<MenuItem> orderedItems) {
        this.customer = customer;
        this.orderedItems = orderedItems;
        this.status = OrderStatus.PENDING;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public double calculateTotal() {
        return orderedItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer.getName() +
                ", orderedItems=" + orderedItems +
                ", status=" + status +
                ", total=" + calculateTotal() +
                '}';
    }
}
