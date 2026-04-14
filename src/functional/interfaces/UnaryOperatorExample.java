package functional.interfaces;

import functional.model.Order;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    static void main() {
        //--------basic------
        UnaryOperator<Order> applyFestivalDiscount = order -> {
            order.setAmount(order.getAmount()* 0.80);
            return order;
        };

        //update field
        UnaryOperator<Order> confirmOrder = order -> {
            order.setStatus("CONFIRMED");
            return  order;
        };

        //-----composing

        Function<Order, Order> discountAndConfirmOrder = applyFestivalDiscount.andThen(confirmOrder);

        Order.getOrders()
                .stream()
                .map(discountAndConfirmOrder::apply)
                .toList()
                .forEach(System.out::println);
    }
}
