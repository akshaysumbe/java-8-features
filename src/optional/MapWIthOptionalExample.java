package optional;

import optional.model.Order;
import optional.service.OrderService;

import java.util.Optional;

public class MapWIthOptionalExample {

    private final static OrderService service = new OrderService();
    static void main() {
        Optional<Order> optOrder = service.findLastOrder("01");

        Optional<String> orderCity = optOrder.map(Order::getCity);

        //chaining of maps
        optOrder.map(Order::getCity)
                .map(String::toUpperCase)
                .ifPresent(System.out::println);

        //real world : extract nested value safely
        Optional<Double> orderAmount = optOrder.map(Order::getAmount);
        orderAmount.ifPresent(amount-> System.out.println("Order amount : " + amount));
    }
}
