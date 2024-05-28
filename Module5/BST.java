package Module5;
import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!        
        if (data == null) {throw new IllegalArgumentException();}
        root = rAdd(root, data);
        size++;
    }

    private BSTNode<T> rAdd(BSTNode<T> curr, T data) {
        if (curr == null) {
            curr = new BSTNode<T>(data);
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(rAdd(curr.getLeft(), data));
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(rAdd(curr.getRight(), data));
        }
        return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {throw new IllegalArgumentException();}
        BSTNode<T> temp1 = new BSTNode<>(null);
        root = rRemove(data, root, temp1);
        size--;
        return temp1.getData();
    }

    private BSTNode<T> rRemove(T data, BSTNode<T> curr, BSTNode<T> temp1) {
        if (curr == null) {throw new NoSuchElementException();}
        if (data.compareTo(curr.getData()) == 0) {
            // Base Case -- Data Found
            temp1 = curr;
            if (curr.getRight() == null && curr.getLeft() == null) {
                return null;
            } else if (curr.getRight() != null && curr.getLeft() == null) {
                return curr.getRight();
            } else if (curr.getRight() == null && curr.getLeft() != null) {
                return curr.getLeft();
            } else {
                BSTNode<T> tempNode = new BSTNode<>(null);
                curr.setRight(succRemovalMethod(curr.getRight(), tempNode));
                curr.setData(tempNode.getData());
            }
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(rRemove(data, curr.getLeft(), temp1));
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(rRemove(data, curr.getRight(), temp1));
        }
        return curr;
    }

    private BSTNode<T> succRemovalMethod(BSTNode<T> curr, BSTNode<T> tempNode) {
        if (curr.getLeft() == null) {
            tempNode.setData(curr.getData());
            curr = curr.getRight();
        } else {
            curr.setLeft(succRemovalMethod(curr.getLeft(), tempNode));
        }
        return curr;
    }
    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}