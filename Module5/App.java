package Module5;
public class App {
    public static void main(String[] args) {
        // Create a new instance of BST
        BST<Integer> bst = new BST<>();

        // Add some elements
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        // Print the tree in-order (should be sorted)
        System.out.println("In-order traversal:");
        printInOrder(bst.getRoot());
        System.out.println();

        // Remove elements and test all three removal cases
        System.out.println("Removing 20 from the tree");
        bst.remove(20);
        System.out.println("In-order traversal after removing 20:");
        printInOrder(bst.getRoot());
        System.out.println("Size of the tree: " + bst.size());
        System.out.println();

        System.out.println("Removing 70 from the tree");
        bst.remove(70);
        System.out.println("In-order traversal after removing 70:");
        printInOrder(bst.getRoot());
        System.out.println("Size of the tree: " + bst.size());
        System.out.println();

        System.out.println("Removing 50 from the tree");
        bst.remove(50);
        System.out.println("In-order traversal after removing 50:");
        printInOrder(bst.getRoot());
        System.out.println("Size of the tree: " + bst.size());
        System.out.println();
    }

    // Helper method to print the tree in-order
    private static void printInOrder(BSTNode<Integer> node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }
}
