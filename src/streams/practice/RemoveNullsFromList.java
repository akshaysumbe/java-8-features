package streams.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveNullsFromList {
    static void main() {
        List<String> words = new ArrayList<>();
        words.add(null);
        words.add("rohit");
        words.add("virat");
        words.add("harbhajan");
        words.add(null);

        words.stream()
                .filter(w->w!=null)
                .forEach(System.out::println);
    }
}
