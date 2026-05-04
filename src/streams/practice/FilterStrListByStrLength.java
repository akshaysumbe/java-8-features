package streams.practice;

import java.util.ArrayList;
import java.util.List;

public class FilterStrListByStrLength {
    static void main() {
        List<String> words = new ArrayList<>();
        words.add("akshay");
        words.add("rohit");
        words.add("virat");
        words.add("harbhajan");
        words.add("ravi");

        words.stream()
                .filter(w-> w.length() > 5)
                .forEach(System.out::println);
    }
}
