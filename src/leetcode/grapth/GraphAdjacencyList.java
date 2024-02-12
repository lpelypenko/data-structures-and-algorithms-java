package leetcode.grapth;

import java.util.*;

/**
 * A-----------B
 * | \           \
 * |  \            \
 * |   \             \
 * C----D-------------E
 * Adjacency List:
 * A -> B -> C -> D
 * B -> A -> E
 * C -> A -> D
 * D -> A -> C -> E
 * E -> B -> D
 * <p>
 * If graph is complete graph - use Adjacency list.
 * - What is complete graph?
 * Ne = Nv(Nv-1)/1, where Nv - number of vertices, Ne - number of edges.
 * If number of edges are few, then we use Adjacency List.
 */
public class GraphAdjacencyList implements Graph {
    ArrayList<GraphNode> nodeList;
    public Map<GraphNode, ArrayList<GraphNode>> neighbors;


    public GraphAdjacencyList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.neighbors = new HashMap<>();
        for (GraphNode node : nodeList) {
            neighbors.put(node, new ArrayList<>());
        }
    }

    public void addUndirectedEdge(int firstNode, int secondNode) {
        GraphNode first = nodeList.get(firstNode);
        GraphNode second = nodeList.get(secondNode);
        ArrayList<GraphNode> fCurrNeighbors = neighbors.get(first);
        fCurrNeighbors.add(second);
        neighbors.put(first, fCurrNeighbors);
        ArrayList<GraphNode> sCurrNeighbors = neighbors.get(second);
        sCurrNeighbors.add(first);
        neighbors.put(second, sCurrNeighbors);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GraphNode node : nodeList) {
            s.append(node.name).append(": ");
            for (int i = 0; i < neighbors.get(node).size(); i++) {
                s.append(neighbors.get(node).get(i).name);
                if (i != neighbors.get(node).size() - 1) {
                    s.append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    private void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor : neighbors.get(currentNode)) {
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
        System.out.println("Demo BFS on Adjacency List:");
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }
}
