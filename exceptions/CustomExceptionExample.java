import java.util.Scanner;

// Custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take user input for age
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Validate the age
            validateAge(age);

            // If validation passes
            System.out.println("Access granted!");

        } catch (InvalidAgeException e) {
            // Handle the exception and display the message
            System.out.println(e.getMessage());
        } finally {
            scanner.close(); // Close scanner resource
        }
    }
}
