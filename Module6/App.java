package Module6;

public class App {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // Test 1: Add elements to the heap
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(3);
        minHeap.add(8);

        // Expected heap: [3, 5, 20, 10, 8]
        System.out.println("Test 1: Add elements");
        printHeap(minHeap);

        // Test 2: Remove the min element
        int min1 = minHeap.remove();
        // Expected min: 3
        System.out.println("Test 2: Remove min element (expected 3, got " + min1 + ")");
        printHeap(minHeap);

        // Test 3: Remove the min element again
        int min2 = minHeap.remove();
        // Expected min: 5
        System.out.println("Test 3: Remove min element again (expected 5, got " + min2 + ")");
        printHeap(minHeap);

        // Test 4: Add more elements to the heap
        minHeap.add(1);
        minHeap.add(6);

        // Expected heap: [1, 6, 20, 10, 8]
        System.out.println("Test 4: Add more elements");
        printHeap(minHeap);

        // Test 5: Remove all elements
        while (minHeap.size() > 0) {
            System.out.println("Removed: " + minHeap.remove());
        }
        System.out.println("Test 5: Remove all elements (heap should be empty)");
        printHeap(minHeap);

        // Test 6: Add more than INITIAL_CAPACITY elements to test resizing
        System.out.println("Test 6: Add elements to trigger resizing");
        for (int i = 0; i < 15; i++) {
            minHeap.add(i);
        }

        // The heap should have resized, and all elements should be in the correct order
        printHeap(minHeap);
        //System.out.println("Backing array length after resizing: " + minHeap.getBackingArray().length);

        // Remove elements to verify the heap property is maintained
        while (minHeap.size() > 0) {
            System.out.println("Removed: " + minHeap.remove());
        }
        System.out.println("Test 6: Remove all elements after resizing (heap should be empty)");
        printHeap(minHeap);
    }

    private static void printHeap(MinHeap<?> heap) {
        Object[] backingArray = heap.getBackingArray();
        System.out.print("Heap: ");
        for (int i = 1; i <= heap.size(); i++) {
            System.out.print(backingArray[i] + " ");
        }
        System.out.println();
    }
}
