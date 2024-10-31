package final_assignment_prefare.service;

import final_assignment_prefare.model.Customer;
import final_assignment_prefare.model.MenuItem;
import final_assignment_prefare.model.Order;

import java.util.List;

public class OrderService {
    public Order createOrder(Customer customer, List<MenuItem> items){
        return new Order(customer, items);
    }

    public void processOrder(Order order) {
        order.setStatus(Order.OrderStatus.IN_PROGRESS);

        completeOrder(order);
    }

    private void completeOrder(Order order) {
        order.setStatus(Order.OrderStatus.COMPLETED);
        System.out.println(order.getCustomer().getName() + "님의 주문이 완료되었습니다.");
    }
}
