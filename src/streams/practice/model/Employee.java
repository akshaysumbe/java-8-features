package streams.practice.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int deptId;

    public Employee(int id, String name, double salary, int deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }

    public static List<Employee> employees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Tejas", 2300.00, 101));
        employees.add(new Employee(102, "Raj", 1200.00, 102));
        employees.add(new Employee(102, "Prasmit", 1300.00, 102));
        employees.add(new Employee(103, "Akshay", 2000.00, 101));
        employees.add(new Employee(101, "Mahesh", 2500.00, 103));
        return  employees;
    }
}
