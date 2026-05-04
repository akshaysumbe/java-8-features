package streams.practice;

import java.util.Arrays;
import java.util.List;

public class StringsToLengths {
    static void main() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println(lengths);
    }
}
