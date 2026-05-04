package optional.repository;

import optional.model.Order;

import java.util.Optional;

public class OrderRepositoy {
    public Optional<Order> findById(String number) {
        return Optional.empty();
    }

    public Order findLastByCustomerId(String customerId) {
        return null;
    }
}
