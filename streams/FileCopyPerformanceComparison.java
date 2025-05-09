import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCopyPerformanceComparison {

    public static void main(String[] args) {
        // Define the source and destination files
        String sourceFilePath = "large_source_file.txt";
        String destinationFilePathBuffered = "large_file_copy_buffered.txt";
        String destinationFilePathUnbuffered = "large_file_copy_unbuffered.txt";
        
        // Measure time for buffered copy
        long startTimeBuffered = System.nanoTime();
        copyFileBuffered(sourceFilePath, destinationFilePathBuffered);
        long endTimeBuffered = System.nanoTime();
        long durationBuffered = endTimeBuffered - startTimeBuffered;
        System.out.println("Buffered Copy Time: " + durationBuffered + " nanoseconds");

        // Measure time for unbuffered copy
        long startTimeUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFilePath, destinationFilePathUnbuffered);
        long endTimeUnbuffered = System.nanoTime();
        long durationUnbuffered = endTimeUnbuffered - startTimeUnbuffered;
        System.out.println("Unbuffered Copy Time: " + durationUnbuffered + " nanoseconds");
    }

    // Copy file using BufferedInputStream and BufferedOutputStream
    public static void copyFileBuffered(String sourceFile, String destinationFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            System.out.println("Buffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error during buffered file copy: " + e.getMessage());
        }
    }

    // Copy file using FileInputStream and FileOutputStream (no buffering)
    public static void copyFileUnbuffered(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("Unbuffered copy completed.");
        } catch (IOException e) {
            System.out.println("Error during unbuffered file copy: " + e.getMessage());
        }
    }
}
