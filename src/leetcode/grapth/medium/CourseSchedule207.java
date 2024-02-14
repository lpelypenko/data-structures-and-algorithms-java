package leetcode.grapth.medium;

import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
        // TC1: no prerequisites no problem
        System.out.println(canFinish(1, new int[][]{}) + " Expect: true");
        // TC2: only one course has dependency
        System.out.println(canFinish(2, new int[][]{{1, 0}}) + " Expect: true");
        // there are 12 possible courses and I want to take 20
        System.out.println(canFinish(20, new int[][]{
                {0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}) + " Expect: false");
        // TC3: 1:(4) 2:(4) 3:(1,2) 4:()
        System.out.println(canFinish(2, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}) + " Expect: true");
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
    // My solution using Khan's algorytm
    // [[1,0],[0,1]] to take 1 you need 0, to take 0 you need to take 1
    public static boolean canFinishMy(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        // which courses depend on each prerequisite course?
        Map<Integer, Set<Integer>> adjMap = new HashMap<>(); // 1: Set(0) 0: Set()
        for (int[] prerequisite : prerequisites) {
            // add dependency
            Set<Integer> dependentOn = adjMap.getOrDefault(prerequisite[0], new HashSet<>());
            dependentOn.add(prerequisite[1]);
            adjMap.put(prerequisite[0], dependentOn);
            // add unique if it does not exist
            if (!adjMap.containsKey(prerequisite[1])) {
                adjMap.put(prerequisite[1], new HashSet<>());
            }
        }
        Queue<Integer> toProcess = new LinkedList<>();

        for (Map.Entry<Integer, Set<Integer>> adj : adjMap.entrySet()) {
            // If course has no dependencies, add to a Queue
            if (adj.getValue().isEmpty()) {
                toProcess.add(adj.getKey());
            }
        }
        if (toProcess.isEmpty()) {
            return false;
        }
        while (!toProcess.isEmpty()) {
            int courseWithNoDependencies = toProcess.poll();
            adjMap.remove(courseWithNoDependencies);
            for (Map.Entry<Integer, Set<Integer>> adj : adjMap.entrySet()) {
                if (adj.getValue().contains(courseWithNoDependencies)) {
                    adj.getValue().remove(courseWithNoDependencies);
                    if (adj.getValue().isEmpty()) {
                        toProcess.add(adj.getKey());
                    }
                }
            }
        }
        return adjMap.isEmpty();
    }
}
