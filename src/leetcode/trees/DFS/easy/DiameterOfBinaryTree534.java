package leetcode.trees.DFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">543. Diameter of Binary Tree</a>
 */
public class DiameterOfBinaryTree534 {
    public static void main(String[] args) {
        Tree test = new Tree();
        TreeNode root = test.insert(new Integer[]{1,2,3,4,5, null, 6});
        test.print();
        System.out.println("Diameter: " + diameterOfBinaryTree(root) + ". Expected: 4");
    }

    public static int maxDepth = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        return Math.max(maxDiameter(root), maxDepth);
    }

    public static int maxDiameter(TreeNode root) {
        if (root == null) return 0;
        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }
}
