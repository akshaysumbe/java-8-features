package streams.practice;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatenation {
    static void main() {
        Stream<String> maleFamilyMembers = Stream.of("Akshay", "Sanket", "Sahebrao", "Advik", "Ramdas");
        Stream<String> femaleFamilyMembers = Stream.of("Ashwini", "Pratiksha", "Kamal", "Vrunda", "Shantabai", "Akshay"/*duplicate*/);

        Set<String> uniqueNames = Stream.concat(maleFamilyMembers, femaleFamilyMembers).collect(Collectors.toSet());
        System.out.println(uniqueNames);
    }
}
