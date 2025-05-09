import java.util.*;

class Employee {
    String name;
    Department department;

    // Constructor
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES, MARKETING;
}

public class GroupByDepartment {

    public static void main(String[] args) {
        // List of Employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));
        employees.add(new Employee("Dave", Department.IT));

        // Grouping employees by department
        Map<Department, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        // Output the grouped employees
        for (Map.Entry<Department, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to group employees by department
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> groupedByDepartment = new HashMap<>();

        for (Employee employee : employees) {
            groupedByDepartment
                .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                .add(employee);
        }

        return groupedByDepartment;
    }
}
