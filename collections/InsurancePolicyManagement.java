import java.time.LocalDate;
import java.util.*;

// Policy class to represent individual insurance policy
class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode(); // Ensure uniqueness based on policy number
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber); // Check equality based on policy number
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

// Insurance Policy Management System class
public class InsurancePolicyManagement {

    // Stores the policies using different Sets
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    // Method to add a policy to each Set
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Method to get all unique policies
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (Policy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    // Method to retrieve policies expiring within the next 30 days
    public void displayExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().isBefore(today.plusDays(30))) {
                System.out.println(policy);
            }
        }
    }

    // Method to retrieve policies based on coverage type
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Method to find duplicate policies based on policy numbers (only HashSet and LinkedHashSet can detect duplicates)
    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policies based on Policy Number:");
        Set<String> seenPolicyNumbers = new HashSet<>();
        for (Policy policy : linkedHashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Method to compare performance of HashSet, LinkedHashSet, and TreeSet
    public void comparePerformance() {
        long startTime = System.nanoTime();
        hashSetPolicies.add(new Policy("1", "John Doe", LocalDate.now().plusYears(1), "Health", 500.00));
        long endTime = System.nanoTime();
        System.out.println("Time taken to add policy in HashSet: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.add(new Policy("2", "Jane Doe", LocalDate.now().plusYears(1), "Auto", 400.00));
        endTime = System.nanoTime();
        System.out.println("Time taken to add policy in LinkedHashSet: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        treeSetPolicies.add(new Policy("3", "Alice Smith", LocalDate.now().plusYears(1), "Home", 600.00));
        endTime = System.nanoTime();
        System.out.println("Time taken to add policy in TreeSet: " + (endTime - startTime) + "ns");

        // Additional operations (remove and search) can be added here to compare remove/search performance
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Adding policies
        system.addPolicy(new Policy("1", "John Doe", LocalDate.now().plusYears(1), "Health", 500.00));
        system.addPolicy(new Policy("2", "Jane Doe", LocalDate.now().plusYears(1), "Auto", 400.00));
        system.addPolicy(new Policy("3", "Alice Smith", LocalDate.now().plusMonths(3), "Home", 600.00));
        system.addPolicy(new Policy("4", "Bob Johnson", LocalDate.now().plusDays(20), "Health", 700.00));
        system.addPolicy(new Policy("5", "Charlie Brown", LocalDate.now().plusDays(40), "Auto", 300.00));

        // Display all policies
        system.displayAllPolicies();

        // Display policies expiring soon
        system.displayExpiringSoonPolicies();

        // Display policies by coverage type
        system.displayPoliciesByCoverageType("Health");

        // Display duplicate policies
        system.displayDuplicatePolicies();

        // Performance comparison
        system.comparePerformance();
    }
}
