package optional;

import optional.model.Order;
import optional.service.OrderService;

import java.util.Optional;

public class FilterWithOptional {
    private static OrderService orderService = new OrderService();

    static void main() {
        Optional<Order> optOrder = orderService.findLastOrder("01");

        Optional<Order> highValueOrder = optOrder.filter(order -> order.getAmount() > 600);

        //real world : validate before processing
        Optional<Order> eligibleForDiscount = optOrder
                .filter(o -> o.getAmount() > 500)
                .filter(o -> o.getStatus().equals("PENDING"))
                .filter(o -> o.getCouponCode() != null);

        eligibleForDiscount.ifPresent(o-> applyDiscount(o, 10.00));
    }

    private static void applyDiscount(Order o, double discount) {
        o.setAmount(o.getAmount()-discount);
    }
}
