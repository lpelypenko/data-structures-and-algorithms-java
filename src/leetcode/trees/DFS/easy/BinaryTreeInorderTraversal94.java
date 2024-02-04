package leetcode.trees.DFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">94. Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInorderTraversal94 {
    static List<Integer> result = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        traverse(root);
        return result;
    }

    public static void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            result.add(root.val);
            traverse(root.right);
        }
    }

    public static void main(String[] args) {
        Tree tc1 = new Tree(new Integer[]{});
        System.out.println(inorderTraversal(tc1.root));
        Tree tc2 = new Tree(new Integer[]{1, null, 2, 3});
        System.out.println(inorderTraversal(tc2.root));
    }
}
