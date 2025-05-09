import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        // Define the path to the file
        String filePath = "info.txt";

        // Use try-with-resources to automatically close the BufferedReader after reading
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read the first line of the file
            String firstLine = br.readLine();

            // Check if the file is empty
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            // Handle IOException and display an error message
            System.out.println("Error reading file");
        }
    }
}
