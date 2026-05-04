package streams.practice;

import java.util.List;
import java.util.stream.IntStream;

public class EvenNumberFilter {
    static void main() {
        List<Integer> evenNumbers = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        System.out.println(evenNumbers);
    }
}
