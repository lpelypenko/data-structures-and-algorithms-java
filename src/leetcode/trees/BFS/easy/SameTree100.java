package leetcode.trees.BFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/same-tree/description/">100. Same Tree</a>
 */
public class SameTree100 {
    static void runTest(Integer[] pArr, Integer[] qArr) {
        Tree p = new Tree();
        TreeNode p1Root = p.insert(pArr);
        System.out.println("1st tree:");
        p.print();
        Tree q = new Tree();
        TreeNode q1Root = q.insert(qArr);
        System.out.println("2nd tree:");
        q.print();
        System.out.println("Is same: " + isSameTree(p1Root, q1Root));
    }

    public static void main(String[] args) {
        // TC1 Balanced tree, expect same
        runTest(new Integer[]{4, 2, 7, 1, 3, 6, 9}, new Integer[]{4, 2, 7, 1, 3, 6, 9});
        // TC2 Unbalanced tree, expect same
        runTest(new Integer[]{4, 2, 7, null, 3, 6, null}, new Integer[]{4, 2, 7, null, 3, 6, null});
        // TC2 One node is null
        runTest(new Integer[]{1, 2, 3}, new Integer[]{1, null, 3});
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> toProcess = new LinkedList<>();
        toProcess.add(p);
        toProcess.add(q);
        while (!toProcess.isEmpty()) {
            TreeNode left = toProcess.poll();
            TreeNode right = toProcess.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) return false;
            toProcess.add(left.left);
            toProcess.add(right.left);
            toProcess.add(left.right);
            toProcess.add(right.right);
        }
        return true;
    }

}
