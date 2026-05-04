package streams.parallel;

import streams.model.Order;

import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamsExample {
    static void main() {
        //sequential- one thread

        long count = Order.orders.stream()
                .filter(order -> order.getStatus().equals("PENDING"))
                .count();

        //parallel- ForkJoinPool, multiple threads, one word change
        long parallelCount = Order.orders.parallelStream()
                .filter(order -> order.getStatus().equals("CANCELLED"))
                .count();

        //generate city-wise revenue report for delivered orders with SLA flag
        Map<String, DoubleSummaryStatistics> cityRevenueReport = Order.orders.parallelStream()
                .filter(order -> order.getStatus().equals("DELIVERED"))
                .collect(Collectors.groupingBy(
                        Order::getCity,
                        Collectors.summarizingDouble(Order::getAmount)
                ));

        cityRevenueReport.forEach(
                (city, stats)->{
                    System.out.printf("%s | Orders : %d | Revenue : $%.2f | Avg : $%.2f%n",
                            city, stats.getCount(), stats.getSum(), stats.getAverage());
                }
        );
    }
}
