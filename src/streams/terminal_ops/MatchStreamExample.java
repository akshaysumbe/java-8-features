package streams.terminal_ops;

import streams.model.Order;

import java.util.Optional;

public class MatchStreamExample {
    static void main() {
        //first matching element
        Optional<Order> puneOrder = Order.orders.stream()
                .filter(order -> order.getCity().equals("Pune"))
                .findFirst();
        puneOrder.ifPresent(System.out::println);

        //any matching element(faster in parallel streams)
        Optional<Order> anyDeliveredOrder = Order.orders.parallelStream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .findAny();
        anyDeliveredOrder.ifPresent(System.out::println);

        // anyMatch - does any element satisfy a condition?
        boolean anySlaBreached = Order.orders.stream()
                .anyMatch(order -> order.getDeliveryTimeMinutes() > 45);
        System.out.println("anySlaBreached : " + anySlaBreached);

        // allMatch : does all elements satisfy condition?
        boolean allDelivered = Order.orders.stream()
                .allMatch(order -> order.getStatus().equals("DELIVERED"));
        System.out.println("allDelivered : " + allDelivered);

        //noneMatch - does NO element satisfy a condition?
        boolean noCancellation = Order.orders.stream()
                .noneMatch(order -> order.getStatus().equals("CANCELLED"));
        System.out.println("noCancellation : " + noCancellation);

        //count
        long puneOrderCount = Order.orders.stream()
                .filter(order -> order.getCity().equals("Pune"))
                .count();
        System.out.println("puneOrderCount : " + puneOrderCount);
    }
}
