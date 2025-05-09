import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    
    // Function to reverse the queue
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: if the queue is empty, return
        if (queue.isEmpty()) {
            return;
        }
        
        // Step 1: Remove the front element of the queue
        int front = queue.poll();
        
        // Step 2: Recursively reverse the remaining elements
        reverseQueue(queue);
        
        // Step 3: Add the front element to the back of the queue
        queue.add(front);
    }
    
    public static void main(String[] args) {
        // Create a queue and add elements
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        
        System.out.println("Original Queue: " + queue);
        
        // Reverse the queue
        reverseQueue(queue);
        
        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
