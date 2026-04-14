package functional.interfaces;

import functional.model.Order;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    static void main() {
        List<Order> orders = Order.getOrders();

        //-----------basic predicates-----------

        Predicate<Order> isHighValue = order -> order.getAmount() > 103;
        Predicate<Order> isPending = order -> order.getStatus().equals("PENDING");
        Predicate<Order> hasCouponCode = order -> order.getCouponCode() != null;

        Predicate<String> isDelivered = Predicate.isEqual("DELIVERED");

        //-----------composing predicates-----------

        //AND : high value and pending
        Predicate<Order> needsUrgentAttention = isHighValue.and(isPending);

        Predicate<Order> isSpecialOrder = isHighValue.or(hasCouponCode);

        Predicate<Order> isLowValue = isHighValue.negate();

        //-----------usage-----------

        orders.stream()
                .filter(needsUrgentAttention)
                .forEach(order -> System.out.println("Urgent orders: " + order.getId()));

        orders.stream()
                .filter(isSpecialOrder)
                .forEach(order -> System.out.println("Special orders: " + order.getId()));

        orders.stream()
                .filter(order -> isDelivered.test(order.getStatus()))
                .forEach(order -> System.out.println("Delivered orders: " + order.getId()));


        //-----------real world usage-----------
        //reusable validation rules

        List<Predicate<Order>> validationRules = List.of(
                order -> order.getAmount() > 0,
                order -> order.getCustomerId() != null,
                order -> order.getCreatedAt() != null
        );

        List<Order> validOrders = orders.stream()
                .filter(order -> validationRules.stream()
                        .allMatch(rule -> rule.test(order)))
                .toList();

        System.out.println("valid orders: " + validOrders);

        System.out.println("Low value valid orders: " + validOrders.stream().filter(isLowValue).toList());


    }

}
