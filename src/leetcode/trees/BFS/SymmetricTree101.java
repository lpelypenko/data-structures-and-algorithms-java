package leetcode.trees.BFS;

import leetcode.trees.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">101. Symmetric Tree</a>
 */
public class SymmetricTree101 {

    public static void main(String[] args) {

    }

    /*
     |--------- DFS approach ---------|
     Space complexity is O(h) where h is tree high
     Time complexity is O(n) because we will visit every element in the tree
     */
     public boolean isSymmetricDFS(TreeNode root) {
         if (root == null) {
             return true;
         }
         return isSame(root.left, root.right);
     }

     private boolean isSame(TreeNode node1, TreeNode node2) {
         if (node1 == null && node2 == null) {
             return true;
         }
         if (node1 == null || node2 == null) {
             return false;
         }
         return node1.val == node2.val && isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
     }

    // |-------- BFS simplified approach ---------|
    public boolean isSymmetricBFSSimplified(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> level = new LinkedList<>(); // Space complexity is O(n/2) if we get to the last level
        level.add(root.left);
        level.add(root.right);

        while(!level.isEmpty()) {
            TreeNode leftNode = level.poll();
            TreeNode rightNode = level.poll();
            if(leftNode == null && rightNode==null) continue;
            if(rightNode == null || leftNode == null || rightNode.val != leftNode.val) return false;
            level.add(leftNode.left);
            level.add(rightNode.right);
            level.add(leftNode.right);
            level.add(rightNode.left);
        }

        return true;
    }

    /**
     * Solution #1: BFS
     * initial solution visiting every level and storing values in the list.
     * The list is checked again and i element is compared with size()-i-1 elements.
     * Exit as soon as one check failed.
     * @param root
     * @return
     */
    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> toProcess = new LinkedList<>(); // Space complexity is O(n/2) if we get o the last level
        toProcess.add(root.left);
        toProcess.add(root.right);

        while(!toProcess.isEmpty()) {
            List<Integer> valuesOnLevel = new ArrayList<>(); // Space complexity is O(n/2) if we get to the last level
            int levelSize = toProcess.size();
            for(int i=0; i < levelSize; i++) {
                TreeNode currentNode = toProcess.poll();
                if(currentNode!=null) {
                    valuesOnLevel.add(currentNode.val);
                    toProcess.add(currentNode.left);
                    toProcess.add(currentNode.right);
                } else {
                    valuesOnLevel.add(null);
                }
            }
            for(int i=0;i < valuesOnLevel.size()/2;i++) {
                if(!Objects.equals(valuesOnLevel.get(i), valuesOnLevel.get(valuesOnLevel.size()-i-1))){
                    return false;
                }
            }
        }

        return true;
    }
}
