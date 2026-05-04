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

        optOrder.ifPresentOrElse(ord->
                        utils.sendEmail("01", "Order is confirmed"),
                        ()-> System.out.println("Order not found"));

        String dummyVal = "s";
        Optional.ofNullable(dummyVal).orElse("ss");

        //Real world
        Optional.ofNullable(System.getenv("DB_URL"))
                .orElse("jdbc:postgresql://localhost:1234/swiggy");

        //orElse() : always gets executed even if optional has value
        Order order2 = optOrder.orElse(service.getDefaultOrder("01"));

        //orElseGet() ; only executes if the order is empty
        Order order3 = optOrder.orElseGet(() -> service.getDefaultOrder("01"));

        //throws NoSuchElementException
        Order order4 = optOrder.orElseThrow();

        //custom exception - common in service layers
        optOrder.orElseThrow(()->new RuntimeException("Order Not Found"));
    }

    //real world
    public Order getOrderById(String id) {
        return service.findLastOrder(id)
                .orElseThrow(()-> new RuntimeException("asdfasga"));
    }
}
