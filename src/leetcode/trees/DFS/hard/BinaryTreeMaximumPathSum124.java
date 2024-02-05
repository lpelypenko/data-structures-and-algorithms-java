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
        System.out.println("Actual: " + maxPathSumFromRoot(tree.root) + " Expected: " + expected);
    }

    public static void main(String[] args) {
        runTests(new Integer[]{1, 2, 3}, 4);
        runTests(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}, 27); // https://leetcode.com/problems/path-sum/
    }

    public static int maxPathSumFromRoot(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + Math.max(maxPathSumFromRoot(root.left), maxPathSumFromRoot(root.right));
    }
}
