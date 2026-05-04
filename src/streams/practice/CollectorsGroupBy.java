package streams.practice;

import streams.practice.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupBy {
    static void main() {
        //Group a list of employees by department using Collectors.groupingBy().
        List<Employee> employees = Employee.employees();
        Map<Integer, List<Employee>> deptWiseEmps = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId
                ));
        System.out.println(deptWiseEmps);

        Map<Integer, Long> deptWiseEmpCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.counting())
                );
        System.out.println(deptWiseEmpCount);

        //Group by dept and get names only
        Map<Integer, List<String>> namesByDept = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDeptId,
                                Collectors.mapping(Employee::getName, Collectors.toList())
                        )
                );
        System.out.println(namesByDept);
    }
}
