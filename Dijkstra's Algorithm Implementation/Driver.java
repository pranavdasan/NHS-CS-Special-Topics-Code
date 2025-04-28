import java.util.*;

public class Driver {
    public static void main(String[] args) {
        int numVertices = 7;

        // Create an adjacency list representation of the graph
        List<List<DijkstraWithPQ.Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add directed edges with weights (u -> v, weight)
        graph.get(0).add(new DijkstraWithPQ.Edge(2, 6));
        graph.get(0).add(new DijkstraWithPQ.Edge(1, 2));

        graph.get(1).add(new DijkstraWithPQ.Edge(3, 5));
        

        graph.get(2).add(new DijkstraWithPQ.Edge(3, 8));

        graph.get(3).add(new DijkstraWithPQ.Edge(4, 10));
        graph.get(3).add(new DijkstraWithPQ.Edge(5, 15));

        graph.get(4).add(new DijkstraWithPQ.Edge(6, 2));

        graph.get(5).add(new DijkstraWithPQ.Edge(6, 6));
      

        // Run Dijkstra's algorithm from source vertex 0
        DijkstraWithPQ.dijkstra(graph, 0);
    }
}
