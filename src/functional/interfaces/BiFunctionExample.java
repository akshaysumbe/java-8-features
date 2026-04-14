package functional.interfaces;

import functional.model.Order;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {
    static void main() {
        //--------basic------------
        //apply discount : (Order, discountPercent) -> discountedOffer

        BiFunction<Order, Double, Order> applyDiscount = (order, discount) -> {
            double discounted = order.getAmount() * (1 - discount / 100);
            order.setAmount(discounted);
            return order;
        };

        //Merge Two Fields: (customerId, orderId) and create tracking reference
        BiFunction<String, String, String> toTrackingRef = (customerId, orderId) ->{
            return customerId + "-" + orderId + "-" + System.currentTimeMillis();
        };

        //Calculate shipping charges
        BiFunction<Order, String, Double> shippingCharges = (order, pincode)->{
            if (pincode.startsWith("41"))
                return 0.0;
            if (order.getAmount() > 2000)
                return  0.0;
            else return 70.99;
        };


        //------andThen-------
        Function<Order, String> toSummary = (order) -> "Order " + order.getId() + " with discounted price: " + order.getAmount() + " is successful";
        BiFunction<Order, Double, String> applyDiscountAndSummarize = applyDiscount.andThen(toSummary);

        Order.getOrders().stream()
                .map(order -> applyDiscountAndSummarize.apply(order, order.getAmount()))
                .toList().forEach(System.out::println);


    }
}
