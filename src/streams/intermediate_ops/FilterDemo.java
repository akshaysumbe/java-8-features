package streams.intermediate_ops;

import streams.model.Order;

import java.util.List;
import java.util.function.Predicate;

public class FilterDemo {
    static void main() {
        List<Order> deliveredOrders = Order.orders.stream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .toList();

        System.out.println(deliveredOrders);

        System.out.println();

        //chained filters
        Order.orders.stream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .filter(order -> order.getCity().equals("Mumbai"))
                .filter(order -> order.getDeliveryTimeMinutes()>=45)
                .toList().forEach(System.out::println);

        System.out.println();

        //using predicate composition
        Predicate<Order> isDelivered = order -> order.getStatus().equals("DELIVERED");
        Predicate<Order> isFromPune = order -> order.getCity().equals("Pune");
        Predicate<Order> isSLABreached = order -> order.getDeliveryTimeMinutes()>45;

        List<Order> breachedPuneOrders = Order.orders.stream()
                .filter(isDelivered)
                .filter(isFromPune)
                .filter(isSLABreached)
                .toList();

        System.out.println("Breached: " + breachedPuneOrders);
    }
}
