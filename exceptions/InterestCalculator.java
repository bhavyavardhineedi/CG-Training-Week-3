public class InterestCalculator {

    // Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Validate the input
        if (amount < 0 || rate < 0) {
            // Throw an exception if amount or rate is negative
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        // Calculate interest (Simple Interest: P * R * T / 100)
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        double amount = 5000;  // Example amount
        double rate = 5;      // Example invalid rate (negative)
        int years = 10;        // Example years

        try {
            // Attempt to calculate interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Interest: " + interest);
        } catch (IllegalArgumentException e) {
            // Handle the exception
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
