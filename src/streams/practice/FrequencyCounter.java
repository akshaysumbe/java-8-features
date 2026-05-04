package streams.practice;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyCounter {
    static void main() {
        Map<String, Long> collect = Stream.of("apple", "banana", "cherry", "apple")
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                Collectors.counting())
                );

        System.out.println(collect);
    }
}
