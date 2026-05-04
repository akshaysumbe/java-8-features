package streams.practice;

import java.util.Arrays;
import java.util.List;

public class PaginationUsingSkipLimit {
    static void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        int pageSize = 5, pageNumber = 2;

        List<Integer> page = numbers.stream()
                .skip((pageNumber - 1) * pageSize) //skip a number of pages * number of elements on one page
                .limit(pageSize) //limit to number of elements on one page
                .toList();

        System.out.println(page);
    }
}
