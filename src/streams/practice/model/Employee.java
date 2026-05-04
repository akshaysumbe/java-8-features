package streams.practice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int deptId;
    private String seniority;
    private List<String> skills;

    public Employee(int id, String name, double salary, int deptId, String seniority, List<String> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
        this.seniority = seniority;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                ", seniority='" + seniority + '\'' +
                ", skills=" + skills +
                '}';
    }

    public static List<Employee> employees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Tejas", 2300.00, 101, "Semi Senior", List.of("Java", "Python")));
        employees.add(new Employee(102, "Raj", 1200.00, 102, "Junior", List.of("C", "C++")));
        employees.add(new Employee(103, "Prasmit", 1300.00, 102, "Semi Senior", List.of("Java", "React")));
        employees.add(new Employee(104, "Akshay", 2000.00, 101, "Senior", List.of("React", "Mongo DB")));
        employees.add(new Employee(105, "Mahesh", 2500.00, 103, "Senior", List.of(".NET", "SQL")));
        employees.add(new Employee(105, "Suraj", 2600.00, 103, "Lead", List.of("Agile", "Leadership")));
        employees.add(new Employee(106, "Akshay", 1600.00, 102, "Tester", List.of("Mockito", "Selenium")));
        return  employees;
    }
}
