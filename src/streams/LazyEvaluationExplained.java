package streams;

import streams.model.Order;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationExplained {
    static void main() {
        System.out.println("Now executing the intermediate operations");
        Stream<Order> pipeline = Order.orders.stream()
                .filter(order -> {
                    System.out.println("filtering : " + order.getId());
                    return order.getStatus().equals("DELIVERED");
                })
                .map(order -> {
                    System.out.println("mapping : " + order.getId());
                    return order;
                });
        System.out.println("Now executing the terminal operation");
        List<Order> result = pipeline.toList();
        System.out.println(result);
    }
}
