package streams.terminal_ops;

import streams.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
    static void main() {
        //toList()
        List<Order> cancelledOrders = Order.orders.stream()
                .filter(order -> order.getStatus().equals("CANCELLED"))
                .collect(Collectors.toList());
        System.out.println(cancelledOrders);

        //to set for de-duplications
        Set<String> restaurantsWithOrders = Order.orders.stream()
                .map(Order::getRestaurantId)
                .collect(Collectors.toSet());

        System.out.println(restaurantsWithOrders);

        // to Map -----------------------------------------------
        //orderId -> Order
        Map<String, Order> orderIdOrderObjMap = Order.orders.stream()
                .collect(Collectors.toMap(
                        Order::getId, //key
                        Function.identity()  //value
                ));

        System.out.println(orderIdOrderObjMap);

        //orderId -> amount
        Map<String, Double> orderIdOrderAmount = Order.orders.stream()
                .collect(Collectors.toMap(
                        Order::getId,
                        Order::getAmount
                ));

        System.out.println(orderIdOrderAmount);

        //groupingBy
        Map<String, List<Order>> byCity = Order.orders.stream()
                .collect(Collectors.groupingBy(Order::getCity));

        System.out.println("byCity : " + byCity);

        Map<String, Long> orderCountByCity = Order.orders.stream()
                .collect(Collectors.groupingBy(Order::getCity, Collectors.counting()));

        System.out.println("orderCountByCity : " + orderCountByCity);


        //groupBy city -> total revenue
        Map<String, Double> cityWiseRevenue = Order.orders.stream()
                .collect(
                        Collectors.groupingBy(Order::getCity,
                                Collectors.summingDouble(Order::getAmount))
                );

        System.out.println("cityWiseRevenue : " + cityWiseRevenue);

        //group by restaurant -> avg delivery time
        Map<String, Double> restaurantAvgDeliveryTime = Order.orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getRestaurantId,
                        Collectors.averagingInt(Order::getDeliveryTimeMinutes)
                ));
        System.out.println("restaurantAvgDeliveryTime : " + restaurantAvgDeliveryTime);

        //partitioningBy - split into true/false
        Map<Boolean, List<Order>> partitioned = Order.orders.stream()
                .collect(Collectors.partitioningBy(
                        order -> order.getDeliveryTimeMinutes() > 45
                ));

        List<Order> slaBreached = partitioned.get(true);
        List<Order> slaCompliant = partitioned.get(false);

        //joining - concatenate strings

        String orderIds = Order.orders.stream()
                .map(Order::getId)
                .collect(Collectors.joining(", "));

        System.out.println(orderIds);

        //formatted string using joining
        String formatted = Order.orders.stream()
                .map(Order::getId)
                .collect(Collectors.joining(
                        ", ", "[", "]"
                ));

        System.out.println(formatted);

    }
}
