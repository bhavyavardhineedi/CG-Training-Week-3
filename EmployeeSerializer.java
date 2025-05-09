import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class (Serializable)
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

// Main class for serialization and deserialization
public class EmployeeSerializer {
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        // Sample employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 60000));
        employees.add(new Employee(102, "Bob", "IT", 75000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        // Serialize the employee list
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> retrievedEmployees = deserializeEmployees();
        if (retrievedEmployees != null) {
            System.out.println("\nRetrieved Employees:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        }
    }

    // Method to serialize list of employees
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to deserialize list of employees
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing employees: " + e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }
}
