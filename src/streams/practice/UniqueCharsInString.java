package streams.practice;

public class UniqueCharsInString {
    static void main() {
        String str = "AAASFNSBB";

        str.chars()
                .mapToObj(c->(char)c)
                .distinct()
                .forEach(System.out::println);
                //.collect(Collectors.toSet()).forEach(System.out::println);
    }
}
