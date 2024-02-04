package leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public TreeNode root;

    public Tree() {
        this.root = null;
    }

    public Tree(Integer[] input) {
        this.root = insert(input);
    }

    /**
     * @param input e.g. [1,2,2,3,4,4,3]
     * @return Returns root
     */
    public TreeNode insert(Integer[] input) {
        if (input.length == 0) return null;
        Queue<TreeNode> toProcess = new LinkedList<>();
        if (input[0] == null) {
            root = null;
        } else {
            root = new TreeNode(input[0]);
        }
        toProcess.add(root);
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (!toProcess.isEmpty()) {
            TreeNode current = toProcess.poll();
            if (leftChildIndex <  input.length) {
                if (input[leftChildIndex] == null) {
                    current.left = null;
                } else {
                    current.left = new TreeNode(input[leftChildIndex]);
                    toProcess.add(current.left);
                }
                leftChildIndex += 2;
            }
            if (rightChildIndex < input.length) {
                if (input[rightChildIndex] == null) {
                    current.right = null;
                } else {
                    current.right = new TreeNode(input[rightChildIndex]);
                    toProcess.add(current.right);
                }
                rightChildIndex += 2;
            }
        }
        return root;
    }

    public void print() {
        Queue<TreeNode> toProcess = new LinkedList<>();
        if (root == null) System.out.println("null");
        toProcess.add(root);
        while (!toProcess.isEmpty()) {
            String leveLine = "";
            int levelSize = toProcess.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = toProcess.poll();
                leveLine = leveLine + "'" + currentNode.val + "'";
                if (currentNode.left != null) {
                    toProcess.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    toProcess.add(currentNode.right);
                }
            }
            System.out.println(leveLine);
        }
    }
}
