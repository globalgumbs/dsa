package Module10;
import java.util.Comparator;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 5, 6, 80};
        Integer[] arr2 = {5, 2, 9, 1, 5, 6, 80};
        Comparator<Integer> comp = Integer::compareTo;
        Sorting.bubbleSort(arr2, comp);
        Sorting.insertionSort(arr, comp);
        // for (Integer integer : arr) {
        //     System.out.println(integer);
        // }
        System.out.println(Arrays.equals(arr, arr2));
    }
}