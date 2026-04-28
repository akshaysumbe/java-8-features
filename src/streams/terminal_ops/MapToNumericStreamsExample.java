package streams.terminal_ops;

import streams.model.Order;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MapToNumericStreamsExample {
    static void main() {
        //avoid boxing/ unboxing overhead with primitive streams
        IntStream deliveryTimes = Order.orders.stream()
                .mapToInt(Order::getDeliveryTimeMinutes);

        DoubleStream amounts = Order.orders.stream()
                .mapToDouble(Order::getAmount);

        //statistics in one shot
        IntSummaryStatistics deliveryStatistics = Order.orders.stream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .mapToInt(Order::getDeliveryTimeMinutes)
                .summaryStatistics();

        System.out.println("max delivery time: " + deliveryStatistics.getMax());
        System.out.println("min delivery time: " + deliveryStatistics.getMin());
        System.out.println("avg delivery time: " + deliveryStatistics.getAverage());
        System.out.println("total successful deliveries: " + deliveryStatistics.getCount());

        //sum, avg, min, max directly
        OptionalDouble avgOrderAmount = Order.orders.stream()
                .mapToDouble(Order::getAmount)
                .average();

        avgOrderAmount.ifPresent(System.out::println);
    }
}