package streams.practice;

import streams.practice.model.User;

import java.util.List;
import java.util.stream.Stream;

public class GenerateInfiniteStream {
    static void main() {
        //infinite Stream
        //Stream.iterate(1, i -> i + 1).forEach(System.out::println);
        List<User> userList = Stream.generate(() -> new User(999, "test", "tester", 9999.00)).limit(5).toList();
        System.out.println(userList);
    }
}
