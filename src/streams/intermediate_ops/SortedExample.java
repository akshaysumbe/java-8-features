package streams.intermediate_ops;

import streams.model.Order;

import java.util.Comparator;

public class SortedExample {
    static void main() {
        //natural order
        Order.orders.stream()
                .map(Order::getCity)
                        .sorted()
                                .forEach(System.out::println);


        //reversed sort
        Order.orders.stream()
                .sorted(Comparator.comparing(Order::getAmount).reversed())
                .forEach(System.out::println);

        //multi-level sort
        System.out.println("Multi-level sort");
        Order.orders.stream()
                .sorted(Comparator.comparing(Order::getCity)
                                .thenComparingDouble(Order::getAmount)
                                .reversed())
                .forEach(System.out::println);
    }
}
