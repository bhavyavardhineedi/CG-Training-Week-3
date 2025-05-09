import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Writer thread: writes data to the piped output stream
            Thread writerThread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                    String[] messages = {"Hello", "This is a test", "Using Piped Streams", "End"};
                    for (String msg : messages) {
                        writer.write(msg);
                        writer.newLine();
                        writer.flush();
                        System.out.println("[Writer] Sent: " + msg);
                        Thread.sleep(500); // Simulate delay
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            // Reader thread: reads data from the piped input stream
            Thread readerThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("[Reader] Received: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Wait for both to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }
}
