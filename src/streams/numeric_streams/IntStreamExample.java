package streams.numeric_streams;

import streams.model.Order;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamExample {
    static void main() {
        // for this example, using repeated calls to getIntStream()
        // as stream once consumed by terminal operations,
        // we will not be able to use it anymore

        int totalTime = getIntStream().sum();
        System.out.println(totalTime);
        double avgDeliveryTime = getIntStream().average().getAsDouble();
        System.out.println(avgDeliveryTime);
        int max = getIntStream().max().getAsInt();
        System.out.println(max);
        int min = getIntStream().min().getAsInt();
        System.out.println(min);
        long count = getIntStream().count();
        System.out.println(count);


        IntSummaryStatistics deliveryStats = Order.orders.stream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .mapToInt(Order::getDeliveryTimeMinutes)
                .summaryStatistics();

        System.out.println("------------------stats--------------");
        System.out.println("min : " + deliveryStats.getMin());
        System.out.println("max : " + deliveryStats.getMax());
        System.out.println("avg : " + deliveryStats.getAverage());
        System.out.println("sum : " + deliveryStats.getSum());
        System.out.println("count : " + deliveryStats.getCount());

        //filter / map will still work on numeric streams

        int totalBreachedTime = getIntStream().filter(time -> time > 45)
                .map(time -> time - 45)//how much SLA breached
                .sum();

        // sorted, distinct, limit, skip will work same
        int[] topThreeDeliveries = getIntStream().sorted().limit(3).toArray();
        System.out.println(Arrays.toString(topThreeDeliveries));
        System.out.println(totalBreachedTime);
    }

    private static IntStream getIntStream() {
        IntStream orderIntStream = Order.orders.stream()
                .mapToInt(Order::getDeliveryTimeMinutes);
        return orderIntStream;
    }
}
