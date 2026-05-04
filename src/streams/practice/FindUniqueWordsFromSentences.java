package streams.practice;

import java.util.Arrays;
import java.util.List;

public class FindUniqueWordsFromSentences {
    static void main() {
        List<String> sentences = List.of(
                "Java streams are powerful",
                "streams make code cleaner",
                "powerful and clean Java code"
        );

        sentences.stream()
                .flatMap(sentence-> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
