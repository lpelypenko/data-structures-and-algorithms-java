package leetcode.trees.heap;

import java.util.*;

public class KClosestPointsToOrigin973 {
    public static void main(String[] args) {
        int [][] result = kClosest(new int[][]{{1, 3}, {-2,2}}, 1);
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Double, int[]>> distances = new PriorityQueue<>(
                Map.Entry.comparingByKey()
        );
        for(int i = 0; i<points.length ; i++) {
            double distance = calculateDistanceBetweenPoints(0, 0, points[i][0], points[i][1]); // O(1)
            distances.add(Map.entry(distance, points[i])); // O(log N)
        }
        int[][] result = new int[k][];
        while (k>0) {
            result[k-1] = distances.poll().getValue();
            k--;
        }
        return result;
    }

    public static double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
