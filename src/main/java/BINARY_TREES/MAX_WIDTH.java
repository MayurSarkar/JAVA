package BINARY_TREES;
import java.util.LinkedList;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;

public class MAX_WIDTH {

    // TreeNode structure
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    // Function widthOfBinaryTree to find the maximum width of the Binary Tree
    public static int widthOfBinaryTree(TreeNode root) {
        // If the root is null, the width is zero
        if (root == null) {
            return 0;
        }

        // Initialize a variable 'ans' to store the maximum width
        int ans = 0;

        // Create a queue to perform level-order traversal, where each element
        // is a pair of TreeNode and its position in the level
        Queue<SimpleEntry<TreeNode, Integer>> q = new LinkedList<>();
        // Push the root node and its position (0) into the queue
        q.add(new SimpleEntry<>(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();
            // Get the position of the front node in the current level
            int mmin = q.peek().getValue();

            // Store the first and last positions of nodes in the current level
            int first = 0, last = 0;

            // Process each node in the current level
            for (int i = 0; i < size; i++) {
                // Calculate current position relative to the minimum position in the level
                int cur_id = q.peek().getValue() - mmin;
                // Get the current node
                TreeNode node = q.peek().getKey();
                // Poll the front node from the queue
                q.poll();

                // If this is the first node in the level, update the 'first' variable
                if (i == 0) {
                    first = cur_id;
                }

                // If this is the last node in the level, update the 'last' variable
                if (i == size - 1) {
                    last = cur_id;
                }

                // Enqueue the left child of the current node with its position
                if (node.left != null) {
                    q.add(new SimpleEntry<>(node.left, cur_id * 2 + 1));
                }

                // Enqueue the right child of the current node with its position
                if (node.right != null) {
                    q.add(new SimpleEntry<>(node.right, cur_id * 2 + 2));
                }
            }

            // Update the maximum width by calculating the difference between the first
            // and last positions, and adding 1
            ans = Math.max(ans, last - first + 1);
        }

        // Return the maximum width of the binary tree
        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Get the maximum width of the binary tree
        int maxWidth = widthOfBinaryTree(root);

        // Print the result
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}
