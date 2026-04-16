package streams.practice.terminal_ops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByFirstLetter {
    static void main() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
        Map<Character, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println(groupedWords);
    }
}
