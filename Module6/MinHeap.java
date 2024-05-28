package Module6;
import java.util.NoSuchElementException;


/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {throw new IllegalArgumentException();}
        if (size == 0) {
            // Initialize the backing array
            backingArray[1] = data;
            size++;
            return;
        }
        if (backingArray.length == size + 1){
            // Resize the backing array
            T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];
            int idx = 0;
            for (T item : backingArray) {
                newBackingArray[idx] = item;
                idx++;
            }
            backingArray = newBackingArray;
        } 
        
        // Recursively add data
        backingArray[size + 1] = data;
        rAdd(data, size + 1);
        size++;
    }

    private void rAdd(T data, int i) {
        if (i == 1 || data.compareTo(backingArray[i/2]) > 0) {
            return;
        } else {
            T dummy = backingArray[i/2];
            backingArray[i/2] = data;
            backingArray[i] = dummy;
            i = i/2;
            rAdd(data, i);
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {throw new NoSuchElementException();}
        T dummy = backingArray[1];
        if (size == 1) {
            backingArray[1] = null;
            size--;
        } else {
            backingArray[1] = backingArray[size];
            backingArray[size] = null;
            size--;
            rRemove(1);
        }
        return dummy;
    }

    private void rRemove(int idx) {
        int minChildIdx;
        // Check how many children
        if (2 * idx == size) { // One child
            minChildIdx = idx * 2;
        } else if (2 * idx < size) { // Two children
            // Find minimum child
            if (backingArray[idx*2].compareTo(backingArray[idx*2+1]) < 0) {minChildIdx = idx*2;} else {minChildIdx = idx*2+1;}
        } else { // No children
            return;
        }

        // Check if swap is necessary
        if (backingArray[idx].compareTo(backingArray[minChildIdx]) < 0) {
            return;
        } else {
            // Swap
            T dummy = backingArray[idx];
            backingArray[idx] = backingArray[minChildIdx];
            backingArray[minChildIdx] = dummy;
            rRemove(minChildIdx);
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}