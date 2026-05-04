package streams.practice;

import streams.practice.model.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultiLevelGroupingExample {
    static void main() {
        Map<Integer, Map<String, List<Employee>>> multiLevelEmpGroup = Employee.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.groupingBy(Employee::getSeniority)
                ));

        System.out.println(multiLevelEmpGroup);

        //Compute summary statistics per group using Collectors.summarizingInt()
        Map<Integer, DoubleSummaryStatistics> empSalaryGrpStatistics = Employee.employees()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDeptId,
                                Collectors.summarizingDouble(Employee::getSalary))
                );

        empSalaryGrpStatistics.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("dept : " + entry.getKey() + " max salary : " + entry.getValue().getMax());
                    System.out.println("dept : " + entry.getKey() + " min salary: " + entry.getValue().getMin());
                    System.out.println("dept : " + entry.getKey() + " total salary: " + entry.getValue().getSum());
                    System.out.println("dept : " + entry.getKey() + " average salary: " + entry.getValue().getAverage());
                    System.out.println("dept : " + entry.getKey() + " total number of salaries: " + entry.getValue().getCount());
                });

    }
}
