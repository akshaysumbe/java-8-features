package streams.practice;

import streams.practice.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterEmpBySalary {
    static void main() {
        List<Employee> employees = Employee.employees();

        Predicate<Employee> salaryCondition = employee -> employee.getSalary() > 2000;
        Predicate<Employee> nameCondition = employee -> employee.getName().startsWith("T");
        employees.stream()
                .filter(salaryCondition.and(nameCondition))
                .toList()
                .forEach(System.out::println);

    }
}
