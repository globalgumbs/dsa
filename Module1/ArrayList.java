import java.util.NoSuchElementException;


public class ArrayList<T> {

    // DO NOT MODIFY THIS VARIABLE!
    public static final int INITIAL_CAPACITY = 9;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    // constructor
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
            throw new IllegalArgumentException("Data cannot be null.");
        }

        if (size == backingArray.length){
            T[] newArray = expand();
            for(int i = 1; i <= size; i++) {
                newArray[i] = backingArray[i - 1];
            }
            backingArray = newArray;
        }
        else {
            for(int i = size - 1; i >= 0; i--) {
                backingArray[i+1] = backingArray[i];
            }
        }
        
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
            throw new IllegalArgumentException("Data cannot be null.");
        }
        if (size == backingArray.length){
            T[] newArray = this.expand();
            for(int i = 0; i < size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        size++; 
        backingArray[size - 1] = data;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("The list is empty");
        }

        T first = backingArray[0];
        for(int i = 0; i < size - 1; i++) {
            backingArray[i] = backingArray[i+1];
        }
        backingArray[size - 1] = null;

        size--;
        return first;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty list");
        }
        else {
            T last = backingArray[size - 1];
            backingArray[size - 1] = null;
            size--;
            return last;
        }
    }

    private T[] expand() {
        T[] newArray = (T[]) new Object[backingArray.length * 2];
        newArray[0] = null;
        return newArray;
    }

    public void printOut() {
        for(int i = 0; i < size; i++) {
            System.out.println(backingArray[i]);
        }

        System.out.println();
        System.out.println("Capacity: " + backingArray.length);
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}