package streams.practice;

import streams.practice.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapEntriesToSortedList {
    static void main() {
        //Question: Convert a Map's entries to a sorted list of formatted strings via entrySet().stream()

        Map<Integer, Employee> empIdEmpObjMap = Employee.employees().stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));

        List<String> sortedEmpLabels = empIdEmpObjMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(entry -> entry.getKey() + " : " + entry.getValue().getName())
                .toList();

        System.out.println(sortedEmpLabels);

    }
}
