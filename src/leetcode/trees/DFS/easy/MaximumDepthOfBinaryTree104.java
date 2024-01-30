package leetcode.trees.DFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">104. Maximum Depth of Binary Tree</a>
 */

public class MaximumDepthOfBinaryTree104 {
    public static void runTests(Integer[] input, int expectedMaxDepth) {
        Tree test = new Tree();
        TreeNode root = test.insert(input);
        test.print();
        System.out.println("Actual max depth: " + maxDepth(root) + ". Expected: " + expectedMaxDepth);
    }
    public static void main(String[] args) {
        runTests(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 3);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepthBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        if (root == null) return maxDepth;
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            maxDepth++;
            for (int i=0; i < queueSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return maxDepth;
    }
}
