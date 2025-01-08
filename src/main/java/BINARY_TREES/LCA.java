package BINARY_TREES;
import java.util.*;

public class LCA {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Default constructor for TreeNode
        TreeNode() {
            this.val = 0;
            this.left = null;
            this.right = null;
        }

        // Constructor with a value
        // parameter for TreeNode
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }

        // Constructor with value, left
        // child, and right child
        // parameters for TreeNode
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // both left and right are not null, we found our result
            return root;
        }
    }
    public static void main(String[] args) {
        // Creating a sample tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // node 5
        TreeNode q = root.left.right.right;  // node 4


        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of nodes " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
