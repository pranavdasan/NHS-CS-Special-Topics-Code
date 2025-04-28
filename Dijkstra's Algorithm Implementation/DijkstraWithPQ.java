import java.util.*;


// Learning: I learned how to implement Dijkstra's Algorithm using a PriorityQueue
// Challenges: How to implement the compareTo() function for the Nodes.


// Dijkstra's Algorithm with Priority Queue (Adjacency List Implementation)
public class DijkstraWithPQ {

    // Represents an edge from one vertex to another with a given weight
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Node class for the priority queue (stores vertex and current distance)
    static class Node implements Comparable<Node> {
        int vertex, dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        // TO DO: Implement compareTo for the priority queue (min-heap)
        @Override
        public int compareTo(Node other) {
            // TO DO
            // If positive, path is long long
            // If negative, path is short
            return this.dist - other.dist; 
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int source) {
        int numVertices = graph.size();
        int[] dist = new int[numVertices]; // Stores shortest distances from source
        boolean[] visited = new boolean[numVertices]; // Tracks visited vertices

        // TO DO: Initialize all distances to Integer.MAX_VALUE
        Arrays.fill(dist, Integer.MAX_VALUE);

        // TO DO: Set the distance of the source to 0
        dist[source] = 0;

        // TO DO: Create a priority queue (min-heap) and add the source node
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(source, 0));

        // TO DO: While the queue is not empty, process nodes
        while (!pq.isEmpty()) {
            // TO DO: Remove node with smallest distance
            Node node = pq.poll();

            // TO DO: Skip if already visited
            if (visited[node.vertex]) {
                continue;
            }

            // TO DO: Mark current node as visited
            visited[node.vertex] = true;

            // TO DO: Loop through neighbors and update distances if a shorter path is found
            for (Edge e : graph.get(node.vertex)) {
                // Get one of its neighbors
                int newVertex = e.to; 
                int newNodeDist = e.weight;
                
                
                // Add the new vertex to the priority queue for next iteration
                pq.offer(new Node(newVertex, newNodeDist));
                
                // Get distance from the current vertex's distance to the new vertex
                int newDist = dist[node.vertex] + newNodeDist;
                
                // Update the distance of the new vertex to shortest path
                if (!visited[newVertex] && newDist < dist[newVertex]) {
                    dist[newVertex] = newDist;
                }
            }
        }

        // Display the result
        printSolution(dist, source);
    }

    private static void printSolution(int[] dist, int source) {
        System.out.println("Vertex \t\t Distance from Source " + source);
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " \t\t INF");
            } else {
                System.out.println(i + " \t\t " + dist[i]);
            }
        }
    }
}
