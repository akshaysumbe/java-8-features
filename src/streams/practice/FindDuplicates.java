package streams.practice;

import streams.practice.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicates {
    static void main() {

        List<String> duplicateNames = Employee.employees().stream()
                .map(Employee::getName)
                .collect(Collectors.groupingBy(
                        name -> name,
                        Collectors.counting()
                )).entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicateNames);
    }
}
