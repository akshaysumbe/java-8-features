package streams.practice;

import streams.practice.model.User;

public class ThreeArgReduceInParallelStreams {
    static void main() {
        Double reducedSalaryTotal = User.users().stream()
                .reduce(
                        0.0,
                        (totalSum, user) -> totalSum = totalSum + user.getSalary(),
                        (thread1Sum, thread2Sum) -> thread1Sum + thread2Sum
                );

        System.out.println(reducedSalaryTotal);
    }
}
