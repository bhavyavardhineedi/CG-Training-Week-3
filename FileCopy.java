import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        // Specify the source and destination file paths
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        // Call the method to copy content from source to destination
        copyFile(sourceFilePath, destinationFilePath);
    }

    public static void copyFile(String sourceFile, String destinationFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Create FileInputStream to read from the source file
            fis = new FileInputStream(sourceFile);

            // Create FileOutputStream to write to the destination file
            fos = new FileOutputStream(destinationFile);

            int byteData;
            // Read byte by byte and write to the destination file
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File content copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred.");
        } finally {
            // Close the streams in the finally block to ensure they are closed even if an exception occurs
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing the streams.");
            }
        }
    }
}
