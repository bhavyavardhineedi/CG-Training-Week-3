import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    // Two queues
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        // Push to queue1
        queue1.add(x);
        
        // Move all elements from queue1 to queue2, except the newly added element
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        // Move all elements back from queue2 to queue1, preserving the order
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
    }

    // Pop the top element from the stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    // Get the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        // Push elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Pop an element from the stack
        System.out.println("Pop: " + stack.pop());  // Output: 3

        // Get the top element of the stack
        System.out.println("Top: " + stack.top());  // Output: 2
    }
}
