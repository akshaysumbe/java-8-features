package streams.practice;

import java.util.IntSummaryStatistics;
import java.util.List;

public class MapToNumeric {
    static void main() {
        List<String> numbers = List.of("10", "20", "30");

        IntSummaryStatistics intSummaryStatistics = numbers.stream()
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());


        int result = numbers.stream()
                .mapToInt(Integer::parseInt)
                .reduce(1, (product, element) -> product * element);

        System.out.println("result : " + result);
    }
}
