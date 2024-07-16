package Module11;
import java.util.Comparator;

public class App {
    // public static void main(String[] args) {
    //     Comparator<Integer> comp = Integer::compareTo;
    //     Integer[] arr = {-3, -1, -2, -5, -4};
    //     int[] arr2 = {-3, -1, -2, -5, -4};
    //     Sorting.mergeSort(arr, comp);
    //     Sorting.lsdRadixSort(arr2);
    //     System.out.println();
    //     System.out.println("Merge sorted array:");
    //     printArr(arr);
    //     System.out.println();
    //     System.out.println("Radix sorted array:");  
    //     printArr(arr2);      
    // }

    // private static void printArr(int[] arr) {
    //     for (int i : arr) {
    //         System.out.print(i + " ");
    //     }
    // }

    // private static void printArr(Integer[] arr) {
    //     for (Integer i : arr) {
    //         System.out.print(i + " ");
    //     }
    // }
    public static void main(String[] args) {
        // Define a comparator for integers
        Comparator<Integer> intComparator = Integer::compareTo;
        
        // Define test arrays
        Integer[] arr1 = {};
        Integer[] arr2 = {1};
        Integer[] arr3 = {2, 2, 2, 2, 2};
        Integer[] arr4 = {1, 2, 3, 4, 5};
        Integer[] arr5 = {5, 4, 3, 2, 1};
        Integer[] arr6 = {-3, -1, -2, -5, -4};
        Integer[] arr7 = {3, -1, 2, -5, 4};
        Integer[] arr8 = {1000, -1000, 500, -500, 0};
        Integer[] arr9 = {4, 5, 4, 3, 4, 2, 1, 2, 1};
        Integer[] arr10 = {8, 3, 7, 1, 2, 6, 5, 4};
        Integer[] arr11 = {7, 2, 5, 3, 1};
        Double[] arr12 = {3.1, 2.5, -1.2, 4.8, 0.0};

        // Test arrays
        testSort(arr1, intComparator);
        testSort(arr2, intComparator);
        testSort(arr3, intComparator);
        testSort(arr4, intComparator);
        testSort(arr5, intComparator);
        testSort(arr6, intComparator);
        testSort(arr7, intComparator);
        testSort(arr8, intComparator);
        testSort(arr9, intComparator);
        testSort(arr10, intComparator);
        testSort(arr11, intComparator);
        
        // For floating point numbers
        Comparator<Double> doubleComparator = Double::compareTo;
        testSort(arr12, doubleComparator);
    }

    private static <T> void testSort(T[] arr, Comparator<T> comparator) {
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        Sorting.mergeSort(arr, comparator);
        System.out.println("Sorted array:   " + java.util.Arrays.toString(arr));
        System.out.println();
    }
}