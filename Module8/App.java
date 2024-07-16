import java.util.*;
public class App {
    public static void main(String[] args) {
        AVL<Integer> avlTree = new AVL<>();

        // Adding elements to cause rotations
        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(30); // This should cause a left rotation at 20
        System.out.println("\n\nAfter adding 10, 20, 30:");
        printTree(avlTree.getRoot());

        avlTree.add(25); // This should cause a left-right rotation at 10
        System.out.println("\n\nAfter adding 25:");
        printTree(avlTree.getRoot());

        avlTree.add(15); // This should be added without rotation
        avlTree.add(5);  // This should be added without rotation
        avlTree.add(1);  // This should cause a right rotation at 5
        System.out.println("\n\nAfter adding 15, 5, 1:");
        printTree(avlTree.getRoot());

        // Removing elements to cause rotations and rebalancing
        avlTree.remove(25); // Removing a node with no children
        System.out.println("\n\nAfter removing 25:");
        printTree(avlTree.getRoot());

        avlTree.remove(5); // Removing a node with one child
        System.out.println("\n\nAfter removing 5:");
        printTree(avlTree.getRoot());

        avlTree.remove(20); // Removing a node with two children
        System.out.println("After removing 20:");
        printTree(avlTree.getRoot());

        // Additional checks
        System.out.println("Tree size: " + avlTree.size());
        System.out.println("Tree root: " + avlTree.getRoot().getData());

        // Edge cases
        testEdgeCases(avlTree);
    }

    private static void printTree(AVLNode<Integer> node) {
        if (node == null) return;

        System.out.println("Node: " + node.getData() + ", Height: " + node.getHeight() + ", Balance Factor: " + node.getBalanceFactor());
        if (node.getLeft() != null) {
            System.out.println("Left child of " + node.getData() + ": " + node.getLeft().getData());
        } else {
            System.out.println("Left child of " + node.getData() + ": null");
        }
        if (node.getRight() != null) {
            System.out.println("Right child of " + node.getData() + ": " + node.getRight().getData());
        } else {
            System.out.println("Right child of " + node.getData() + ": null");
        }

        printTree(node.getLeft());
        printTree(node.getRight());
    }

    private static void testEdgeCases(AVL<Integer> avlTree) {
        // Test adding null element
        try {
            avlTree.add(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException for adding null element");
        }

        // Test removing null element
        try {
            avlTree.remove(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException for removing null element");
        }

        // Test removing element not in the tree
        try {
            avlTree.remove(100);
        } catch (NoSuchElementException e) {
            System.out.println("Caught NoSuchElementException for removing element not in the tree");
        }

        // Test adding duplicate elements
        avlTree.add(10);
        avlTree.add(10);
        System.out.println("After attempting to add duplicate 10:");
        printTree(avlTree.getRoot());

        // Test removing all elements
        // avlTree.remove(30);
        // avlTree.remove(20);
        // avlTree.remove(5);
        // avlTree.remove(1);
        // avlTree.remove(10);
        // System.out.println("After removing all elements:");
        // printTree(avlTree.getRoot());
    }
}
