package streams.intermediate_ops;

import streams.model.Order;

import java.util.Comparator;
import java.util.List;

public class LimitExample {
    static void main() {
        //limit - take first N elements
        List<Order> topTwoAmountOrders = Order.orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .limit(2)
                .toList();
        System.out.println(topTwoAmountOrders);
    }
}
