package streams.practice;

import streams.practice.model.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectingAndThenExample {
    static void main() {
        Map<Integer, String> collectingAndThenResult = Employee.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                //Collections::unmodifiableList //OR
                                list -> "total emps in group : " + list.size()
                        )
                ));

        System.out.println(collectingAndThenResult);

        Map<Integer, Optional<Employee>> deptWiseMaxSal = Employee.employees().stream()
                .collect(Collectors.groupingBy(Employee::getDeptId, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        deptWiseMaxSal.entrySet()
                .stream().forEach(System.out::println);
    }
}
