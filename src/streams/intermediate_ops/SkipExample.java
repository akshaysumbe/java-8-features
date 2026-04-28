package streams.intermediate_ops;

import streams.model.Order;

import java.util.Comparator;
import java.util.List;

public class SkipExample {
    static void main() {
        //skip - skip first N elements
        List<Order> thirdOrderId = Order.orders.stream()
                .sorted(Comparator.comparing(Order::getId))
                .skip(2)
                .limit(1)
                .toList();

        System.out.println(thirdOrderId.size());
        System.out.println(thirdOrderId);
    }
}
