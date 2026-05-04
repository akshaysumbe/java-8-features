package optional;

import functional.service.UtilityService;
import optional.model.Order;
import optional.service.OrderService;

import java.util.Optional;

public class CheckAndExtractValues {
    private final static OrderService service = new OrderService();
    private final static UtilityService utils = new UtilityService();
    static void main() {
        Optional<Order> optOrder = service.findLastOrder("01");

        //isPresent()/ isEmpty()
        optOrder.ifPresent(System.out::println);

        if (optOrder.isEmpty())
            System.out.println("No Order Found");
        //get()
        Order order = optOrder.get();
        //NoSuchElementException if empty

        //real world use-
        optOrder.ifPresent(o-> utils.sendEmail("01", "order " +o.getId()+" is confirmed"));

    }
}
