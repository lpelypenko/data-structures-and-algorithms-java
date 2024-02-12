package leetcode.grapth;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false; // Support for BFS

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
