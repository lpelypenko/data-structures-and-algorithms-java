package leetcode.grapth.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberOfIslands200 {
    public static void main(String[] args) {

    }

    static Set<String> visited = new HashSet<>();

    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (!visited.contains(row + "," + column) && grid[row][column] == '1') {
                    num++;
                    dfs(grid, row, column);
                }
            }
        }
        return num;
    }

    public static void dfs(char[][] grid, int row, int column) {
        if (visited.contains(row + "," + column)
                || row >= grid.length
                || row < 0
                || column >= grid[row].length
                || column < 0
                || grid[row][column] == '0') {
            return;
        }
        visited.add(row + "," + column);
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}

