package leetcode.grapth;

import java.util.ArrayList;

public class Main {

    public static ArrayList<GraphNode> getDemoList() {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        return nodeList;
    }

    public static void addUndirectedEdges(Graph graph) {
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(4, 3);
        System.out.print(graph);
    }
    public static void main(String[] args) {
        // Demo Adjacency Matrix
        System.out.println("Demo Adjacency Matrix:");
        Graph graphWithMatrix = new GraphAdjacencyMatrix(getDemoList());
        addUndirectedEdges(graphWithMatrix);
        graphWithMatrix.bfs();
        System.out.println("Demo Adjacency List:");
        Graph graphWithList = new GraphAdjacencyList(getDemoList());
        addUndirectedEdges(graphWithList);
        graphWithList.bfs();
    }
}
