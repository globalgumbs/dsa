package Module3;
public class App {
    public static void main(String[] args) {
        // Create an instance of ArrayQueue
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        // Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Print the current size of the queue
        System.out.println("Size after enqueue: " + queue.size());

        // Dequeue elements and print them
        while (queue.size() != 0) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Print the current size of the queue
        System.out.println("Size after dequeue: " + queue.size());

        // Enqueue more elements to test resizing
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        // Print the backing array after resizing
        // Print the backing array after resizing
        System.out.println("Backing array after resizing:");
        Object[] backingArray = queue.getBackingArray();
        for (Object element : backingArray) {
            System.out.print((Integer) element + " "); // Explicit cast to Integer
        }
        System.out.println();

        // Dequeue elements again
        while (queue.size() != 0) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Print the current size of the queue
        System.out.println("Size after dequeue: " + queue.size());
    }
}
