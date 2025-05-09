import java.util.Scanner;

public class MultipleCatchBlocksExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input for array and index
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize array
        int[] array = null;

        try {
            // Initialize array based on the entered size
            array = new int[size];

            // Fill the array with some values for testing
            for (int i = 0; i < size; i++) {
                array[i] = i * 10;
            }

            // Accept the index to retrieve the value
            System.out.print("Enter the index to retrieve value: ");
            int index = scanner.nextInt();

            // Retrieve and print the value at the given index
            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle invalid index
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            // Handle case when array is null
            System.out.println("Array is not initialized!");

        } finally {
            scanner.close(); // Close scanner resource
        }
    }
}
