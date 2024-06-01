package Module7;

import java.util.NoSuchElementException;

public class App {
    public static void main(String[] args) {
        // Create a new ExternalChainingHashMap
        ExternalChainingHashMap<String, Integer> map = new ExternalChainingHashMap<>();

        // Test 1: Adding a new key-value pair
        System.out.println("Test 1: Adding a new key-value pair");
        Integer result = map.put("one", 1);
        if (result == 1 && map.size() == 1 && map.getTable()[hash("one", map.getTable().length)].getValue() == 1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
            printFailureDetails(result, 1, map.size(), 1, "one", map.getTable());
        }
        printMap(map);

        // Test 2: Adding another key-value pair
        System.out.println("Test 2: Adding another key-value pair");
        result = map.put("two", 2);
        if (result == 2 && map.size() == 2 && map.getTable()[hash("two", map.getTable().length)].getValue() == 2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed");
            printFailureDetails(result, 2, map.size(), 2, "two", map.getTable());
        }
        printMap(map);

        // Test 3: Replacing an existing key-value pair
        System.out.println("Test 3: Replacing an existing key-value pair");
        result = map.put("one", 10);
        if (result == 1 && map.size() == 2 && map.getTable()[hash("one", map.getTable().length)].getValue() == 10) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 failed");
            printFailureDetails(result, 1, map.size(), 2, "one", map.getTable());
        }
        printMap(map);

        // Test 4: Removing an existing key-value pair
        System.out.println("Test 4: Removing an existing key-value pair");
        result = map.remove("one");
        if (result == 10 && map.size() == 1 && map.getTable()[hash("one", map.getTable().length)] == null) {
            System.out.println("Test 4 passed");
        } else {
            System.out.println("Test 4 failed");
            printFailureDetails(result, 10, map.size(), 1, "one", map.getTable());
        }
        printMap(map);

        // Test 5: Removing a non-existing key-value pair
        System.out.println("Test 5: Removing a non-existing key-value pair");
        boolean exceptionThrown = false;
        try {
            map.remove("one");
        } catch (NoSuchElementException e) {
            exceptionThrown = true;
        }
        if (exceptionThrown) {
            System.out.println("Test 5 passed");
        } else {
            System.out.println("Test 5 failed");
            System.out.println("Expected NoSuchElementException but it was not thrown");
        }
        printMap(map);

        // Test 6: Adding a key-value pair with null key
        System.out.println("Test 6: Adding a key-value pair with null key");
        exceptionThrown = false;
        try {
            map.put(null, 100);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        if (exceptionThrown) {
            System.out.println("Test 6 passed");
        } else {
            System.out.println("Test 6 failed");
            System.out.println("Expected IllegalArgumentException but it was not thrown");
        }
        printMap(map);

        // Test 7: Adding a key-value pair with null value
        System.out.println("Test 7: Adding a key-value pair with null value");
        exceptionThrown = false;
        try {
            map.put("three", null);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        if (exceptionThrown) {
            System.out.println("Test 7 passed");
        } else {
            System.out.println("Test 7 failed");
            System.out.println("Expected IllegalArgumentException but it was not thrown");
        }
        printMap(map);

        // Test 8: Adding enough elements to trigger a resize
        System.out.println("Test 8: Adding enough elements to trigger a resize");
        for (int i = 3; i <= 10; i++) {
            map.put("key" + i, i);
        }
        boolean resizeSuccess = map.size() == 9 && map.getTable().length == 27;
        for (int i = 3; i <= 9; i++) {
            if (map.getTable()[hash("key" + i, map.getTable().length)] == null || map.getTable()[hash("key" + i, map.getTable().length)].getValue() != i) {
                resizeSuccess = false;
                break;
            }
        }
        if (resizeSuccess) {
            System.out.println("Test 8 passed");
        } else {
            System.out.println("Test 8 failed");
            printResizeFailureDetails(map);
        }
        printMap(map);
    }

    // Helper method to compute the hash index
    private static int hash(String key, int length) {
        return Math.abs(key.hashCode() % length);
    }

    // Helper method to print the entire map
    private static void printMap(ExternalChainingHashMap<String, Integer> map) {
        System.out.println("Current map state:");
        ExternalChainingMapEntry<String, Integer>[] table = map.getTable();
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            ExternalChainingMapEntry<String, Integer> entry = table[i];
            if (entry == null) {
                System.out.println("null");
            } else {
                while (entry != null) {
                    System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
                    entry = entry.getNext();
                    if (entry != null) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
    }

    // Helper method to print failure details
    private static void printFailureDetails(Integer result, Integer expectedValue, int size, int expectedSize, String key, ExternalChainingMapEntry<String, Integer>[] table) {
        System.out.println("Expected value: " + expectedValue + ", but got: " + result);
        System.out.println("Expected size: " + expectedSize + ", but got: " + size);
        System.out.println("Bucket state for key \"" + key + "\":");
        int index = hash(key, table.length);
        ExternalChainingMapEntry<String, Integer> entry = table[index];
        if (entry == null) {
            System.out.println("null");
        } else {
            while (entry != null) {
                System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "]");
                entry = entry.getNext();
                if (entry != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    // Helper method to print failure details for resize test
    private static void printResizeFailureDetails(ExternalChainingHashMap<String, Integer> map) {
        System.out.println("Expected size: 9, but got: " + map.size());
        System.out.println("Expected table length: 27, but got: " + map.getTable().length);
        System.out.println("Current table state:");
        printMap(map);
    }
}
