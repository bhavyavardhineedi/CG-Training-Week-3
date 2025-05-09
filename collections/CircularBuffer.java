public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    // Constructor to initialize the buffer
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Insert an element into the buffer
    public void insert(int element) {
        if (size == capacity) {
            // Buffer is full, overwrite the oldest element (front)
            front = (front + 1) % capacity;
        } else {
            size++;
        }

        // Insert the new element at the rear
        buffer[rear] = element;
        rear = (rear + 1) % capacity;
    }

    // Display the elements in the buffer
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Initialize a circular buffer of size 3
        CircularBuffer circularBuffer = new CircularBuffer(3);

        // Insert elements into the buffer
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        
        // Display the buffer
        circularBuffer.display();  // Output: Buffer: [1, 2, 3]
        
        // Insert an element when the buffer is full
        circularBuffer.insert(4);
        
        // Display the buffer after overwriting the oldest element
        circularBuffer.display();  // Output: Buffer: [2, 3, 4]
    }
}
