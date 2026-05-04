package streams.practice;

import streams.practice.model.User;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HandleDuplicateKeyConflicts {
    static void main() {
        //Handle duplicate key conflicts in Collectors.toMap() with a merge function.
        //keep first value
        Map<String, User> userMap = User.users().stream()
                .collect(Collectors.toMap(User::getRole,
                        Function.identity(),
                        (existing, replacement) -> existing
                ));

        //keep last value
        userMap = User.users().stream()
                        .collect(
                                Collectors.toMap(
                                        User::getRole,
                                        Function.identity(),
                                        (existing, replacement)-> replacement
                                )
                        );

        //combine/aggregate values
        userMap = User.users().stream()
                        .collect(
                                Collectors.toMap(
                                        User::getRole,
                                        Function.identity(),
                                        (user1, user2)-> user1.getSalary()>user2.getSalary()?user1:user2
                                )
                        );

        System.out.println(userMap);
    }
}
