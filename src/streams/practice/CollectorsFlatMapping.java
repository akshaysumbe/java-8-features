package streams.practice;

import streams.practice.model.Employee;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsFlatMapping {
    static void main() {
        Map<Integer, Set<String>> deptWiseSkills = Employee.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        Collectors.flatMapping(
                                employee -> employee.getSkills().stream(),
                                Collectors.toSet()
                        )
                ));

        System.out.println(deptWiseSkills);
    }
}
