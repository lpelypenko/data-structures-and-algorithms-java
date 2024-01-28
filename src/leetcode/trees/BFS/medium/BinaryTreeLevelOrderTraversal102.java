package leetcode.trees.BFS.medium;
import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    /**
     * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a>
     * @param args
     */
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> toProcess = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        toProcess.add(root);
        while (!toProcess.isEmpty()) {
            List<Integer> nodesOnCurrentLevel = new ArrayList<>();
            int levelSize = toProcess.size(); // 2
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = toProcess.poll();
                nodesOnCurrentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    toProcess.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    toProcess.add(currentNode.right);
                }
            }
            res.add(nodesOnCurrentLevel);
        }
        return res;
    }
}
