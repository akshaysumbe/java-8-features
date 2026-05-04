package streams.practice;

import streams.practice.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {
    static void main() {
        Map<Boolean, List<Employee>> groupedLists = Employee.employees().stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 2000));

        System.out.println(groupedLists);
    }
}
