package Module4;
import java.util.List;
//import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Unit Test
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        Traversals<Integer> traversals = new Traversals<>();

        List<Integer> preorderResult = traversals.preorder(root);
        List<Integer> inorderResult = traversals.inorder(root);
        List<Integer> postorderResult = traversals.postorder(root);

        System.out.println("Pre-order traversal: " + preorderResult);
        System.out.println("In-order traversal: " + inorderResult);
        System.out.println("Post-order traversal: " + postorderResult);
    }
}
