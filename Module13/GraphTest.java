package Module13;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class GraphTest {
    public static void main(String[] args) {
        // Create vertices
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);

        // Create edges
        Edge<Integer> e1 = new Edge<>(v1, v2, 1);
        Edge<Integer> e2 = new Edge<>(v1, v3, 1);
        Edge<Integer> e3 = new Edge<>(v2, v4, 1);
        Edge<Integer> e4 = new Edge<>(v3, v4, 1);
        Edge<Integer> e5 = new Edge<>(v4, v5, 1);

        // Add vertices and edges to sets
        Set<Vertex<Integer>> vertices = new HashSet<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);

        // Create the graph
        Graph<Integer> graph = new Graph<>(vertices, edges);

        // Perform BFS
        List<Vertex<Integer>> bfsResult = GraphAlgorithms.bfs(v1, graph);
        System.out.print("BFS result: ");
        for (Vertex<Integer> vertex : bfsResult) {
            System.out.print(vertex.getData() + " ");
        }
        System.out.println();

        // Perform DFS
        List<Vertex<Integer>> dfsResult = GraphAlgorithms.dfs(v1, graph);
        System.out.print("DFS result: ");
        for (Vertex<Integer> vertex : dfsResult) {
            System.out.print(vertex.getData() + " ");
        }
    }
}
