package leetcode.trees.DFS.hard;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">124. Binary Tree Maximum Path Sum</a>
 */
public class BinaryTreeMaximumPathSum124 {

    public static void runTests(Integer[] input, int expected) {
        Tree tree = new Tree(input);
        tree.print();
        System.out.println("Actual: " + maxPathSum(tree.root) + " Expected: " + expected);
    }

    public static void main(String[] args) {
        runTests(new Integer[]{9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6}, 16);
        runTests(new Integer[]{1, 2, 3}, 6);
        runTests(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}, 48); // https://leetcode.com/problems/path-sum/
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    public static Integer dfs(TreeNode node) {
        if (node == null) return 0;
        int sumLeft = Math.max(dfs(node.left), 0);
        int sumRight = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, node.val + sumLeft + sumRight);
        return Math.max(node.val + sumLeft, node.val + sumRight);
    }

    public static int maxPathSumFromRoot(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + Math.max(maxPathSumFromRoot(root.left), maxPathSumFromRoot(root.right));
    }
}
