package leetcode.grapth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A-----------B
 * | \           \
 * |  \            \
 * |   \             \
 * C----D-------------E
 * Adjacency Matrix:
 * <p>
 * A B C D E
 * A: 0 1 1 1 0
 * B: 1 0 0 0 1
 * C: 1 0 0 1 0
 * D: 1 0 1 0 1
 * E: 0 1 0 1 0
 * If graph is complete graph - use Adjacency list.
 * - What is complete graph?
 * Ne = Nv(Nv-1)/1, where Nv - number of vertices, Ne - number of edges.
 * If number of edges are few, then we use Adjacency List.
 */
public class GraphAdjacencyMatrix implements Graph {
    ArrayList<GraphNode> nodeList;
    int[][] adjacencyMatrix;


    public GraphAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int firstNode, int secondNode) {
        this.adjacencyMatrix[firstNode][secondNode] = 1;
        this.adjacencyMatrix[secondNode][firstNode] = 1;

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (GraphNode node : nodeList) {
            s.append(node.name).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name).append(": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j)).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    private ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    private void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
        System.out.print("\n");
    }

    // BFS for Adjacency matrix
    public void bfs() {
        System.out.println("Demo BFS on Adjacency Matrix:");
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }
}
