package leetcode.trees.BFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">226. Invert Binary Tree</a>
 */
public class InvertBinaryTree226 {
    public static void main(String[] args) {
        // TC1
        Tree testCase1 = new Tree();
        TreeNode testCase1Root = testCase1.insert(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        System.out.println("Original:");
        testCase1.print();
        invertTree(testCase1Root);
        System.out.println("Inverted:");
        testCase1.print();
        // TC2
        Tree testCase2 = new Tree();
        TreeNode testCase2Root = testCase2.insert(new Integer[]{2, 1, 3});
        System.out.println("Original:");
        testCase2.print();
        invertTree(testCase2Root);
        System.out.println("Inverted:");
        testCase2.print();
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> toProcess = new LinkedList<>();
        toProcess.add(root); // 2,7
        while (!toProcess.isEmpty()) {
            TreeNode current = toProcess.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                toProcess.add(current.left);
            }
            if (current.right != null) {
                toProcess.add(current.right);
            }
        }
        return root;
    }
}
