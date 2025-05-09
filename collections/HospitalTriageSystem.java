import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Override the compareTo method to prioritize higher severity patients
    @Override
    public int compareTo(Patient other) {
        // Higher severity should come first, so we reverse the comparison
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a priority queue to simulate the triage system
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        // Add patients to the queue with their severity levels
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Process and treat patients based on priority
        System.out.println("Order of treatment (highest severity first):");
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.poll();  // Retrieve and remove the highest priority patient
            System.out.println(patient);
        }
    }
}
