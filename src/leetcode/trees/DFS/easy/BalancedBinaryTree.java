package leetcode.trees.DFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

public class BalancedBinaryTree {

    public static void runTests(Integer[] input, boolean expected) {
        Tree test = new Tree();
        TreeNode root = test.insert(input);
        test.print();
        System.out.println("Is balanced: " + isBalanced(root) + ". Expected: " + expected);
    }

    public static void main(String[] args) {
        runTests(new Integer[]{3, 9, 20, null, null, 15, 7}, true);
        runTests(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}, false);
    }

    public static boolean isBalanced = true;

    public static boolean isBalanced(TreeNode root) {
        checkBalanced(root);
        return isBalanced;
    }

    public static int checkBalanced(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = checkBalanced(root.left);
        int rightDepth = checkBalanced(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
