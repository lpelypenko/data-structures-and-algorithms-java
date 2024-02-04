package leetcode.trees.DFS.medium;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

/*
https://leetcode.com/problems/validate-binary-search-tree/ 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        runTests(new Integer[]{5, 4, 6, null, null, 3, 7}, false);
        runTests(new Integer[]{32, 26, 47, 19, null, null, 56, null, 27}, false);
    }

    public static void runTests(Integer[] treeArr, boolean expected) {
        Tree tree = new Tree();
        TreeNode root = tree.insert(treeArr);
        System.out.println("Is valid: " + isValidBST(root) + ". Expected: " + expected);
    }

    /*
     Tip: Inorder Traversal of Valid BST is always strictly increasing array:
     Output: 3 4 5 6 7 8 9
     */
    static Integer prevNodeValue = null;
    static boolean valid = true;

    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            isValidBST(root.left);
            if (prevNodeValue != null && root.val <= prevNodeValue) {
                valid = false;
            }
            prevNodeValue = root.val;
            System.out.print(" " + root.val);
            isValidBST(root.right);
        }
        return valid;
    }
}
