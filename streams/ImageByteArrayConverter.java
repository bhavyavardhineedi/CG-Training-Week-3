import java.io.*;

public class ImageByteArrayConverter {

    public static void main(String[] args) {
        String sourcePath = "input.jpg";       // Replace with your input image path
        String destinationPath = "output.jpg"; // Output image path

        try {
            // Step 1: Read the image into a byte array
            byte[] imageBytes = readImageToByteArray(sourcePath);
            System.out.println("Image successfully converted to byte array.");

            // Step 2: Write the byte array back to a new image
            writeByteArrayToImage(imageBytes, destinationPath);
            System.out.println("Byte array written back to image successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Reads image and returns byte array
    public static byte[] readImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }

    // Writes byte array to image file
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
