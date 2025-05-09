import java.util.*;

class Customer {
    private String accountNumber;
    private double balance;

    public Customer(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}

class BankingSystem {
    private Map<String, Customer> customerAccounts = new HashMap<>(); // HashMap to store accounts
    private TreeMap<Double, List<Customer>> sortedCustomersByBalance = new TreeMap<>(); // TreeMap to store sorted customers
    private Queue<String> withdrawalQueue = new LinkedList<>(); // Queue to process withdrawal requests

    // Add a customer to the system
    public void addCustomer(String accountNumber, double initialBalance) {
        Customer customer = new Customer(accountNumber, initialBalance);
        customerAccounts.put(accountNumber, customer);
        updateSortedCustomers(customer);
    }

    // Update the TreeMap when a customer's balance is updated
    private void updateSortedCustomers(Customer customer) {
        double balance = customer.getBalance();
        sortedCustomersByBalance.putIfAbsent(balance, new ArrayList<>());
        sortedCustomersByBalance.get(balance).add(customer);
    }

    // Withdraw money from the account
    public void withdraw(String accountNumber, double amount) {
        if (!customerAccounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        Customer customer = customerAccounts.get(accountNumber);
        double balance = customer.getBalance();
        
        if (balance >= amount) {
            customer.setBalance(balance - amount);
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + customer.getBalance());
            updateSortedCustomers(customer);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Add a withdrawal request to the queue
    public void addWithdrawalRequest(String accountNumber) {
        withdrawalQueue.add(accountNumber);
    }

    // Process the withdrawal requests in the queue
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            // In a real-world scenario, we would process the withdrawal by asking for an amount.
            // For this demo, let's assume we withdraw a fixed amount (e.g., $50).
            withdraw(accountNumber, 50.0);
        }
    }

    // Display all customer accounts sorted by balance
    public void displaySortedCustomers() {
        System.out.println("\nCustomers sorted by balance:");
        for (Map.Entry<Double, List<Customer>> entry : sortedCustomersByBalance.entrySet()) {
            for (Customer customer : entry.getValue()) {
                System.out.println(customer);
            }
        }
    }

    // Display customer details by account number
    public void displayCustomer(String accountNumber) {
        Customer customer = customerAccounts.get(accountNumber);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Account not found!");
        }
    }
}

public class BankingSystemDemo {

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding customers to the system
        bank.addCustomer("A1001", 1000.00);
        bank.addCustomer("A1002", 500.00);
        bank.addCustomer("A1003", 2000.00);
        bank.addCustomer("A1004", 1500.00);

        // Display all customers sorted by balance
        bank.displaySortedCustomers();

        // Add withdrawal requests to the queue
        bank.addWithdrawalRequest("A1001");
        bank.addWithdrawalRequest("A1002");

        // Process the withdrawal requests
        System.out.println("\nProcessing withdrawal requests:");
        bank.processWithdrawals();

        // Display all customers sorted by balance after withdrawal
        bank.displaySortedCustomers();

        // Display specific customer details
        bank.displayCustomer("A1003");
    }
}
