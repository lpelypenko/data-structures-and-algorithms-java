package leetcode.trees.DFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

/*
https://leetcode.com/problems/subtree-of-another-tree/description/
Subtree of Another Tree
 */
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        runTests(new Integer[]{3, 4, 5, 1, 2}, new Integer[]{4, 1, 2}, true);
    }

    public static void runTests(Integer[] treeArr, Integer[] subTreeArr, boolean expected) {
        Tree tree = new Tree();
        TreeNode root = tree.insert(treeArr);
        Tree subTree = new Tree();
        TreeNode subRoot = subTree.insert(subTreeArr);
        System.out.println("Is subtree: " + isSubtree(root, subRoot) + ". Expected: " + expected);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // Edge case
        if (root == null) return false; // Edge case
        if (isSame(root, subRoot)) return true;  // Early return if compared on root

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

//    public static boolean dfsTraverse(TreeNode root, TreeNode subRoot) {
//        if (root != null) {
//            if (root.val == subRoot.val) {
//                isSubtree = isSame(root, subRoot);
//            }
//            dfsTraverse(root.left, subRoot);
//            dfsTraverse(root.right, subRoot);
//        }
//        return isSubtree;
//    }

    public static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
        return false;
    }
}
