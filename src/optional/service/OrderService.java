package optional.service;

import optional.model.Order;
import optional.repository.OrderRepositoy;

import java.util.Optional;

public class OrderService {
    private final OrderRepositoy orderRepositoy = new OrderRepositoy();

    public Optional<Order> findLastOrder(String customerId) {
        //Explicitly return absence
        Order order = orderRepositoy.findLastByCustomerId(customerId);
        if (order == null) return Optional.empty();
        return Optional.of(order);
    }

    //cleaner way
    public Optional<Order> findLastOrder2(String customerId) {
        return Optional.ofNullable(orderRepositoy.findLastByCustomerId(customerId));
    }

    public Order getDefaultOrder(String number) {
        return null;
    }
}
