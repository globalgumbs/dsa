package Module10;
import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have arr worst case running time of: O(n^2)
     * And arr best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // int lastSwapIdx = arr.length-1;
        // boolean hasSwapped = true;
        // while (lastSwapIdx > 0 && hasSwapped == true) {
        //     hasSwapped = false;
        //     int i = 0;
        //     while (i < lastSwapIdx) {
        //         if (comparator.compare(arr[i], arr[i+1]) > 0) {
        //             swap(arr, i, i+1);
        //             hasSwapped = true;
        //         }
        //         i++;
        //     }
        //     lastSwapIdx--;
        // }
        // return;
    int lastSwap = arr.length - 1;
    for (int i = 1; i < arr.length; i++) {
        boolean is_sorted = true;
        int currentSwap = -1;
        for (int j = 0; j < lastSwap; j++) {
            if (comparator.compare(arr[j], arr[j+1]) > 0) {
                swap(arr, j, j+1);
                is_sorted = false;
                currentSwap = j;
            }
        }
        if (is_sorted) return;
        lastSwap = currentSwap;
    }
}

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have arr worst case running time of: O(n^2)
     * And arr best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int outerIdx = 0; outerIdx < arr.length; outerIdx++) {
            int relativeMinIdx = outerIdx;
            for (int innerIdx = outerIdx + 1; innerIdx < arr.length; innerIdx++) {
                if (comparator.compare(arr[relativeMinIdx], arr[innerIdx]) > 0) {relativeMinIdx = innerIdx;}
            }
            if (relativeMinIdx != 0) {swap(arr, outerIdx, relativeMinIdx);}
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have arr worst case running time of: O(n^2)
     * And arr best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int i = 1; i < arr.length; i++) {
            int innerIdx = i;
            while (innerIdx >= 1 && comparator.compare(arr[innerIdx], arr[innerIdx-1]) < 0) {
                swap(arr, innerIdx, innerIdx-1);
                innerIdx--;
            }
        }
    }

    private static <T> void swap(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        return;
    }
}