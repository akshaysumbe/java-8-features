package streams.practice;

import java.util.ArrayList;
import java.util.List;

public class GetDistinct {
    static void main() {
        List<String> words = new ArrayList<>();
        words.add("akshay");
        words.add("rohit");
        words.add("akshay");
        words.add("virat");
        words.add("harbhajan");
        words.add("ravi");

        words.stream()
                .distinct().forEach(System.out::println);
    }
}
