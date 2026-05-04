package streams.practice;

import java.util.List;

public class StreamSlicing {
    static void main() {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70);

        numbers.stream()
                .dropWhile(n->n<20)
                .takeWhile(n->n<60)
                .forEach(System.out::println);
    }
}
