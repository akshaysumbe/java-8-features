package streams.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilterOptionals {

    //question: Filter a list of Optionals and unwrap only the present values using flatMap().

    static void main() {
        List<Optional<String>> optionalsList = Arrays.asList(
                Optional.of("Alpha"),
                Optional.empty(),
                Optional.of("Beta"),
                Optional.of("Gamma"),
                Optional.empty(),
                Optional.of("Delta"),
                Optional.empty(),
                Optional.empty(),
                Optional.of("Epsilon"),
                Optional.of("Zeta")
        );

        List<String> strings = optionalsList.stream()
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .toList();

        System.out.println(strings);
    }
}
