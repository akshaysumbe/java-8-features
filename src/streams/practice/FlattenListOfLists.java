package streams.practice;

import java.util.Arrays;
import java.util.List;

public class FlattenListOfLists {
    static void main() {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Alpha", "Beta", "Gamma"),      // Page 1
                Arrays.asList("Delta", "Epsilon", "Zeta"),    // Page 2
                Arrays.asList("Eta", "Theta", "Iota"),       // Page 3
                Arrays.asList("Kappa")                        // Page 4 (10th element)
        );

        List<String> flattenedList = nestedList.stream()
                .flatMap(innerList -> innerList.stream())
                .toList();

        System.out.println(flattenedList);

    }
}
