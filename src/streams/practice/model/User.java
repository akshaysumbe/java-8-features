package streams.practice.model;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String role;
    private double salary;

    public User(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static List<User> users() {
        return List.of(
                new User(1, "Alice", "Admin", 90000),
                new User(1, "Alice", "Admin", 40000),
                new User(2, "Bob", "Dev", 80000),
                new User(3, "Charlie", "Dev", 85000),
                new User(4, "David", "Tester", 60000),
                new User(5, "Eve", "Admin", 95000)
        );
    }
}
