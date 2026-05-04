package optional;

import optional.model.Order;
import optional.repository.OrderRepositoy;

import java.time.LocalDateTime;
import java.util.Optional;

public class CreatingOptional {

    private final static OrderRepositoy orderRepositoy = new OrderRepositoy();

    static void main() {
        //Optional.of()

        Optional<Order> order = Optional.of(
                new Order("1", "1", 100,
                        "Delhi", "DELIVERED", "10_OFF",
                        LocalDateTime.now()));
        //Optional<Object> boom = Optional.of(null);//throws NPE

        //Optional.ofNullable()
        Optional<Object> empty = Optional.ofNullable(null);
        Optional<Optional<Order>> order2 = Optional.ofNullable(orderRepositoy.findById("01"));

    }
}
