import java.io.*;
import java.nio.charset.StandardCharsets;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {
        String inputFile = "input.txt";   // Source file path
        String outputFile = "output.txt"; // Destination file path

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8)
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8)
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // Preserve line breaks
            }
            System.out.println("File converted successfully (uppercase → lowercase).");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
