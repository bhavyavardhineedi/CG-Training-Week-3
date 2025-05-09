import java.io.*;

public class UserInfoToFile {

    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            // Initialize BufferedReader to read from the console
            reader = new BufferedReader(new InputStreamReader(System.in));

            // Read user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Create or open a file to write the data
            writer = new FileWriter("user_info.txt");

            // Write the data to the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("\nUser information saved to 'user_info.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to the file.");
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing streams.");
                e.printStackTrace();
            }
        }
    }
}
