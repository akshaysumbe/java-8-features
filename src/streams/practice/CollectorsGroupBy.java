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

    public static class MatchingPredicates {
        static void main() {
            //anyMatch
            boolean haveJavaEnabledEmployees = Employee.employees().stream()
                    .anyMatch(employee -> employee.getSkills().contains("Java"));

            System.out.println(haveJavaEnabledEmployees);

            //allMatch
            boolean haveCCPPskills = Employee.employees().stream()
                    .allMatch(employee -> employee.getSkills().containsAll(List.of("C", "C++")));

            System.out.println(haveCCPPskills);// false as not all employees skilled in C & C++

            //noneMatch
            boolean chemistryEnabled = Employee.employees().stream()
                    .noneMatch(employee -> employee.getSkills().contains("Chemistry"));

            System.out.println(chemistryEnabled);
        }
    }
}
