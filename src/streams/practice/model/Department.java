package streams.practice.model;

import java.util.List;

public class Department {
    private int id;
    private String name;
    private String location;

    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public static List<Department> all() {
        return List.of(
                new Department(101, "Engineering", "New York"),
                new Department(102, "Human Resources", "London"),
                new Department(103, "Marketing", "New York")
        );
    }
}