package leetcode.trees.BFS.easy;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode Easy.
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/description/">637. Average of Levels in Binary Tree</a>
 */
public class AverageOfLevelsInBinaryTree637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodesOnOneLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current !=null) {
                    nodesOnOneLevel.add(current.val);
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }
            }
            result.add(calculateAverage(nodesOnOneLevel));
        }

        return result;
    }

    public static double calculateAverage(List<Integer> nodesOnOneLevel) {
        /// IMPORTANT: SUM OF TWO MAX INTEGERS SHOULD BE LONG
        long sum = 0;
        for (int nodeVal : nodesOnOneLevel) {
            sum += nodeVal;
        }
        return (double) sum / nodesOnOneLevel.size();
    }

    public static void main(String[] args) {
        Tree testCase1 = new Tree();
        TreeNode testCase1Root = testCase1.insert(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        testCase1.print();
        System.out.println("Average on levels: " + averageOfLevels(testCase1Root));
        Tree testCase2 = new Tree();
        TreeNode testCase2Root = testCase2.insert(new Integer[]{1, 2, 2, null, 3, null, 3});
        testCase2.print();
        System.out.println("Average on levels: " + averageOfLevels(testCase2Root));
        Tree testCase3 = new Tree();
        TreeNode testCase3Root = testCase3.insert(new Integer[]{2147483647,2147483647,2147483647});
        System.out.println("Average on levels: " + averageOfLevels(testCase3Root));
    }
}
