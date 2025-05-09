import java.util.*;
import java.text.*;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

class PolicyManager {
    private Map<String, Policy> policiesByNumber = new HashMap<>();
    private Map<String, Policy> policiesByInsertionOrder = new LinkedHashMap<>();
    private Map<Date, Policy> policiesByExpiryDate = new TreeMap<>();

    // Add a new policy
    public void addPolicy(Policy policy) {
        policiesByNumber.put(policy.getPolicyNumber(), policy);
        policiesByInsertionOrder.put(policy.getPolicyNumber(), policy);
        policiesByExpiryDate.put(policy.getExpiryDate(), policy);
    }

    // Retrieve a policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policiesByNumber.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_YEAR, 30); // 30 days from today
        Date thirtyDaysLater = cal.getTime();

        for (Policy policy : policiesByExpiryDate.values()) {
            if (policy.getExpiryDate().before(thirtyDaysLater)) {
                expiringPolicies.add(policy);
            }
        }

        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policiesByNumber.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        List<String> expiredPolicyNumbers = new ArrayList<>();

        // Check expired policies from the TreeMap (sorted by expiry date)
        for (Policy policy : policiesByExpiryDate.values()) {
            if (policy.getExpiryDate().before(currentDate)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }

        // Remove expired policies
        for (String policyNumber : expiredPolicyNumbers) {
            policiesByNumber.remove(policyNumber);
            policiesByInsertionOrder.remove(policyNumber);
            policiesByExpiryDate.values().removeIf(policy -> policy.getPolicyNumber().equals(policyNumber));
        }
    }

    // Display all policies
    public void displayAllPolicies() {
        for (Policy policy : policiesByNumber.values()) {
            System.out.println(policy);
        }
    }
}

public class insurance {

    public static void main(String[] args) throws ParseException {
        // Create the PolicyManager instance
        PolicyManager manager = new PolicyManager();

        // Sample data
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Add policies
        manager.addPolicy(new Policy("P001", "Alice", dateFormat.parse("30/06/2025"), "Health", 500.0));
        manager.addPolicy(new Policy("P002", "Bob", dateFormat.parse("15/07/2025"), "Auto", 300.0));
        manager.addPolicy(new Policy("P003", "Alice", dateFormat.parse("01/06/2025"), "Home", 700.0));
        manager.addPolicy(new Policy("P004", "Carol", dateFormat.parse("20/05/2025"), "Auto", 400.0));

        // Display all policies
        System.out.println("All Policies:");
        manager.displayAllPolicies();

        // Get a policy by number
        System.out.println("\nPolicy P002: " + manager.getPolicyByNumber("P002"));

        // Get policies expiring soon (within the next 30 days)
        System.out.println("\nPolicies expiring soon:");
        List<Policy> expiringPolicies = manager.getPoliciesExpiringSoon();
        for (Policy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // Get policies by policyholder name (Alice)
        System.out.println("\nPolicies for Alice:");
        List<Policy> alicePolicies = manager.getPoliciesByPolicyholder("Alice");
        for (Policy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        manager.displayAllPolicies();
    }
}
