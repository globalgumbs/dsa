package Module4;
import java.util.List;
import java.util.ArrayList;
//import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new ArrayList<>();
        if (root == null){return list;}
        if (root.getData() != null) {
            list.add(root.getData());
            list = combineList(list, preorder(root.getLeft()));
            list = combineList(list, preorder(root.getRight()));
        }
        return list;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new ArrayList<>();
        if (root == null){return list;}
        if (root.getData() != null) {
            list = combineList(list, inorder(root.getLeft()));
            list.add(root.getData());
            list = combineList(list, inorder(root.getRight()));
        }
        return list;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new ArrayList<>();
        if (root == null){return list;}
        if (root.getData() != null) {
            list = combineList(list, postorder(root.getLeft()));
            list = combineList(list, postorder(root.getRight()));
            list.add(root.getData());
        }
        return list;
    }

    private List<T> combineList(List<T> list1, List<T> list2) {
        for (T t : list2) {
            list1.add(t);
        }
        return list1;
    }
}