package leetcode.trees.BFS.medium;

import leetcode.trees.Tree;
import leetcode.trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal103 {

    static void runTest(Integer[] input, List<List<Integer>> expected) {
        Tree testCase = new Tree();
        TreeNode testCaseRoot = testCase.insert(input);
        testCase.print();
        System.out.println("Zigzag Level Order: " + zigzagLevelReverseOnOdd(testCaseRoot) + " Expected: " + expected);
    }

    public static void main(String[] args) {
        runTest(new Integer[]{1, 2, 3, 4, 5}, new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(1);
            }});
            add(new ArrayList<>() {{
                add(3);
                add(2);
            }});
            add(new ArrayList<>() {{
                add(4);
                add(5);
            }});
        }});
        // 1,2,3,4,null,null,5
        runTest(new Integer[]{1,2,3,4,null,null,5}, new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(1);
            }});
            add(new ArrayList<>() {{
                add(3);
                add(2);
            }});
            add(new ArrayList<>() {{
                add(4);
                add(5);
            }});
        }});
        // [[3],[20,9],[15,7]]
        runTest(new Integer[] {3,9,20,null,null,15,7}, new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(3);
            }});
            add(new ArrayList<>() {{
                add(20);
                add(9);
            }});
            add(new ArrayList<>() {{
                add(15);
                add(7);
            }});
        }});
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean rightStart = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelResult = new ArrayList<>(levelSize);
            LinkedList<TreeNode> levelQueue = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.pollFirst();
                levelQueue.add(current);
                levelResult.add(current.val);
            }
            res.add(levelResult);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = levelQueue.pollFirst();
                if (current.right != null) {
                    if (rightStart) {
                        queue.addLast(current.right);
                    } else {
                        queue.addFirst(current.right);
                    }
                }
                if (current.left != null) {
                    if (rightStart) {
                        queue.addLast(current.left);
                    } else {
                        queue.addFirst(current.left);
                    }
                }
            }

            rightStart = !rightStart;
        }
        return res;
    }

    public static List<List<Integer>> zigzagLevelOrderEvenIndex(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] levelResult = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (res.size() % 2 != 0) {
                    // is odd, e.g 1, 3, 5
                    levelResult[i] = current.val;
                } else {
                    levelResult[levelSize - 1 - i] = current.val;
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
            }
            res.add(Arrays.stream(levelResult).boxed().collect(Collectors.toList()));
        }
        return res;
    }

    public static List<List<Integer>> zigzagLevelReverseOnOdd(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelResult = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelResult.add(current.val);
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
            }
            if (res.size() % 2 == 0) {
                Collections.reverse(levelResult);
            }
            res.add(levelResult);
        }
        return res;
    }
}
