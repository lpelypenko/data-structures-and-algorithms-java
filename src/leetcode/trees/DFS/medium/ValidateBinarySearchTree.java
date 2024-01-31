package leetcode.trees.DFS.medium;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

/*
https://leetcode.com/problems/validate-binary-search-tree/ 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        runTests(new Integer[]{5, 4, 6, null, null, 3, 7}, false);
        runTests(new Integer[]{32,26,47,19,null,null,56,null,27}, false);
    }

    public static void runTests(Integer[] treeArr, boolean expected) {
        Tree tree = new Tree();
        TreeNode root = tree.insert(treeArr);
        System.out.println("Is valid: " + isValidBST(root) + ". Expected: " + expected);
    }

    static Integer prevNodeValue = null;
    static boolean valid = true;
    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            isValidBST(root.left);
            if (prevNodeValue !=null && root.val <= prevNodeValue) {
                valid = false;
            }
            prevNodeValue = root.val;
            System.out.print(" " + root.val);
            isValidBST(root.right);
        }
        return valid;
    }

    // Recursive attempt failed
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        return isValid(root) && isValidRight(root.right, root) && isValidLeft(root.left, root);
//    }
//
//    public static boolean isValid(TreeNode current) {
//        if (current == null) return true;
//        if (current.left == null && current.right == null) {
//            return true;
//        }
//        if (current.left != null && current.left.val >= current.val) {
//            return false;
//        }
//        if (current.right != null && current.right.val <= current.val) {
//            return false;
//        }
//        return isValid(current.left) && isValid(current.right);
//    }
//
//    public static boolean isValidRight(TreeNode current, TreeNode root) {
//        if (current == null || current == root) return true;
//
//        return  current.val > root.val && isValidRight(current.left, root) && isValidRight (current.right, root);
//    }
//
//    public static boolean isValidLeft(TreeNode current, TreeNode root) {
//        if (current == null || current == root) return true;
//
//        return current.val < root.val && isValidLeft(current.left, root) && isValidLeft(current.right, root);
//    }
}
