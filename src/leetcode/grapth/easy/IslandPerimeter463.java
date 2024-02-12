package leetcode.grapth.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * Example 1:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Example 2:
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 * Input: grid = [[1,0]]
 * Output: 4
 */
public class IslandPerimeter463 {
    public static void main(String[] args) {
        System.out.println("Perimeter: " + islandPerimeter(new int[][]{{1, 1, 1}, {1, 0, 0}}) + ". Expected 10");
        System.out.println("Perimeter: " + islandPerimeter(new int[][]{{1, 0}}) + ". Expected 4");
        System.out.println("Perimeter: " + islandPerimeter(new int[][]{{0, 1}}) + ". Expected 4");
        System.out.println("Perimeter: " + islandPerimeter(new int[][]{{1}}) + ". Expected 4");
        System.out.println("Perimeter: " + islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}) + ". Expected 16");
    }

    public static int islandPerimeter1(int[][] grid) {
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int current = grid[row][column];
                if (current == 1) {
                    // up
                    if (row == 0 || grid[row - 1][column] == 0) {
                        perimeter++;
                    }
                    // down
                    if (row + 1 == grid.length || grid[row + 1][column] == 0) {
                        perimeter++;
                    }
                    // left
                    if (column == 0 || grid[row][column - 1] == 0) {
                        perimeter++;
                    }
                    // right
                    if (column + 1 == grid[row].length || grid[row][column + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    static int perimeter = 0;
    static Set<Integer> visited = new HashSet<>();

    public static int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    dfs(grid, row, column);
                    break;
                }
            }
        }
        return perimeter;
    }

    private static void dfs(int[][] grid, int row, int column) {
        if (visited.contains(row * grid[row].length + column)) {
            return;
        }
        visited.add(row * grid[row].length + column);
        if (row == 0 || grid[row - 1][column] == 0) {
            perimeter++;
        } else {
            dfs(grid, row - 1, column);
        }
        // down
        if (row + 1 == grid.length || grid[row + 1][column] == 0) {
            perimeter++;
        } else {
            dfs(grid, row + 1, column);
        }
        // left
        if (column == 0 || grid[row][column - 1] == 0) {
            perimeter++;
        } else {
            dfs(grid, row, column - 1);
        }
        // right
        if (column + 1 == grid[row].length || grid[row][column + 1] == 0) {
            perimeter++;
        } else {
            dfs(grid, row, column + 1);
        }
    }
}
