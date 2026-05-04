package streams.practice;

import streams.practice.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class UpperCaseNameConversion {
    static void main() {
        List<Employee> employees = Employee.employees();

        employees.stream()
                .map(employee -> employee.getName().toUpperCase())
                .forEach(System.out::println);

        List<Double> salaryList = employees.stream().map(Employee::getSalary).toList();
        System.out.println(salaryList);
    }
}
