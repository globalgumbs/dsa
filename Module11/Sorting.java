package Module11;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int length = arr.length;
        // Base Case
        if (length == 0) {return;}
        if (length == 1) {return;}

        // Split
        int mid = length/2;
        T[] right = (T[]) new Object[length-mid];
        T[] left = (T[]) new Object[mid];
        for (int i=0; i < mid; i++) {
            left[i] = arr[i];
        }
        int idx=0;
        for (int i=mid; i < length; i++) {
            right[idx++] = arr[i];
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // Merge
        int i=0, j=0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) { // Left < Right
                arr[i+j] = left[i];
                i++;
            } else { // Right < Left
                arr[i+j] = right[j];
                j++;
            }
        }

        while (i < left.length) {
            arr[i+j] = left[i];
            i++;
        }
        while (j < right.length) {
            arr[i+j] = right[j];
            j++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int k = 0;
        for (int num: arr) {
            if (String.valueOf(num).length() > k) {
                k = String.valueOf(num).length();
            }
        }
        
        // Create buckets
        List<Integer>[] buckets = new List[19];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        // Add to buckets
        int divisor = 1;
        for (int i=0; i<k; i++) {
            for (int number: arr) {
                buckets[(number/divisor) % 10 + 9].add(number); // Enqueue: add to back
            }
            // Add back to array
            int j = 0;
            for (List<Integer> list: buckets) {
                for (int num: list) {
                    arr[j++] = num; // Dequeue: remove from front
                }
                list.clear();
            }
            divisor *= 10;
        }
        

    }
}