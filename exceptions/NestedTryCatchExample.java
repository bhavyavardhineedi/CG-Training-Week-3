import java.util.Scanner;

public class NestedTryCatchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size and divisor from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] numbers = new int[size];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();
        
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();
        
        try {
            // Try to access the array element
            try {
                int element = numbers[index]; // This may throw ArrayIndexOutOfBoundsException
                // Try to divide the element by the divisor
                try {
                    int result = element / divisor; // This may throw ArithmeticException
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            scanner.close(); // Close the scanner resource
        }
    }
}
