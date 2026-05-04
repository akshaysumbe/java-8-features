package streams.practice;

import streams.practice.model.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighestSalaryEmpPerDept {

    //Find the highest-paid employee per department using groupingBy + maxBy.
    static void main() {
        Map<Integer, Optional<Employee>> topPaidEmp = Employee.employees().stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDeptId,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        )
                );

        topPaidEmp.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " : "+ entry.getValue().get());
                });
    }
}
