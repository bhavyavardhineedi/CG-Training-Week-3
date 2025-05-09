import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    
    // Function to generate the first N binary numbers
    public static void generateBinaryNumbers(int N) {
        // Queue to store binary numbers
        Queue<String> queue = new LinkedList<>();
        
        // Enqueue the first binary number "1"
        queue.add("1");
        
        // Generate the binary numbers
        for (int i = 0; i < N; i++) {
            // Dequeue the front element
            String binaryNumber = queue.poll();
            
            // Print the binary number
            System.out.print(binaryNumber + " ");
            
            // Enqueue the next two binary numbers by appending "0" and "1"
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }
    }
    
    public static void main(String[] args) {
        // Generate the first N binary numbers
        int N = 5;  // You can change N to generate more binary numbers
        generateBinaryNumbers(N);
    }
}
