// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {

    private double balance;

    // Constructor to initialize the bank account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount! Amount cannot be negative.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance of 1000

        // Test withdrawals
        try {
            System.out.println("Current balance: " + account.getBalance());
            // Trying to withdraw a valid amount
            account.withdraw(500);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());
            
            // Trying to withdraw more than available balance
            account.withdraw(600); // This will throw InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Trying to withdraw a negative amount
        try {
            account.withdraw(-100); // This will throw IllegalArgumentException
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
