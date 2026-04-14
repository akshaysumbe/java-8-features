package functional.repository;

import functional.model.Order;

import java.util.List;
import java.util.function.Function;

public class OrderRepository {
    public void saveOrder(Order order) {
        System.out.println("Order saved");
    }

    public List<Order> findByStatus(String status) {
        return Order.getOrders()
                .stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .toList();
    }

    public Object findById(String id) {
        return Order.getOrders().stream().findFirst().orElse(null);
    }
}
