package streams.practice;

import streams.practice.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMappingExample {
    static void main() {
        //Group and transform values using Collectors.mapping() as a downstream collector.
        Map<Integer, List<String>> deptWiseEmpNames = Employee.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        System.out.println(deptWiseEmpNames);
    }

    public static class SortByMultiFields {
        static void main() {
            List<Employee> sortedEmpList = Employee.employees().stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary)
                            .thenComparingInt(Employee::getDeptId))
                    .toList();

            System.out.println(sortedEmpList);
        }
    }
}
