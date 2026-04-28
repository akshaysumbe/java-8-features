package streams.intermediate_ops;

import streams.model.Order;

import java.util.Comparator;
import java.util.List;

public class PeekExample {
    static void main() {
        // peek() lets you inspect element mid-pipeline without consuming the stream
        List<Order> pendingOrdersByHightoLowAmount = Order.orders.stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .peek(order -> System.out.println("After filter: " + order.getId()))
                .map(order -> {
                    order.setAmount(order.getAmount() * 1.18);
                    return order;
                })
                .peek(order -> System.out.println(order.getAmount()))
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .toList();

        System.out.println(pendingOrdersByHightoLowAmount);
    }
}
